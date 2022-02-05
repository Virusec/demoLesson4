package com.example.demolesson4.service.impl;

import com.example.demolesson4.data.Person;
import com.example.demolesson4.exception.NoAccessToPersonException;
import com.example.demolesson4.exception.WrongPinCodeException;
import com.example.demolesson4.service.PersonService;
import com.example.demolesson4.service.list.Mylist;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    Mylist<Person> persons;

    int pinCode = 1234;

    public PersonServiceImpl() {
        this.persons = new Mylist<>();
        persons.add(new Person("Игорь Задон", true));
        persons.add(new Person("Миша Аверин", false));
        persons.add(new Person("Митя Ровный", false));
        persons.add(new Person("Катя Занина", false));
        persons.add(new Person("Лена Горемыка", true));
    }

    @Override
    public String getPerson(Integer id) {
        if (persons.size() > id) {
            try {
                //Блок кода в котором мы хотим поймать ошибку
                return getPersonWithoutPinCode(id);
                //Описываем какую мы хотим поймать и называем переменную этой ошибки
            } catch (NoAccessToPersonException exception) {
                //Пишем обработку ошибки
                return getNoAccessMessage();
            } finally {
                // finally блок, этот блок выполниться в любом случае после try-catch блоков
                System.out.println("Finally block");
            }
        } else {
            return getNotFoundMessage(id);
        }
    }

    private String getNoAccessMessage() {
        return "Вы не имеете доступ к этому пользователю";
    }

    private String getNotFoundMessage(Integer id) {
        return "Пользователь с id = " + id + " не найден";
    }

    @Override
    public String getPersonWithPinCode(Integer id, int pinCode) {
        if (this.pinCode == pinCode) {
            return persons.get(id).getName();
        } else {
            throw new WrongPinCodeException();
        }
    }

    @Override
    public String updatePerson(String name, Boolean block, Integer id) {
        if (persons.size() > id) {
            Person person = persons.get(id);
            if (!person.isBlock()) {
                person.setName(name);
                person.setBlock(block);
                return name;
            } else {
                return getNoAccessMessage();
            }

        } else {
            return getNotFoundMessage(id);
        }
    }

    @Override
    public String addPerson(String name, Boolean block) {
        return null;
    }

    @Override
    public String removePerson(Integer id) {
        return null;
    }

    private String getPersonWithoutPinCode(Integer id) throws NoAccessToPersonException {
        Person person = persons.get(id);
        if (person.isBlock()) {
            throw new NoAccessToPersonException();
        }
        return person.getName();
    }
}