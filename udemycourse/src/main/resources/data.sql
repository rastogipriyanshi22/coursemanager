CREATE TABLE learn.course
(
    id bigint NOT NULL,
    name character varying COLLATE pg_catalog."default",
    author character varying COLLATE pg_catalog."default",
    CONSTRAINT course_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE learn.course
    OWNER to postgres;
    
INSERT INTO learn.course(
	id, name, author)
	VALUES (2, 'Learn JDBC1', 'PrR');