CREATE TABLE options_of_answer (
    options_id SMALLSERIAL PRIMARY KEY,
    first_option CHARACTER VARYING(120) NOT NULL,
    second_option CHARACTER VARYING(120) NOT NULL,
    third_option CHARACTER VARYING(120) NOT NULL,
    forth_option CHARACTER VARYING(120) NOT NULL,
    correct_option INTEGER NOT NULL
);

CREATE TABLE questions (
    question_id SMALLSERIAL PRIMARY KEY,
    question_text CHARACTER VARYING(120) NOT NULL,
    options_number SMALLSERIAL REFERENCES options_of_answer (options_id) ON DELETE CASCADE
);

INSERT INTO options_of_answer(first_option, second_option, third_option, forth_option, correct_option)
VALUES
    ('Говардом Стенфордом?', 'Мэтью Линуксом?', 'Линусом Торвальдсом?', 'Хью Грантом?', 3),
    ('16 байт', '8 байт', '32 байта', '24 байта', 4),
    ('Заголовок объекта', 'Пaмять для примитивного типа', 'Память для ссылочного типа', 'Коэффицент вариации', 4);

INSERT INTO questions(question_text)
VALUES
    ('Кем был создан Linux?'),
    ('Сколько весит объект класса Integer в 64-х разрядной системе?'),
    ('Что не входит в содержание объекта String в памяти?');

SELECT questions.*, options_of_answer.*
FROM questions
         JOIN options_of_answer
             ON questions.question_id = options_of_answer.options_id;
