package com.example.demolesson4;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    Person[] persons = {
            new Person("Игорь Задон", false),
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
                return "Вы не имеете доступ к этому пользователю";
            }
        } else {
            return "Пользователь с id = " + id + " не найден";
        }
    }

    @Override
    public String getPersonWithPinCode(Integer id, int pinCode) {
        if (this.pinCode == pinCode) {
            return persons[id].getName();
        } else {
            throw new WrongPinCodeException();
        }
    }

    private String getPersonWithoutPinCode(Integer id) throws NoAccessToPersonException {
        Person person = persons[id];
        if (person.isBlock()) {
            throw new NoAccessToPersonException();
        }
        return person.getName();
    }
}