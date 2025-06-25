BEGIN
  FOR i IN (SELECT * FROM customer) LOOP
    IF i.age > 60 THEN
      UPDATE loan
      SET interest_rate = interest_rate - 1
      WHERE id = i.id;
    END IF;
  END LOOP;
  COMMIT;
END;
/
SELECT * FROM loan;