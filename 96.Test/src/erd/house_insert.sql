/**********************member insert************************/
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('aaaa','aaaa','철수','920630','1234-5698','떡잎마을');
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('bbbb','bbbb','유리','920731','4568-8547','떡잎마을');
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('cccc','dddd','짱구','921225','9512-7584','떡잎마을');

/*********************product insert*************************/
insert into product(p_no, p_name, p_price, p_img, p_desc) values(producat_p_no_SEQ.nextval,'조립식 식탁','150000','','직접 조립하는 가구DIY');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(producat_p_no_SEQ.nextval,'아일랜드 식탁','300000','','튼튼하고 세련된 식탁');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(producat_p_no_SEQ.nextval,'파스텔톤 커튼','30000','','산뜻한 색깔의 커튼');

/*********************cart insert**********************/
--aaaa
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,2,'aaaa',1);
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,1,'aaaa',2);

--bbbb
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,2,'bbbb',3);
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,1,'bbbb',1);


