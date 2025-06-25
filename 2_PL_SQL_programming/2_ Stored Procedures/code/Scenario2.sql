CREATE OR REPLACE PROCEDURE Bonus (
  p_department IN VARCHAR2,
  p_bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE employee
  SET salary = salary + (salary * p_bonus_percent / 100)
  WHERE department = p_department;

  COMMIT;
END;
/
BEGIN
  Bonus('HR', 10);
END;
/
SELECT * FROM employee;