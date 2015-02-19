package com.citiparks.grubup.service;


import java.util.List;

import com.citiparks.grubup.model.Person;

public interface PersonService {
    
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
}
