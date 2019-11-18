--Procedure 
CREATE OR REPLACE PROCEDURE welcome_msg (p_name IN VARCHAR2) 
IS
BEGIN
dbms_output.put_line ('Welcome'|| p_name);
END;
EXEC welcome_msg ('Dong Hung');
-- End Procedure

-- Function
CREATE OR REPLACE FUNCTION welcome_msgJune ( p_name IN VARCHAR2) RETURN VAR.CHAR2
IS
BEGIN
RETURN (‘Welcome ‘|| p_name);
END;
/
DECLARE
lv_msg VARCHAR2(250);
BEGIN
lv_msg := welcome_msg_func ('Dong Hung');
dbms_output.put_line(lv_msg);
END;
SELECT welcome_msg_func('Dong Hung') FROM DUAL;
-- End function

-- PACKAGE
CREATE OR REPLACE PACKAGE c_package AS 
   -- Adds a topic 
   PROCEDURE addTopic(c_id   topic.topicid%type, 
   c_name  topic.name%type, 
   c_description  topic.description%type, 
   c_status topic.status%type,  
   c_note  customers.note%type); 
   
   -- Removes a topic 
   PROCEDURE delTopic(c_id  topic.topicid%TYPE); 
   --Lists all topic 
   PROCEDURE listCustomer; 
  
END c_package; 