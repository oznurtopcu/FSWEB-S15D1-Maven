package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public ArrayList<String> startGrocery() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter choice: you can choice 0-1-2");

        String choice = input.nextLine();
        System.out.println("choice::::: " + choice);
        switch (choice) {
            case "0" -> {
                input.close();
                System.out.println("Program sonlandırıldı.");
            }
            case "1" -> {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                String addInput = input.nextLine();
                String[] adds = addInput.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                //ArrayList<String> addList  = new ArrayList<>(Arrays.asList(adds));
                for (String add : adds) {
                    addItems(add);
                }
            }
            case "2" -> {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz:");
                String removeInput = input.nextLine();
                String[] removes = removeInput.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                //ArrayList<String> removeList  = new ArrayList<>(Arrays.asList(removes));
                for (String remove : removes) {
                    removeItems(remove);
                }
            }
            default -> System.out.println("Lütfen geçerli bir seçim yapınız.");
        }


        return groceryList;
    }

    public static void addItems(String input) {
        //gelen tek bir string de olabilir, virgülle ayrılmış birden çok da olabilir
        //bu yüzden array haline getirdik
        String[] items = input.toLowerCase().replaceAll("[^a-zA-Z\\s]", " ").split("\\s+");
        System.out.println(Arrays.toString(items));
        for(String item: items) {
            if(!checkItemIsInList(item))  {
                groceryList.add(item);
            }
        }
        printSorted();
    }
    public static void removeItems(String input) {
        //gelen tek bir string de olabilir, virgülle ayrılmış birden çok da olabilir
        //bu yüzden array haline getirdik
        String[] items = input.toLowerCase().replaceAll("[^a-zA-Z\\s]", " ").split("\\s+");
        System.out.println(Arrays.toString(items));
        for(String item: items) {
            if(checkItemIsInList(item))  {
                groceryList.remove(item);
            }
        }
        printSorted();
    }
    public static boolean checkItemIsInList(String input) {
        return groceryList.contains(input);
    }
    public static void printSorted() {
        //listeyi sortlamaya yarıyor
        Collections.sort(groceryList);
    }




}
