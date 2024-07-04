import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws Exception {
        // Reading input using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFromBufferedReader = br.readLine();
        System.out.println("Hi, " + nameFromBufferedReader + ".");

        // Reading input using Scanner
        Scanner scanner = new Scanner(System.in);
        String nameFromScanner = scanner.nextLine();
        System.out.println("Hi, " + nameFromScanner + ".");
        
        scanner.close();
    }
}