ALTER TABLE Customers ADD IsVIP CHAR(1) DEFAULT 'N';
/
BEGIN
    FOR cust IN (
        SELECT CustomerID, Balance
        FROM Customers
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = cust.CustomerID;
    END LOOP;

    COMMIT;
END;
/
SELECT CustomerID, Name, Balance, IsVIP
FROM Customers
ORDER BY CustomerID;
/