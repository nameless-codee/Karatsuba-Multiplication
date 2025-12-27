import java.util.Scanner;

public class Karatsuba {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Note: Lengths should be a power of 2 and equal.");
        System.out.print("Enter number 1: ");
        long num1 = scan.nextLong();
        System.out.print("Enter number 2: ");
        long num2 = scan.nextLong();

        System.out.println("The result is: " + multiply(num1, num2));
        scan.close();
    }

    public static long multiply(long x, long y) {
        // Base case: single digit multiplication
        if (x < 10 && y < 10) {
            return x * y;
        }

        // Calculate the size of the numbers
        String s1 = String.valueOf(x);
        String s2 = String.valueOf(y);
        int n = Math.max(s1.length(), s2.length());
        int halfN = n / 2;

        // Split numbers: x = a*10^m + b, y = c*10^m + d
        long powerOf10 = (long) Math.pow(10, halfN);
        long a = x / powerOf10;
        long b = x % powerOf10;
        long c = y / powerOf10;
        long d = y % powerOf10;

        // Recursive steps - The function calls itself
        long ac = multiply(a, c);
        long bd = multiply(b, d);
        long pq = multiply(a + b, c + d);

        long adbc = pq - ac - bd;

        // Combine using the Karatsuba formula
        return (long) (ac * Math.pow(10, 2 * halfN) + adbc * Math.pow(10, halfN) + bd);
    }
}