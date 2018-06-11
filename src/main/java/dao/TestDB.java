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

create table person (
	id serial primary key,
	person_name varchar(100) not null,
	email varchar(100) not null,
	username varchar(60) not null,
	password varchar(60) not null,
	profile varchar(60),
	status varchar(60)
);

create table application (
	id serial primary key,
	publish_date date,
	candidate_name varchar(100),
	email varchar(100),
	phone varchar(60),
	address varchar(100),
	file varchar(60),
	idVacancy int
);
 */
