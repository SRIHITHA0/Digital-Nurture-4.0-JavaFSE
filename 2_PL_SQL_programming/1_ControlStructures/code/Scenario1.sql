BEGIN
    FOR rec IN (
        SELECT l.LoanID
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;
END;
/

SELECT 
    c.CustomerID,
    c.Name,
    TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age,
    l.LoanID,
    l.LoanAmount,
    l.InterestRate
FROM 
    Customers c
JOIN 
    Loans l ON c.CustomerID = l.CustomerID
ORDER BY 
    c.CustomerID;
/