import java.util.Scanner;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number a: ");
        double a = scanner.nextDouble();

        System.out.println("Enter the second number b:");
        double b = scanner.nextDouble();

        System.out.println("Enter third number c: ");
        double c = scanner.nextDouble();

        Function<Triple, String> solver = sqareroot::solve;
        String root = solver.apply(new Triple(a, b, c));
        System.out.println(root);

        scanner.close();
    }
}

class sqareroot {
    public static String solve(Triple triple) {
        double a = triple.a;
        double b = triple.b;
        double c = triple.c;

        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            return "Roots: " + x1 + " , " + x2;
        } else if (D == 0) {
            double x = -b / (2 * a);
            return "Root is: " + x;
        } else {
            double real = -1 / (2 * a);
            double imaginary = Math.sqrt(-D) / (2 * a);
            return "real and imag1 part " + real + " + " + imaginary + "i, " + real + " - " + imaginary + "i";
        }
    }
}

class Triple {
    double a;
    double b;
    double c;

    public Triple(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
