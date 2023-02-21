DROP   TABLE  USERS;
DROP   TABLE  GROCERIES; 
DROP   TABLE  GROCERY_INPUT; 
DROP   TABLE  GROCERY_OUTPUT; 
DROP   TABLE  GROCERY_EXPIRE; 
DROP   TABLE  EXPENSES; 


--TABLE 생성
CREATE TABLE USERS
( 
  USER_ID          VARCHAR2(50)   NOT  NULL  PRIMARY KEY  --유저 ID P
 ,USER_NAME        VARCHAR2(50)   NOT  NULL               --유저 이름
 ,USER_PASSWORD    VARCHAR2(50)   NOT  NULL               --유저 비밀번호
 ,USER_EMAIL       VARCHAR2(50)   UNIQUE                  --유저 이메일
 ,USER_GRADE       NUMBER(1)      NOT  NULL               --전회원(0)/현회원(1)/관리자(2) 숫자로 구분
 ,USER_STATUS      VARCHAR2(20)   NOT  NULL               --전회원/현회원/관리자
);

CREATE TABLE GROCERIES
(
  GROCERY_ID       NUMBER(6)      NOT  NULL  PRIMARY KEY  --재료 ID 
 ,GROCERY_NAME     VARCHAR2(50)   NOT  NULL               --재료 이름
 ,MAJOR_CLASSIFIC  VARCHAR2(30)   NOT  NULL               --대분류
 ,MINOR_CLASSIFIC  VARCHAR2(30)   NOT  NULL               --중분류
);

CREATE TABLE GROCERY_INPUT
(
  INPUT_ID        NUMBER(6)      NOT  NULL  PRIMARY KEY   --KEY입고 ID 
 ,GROCERY_ID      NUMBER(6)      NOT  NULL                --재료 ID
 ,GROCERY_NAME    VARCHAR2(50)   NOT  NULL                --재료 이름
 ,MAJOR_CLASSIFIC VARCHAR2(30)   NOT  NULL                --대분류
 ,MINOR_CLASSIFIC VARCHAR2(30)   NOT  NULL                --중분류
 ,STORAGE_PLACE   VARCHAR2(30)   NOT  NULL                --재료 보관장소
 ,STORE_ID        NUMBER(6)      UNIQUE                   --구매처ID
 ,QUANTITY        NUMBER(10)     NOT  NULL                --재료 수량
 ,PRICE           NUMBER(10)     NOT  NULL                --재료 가격 
 ,STORE_NAME      VARCHAR2(20)   NOT  NULL                --구매처 이름
 ,INPUT_DATE      DATE           DEFAULT    SYSDATE       --입고날짜
 ,EXPIRE_DATE     DATE           NOT  NULL                --소비기한
 ,USER_ID         VARCHAR2(50)   NOT  NULL                --입고한 사람 
  
 
 ,FOREIGN KEY   ( GROCERY_ID ) REFERENCES    GROCERIES( GROCERY_ID )
 ,FOREIGN KEY   ( USER_ID ) REFERENCES    USERS( USER_ID )
);

 
CREATE TABLE GROCERY_OUTPUT
(
  OUTPUT_ID       NUMBER(6)      NOT  NULL  PRIMARY KEY   --출고 ID 
 ,GROCERY_ID      NUMBER(6)      NOT  NULL                --재료 ID
 ,GROCERY_NAME    VARCHAR2(50)   NOT  NULL                --재료 이름
 ,MAJOR_CLASSIFIC VARCHAR2(30)   NOT  NULL                --대분류
 ,MINOR_CLASSIFIC VARCHAR2(30)   NOT  NULL                --중분류
 ,STORAGE_PLACE   VARCHAR2(30)   NOT  NULL                --재료 보관장소
 ,OUTPUT_DATE     DATE           DEFAULT    SYSDATE       --출고 날짜
 ,OUTPUT_QUANTITY NUMBER(10)     NOT  NULL                --출고 수량
 ,USER_ID         VARCHAR2(50)   NOT  NULL                --출고한 사람 FOREIGN KEY
 
 
 ,FOREIGN KEY   ( GROCERY_ID ) REFERENCES    GROCERIES( GROCERY_ID )
 ,FOREIGN KEY   ( USER_ID ) REFERENCES    USERS( USER_ID )
);

