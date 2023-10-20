SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS shain_master;
DROP TABLE IF EXISTS bu_master;




/* Create Tables */

CREATE TABLE bu_master
(
	bu_id char(3) NOT NULL,
	name varchar(20) NOT NULL,
	PRIMARY KEY (bu_id)
);


CREATE TABLE shain_master
(
	id char(4) NOT NULL,
	name varchar(10) NOT NULL,
	enter_date date,
	retire_flg boolean NOT NULL,
	bu_id char(3) NOT NULL,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE shain_master
	ADD FOREIGN KEY (bu_id)
	REFERENCES bu_master (bu_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



