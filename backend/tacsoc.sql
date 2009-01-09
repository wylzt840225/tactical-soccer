/*	Tactical Soccer
	Copyright © 2007,2008 LinFox Serviços de Informatica LTDA.

	This file is part of Tactical Soccer.

	Tactical Soccer is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	Tactical Soccer is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with Tactical Soccer.  If not, see <http://www.gnu.org/licenses/>. */

CREATE DATABASE IF NOT EXISTS tacsoc
CHARACTER SET utf8 DEFAULT CHARACTER SET utf8
COLLATE utf8_general_ci DEFAULT COLLATE utf8_general_ci;
USE tacsoc;


CREATE TABLE IF NOT EXISTS config (
	config_id integer NOT NULL auto_increment,
	sitename varchar(32) NOT NULL,
	language varchar(5) NOT NULL,
	PRIMARY KEY (config_id)
) ENGINE=InnoDB;

INSERT INTO config (config_id, sitename, domain, dhcpd_header, iptables, ip, cp_port, language, bandwith, iface, proxy_port, payment_delay, template) VALUES
(1, 'TacSoc', 'pt_BR');


CREATE TABLE IF NOT EXISTS users (
	user_id integer NOT NULL auto_increment,
	username varchar(32) NOT NULL,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password binary(128) NOT NULL,
	admin boolean NOT NULL default false,
	PRIMARY KEY (user_id)
) ENGINE=InnoDB;

INSERT INTO users (user_id, username, name, password, admin, email) VALUES 
(1, 'admin', 'Administrator', 0x6337616434346362616437363261356461306134353266396538353466646331653065376135326133383031356632336633656162316438306239333164643437323633346466616337316364333465626333356431366162376662386139306338316639373531313364366337353338646336396464386465393037376563, true, 'vulpes@linfox.com.br');


CREATE TABLE IF NOT EXISTS user_groups (
	group_id integer NOT NULL auto_increment,
	name varchar(32) NOT NULL,
	description varchar(255) NOT NULL,
	PRIMARY KEY (group_id)
) ENGINE=InnoDB;

INSERT INTO user_groups (group_id, name, description)
VALUES (1, 'admin', 'Administrators');


CREATE TABLE IF NOT EXISTS user_members (
	member_id integer NOT NULL auto_increment,
	user_id integer NOT NULL,
	group_id integer NOT NULL,
	PRIMARY KEY (member_id),
	FOREIGN KEY (user_id) REFERENCES users (user_id),
	FOREIGN KEY (group_id) REFERENCES user_groups (group_id)
) ENGINE=InnoDB;

INSERT INTO user_members (user_id, group_id) VALUES (1, 1);


CREATE TABLE IF NOT EXISTS user_permissions (
	permission_id integer NOT NULL auto_increment,
	group_id integer NOT NULL,
	mode varchar(32) NOT NULL,
	action varchar(32) NOT NULL,
	PRIMARY KEY (permission_id)
	FOREIGN KEY ()
) ENGINE=InnoDB;

INSERT INTO user_permissions (group_id, mode, action) VALUES (1, '_ALL', '_ALL');


CREATE TABLE IF NOT EXISTS savegames (
	savegame_id integer NOT NULL auto_increment,
	PRIMARY KEY (permission_id)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS characters (
	character_id integer NOT NULL auto_increment,
	user_id integer NOT NULL,
	name varchar(32) NOT NULL,
	hp smallint NOT NULL,
	mp smallint NOT NULL,
	str smallint NOT NULL,
	def smallint NOT NULL,
	mag smallint NOT NULL,
	spr smallint NOT NULL,
	spd smallint NOT NULL,
	eva smallint NOT NULL,
	acc smallint NOT NULL,
	lck smallint NOT NULL,
	PRIMARY KEY (character_id)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS matches (
	match_id integer NOT NULL auto_increment,
	width smallint NOT NULL,
	height smallint NOT NULL,
	PRIMARY KEY (battle_id)
) ENGINE=InnoDB;