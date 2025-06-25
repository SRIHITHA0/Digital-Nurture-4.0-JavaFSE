BEGIN
  FOR i IN (SELECT * FROM customer) LOOP
    IF i.balance > 10000 THEN
      UPDATE customer
      SET isvip = 'TRUE'
      WHERE id = i.id;
    END IF;
  END LOOP;
  COMMIT;
END;
/
SELECT id, name, balance, isvip FROM customer;