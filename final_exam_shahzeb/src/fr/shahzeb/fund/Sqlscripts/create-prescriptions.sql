CREATE TABLE PRESCRIPTIONS (
                               presc_id INT AUTO_INCREMENT PRIMARY KEY,
                               presc_ref_pat VARCHAR(255) NOT NULL,
                               presc_code INT NOT NULL,
                               presc_days INT NOT NULL
);