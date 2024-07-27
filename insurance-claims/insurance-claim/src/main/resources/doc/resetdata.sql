-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

-- Delete existing data
DELETE FROM claim_document;
DELETE FROM claim;
DELETE FROM insurance_product;
DELETE FROM customer;
DELETE FROM claim_status;

-- Enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Insert into claim_status table
INSERT INTO claim_status (status, created_by, created_date, deleted, last_modified_by, last_modified_date) VALUES
                                                                                                               ('Pending', 'nguyen.admin', NOW(), 0, 'nguyen.admin', NOW()),
                                                                                                               ('Approved', 'nguyen.admin', NOW(), 0, 'nguyen.admin', NOW()),
                                                                                                               ('Rejected', 'nguyen.admin', NOW(), 0, 'nguyen.admin', NOW());

-- Insert into customer table
INSERT INTO customer (address, bank_name, bank_number, created_by, created_date, deleted, email, last_modified_by, last_modified_date, name, phone_number) VALUES
                                                                                                                                                               ('123 Đường ABC, Quận 1, TP. HCM', 'Ngân hàng A', '1234567890', 'nguyen.admin', NOW(), 0, 'john.doe@example.com', 'nguyen.admin', NOW(), 'John Doe', '0123456789'),
                                                                                                                                                               ('456 Đường XYZ, Quận 2, TP. HCM', 'Ngân hàng B', '0987654321', 'nguyen.admin', NOW(), 0, 'jane.smith@example.com', 'nguyen.admin', NOW(), 'Jane Smith', '0987654321'),
                                                                                                                                                               ('789 Đường DEF, Quận 3, TP. HCM', 'Ngân hàng C', '5555555555', 'nguyen.admin', NOW(), 0, 'bob.johnson@example.com', 'nguyen.admin', NOW(), 'Bob Johnson', '0987654321');

-- Insert into insurance_product table
INSERT INTO insurance_product (coverage, created_by, created_date, deleted, description, last_modified_by, last_modified_date, name) VALUES
                                                                                                                                         ('Bảo hiểm toàn diện cho xe hơi', 'nguyen.admin', NOW(), 0, 'Bảo hiểm xe hơi', 'nguyen.admin', NOW(), 'Bảo hiểm xe hơi'),
                                                                                                                                         ('Bảo hiểm sức khỏe toàn diện', 'nguyen.admin', NOW(), 0, 'Bảo hiểm sức khỏe', 'nguyen.admin', NOW(), 'Bảo hiểm sức khỏe'),
                                                                                                                                         ('Bảo hiểm nhà toàn diện', 'nguyen.admin', NOW(), 0, 'Bảo hiểm nhà', 'nguyen.admin', NOW(), 'Bảo hiểm nhà'),
                                                                                                                                         ('Bảo hiểm du lịch toàn diện', 'nguyen.admin', NOW(), 0, 'Bảo hiểm du lịch', 'nguyen.admin', NOW(), 'Bảo hiểm du lịch');

-- Insert into claim table
INSERT INTO claim (amount, claim_date, created_by, created_date, deleted, description, last_modified_by, last_modified_date, status_id, customer_id, product_id) VALUES
                                                                                                                                                                     (6290.20, '2024-04-28', 'tran.user1', '2024-04-28 10:09:04', 0, 'Yêu cầu bồi thường chi phí y tế', 'le.user2', '2024-05-03 10:09:04', (SELECT id FROM claim_status WHERE status='Rejected'), (SELECT id FROM customer WHERE name='Jane Smith'), (SELECT id FROM insurance_product WHERE name='Bảo hiểm nhà')),
                                                                                                                                                                     (8217.87, '2023-08-12', 'tran.user1', '2023-08-12 10:09:04', 0, 'Yêu cầu bồi thường tai nạn xe', 'le.user2', '2023-08-22 10:09:04', (SELECT id FROM claim_status WHERE status='Pending'), (SELECT id FROM customer WHERE name='John Doe'), (SELECT id FROM insurance_product WHERE name='Bảo hiểm nhà')),
                                                                                                                                                                     (4063.26, '2024-07-04', 'tran.user1', '2024-07-04 10:09:04', 0, 'Yêu cầu bồi thường bảo hiểm du lịch', 'le.user2', '2024-07-14 10:09:04', (SELECT id FROM claim_status WHERE status='Rejected'), (SELECT id FROM customer WHERE name='Bob Johnson'), (SELECT id FROM insurance_product WHERE name='Bảo hiểm nhà')),
                                                                                                                                                                     (6963.71, '2024-03-30', 'nguyen.admin', '2024-03-30 10:09:04', 0, 'Yêu cầu bồi thường bảo hiểm du lịch', 'tran.user1', '2024-04-09 10:09:04', (SELECT id FROM claim_status WHERE status='Approved'), (SELECT id FROM customer WHERE name='Bob Johnson'), (SELECT id FROM insurance_product WHERE name='Bảo hiểm du lịch')),
                                                                                                                                                                     (1057.15, '2024-03-23', 'nguyen.admin', '2024-03-23 10:09:04', 0, 'Yêu cầu bồi thường bảo hiểm du lịch', 'nguyen.admin', '2024-04-02 10:09:04', (SELECT id FROM claim_status WHERE status='Rejected'), (SELECT id FROM customer WHERE name='John Doe'), (SELECT id FROM insurance_product WHERE name='Bảo hiểm du lịch'));

-- Insert into claim_document table
-- Using specific claim IDs
INSERT INTO claim_document (created_by, created_date, deleted, document_name, document_type, file_path, last_modified_by, last_modified_date, upload_date, claim_id) VALUES
    ('nguyen.admin', NOW(), 0, 'Giấy tờ liên quan bồi thường chi phí y tế', 'PDF', '/path/to/medical_expense.pdf', 'nguyen.admin', NOW(), '2024-05-01', (SELECT id FROM claim WHERE description='Yêu cầu bồi thường chi phí y tế' LIMIT 1)),
                                                                                                                                                                         ('nguyen.admin', NOW(), 0, 'Giấy tờ liên quan bồi thường tai nạn xe', 'Image', '/path/to/car_accident.png', 'nguyen.admin', NOW(), '2023-08-15', (SELECT id FROM claim WHERE description='Yêu cầu bồi thường tai nạn xe' LIMIT 1)),
                                                                                                                                                                         ('nguyen.admin', NOW(), 0, 'Giấy tờ liên quan bồi thường bảo hiểm du lịch', 'Image', '/path/to/travel_insurance.png', 'nguyen.admin', NOW(), '2024-07-05', (SELECT id FROM claim WHERE description='Yêu cầu bồi thường bảo hiểm du lịch' LIMIT 1));
