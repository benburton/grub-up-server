package com.citiparks.grubup.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiparks.grubup.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

  @PersistenceContext
  EntityManager entityManager;
    
  @Transactional
  public void addPerson(Person person) {
    entityManager.persist(person);
  }

  @Transactional
  public List<Person> listPeople() {
    CriteriaQuery<Person> c = entityManager.getCriteriaBuilder().createQuery(Person.class);
    c.from(Person.class);
    return entityManager.createQuery(c).getResultList();
  }

  @Transactional
  public void removePerson(Integer id) {
    Person person = entityManager.find(Person.class, id);
    if (null != person) {
      entityManager.remove(person);
    }
  }
  
}
