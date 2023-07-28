# Итоговая контрольная работа по блоку специализация

**Информация о проекте**

* Необходимо организовать систему учета для питомника в котором живут домашние и вьючные животные.

### Задание

1. Используя команду cat в терминале операционной системы Linux, создать два файла "Домашние животные"
   (заполнив файл "собаками", "кошками", "хомяками") и "Вьючные животные" (заполнив файл "лошадьми", "верблюдами" и "
   ослами"),
   а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя "Друзья
   человека".
2. Создать директорию, переместить файл туда.
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале Ubuntu.
6. Нарисовать диаграмму, в которой есть классы - родительский, домашние животные и вьючные животные,
   в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут:
   лошади, верблюды и ослы.
7. В подключенном MySQL репозитории создать базу данных “Друзья человека”.
8. Создать таблицы с иерархией из диаграммы в БД.
9. Заполнить низкоуровневые таблицы именами (животных), командами которые они выполняют и датами рождения.
10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
    Объединить таблицы "лошади", и "ослы" в одну таблицу.
11. Создать новую таблицу "молодые животные" в которую попадут все животные старше 1 года, но младше 3 лет
    и в отдельном столбце, с точностью до месяца, подсчитать возраст животных в новой таблице.
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
    В программе должен быть реализован следующий функционал:

    14.1. Завести новое животное;

    14.2. Определять животное в правильный класс;

    14.3. Увидеть список команд, которое выполняет животное;

    14.4. Обучить животное новым командам;

    14.5. Реализовать навигацию по меню.

15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆ int переменной̆ на 1
    при нажатии “Завести новое животное”. Сделайте так, чтобы с объектом такого типа можно было работать в блоке
    try-with-resources.
    Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт.
    Значение считать в ресурсе try, если при заведения животного заполнены все поля.

### Решение:
1. Команды bash:
    
    ```bash
    cat > "Домашние животные"
    Собаки
    Кошки
    Хомяки
    'Ctrl+d'
    ```
    ```bash
    cat > "Вьючные животные"
    Лошади
    Верблюды
    Ослы

    'Ctrl+d'
    ```

    ```bash
    cat "Домашние животные" "Вьючные животные" > Animals
    cat Animals
    mv "Animals" "Друзья человека"
    ```
    
2. Команды bash:
    ```bash
    mkdir final-project
    mv 'Друзья человека' final-project/
    cd final-project/
    ls
    ```
3. Команды bash:
    ```bash
    sudo apt-get update
    sudo apt install mysql-server
    sudo service mysql status
    ```
4. Команды bash:
    ```bash
    wget http://ftp.us.debian.org/debian/pool/main/s/sl/sl_5.02-1_amd64.deb
    sudo dpkg -i sl_5.02-1_amd64.deb
    sudo dpkg -r sl
    ```
5. Команды bash:
    ```bash
    135  cat > "Домашние животные"
    136  cat "Домашние животные" "Вьючные животные" > Animals
    137  cat Animals
    138  mv Animals "Друзья человека"
    139  mkdir final-project
    140  mv Друзья\ человека final-project/
    141  cd final-project/
    142  ls
    143  sudo apt-get update
    144  sudo apt install mysql-server
    145  sudo service mysql-server status
    146  sudo service mysql status
    147  dpkg --help
    148  dpkg -l
    149  wget http://ftp.us.debian.org/debian/pool/main/s/sl/sl_5.02-1_amd64.deb
    150  sudo dpkg -i sl_5.02-1_amd64.deb
    151  sudo dpkg -r sl
    152  history
    ```
6. Cхема:

    ![schema](https://github.com/a-shlyapnikov/final-project/blob/main/src/diagram.png)

7. Команды SQL:
    ```sql
    CREATE DATABASE Друзья_человка;
    USE Друзья_человка;
    ```
8. Команды SQL:
    ```sql
    CREATE TABLE animals (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        type VARCHAR(50)
    );

    CREATE TABLE house_animals(
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        type VARCHAR(60), 
        animal_type INT default 1,
        FOREIGN KEY (animal_type) REFERENCES animals(id)
    );

    CREATE TABLE pack_animals(
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        type VARCHAR(60),
        animal_type INT default 2,
        FOREIGN KEY (animal_type) REFERENCES animals(id)
    );

    CREATE TABLE cats (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(50),
        commands VARCHAR(50),
        birthday DATE,
        type_id int default 1,
        FOREIGN KEY (type_id) REFERENCES house_animals(id)
    );

    CREATE TABLE dogs (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(50),
        commands VARCHAR(50),
        birthday DATE,
        type_id int default 2,
        FOREIGN KEY (type_id) REFERENCES house_animals(id)
    );

    CREATE TABLE hamsters (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(50),
        commands VARCHAR(50),
        birthday DATE,
        type_id int default 3,
        FOREIGN KEY (type_id) REFERENCES house_animals(id)
    );

    CREATE TABLE horses (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(50),
        commands VARCHAR(50),
        birthday DATE,
        type_id int default 1,
        FOREIGN KEY (type_id) REFERENCES pack_animals(id)
    );

    CREATE TABLE camels (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(50),
        commands VARCHAR(50),
        birthday DATE,
        type_id int default 2,
        FOREIGN KEY (type_id) REFERENCES pack_animals(id)
    );

    CREATE TABLE donkeys (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(50),
        commands VARCHAR(50),
        birthday DATE,
        type_id int default 3,
        FOREIGN KEY (type_id) REFERENCES pack_animals(id)
    );


    ```
9. Команды SQL:
    ```sql
    INSERT INTO cats ( `name`, commands, birthday)
    VALUES ('Бурбон', 'Кис-кис', '2021-01-20'),
        ('Симба', 'Кскс', '2019-03-03');

    INSERT INTO dogs ( `name`, commands, birthday)
    VALUES ('Рекс', 'Дай лапу', '2019-01-21'),
        ('Керри', 'Лежать', '2020-03-08');

    INSERT INTO hamsters ( `name`, commands, birthday)
    VALUES ('Желток', 'Кушать', '2022-01-21'),
        ('Печенька', 'Домой', '2023-03-08');

    INSERT INTO horses ( `name`, commands, birthday)
    VALUES ('Спирит', 'Но', '2020-01-21'),
        ('Вавилон', 'Бррррр', '2022-03-08');  

    INSERT INTO camels ( `name`, commands, birthday)
    VALUES ('Тимон', 'Вперед, стоп', '2019-02-01'),
        ('Пубма', 'На месте', '2018-11-12'),
        ('МолнияМакуин', 'Ждать', '2006-04-05');

    INSERT INTO donkeys ( `name`, commands, birthday)
    VALUES ('Анатолий', 'Пошёл', '2019-01-21'),
        ('Кирилл', 'Стой', '2021-03-08');

    ```
10. Команды SQL:
    ```sql
    TRUNCATE TABLE camels;
    ```
    ```sql
    CREATE TABLE horses_and_donkeys AS
    SELECT * FROM horses
    UNION
    SELECT * FROM donkeys;

    ALTER TABLE horses_and_donkeys DROP column id;

    ALTER TABLE horses_and_donkeys ADD id INT NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;
    ```
11. Команды SQL:
    ```sql
    CREATE TABLE young_animals
        SELECT `name`, birthday, commands, type_id
        FROM cats
        WHERE YEAR(NOW()) - YEAR(birthday) BETWEEN 1 AND 3
        UNION
        SELECT `name`, birthday, commands, type_id
        FROM dogs
        WHERE YEAR(NOW()) - YEAR(birthday) BETWEEN 1 AND 3
        UNION
        SELECT `name`, birthday, commands, type_id
        FROM hamsters
        WHERE YEAR(NOW()) - YEAR(birthday) BETWEEN 1 AND 3
        UNION
        SELECT `name`, birthday, commands, type_id
        FROM horses_and_donkeys
        WHERE YEAR(NOW()) - YEAR(birthday) BETWEEN 1 AND 3;
    
    ALTER TABLE young_animals ADD id INT NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;

    ALTER TABLE young_animals ADD age VARCHAR(50) DEFAULT (CONCAT(TIMESTAMPDIFF(YEAR, birthday, NOW()), ' year ', TIMESTAMPDIFF(MONTH, birthday, NOW())%12, ' month'));

    ```
12. Команды SQL:
    ```sql
    CREATE TABLE animals_all AS
    SELECT id, `name`, birthday, commands, type_id FROM dogs
    UNION ALL
    SELECT  id, `name`, birthday, commands, type_id FROM cats
    UNION ALL
    SELECT id, `name`, birthday, commands, type_id FROM hamsters
    UNION ALL
    SELECT id, `name`, birthday, commands, type_id FROM horses
    UNION ALL
    SELECT id, `name`, birthday, commands, type_id FROM donkeys;
    
    ```

### Решение заданий 13-15 лежит (тут)[https://github.com/a-shlyapnikov/final-project/tree/main/JavaProject/final-projectGB]