

DROP PROCEDURE IF EXISTS get_name;
delimiter //
CREATE PROCEDURE `get_name` (IN id INT, OUT name VARCHAR(20))
    BEGIN
      SELECT STUDENT.NAME INTO name FROM STUDENT WHERE STUDENT.ID=id;
    END//
delimiter ;
