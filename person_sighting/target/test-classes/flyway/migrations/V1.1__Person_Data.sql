-- Province
INSERT INTO province (province_id, province_name) VALUES('HENAN', 'HeNan');
INSERT INTO province (province_id, province_name) VALUES('SHANXI', 'ShanXi');
INSERT INTO province (province_id, province_name) VALUES('SICHUAN', 'SiChuan');
INSERT INTO province (province_id, province_name) VALUES('GUIZHOU', 'GuiZhou');
INSERT INTO province (province_id, province_name) VALUES('YUNNAN', 'YunNan');
INSERT INTO province (province_id, province_name) VALUES('SHANDONG', 'ShanDong');
INSERT INTO province (province_id, province_name) VALUES('FUJIAN', 'FuJian');

-- Person
INSERT INTO person (person_id, family_name, given_name, birthday, gender, missing_date, province_fk, Home_province_id) VALUES('YANG_BO', 'Yang',  'Bo', '2018-12-01', 'male', '2022-1-28',1,  'HENAN' );

INSERT INTO person (person_id, family_name, given_name, birthday, gender, missing_date,province_fk,Home_province_id) VALUES('WEIXUE', 'Wei',  'Xue', '2015-8-11', 'female', '2021-5-11', 5, 'YUNNAN');

INSERT INTO person (person_id, family_name, given_name, birthday, gender, missing_date, province_fk,Home_province_id) VALUES('WUBIN', 'Wu',  'Bin', '2019-6-22', 'female', '2020-7-3' , 6, 'SHANDONG');

-- Sighting
INSERT INTO sighting (sighting_id,sighting_date, province_fk, sighting_province_id) VALUES('WEIXUE',   '2021-6-17', 7, 'FUJIAN' );

INSERT INTO sighting (sighting_id, sighting_date, province_fk, sighting_province_id) VALUES('YANG_BO',  '2022-3-15', 4,  'GUIZHOU');

