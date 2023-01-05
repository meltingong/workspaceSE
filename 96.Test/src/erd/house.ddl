DROP TABLE order CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;

CREATE TABLE member(
		m_id                          		VARCHAR2(50)		 NULL ,
		m_pw                          		VARCHAR2(100)		 NULL ,
		m_name                        		VARCHAR2(100)		 NULL ,
		m_birth                       		VARCHAR2(100)		 NULL ,
		m_phone                       		VARCHAR2(100)		 NULL ,
		m_address                     		VARCHAR2(200)		 NULL 
);


CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(100)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_img                         		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE cart(
		c_no                          		NUMBER(10)		 NULL ,
		c_qty                         		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_c_no_SEQ;

CREATE SEQUENCE cart_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE order(
		o_no                          		NUMBER(10)		 NULL ,
		o_qty                         		NUMBER(10)		 NULL ,
		o_price                       		NUMBER(10)		 NULL ,
		o_totPrice                    		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		c_no                          		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE order_o_no_SEQ;

CREATE SEQUENCE order_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



ALTER TABLE member ADD CONSTRAINT IDX_member_PK PRIMARY KEY (m_id);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (c_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (m_id) REFERENCES member (m_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE order ADD CONSTRAINT IDX_order_PK PRIMARY KEY (o_no);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK0 FOREIGN KEY (p_no) REFERENCES product (p_no);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK1 FOREIGN KEY (c_no) REFERENCES cart (c_no);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK2 FOREIGN KEY (m_id) REFERENCES member (m_id);

