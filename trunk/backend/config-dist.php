<?php

/**
 * Site configuration file.
 * 
 * This file contains the setup class
 */

/**
 * Setup class
 * 
 * This abstract class contains constants with the sites configuration.
 */
abstract class setup
{
	const db_hostname     = 'localhost';
	const db_username     = 'root';
	const db_password     = '';
	const db_database     = 'tacsoc';
	// These aren't used yet:
	const db_prefix       = 'tc_';
	const db_driver       = 'mysql';
	const db_port         = NULL;

	const db_config_table = 'config';
	const db_config_key   = 'config_id';
	
	const libfox_path     = '../libfox';

	const root            = 'tacsoc';
	const prefix          = 'lf_';
	const mode            = 'game';
	const action          = 'show_all';
}

// Set include path for LibFox
ini_set('include_path', '.:../:'.setup::libfox_path);

// Set default timezone
date_default_timezone_set('America/Recife');

?>