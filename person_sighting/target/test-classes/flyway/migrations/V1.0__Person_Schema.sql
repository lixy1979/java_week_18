DROP TABLE IF EXISTS person_sighting;
DROP TABLE IF EXISTS sighting;
DROP TABLE IF EXISTS person;

CREATE TABLE person(
person_pk int unsigned NOT NULL AUTO_INCREMENT,
person_id VARCHAR(45) NOT NULL,
family_name VARCHAR(45) NOT NULL,
given_name VARCHAR(45) NOT NULL,
birthday DATETIME NOT NULL,
gender VARCHAR(10) NOT NULL,
missing_date DATETIME NOT NULL,
Home_province_id VARCHAR(40) NOT NULL,
PRIMARY KEY (person_pk),
UNIQUE KEY (person_id)
);
CREATE TABLE sighting(
sighting_pk int unsigned NOT NULL AUTO_INCREMENT,
sighting_id VARCHAR(45) NOT NULL,
sighting_date DATETIME NOT NULL,
sighting_province_id VARCHAR(40) NOT NULL,
PRIMARY KEY (sighting_pk),
UNIQUE KEY (sighting_id)
);
CREATE TABLE person_sighting(
person_sighting_pk int unsigned NOT NULL AUTO_INCREMENT,
sighting_fk int unsigned NOT NULL,
person_fk int unsigned NOT NULL,
PRIMARY KEY (person_sighting_pk),
FOREIGN KEY (sighting_fk) REFERENCES sighting (sighting_pk) ON DELETE CASCADE,
FOREIGN KEY (person_fk) REFERENCES person (person_pk) ON DELETE CASCADE
);
