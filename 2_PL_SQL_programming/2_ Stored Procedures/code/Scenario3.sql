CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) IS
BEGIN
  
  UPDATE bank_account
  SET balance = balance - p_amount
  WHERE account_id = p_from_account
    AND balance >= p_amount;

  
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance or account not found.');
  END IF;

  UPDATE bank_account
  SET balance = balance + p_amount
  WHERE account_id = p_to_account;

  COMMIT;
END;
/
BEGIN
  TransferFunds(101, 102, 2000);
END;
/
SELECT * FROM bank_account;