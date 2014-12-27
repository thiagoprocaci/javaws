package com.tbp.service.v1.repository;


import com.tbp.service.v1.Address;
import com.tbp.service.v1.City;
import com.tbp.service.v1.Country;
import com.tbp.service.v1.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {

    private static Map<Long, Person> DATABASE = new HashMap<Long, Person>();

    static {

        Country country = new Country();
        country.setId(1L);
        country.setName("USA");

        City city = new City();
        city.setId(1L);
        city.setName("New York");
        city.setCountry(country);
        city.setPopulation(19746227);

        Address address = new Address();
        address.setCity(city);
        address.setNumber(20);
        address.setStreet("5th avenue");

        Person p = new Person();
        p.setId(1L);
        p.setName("John");
        p.setAddress(address);

        Person p2 = new Person();
        p2.setId(2L);
        p2.setName("Mary");
        p2.setAddress(address);

        // mock database
        DATABASE.put(p.getId(), p);
        DATABASE.put(p2.getId(), p2);
    }



    public List<Person> findByExample(Person person) {
        List<Person> personList = new ArrayList<Person>();
        if (person != null) {
            for (Long id: DATABASE.keySet()) {
                Person p = DATABASE.get(id);
                if(p.getId().equals(person.getId()) || p.getName().equals(person.getName())) {
                    personList.add(p);
                    continue;
                }
                if(person.getAddress() != null) {
                    if(p.getAddress().getNumber().equals(person.getAddress().getNumber()) ||
                            p.getAddress().getStreet().equals(person.getAddress().getStreet())) {
                        personList.add(p);
                        continue;
                    }
                    if(person.getAddress().getCity() != null) {
                        if(p.getAddress().getCity().getId().equals(person.getAddress().getCity().getId()) ||
                                p.getAddress().getCity().getName().equals(person.getAddress().getCity().getName()) ||
                                p.getAddress().getCity().getPopulation().equals(person.getAddress().getCity().getPopulation())) {
                            personList.add(p);
                            continue;
                        }
                        if(person.getAddress().getCity().getCountry() != null) {
                            if(p.getAddress().getCity().getCountry().getId().equals(person.getAddress().getCity().getCountry().getId()) ||
                                    p.getAddress().getCity().getCountry().getName().equals(person.getAddress().getCity().getCountry().getName())) {
                                personList.add(p);
                            }
                        }
                    }
                }
            }
        }


        return personList;

    }

}