CREATE TABLE GROCERY_EXPIRE
(
 EXPIRED_ID        NUMBER(6)      NOT  NULL  PRIMARY KEY  --페기 ID 
 ,GROCERY_ID       NUMBER(6)      NOT  NULL               --재료 ID
 ,DISCARD_QUANTITY NUMBER(10)     NOT  NULL               --폐기 수량
 ,DISCARD_DATE     DATE           NOT  NULL               --폐기 날짜
 ,DISCARD_REASON   VARCHAR2(50)                           --폐기 사유
 ,USER_ID          VARCHAR2(50)   NOT  NULL               --폐기한 사람 FOREIGN KEY
 
 ,FOREIGN KEY   ( GROCERY_ID ) REFERENCES    GROCERIES( GROCERY_ID ) 
 ,FOREIGN KEY   ( USER_ID ) REFERENCES    USERS( USER_ID )
);

CREATE TABLE EXPENSES
(
 EXPENSE_ID        NUMBER(6)      NOT  NULL  PRIMARY KEY  --지출 ID
 ,EXPENSE_DATE     DATE           NOT  NULL               --지출 날짜
 ,EXPENSE_CATEGORY VARCHAR2(10)   NOT  NULL               --지출 종류, 소비/폐기
 ,AMOUNT           NUMBER(15)     NOT  NULL               --지출액
 ,STORE_ID         NUMBER(6)      UNIQUE                  --구매처ID, FOREIGN KEY
 ,STORE_NAME       VARCHAR2(20)   NOT  NULL               --구매처 이름
 ,USER_ID          VARCHAR2(50)   NOT  NULL               --유저ID, FOREIGN KEY
 
 ,FOREIGN KEY   ( STORE_ID ) REFERENCES    GROCERY_INPUT( STORE_ID ) 
 ,FOREIGN KEY   ( USER_ID ) REFERENCES    USERS( USER_ID )
);

COMMIT;
--------------------------------------------------------------------------------
--USERS 테이블 데이터 삽입
INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'admin', '나관리', '1234',  'managergreen@naver.com',  2,  '관리자'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'star', '하나별', '1234567',  'onestar@naver.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'sky', '나하늘', '1234',  'bluesky@naver.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'rain', '오나비', '1234',  'rain@naver.com',  0,  '전회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'wind', '강바람', '1234',  'strongwind@gmail.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'spring', '이봄', '1234',  'spring@gmail.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'summer', '한여름', '1234',  'hotsummer@gmail.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'autumn', '김가을', '1234',  'lonely@naver.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'winter', '한겨울', '1234',  'coldwinter@gmail.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'yesterday', '나어제', '1234',  'yesterday@gmail.com',  0,  '전회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'today', '나오늘', '1234',  'today@gmail.com',  1,  '현회원'
);

INSERT INTO USERS (
USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS
) 
VALUES (
 'tomorrow', '나내일', '1234',  'tomorrow@gmail.com',  1,  '현회원'
);

COMMIT;
--------------------------------------------------------------------------------

--GROCERY_INPUT 테이블 데이터 삽입

INSERT INTO GROCERY_INPUT (
 INPUT_ID,         GROCERY_ID,      GROCERY_NAME, 
 MAJOR_CLASSIFIC, MINOR_CLASSIFIC, STORAGE_PLACE,
 STORE_ID,         QUANTITY,        PRICE,
 STORE_NAME,      INPUT_DATE,   EXPIRE_DATE, USER_ID
)
VALUES (
 1,                      1,            '사과', 
 '과일',             '사과/배',        '냉장',
 1,                      5,             12000,
 'Homeplus',       '2023-02-10',      '2023-03-10',   'star'
);

COMMIT;







