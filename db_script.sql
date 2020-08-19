CREATE TABLE IF NOT EXISTS correspondents (
  id TINYINT NOT NULL AUTO_INCREMENT,
  correspondent VARCHAR(50) NOT NULL,
  CONSTRAINT pk_correspondent_id PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS deliveries (
  id TINYINT NOT NULL AUTO_INCREMENT,
  delivery_type VARCHAR(15),
  CONSTRAINT pk_delivery_id PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS documents (
  reg_id VARCHAR(255) NOT NULL,
  reg_date DATE NOT NULL DEFAULT (CURRENT_DATE()),
  doc_id VARCHAR(255),
  doc_date DATE DEFAULT NULL,
  correspondent_id TINYINT NOT NULL,
  delivery_id TINYINT NOT NULL,
  doc_subject VARCHAR(100) NOT NULL,
  doc_description VARCHAR(1000) NOT NULL,
  doc_deadline DATE DEFAULT NULL,
  doc_authority VARCHAR(3) DEFAULT 'No',
  doc_control VARCHAR(3) DEFAULT 'No',
  doc_name VARCHAR(50),
  doc_type TINYTEXT,
  doc_file MEDIUMBLOB NOT NULL,
  CONSTRAINT chk_date CHECK (doc_deadline > reg_date),
  CONSTRAINT pk_reg_id PRIMARY KEY (reg_id),
  CONSTRAINT fk_documents_correspondents
    FOREIGN KEY (correspondent_id)
    REFERENCES correspondents (id),
  CONSTRAINT fk_documents_deliveries
    FOREIGN KEY (delivery_id)
    REFERENCES deliveries (id))
ENGINE = InnoDB;

INSERT INTO correspondents 
VALUES ('1', 'World Bank'),
  ('2', 'Oracle'),
  ('3', 'Lotus Pharmaceutical Co.');
  
INSERT INTO deliveries 
VALUES ('1', 'Courier'),
  ('2', 'Email'),
  ('3', 'Fax');