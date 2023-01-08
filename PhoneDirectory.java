package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    private static HashMap<String, ArrayList<Integer>> phoneNumber = new HashMap<>();

    public void add (String name, Integer number) {
        if (phoneNumber.containsKey(name)) {
            phoneNumber.get(name).add(number);
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(number);
            phoneNumber.put(name, numbers);
        }
    }
    public ArrayList<Integer> find(String name) {
        if(phoneNumber.containsKey(name)) {
            return phoneNumber.get(name);
        }
        return new ArrayList<Integer>();
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneNumber() {
        return phoneNumber;
    }
}
