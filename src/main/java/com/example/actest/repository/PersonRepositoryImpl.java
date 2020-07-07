package com.example.actest.repository;

import com.example.actest.CsvUtil;
import com.example.actest.model.Person;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    private List<Person> personList;

    private final String fileName = "sample-input.csv";

    public PersonRepositoryImpl() throws IOException, CsvException {

        Resource resource = new ClassPathResource("static" + "/" + fileName);
        File file = resource.getFile();
        CsvUtil csvUtil = new CsvUtil();
        List<String[]> list = csvUtil.readCsvFile(file);
        this.personList = modelGenerator(list);

    }

    public List<Person> findAll() {
        return this.personList;
    }

    public Person findById(int id) {
        return personList.get(id-1);
    }

    public List<Person> findByColor(String color) {
        List<Person> selectedPerson = new ArrayList<>();
        for (Person person: this.personList) {
            if (person.getColor().contains(color)){
                selectedPerson.add(person);
            }
        }
        return selectedPerson;
    }

    /**
     * tranfer a list of string to a list including person objects
     * @param list
     * @return
     */
    public List<Person> modelGenerator(List<String[]> list) {
        List<Person> personList = new ArrayList<>();
        for (int i=0; i< list.size(); i++) {
            Person person = new Person();
            person.setId(i+1);
            person.setLastname(list.get(i)[0]);
            person.setName(list.get(i)[1]);
            String zipCodeAndCity = list.get(i)[2];
            String city = zipCodeAndCity.replaceAll("[^(a-zA-Z)]","" );
            String zipCode = zipCodeAndCity.replaceAll("[^(0-9)]", "");
            person.setZipcode(zipCode);
            person.setCity(city);
            String colorCode = list.get(i)[3];
            if (colorCode.contains("1")){
                person.setColor("blau");
            }else if (colorCode.contains("2")){
                person.setColor("grün");
            }else if (colorCode.contains("3")){
                person.setColor("violett");
            }else if (colorCode.contains("4")){
                person.setColor("rot");
            }else if (colorCode.contains("5")){
                person.setColor("gelb");
            }else if (colorCode.contains("6")){
                person.setColor("türkis");
            }else if (colorCode.contains("7")){
                person.setColor("weiß");
            }else {
                System.out.println("error");
            }
            personList.add(person);
        }
        return personList;

    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
