CREATE TABLE student_achievement (
    id SERIAL PRIMARY KEY NOT NULL,
    achievement_id BIGINT,
    student_id BIGINT,

    constraint foreign_key_student_id
    FOREIGN KEY (student_id)
    REFERENCES student (id),

    constraint foreign_key_achievement_id
    FOREIGN KEY (achievement_id)
    REFERENCES achievement (id)
);