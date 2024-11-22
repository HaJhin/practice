create database noodle;
use noodle;
create table member( # 회원 테이블
membernumpk int unsigned not null auto_increment, # 회원번호는 가입 순서대로 받는 int
id varchar(20),	# id 최대 20글자까지 받기 위해 varchar20
password varchar(20), # password 최대 20글자까지 받기 위해 varchar20
contact char(13), # 연락처는 XXX-XXXX-XXXX 형식으로 받기 위해 char20
 primary key(membernurpk)); # 회원번호-기본키

 create table category( # 카테고리 테이블
 categorynumpk int, # 카테고리 번호-pk : 숫자로 받기 위해 int
 categoryname char(10), # 카테고리명 : 최대 10글자까지 받기 위해 char10
 primary key(categorynumpk)); # 카테고리번호-기본키

 create table product( # 제품 테이블
 productnumpk int not null primary key, # 제품번호-기본키
 productname varchar(50), # 제품명
 productprice int, # 제품가격
 productcount int, # 제품 개수
 prod_cate_numfk int, # 제품카테고리번호
 foreign key(prod_cate_numfk) references category(categorynumpk) # 카테고리 테이블 참조
 );

 create table cart(	# 장바구니 테이블
 cartnumpk int not null primary key, # 장바구니 번호-기본키
 productstatefk int, # 담겨있는 제품
 foreign key(productstatefk) references product(productnumpk)
 ); # 제품 테이블 참조

 create table p_order( # 주문 테이블
 ordernumpk int not null primary key, # 주문번호-기본키
 orderdate date # 주문날짜
 );

 create table P_fullorder( # 주문상세 테이블
 fullordernumpk int not null primary key, # 주문상세 번호-기본키
 ordernumfk int, # 주문번호 참조키
 cartnumfk int, # 장바구니번호 참조키
 foreign key(ordernumfk) references p_order(ordernumfk), # 카트 테이블 참조
 foreign key(cartnumfk) references cart(cartnumpk) # 장바구니 테이블 참조
 );