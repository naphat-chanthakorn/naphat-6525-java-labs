package chanthakorn.naphat.lab2; 
public class Patient {
    public static void main(String[] args) {
        if (args.length == 3) {
            String name = args[0];
            String age = args[1];
            String gender = args[2];
            System.out.println("Patient's name: " + name);
            System.out.println("age: " + age);
            System.out.println("gender: " + gender);
        }
        else {
            System.err.println("Invalid number of arguments. Please provide exactly three arguments");
        }
    }
}

/**
 * The Patient's Program:
 * This program accecpts three argruments then provide
 * and display patient information
 * The output should be
 * Patient's name: <patient_name>
 * age: <patient_age>
 * gender: <patient_gender>
 * 
 * Author: Naphat Chanthakorn
 * ID: 663040652-5
 * Sec: 2
 */