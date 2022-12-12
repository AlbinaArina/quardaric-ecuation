import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner vars = new Scanner(System.in);
        System.out.println("Print a");
        int a = Integer.parseInt(vars.nextLine());
        System.out.println("Print b");
        int b = Integer.parseInt(vars.nextLine());
        System.out.println("Print c");
        int c = Integer.parseInt(vars.nextLine());

        double[] solutions = solveQuadraticEquation(a, b, c);
        printEquation(a, b, c);
        printSolution(solutions);
    }

    public static double[] solveQuadraticEquation(int a, int b, int c) {
        if (a == 0) {
            throw new IllegalArgumentException("a can not be 0");
        }
        int discriminant = calculateDiscriminant(a, b, c);
        return findSolutions(discriminant, a, b);
    }

    private static int calculateDiscriminant(int a, int b, int c) {
        return b*b - 4*a*c;
    }

    private static double[] findSolutions(int d, int a, int b) {
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d))/(2*a);
            double x2 = (-b - Math.sqrt(d))/(2*a);
            return new double[] {x1, x2};
        } else if (d == 0) {
            double x = (-b + Math.sqrt(d))/(2*a);
            return new double[] {x};
        } else {
            return null;
        }
    }

    private static void printEquation(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append("x^2");
        if (b < 0) {
            sb.append(" - ").append(Math.abs(b)).append("x");
        } else if (b > 0) {
            sb.append(" + ").append(b).append("x");
        }
        if (c < 0) {
            sb.append(" -").append(Math.abs(c));
        } else if (c > 0) {
            sb.append(" +").append(c);
        }
        sb.append(" = ").append(" 0");
        System.out.println("Quadratic equation: " + sb);
    }

    private static void printSolution(double[] solutions) {
        if (solutions == null) {
            System.out.println("There is no solution");
        } else if (solutions.length == 1) {
            System.out.println("x = " + solutions[0]);
        } else if (solutions.length == 2) {
            System.out.println("x1 = " + solutions[0] + ", x2 = " + solutions[1]);
        }
    }
}