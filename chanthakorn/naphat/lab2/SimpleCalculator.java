package chanthakorn.naphat.lab2;

public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Error: Please provide exacly three arguments.");
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        char operator = args[2].charAt(0);

        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case 'x':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.err.println("Error: Division by zero is not allowed.");
                }
                result = num1 / num2;
                break;
            default:
                System.err.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
        }

        System.out.println(num1 + "" + operator + "" + num2 + "=" + result);
    }
}
