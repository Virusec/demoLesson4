package com.example.demolesson4.service.impl;

import com.example.demolesson4.data.Person;
import com.example.demolesson4.exception.NoAccessToPersonException;
import com.example.demolesson4.exception.WrongPinCodeException;
import com.example.demolesson4.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    Map<Integer, Person> persons;

    int pinCode = 1234;

    Integer nextId = 0;

    public PersonServiceImpl() {
        this.persons = new HashMap<>();
        persons.put(getNextId(), new Person("Игорь Задон", true));
        persons.put(getNextId(), new Person("Миша Аверин", false));
        persons.put(getNextId(), new Person("Митя Ровный", false));
        persons.put(getNextId(), new Person("Катя Занина", false));
        persons.put(getNextId(), new Person("Лена Горемыка", true));
    }

    private Integer getNextId() {
        Integer result = nextId;
        nextId = nextId + 1;
        return result;
    }

    @Override
    public Person getPerson(Integer id) {
        return persons.get(id);
    }

    @Override
    public String getPersonName(Integer id) {
        if (persons.containsKey(id)) {
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
    public String getPersonNameWithPinCode(Integer id, int pinCode) {
        if (persons.containsKey(id)) {
            if (this.pinCode != pinCode) {
                throw new WrongPinCodeException();
            }
            return persons.get(id).getName();
        } else {
            return getNotFoundMessage(id);
        }
    }

    @Override
    public String updatePerson(String name, Boolean block, Integer id) {
        if (persons.containsKey(id)) {
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
        persons.put(getNextId(), new Person(name, block));
        return name;
    }

    @Override
    public String removePerson(Integer id) {
        if (persons.containsKey(id)) {
            return persons.remove(id).getName();
        } else {
            return getNotFoundMessage(id);
        }
    }

    private String getPersonWithoutPinCode(Integer id) throws NoAccessToPersonException {
        Person person = persons.get(id);
        if (person.isBlock()) {
            throw new NoAccessToPersonException();
        }
        return person.getName();
    }
}