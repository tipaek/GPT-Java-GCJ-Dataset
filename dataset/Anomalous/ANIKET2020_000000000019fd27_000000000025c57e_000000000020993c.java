import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws Exception {

        // Using BufferedReader to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFromBufferedReader = br.readLine(); // Reading input from STDIN
        System.out.println("Hi, " + nameFromBufferedReader + "."); // Writing output to STDOUT

        // Using Scanner to read input
        Scanner scanner = new Scanner(System.in);
        String nameFromScanner = scanner.nextLine(); // Reading input from STDIN
        System.out.println("Hi, " + nameFromScanner + "."); // Writing output to STDOUT

        scanner.close(); // Close the scanner to prevent resource leak
    }
}