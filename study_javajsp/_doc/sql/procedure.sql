DELIMITER $$
DROP PROCEDURE IF EXISTS `getName` $$
CREATE DEFINER=`study`@`localhost` PROCEDURE `getName` 
   (IN I_ID VARCHAR(255), OUT O_NAME VARCHAR(255))
BEGIN
   SELECT USER_NM INTO O_NAME
   FROM TEST1
   WHERE USER_ID = I_ID;
END $$
DELIMITER ;











CALL getName('admin', @out_value);

SELECT @out_value;