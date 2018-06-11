package dao;

import model.Person;

public class TestDB {

    public static void main(String[] args) {
        ConnectDB conn = new ConnectDB();
        PersonDao personDao = new PersonDaoImpl(conn);

        Person person = personDao.login("admin", "1234");
        System.out.println(person);
    }
}

/*
insert into person
values (
	0,
	'Nelson Sandoval',
	'nelson@gmail.com',
	'admin',
	md5('1234'),
	'administrator',
	'active'
);
 */
