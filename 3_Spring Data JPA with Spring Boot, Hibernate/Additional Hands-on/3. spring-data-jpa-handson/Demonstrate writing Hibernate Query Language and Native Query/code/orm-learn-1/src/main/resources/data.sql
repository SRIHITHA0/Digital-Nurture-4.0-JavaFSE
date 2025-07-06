INSERT INTO department(id, name) VALUES (1, 'Engineering');
INSERT INTO skill(id, name) VALUES (1, 'Java');
INSERT INTO employee(id, name, permanent, salary, date_of_birth, em_dp_id)
VALUES (1, 'Alice', true, 60000.0, '1990-01-01', 1);
INSERT INTO employee_skill(es_em_id, es_sk_id) VALUES (1, 1);
