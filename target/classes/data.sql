DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;

CREATE TABLE account (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  accountNumber VARCHAR(10) NOT NULL,
  lastUpdateTimestamp TIMESTAMP NOT NULL,
  balance NUMBER DEFAULT NULL
);

CREATE TABLE transaction (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  accountNumber VARCHAR(10) NOT NULL,
  transactionTs TIMESTAMP NOT NULL,
  type VARCHAR(10) NOT NULL,
  amount NUMBER DEFAULT NULL
);

INSERT INTO account (accountNumber, lastUpdateTimestamp, balance) VALUES
  ('1234567891', {ts '2012-09-19 18:47:52.69'}, 1005),
  ('1234567891', {ts '2012-09-17 18:47:52.69'}, 1000),
  ('1234567892', {ts '2012-09-17 18:47:52.69'}, 2000),
  ('9876543211', {ts '2012-09-17 18:47:52.69'}, 3000);
  
INSERT INTO transaction (accountNumber, transactionTs, type, amount) VALUES
  ('1234567891', {ts '2012-09-11 18:47:52.69'}, 'DEPOSIT', 100),
  ('1234567891', {ts '2012-09-13 18:47:52.69'}, 'WITHDRAWAL', 15),
  ('1234567891', {ts '2012-09-13 18:47:52.69'}, 'WITHDRAWAL', 10),
  ('1234567892', {ts '2012-09-17 18:47:52.69'}, 'WITHDRAWAL', 25),
  ('9876543211', {ts '2012-09-17 18:47:52.69'}, 'DEPOSIT', 113);
  