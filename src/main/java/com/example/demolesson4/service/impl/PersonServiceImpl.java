package com.example.demolesson4.service.impl;

import com.example.demolesson4.data.Person;
import com.example.demolesson4.exception.NoAccessToPersonException;
import com.example.demolesson4.exception.WrongPinCodeException;
import com.example.demolesson4.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    Person[] persons = {
            new Person("Игорь Задон", true),
            new Person("Миша Аверин", false),
            new Person("Митя Ровный", false),
            new Person("Катя Занина", false),
            new Person("Лена Горемыка", true)
    };

    int pinCode = 1234;

    @Override
    public String getPerson(Integer id) {
        if (persons.length > id) {
            try {
                return getPersonWithoutPinCode(id);
            } catch (NoAccessToPersonException exception) {
                return getNoAccessMessage();
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
            return persons[id].getName();
        } else {
            throw new WrongPinCodeException();
        }
    }

    @Override
    public String updatePerson(String name, Boolean block, Integer id) {
        if (persons.length > id) {
            Person person = persons[id];
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
        Person person = persons[id];
        if (person.isBlock()) {
            throw new NoAccessToPersonException();
        }
        return person.getName();
    }
}