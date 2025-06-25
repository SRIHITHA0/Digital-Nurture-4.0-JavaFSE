CREATE OR REPLACE PROCEDURE Interest IS
BEGIN
  FOR acc IN (SELECT account_id, balance FROM savings_account) LOOP
    UPDATE savings_account
    SET balance = acc.balance + (acc.balance * 0.01)
    WHERE account_id = acc.account_id;
  END LOOP;
  COMMIT;
END;
/
BEGIN
  Interest;
END;
/
SELECT * FROM savings_account;