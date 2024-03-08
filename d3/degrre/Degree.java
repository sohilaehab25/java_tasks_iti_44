import java.util.Scanner;
import java.util.function.Function;

class CelsiusToFahrenheit implements Function<Double, Double> {
    public Double apply(Double celsius) {
        return (celsius * 1.8) + 32;
    }
}

class Degree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your degree:");
        double celsius = scanner.nextDouble();

        CelsiusToFahrenheit converter = new CelsiusToFahrenheit();
        double fahrenheit = converter.apply(celsius);

        System.out.println("Your degree in Fahrenheit: " + fahrenheit);
        scanner.close();
    }
}
