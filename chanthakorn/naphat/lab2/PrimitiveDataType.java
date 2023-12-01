package chanthakorn.naphat.lab2;

public class PrimitiveDataType {
    public static void main(String[] args) {
        String first_name = "Naphat";
        int student_id = 663040652-5;
        byte bytevalue = 25;
        short shortvalue = 525;
        int intvalue = 406525;
        long longvalue = 30406525;
        double floatvalue = 0.25;
        double doublevalue = 0.30406525;
        boolean isLastDigitOdd = (student_id % 10) % 2 != 0;

        System.out.println("Student ID: " + student_id);
        System.out.println("First name: " + first_name);
        System.out.println("Byte Value: " + bytevalue);
        System.out.println("Short Value: " + shortvalue);
        System.out.println("Int Value: " + intvalue);
        System.out.println("Long Value: " + longvalue);
        System.out.println("Float Value: " + floatvalue);
        System.out.println("Double Value: " + doublevalue);
        System.out.println("Char Value: " + first_name.charAt(0));
        System.out.println("Boolean Value: " + isLastDigitOdd);
    }
}