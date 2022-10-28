package com.whx.json;

import com.google.gson.Gson;
import com.whx.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author WhitehatXiao
 * @date 2022/10/1
 * @descriptions
 */
public class javaJsonUseTest {

    @Test
    public void test2(){
        ArrayList<Person> listPerson = new ArrayList<Person>();

        listPerson.add(new Person(1,"lin"));
        listPerson.add(new Person(2,"linken"));

        Gson gson = new Gson();

        String json = gson.toJson(listPerson);
        System.out.println(json);

        ArrayList<Person> arrayList = gson.fromJson(json, new PersonListType().getType());
        System.out.println(arrayList);
        Person person = arrayList.get(0);
        System.out.println(person);

        // ArrayList<Person> arrayList = gson.fromJson(s, listPerson.getClass());
        // System.out.println(arrayList);
        // Person person = arrayList.get(0);
        // System.out.println(person);
    }

    @Test
    public void test3(){



    }






}
