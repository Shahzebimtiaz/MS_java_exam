CREATE TABLE MEDICATIONS (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             medication_code INT NOT NULL,
                             medication_name VARCHAR(255) NOT NULL,
                             medication_comment VARCHAR(255)
);