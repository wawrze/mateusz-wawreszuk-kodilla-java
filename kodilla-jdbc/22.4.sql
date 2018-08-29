CREATE TABLE BOOKS_AUD (
	EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
    EVENT_DATE DATETIME NOT NULL,
    EVENT_TYPE VARCHAR(10) DEFAULT NULL,
    BOOK_ID INT(11) DEFAULT NULL,
    OLD_TITLE VARCHAR(255),
    NEW_TITLE VARCHAR(255),
    OLD_PUBYEAR INT(4),
    NEW_PUBYEAR INT(4),
    OLD_BESTSELLER BOOLEAN,
    NEW_BESTSELLER BOOLEAN,
    PRIMARY KEY(`EVENT_ID`)
);

CREATE TABLE READERS_AUD (
	EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
    EVENT_DATE DATETIME NOT NULL,
    EVENT_TYPE VARCHAR(10) DEFAULT NULL,
    READER_ID INT(11) DEFAULT NULL,
    OLD_FIRSTNAME VARCHAR(255),
    NEW_FIRSTNAME VARCHAR(255),
    OLD_LASTNAME VARCHAR(255),
    NEW_LASTNAME VARCHAR(255),
    OLD_PESELID VARCHAR(11),
    NEW_PESELID VARCHAR(11),
    OLD_VIP_LEVEL VARCHAR(20),
    NEW_VIP_LEVEL VARCHAR(20),
    PRIMARY KEY(`EVENT_ID`)
);

commit;

DELIMITER $$

create trigger BOOKS_INSERT after insert on BOOKS
for each row
begin
	insert into BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER)
		   values (curtime(), "INSERT", new.BOOK_ID, new.TITLE, new.PUBYEAR, new.BESTSELLER);
end $$

create trigger BOOKS_DELETE after delete on BOOKS
for each row
begin
insert into BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, OLD_TITLE, OLD_PUBYEAR, OLD_BESTSELLER)
		   values (curtime(), "DELETE", old.BOOK_ID, old.TITLE, old.PUBYEAR, old.BESTSELLER);
end $$

create trigger BOOKS_UPDATE after update on BOOKS
for each row
begin
	insert into BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID,
                            OLD_TITLE, NEW_TITLE,
                            OLD_PUBYEAR, NEW_PUBYEAR,
                            OLD_BESTSELLER, NEW_BESTSELLER)
		   values (curtime(), "UPDATE", old.BOOK_ID,
                            old.TITLE, new.TITLE,
                            old.PUBYEAR, new.PUBYEAR,
                            old.BESTSELLER, new.BESTSELLER);
end $$

create trigger READERS_INSERT after insert on READERS
for each row
begin
	insert into READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
						     NEW_FIRSTNAME,
                             NEW_LASTNAME,
                             NEW_PESELID,
                             NEW_VIP_LEVEL)
		   values (curtime(), "INSERT", new.READER_ID,
							 new.FIRSTNAME,
                             new.LASTNAME,
                             new.PESELID,
                             new.VIP_LEVEL);
end $$

create trigger READERS_DELETE after delete on READERS
for each row
begin
insert into READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
						 OLD_FIRSTNAME,
                         OLD_LASTNAME,
                         OLD_PESELID,
                         OLD_VIP_LEVEL)
		   values (curtime(), "DELETE", old.READER_ID,
						 old.FIRSTNAME,
                         old.LASTNAME,
                         old.PESELID,
                         old.VIP_LEVEL
                         );
end $$

create trigger READERS_UPDATE after update on READERS
for each row
begin
	insert into READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
                            OLD_FIRSTNAME, NEW_FIRSTNAME,
                            OLD_LASTNAME, NEW_LASTNAME,
                            OLD_PESELID, NEW_PESELID,
                            OLD_VIP_LEVEL, NEW_VIP_LEVEL)
		   values (curtime(), "UPDATE", old.READER_ID,
                            old.FIRSTNAME, new.FIRSTNAME,
                            old.LASTNAME, new.LASTNAME,
                            old.PESELID, new.PESELID,
                            old.VIP_LEVEL, new.VIP_LEVEL);
end $$

DELIMITER ;