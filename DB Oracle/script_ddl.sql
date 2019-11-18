-- Create table:
create table topic(
	topicid number(3) not null,
	name varchar(25) not null,
	description varchar(255) not null,
	CONSTRAINT pk_topicid PRIMARY KEY(topicid)
);
-- End Create table

-- ALTER TABLE
-- Add column in table
ALTER Table topic
	ADD state number(1) not null;
-- Add multiple columns in table
ALTER Table topic
	ADD(
		col1 varchar(25),
		col2 varchar(25)
	);
-- Modify column in table
ALTER table topic
	MODIFY col1 varchar(255);
-- Modify multiple columns in table
ALTER table topic
	MODIFY(
		col1 varchar(255),
		col2 varchar(255) not null
	);
-- Drop column in table
ALTER table topic
	DROP COLUMN col2;
-- Rename column in table
ALTER table topic
	RENAME COLUMN col1 TO note
-- Rename table
ALTER table topic 
	RENAME TO topics
ALTER table topics 
	RENAME TO topic
-- End ALTER TABLE

-- TRUNCATE TABLE
TRUNCATE TABLE topic
-- END TRUNCATE TABLE

-- DROP TABLE
-- DROP TABLE topic
-- END DROP TABLE





