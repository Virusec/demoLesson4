package com.example.demolesson4.service;

import com.example.demolesson4.data.Person;

public interface PersonService {

    Person getPerson(Integer id);

    String getPersonName(Integer id);

    String getPersonNameWithPinCode(Integer id, int pinCode);

    String updatePerson(String name, Boolean block, Integer id);

    String addPerson(String name, Boolean block);

    String removePerson(Integer id);
}
