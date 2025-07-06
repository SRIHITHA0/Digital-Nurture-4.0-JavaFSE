CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (0.01 * acc.Balance),
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;
    END LOOP;

    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
