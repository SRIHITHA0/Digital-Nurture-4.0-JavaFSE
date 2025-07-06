
CREATE SEQUENCE Transactions_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    INSERT INTO Transactions
    VALUES (
        Transactions_seq.NEXTVAL, p_from_account, SYSDATE, p_amount, 'Debit'
    );

    INSERT INTO Transactions
    VALUES (
        Transactions_seq.NEXTVAL, p_to_account, SYSDATE, p_amount, 'Credit'
    );

    COMMIT;
END;
/
