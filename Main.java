package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //enterPhoneDirectory();
        //getNames();
        arrayListHeapsort();
    }
    /*Реализуйте структуру телефонной книги с помощью HashMap,
     учитывая, что 1 человек может иметь несколько телефонов.*/
    private static void enterPhoneDirectory(){
        PhoneDirectory phons = new PhoneDirectory();
        phons.add("Иван Иванов", 212115);
        phons.add("Светлана Петрова", 123456);
        phons.add("Кристина Белова", 363738);
        phons.add("Иван Иванов", 252627);
        phons.add("Анна Мусина", 986544);
        System.out.println("Светлана Петрова: "+ phons.find("Светлана Петрова"));
        System.out.println("Иван Иванов: "+ phons.find("Иван Иванов"));

    }
    /*Пусть дан список сотрудников
    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности.
     */
    private static void getNames(){
        NameWorkers names = new NameWorkers();
        String[] workers = {"Иван Иванов","Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
        "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
        "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин","Иван Ежов"};
        for (int i = 0; i < workers.length; i++) {
            names.add(workers[i]);
        }
        names.getSortNamesRank();
    }
/*Реализовать алгоритм пирамидальной сортировки (HeapSort)*/
    private static void arrayListHeapsort(){
        ArrayList<Integer> array = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int val = random.nextInt(-10, 10);
            array.add(val);
        }
        System.out.println("Задан целочисленный список");
        System.out.println(Arrays.asList(array));
        System.out.println("Список отсортирован пирамидальной сортировкой");
        array = heapSort(array);
        System.out.println(Arrays.asList(array));

    }

    private static ArrayList<Integer> heapSort(ArrayList<Integer> myArray){
        int temp;
        int size = myArray.size()-1;
        for (int i = (myArray.size() / 2); i >= 0; i--) {
            heapify(myArray, i, size);
        };
        for(int i= size; i>=0; i--) {
            temp = myArray.get(0);
            myArray.set(0, myArray.get(size));
            myArray.set(size, temp);
            size--;
            heapify(myArray, 0, size);
        }
        return myArray;
    }
    public static void heapify (ArrayList<Integer> myArray, int i, int heapSize) {
        int a = 2*i;
        int b = 2*i+1;
        int largestElement;
        if (a<= heapSize && myArray.get(a) > myArray.get(i)) {
            largestElement = a;
        } else {
            largestElement = i;
        }
        if (b <= heapSize && myArray.get(b) > myArray.get(largestElement)) {
            largestElement = b;
        }
        if (largestElement != i) {
            int temp = myArray.get(i);
            myArray.set(i, myArray.get(largestElement));
            myArray.set(largestElement, temp);
            heapify(myArray, largestElement, heapSize);
        }
    }
}