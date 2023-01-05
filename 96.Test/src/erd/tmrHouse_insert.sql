/**********************member insert************************/
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('aaaa','aaaa','철수','920630','1234-5698','떡잎마을');
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('bbbb','bbbb','유리','920731','4568-8547','떡잎마을');
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('cccc','dddd','짱구','921225','9512-7584','떡잎마을');

/*********************product insert*************************/
insert into product(p_no, p_name, p_price, p_img, p_desc) values(product_p_no_SEQ.nextval,'조립식 식탁',150000,'dafult.jpg','직접 조립하는 가구DIY');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(product_p_no_SEQ.nextval,'아일랜드 식탁',30000,'dafult.jpg','튼튼하고 세련된 식탁');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(product_p_no_SEQ.nextval,'파스텔톤 커튼',30000,'dafult.jpg','산뜻한 색깔의 커튼');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(product_p_no_SEQ.nextval,'다육이',15000,'dafult.jpg','귀여운 식물');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(product_p_no_SEQ.nextval,'머쉬룸스탠드',20000,'dafult.jpg','버섯모양의 느낌있는 조명');
insert into product(p_no, p_name, p_price, p_img, p_desc) values(product_p_no_SEQ.nextval,'파스텔톤 커튼',30000,'dafult.jpg','산뜻한 색깔의 커튼');
/*********************cart insert**********************/
--aaaa
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,2,'aaaa',1);
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,1,'aaaa',2);

--bbbb
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,2,'bbbb',3);
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval,1,'bbbb',1);

/*********************orders insert*********************/
/*
aaa님이
    제품번호 1번 1개
    제품번호 3번 1개
*/
-- orders insert
insert into orders(o_no, o_desc, o_qty, o_price, o_date) values(orders_o_no_SEQ.newtval,'조립식 식탁 외1건',1,150000,sysdate);

-- order item insert
-- 제품번호 1번 1개
insert into order_item(oi_no, oi_qty, o_no, p_no) values();





