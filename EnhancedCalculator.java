import java.util.Scanner;

public class EnhancedCalculator {

    // Basic arithmetic operations
    public int add(int x, int y){
        System.out.println("The Addition Value is: -> ");
        return x + y;
    }
    
    public int sub(int x, int y){
        System.out.println("The Subtraction Value is: ->");
        return x - y;
    }

    public int multiply(int x, int y){
        System.out.println("The Multiplication Value is: ->");
        return x * y;
    }

    public double divide(int x, int y){
        if (y == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;  // Return NaN (Not-a-Number) in case of error.
        }
        System.out.println("The Division Value is: ->");
        return (double) x / y;
    }

    // Scientific calculations
    public double squareRoot(double x) {
        if (x < 0) {
            System.out.println("Error: Square root of negative number is not defined.");
            return Double.NaN;  // Return NaN for invalid input.
        }
        System.out.println("The Square Root Value is: ->");
        return Math.sqrt(x);
    }

    public double exponentiation(double base, double exponent) {
        System.out.println("The Exponentiation Value is: ->");
        return Math.pow(base, exponent);
    }

    // Unit conversions
    public double fahrenheitToCelsius(double fahrenheit) {
        System.out.println("Fahrenheit to Celsius: ->");
        return (fahrenheit - 32) * 5/9;
    }

    public double celsiusToFahrenheit(double celsius) {
        System.out.println("Celsius to Fahrenheit: ->");
        return (celsius * 9/5) + 32;
    }

    public double usdToInr(double usd) {
        double conversionRate = 83.0; // Example conversion rate
        System.out.println("USD to INR conversion: ->");
        return usd * conversionRate;
    }

    public double inrToUsd(double inr) {
        double conversionRate = 1/83.0; // Reverse conversion
        System.out.println("INR to USD conversion: ->");
        return inr * conversionRate;
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnhancedCalculator calc = new EnhancedCalculator();
        int choice;

        while (true) {
            System.out.println("\nEnhanced Calculator Menu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation");
            System.out.println("7. Fahrenheit to Celsius");
            System.out.println("8. Celsius to Fahrenheit");
            System.out.println("9. USD to INR Conversion");
            System.out.println("10. INR to USD Conversion");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 11) {
                System.out.println("Exiting the calculator...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter two integers: ");
                    int x1 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    System.out.println("Result: " + calc.add(x1, y1));
                    break;
                case 2:
                    System.out.print("Enter two integers: ");
                    int x2 = scanner.nextInt();
                    int y2 = scanner.nextInt();
                    System.out.println("Result: " + calc.sub(x2, y2));
                    break;
                case 3:
                    System.out.print("Enter two integers: ");
                    int x3 = scanner.nextInt();
                    int y3 = scanner.nextInt();
                    System.out.println("Result: " + calc.multiply(x3, y3));
                    break;
                case 4:
                    System.out.print("Enter two integers: ");
                    int x4 = scanner.nextInt();
                    int y4 = scanner.nextInt();
                    System.out.println("Result: " + calc.divide(x4, y4));
                    break;
                case 5:
                    System.out.print("Enter a number to find the square root: ");
                    double x5 = scanner.nextDouble();
                    System.out.println("Result: " + calc.squareRoot(x5));
                    break;
                case 6:
                    System.out.print("Enter base and exponent: ");
                    double base = scanner.nextDouble();
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + calc.exponentiation(base, exponent));
                    break;
                case 7:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.println("Result: " + calc.fahrenheitToCelsius(fahrenheit) + " Celsius");
                    break;
                case 8:
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Result: " + calc.celsiusToFahrenheit(celsius) + " Fahrenheit");
                    break;
                case 9:
                    System.out.print("Enter amount in USD: ");
                    double usd = scanner.nextDouble();
                    System.out.println("Result: " + calc.usdToInr(usd) + " INR");
                    break;
                case 10:
                    System.out.print("Enter amount in INR: ");
                    double inr = scanner.nextDouble();
                    System.out.println("Result: " + calc.inrToUsd(inr) + " USD");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
