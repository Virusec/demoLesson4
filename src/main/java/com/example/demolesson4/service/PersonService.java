package com.example.demolesson4.service;

public interface PersonService {

    String getPerson(Integer id);

    String getPersonWithPinCode(Integer id, int pinCode);

    String updatePerson(String name, Boolean block, Integer id);

    String addPerson(String name, Boolean block);

    String removePerson(Integer id);
}
