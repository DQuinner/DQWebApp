CREATE TABLE  "WEB_USER_ROLES"   
   ("USER_ROLE_ID" NUMBER(10,0) NOT NULL ENABLE,
    "USER_ID" NUMBER(10,0) NOT NULL ENABLE,   
	"USERNAME" VARCHAR2(255 CHAR) NOT NULL ENABLE,   
	"ROLE" VARCHAR2(255 CHAR) NOT NULL ENABLE,	
	PRIMARY KEY ("USER_ROLE_ID") ENABLE  
   )  
/  

