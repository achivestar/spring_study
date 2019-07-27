SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE LOGIN_HIST;
DROP TABLE USER;
DROP TABLE USER_LEVEL;




/* Create Tables */

CREATE TABLE USER_LEVEL
(
	-- 등급
	USER_LV int NOT NULL COMMENT '등급',
	-- 등급명
	LEVEL_NM varchar(20) NOT NULL COMMENT '등급명',
	-- 사용여부
	USE_YN varchar(1) DEFAULT 'Y' NOT NULL COMMENT '사용여부',
	PRIMARY KEY (USER_LV)
);


CREATE TABLE USER
(
	-- 아이디
	USER_ID varchar(20) NOT NULL COMMENT '아이디',
	-- 이름
	USER_NM varchar(20) COMMENT '이름',
	-- 비밀번호
	USER_PW varchar(50) COMMENT '비밀번호',
	-- 연락처
	PHONE varchar(20) COMMENT '연락처',
	-- 이메일
	EMAIL varchar(50) COMMENT '이메일',
	-- 등급
	USER_LV int COMMENT '등급',
	-- 로그인시도수
	TRY_CNT int DEFAULT 0 NOT NULL COMMENT '로그인시도수',
	-- 회원상태['01':정상, '04':중지, '02':블럭]
	STATUS varchar(2) DEFAULT '01' NOT NULL COMMENT '회원상태[''01'':정상, ''04'':중지, ''02'':블럭]',
	-- 최근로그인일시
	LAST_DT datetime COMMENT '최근로그인일시',
	-- 수정일시
	UPD_DT datetime COMMENT '수정일시',
	-- 등록일시
	REG_DT datetime COMMENT '등록일시',
	PRIMARY KEY (USER_ID)
);


CREATE TABLE LOGIN_HIST
(
	-- 번호
	NO int NOT NULL AUTO_INCREMENT COMMENT '번호',
	-- 아이디
	USER_ID varchar(20) NOT NULL COMMENT '아이디',
	-- 등급
	USER_LV int NOT NULL COMMENT '등급',
	-- 등록일시
	REG_DT datetime NOT NULL COMMENT '등록일시',
	PRIMARY KEY (NO)
);



