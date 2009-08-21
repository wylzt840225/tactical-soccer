<?php

/*	TacSoc - Tactical Soccer
	Copyright © 2009 Alwin Garside

	This file is part of TacSoc.

	TacSoc is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	TacSoc is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with TacSoc.  If not, see <http://www.gnu.org/licenses/>. */

require 'config.php';
require 'libfox.php';

$user_dao = new user_dao();
$user = $user_dao->auth(get('login_username',''),get('login_password',''));

$mode = get_mode();
$action = get_action();
$target = get_target();
$tpl = 'xml_tpl';
$result = '';
$changes = changes::get_instance();

if ($user) {

	try {
		if ($mode && $user->perm($mode,$action)) {
			$ctl_class = $mode.'_ctl';
			if (include_once('ctl/'.$ctl_class.'.php')) {
				$controller = new $ctl_class();
				$log_ctl = new log_ctl();
				$log_ctl->insert();
			} else {
				throw new Exception('Cannot find controller for this mode.');
			}
			$result .= $controller->$action();
			$tpl = $controller->tpl;
		} else {
			throw new Exception('access_denied');
		}
	} catch (Exception $e) {
		$error = $e->getMessage();
	}

} else {
	$error = 'Invalid user';
}

exec('sudo ./plugrunner.php '.$mode.' '.$action.' > /dev/null &');

include 'tpl/'.$tpl.'.php';

?>