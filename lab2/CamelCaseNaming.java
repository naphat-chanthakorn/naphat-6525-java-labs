public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Please provide exacly two arguments");
        }
        String firstname = args[0].toLowerCase();
        firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);

        String surname = args[1].toLowerCase(); 
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        String camelCaseString = firstname + surname;

        System.out.println("Camel Case: " + camelCaseString);
    }
}