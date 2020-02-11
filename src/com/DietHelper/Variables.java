package com.DietHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Variables {
    public static int choice;
    public static boolean goodChoice = false;
    public static boolean isNeededGreetings = true;
    public static Scanner scanner = new Scanner(System.in);
    public static int numberOfPatients;
    public static int selectedPatient;
    public static int numberOfProducts;
    static List<Patient> patientList = new LinkedList<>();
    static List<Result> resultsList = new LinkedList<>();
    static List<Product> productsList = new LinkedList<>();
    static List<Meal> mealsList = new LinkedList<>();
    static int numberOfResults;
    public static int tempNumberOfProducts;
}
