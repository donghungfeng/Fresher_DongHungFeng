-- INSERT data
-- Only data
INSERT INTO topic values(1,'topic01','The first topic',1,'demo');
-- Filed and data
INSERT INTO topic(topicid,name,description,state,note) values(2,'topic02','The second topic',1,'demo');
-- END INSERT data

-- UPDATE data
-- UPDATE all
UPDATE topic set NAME = 'topic';
-- UPDATE with condition
UPDATE topic set note = 'fix' WHERE topicid = 2;
-- END UPDATE data

-- DELETE data
-- DELETE all records
DELETE * FROM topic;
-- DELETE records with condition
DELETE FROM topic WHERE id = 2;
-- END DELETE data