BEGIN
  FOR i IN (
    SELECT l.loan_id, l.due_date, c.name
    FROM loan l
    JOIN customer c ON l.id = c.id
    WHERE l.due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || i.loan_id || 
                         ' for customer ' || i.name || 
                         ' is due on ' || TO_CHAR(i.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/