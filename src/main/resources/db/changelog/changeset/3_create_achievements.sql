CREATE TABLE achievement (
    id SERIAL PRIMARY KEY NOT NULL,
    bonus INT NOT NULL,
    student_id BIGINT,

    constraint foreign_key_student_id
    FOREIGN KEY (student_id)
    REFERENCES student (id)
);