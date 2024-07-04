import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        // Initialize the scanner to read from the specified file
        sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt")))));

        // Read the number of test cases
        int t = sc.nextInt();
        sc.nextLine();

        // Process each test case
        for (int test = 1; test <= t; test++) {
            // Read the number of strings
            int a = sc.nextInt();
            sc.nextLine();

            // Read and process each string
            List<String> list = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                list.add(sc.nextLine());
            }

            // Replace all occurrences of '*' with '[AZ]'
            for (int i = 0; i < a; i++) {
                list.set(i, list.get(i).replaceAll("[*]", "[AZ]"));
            }

            // Output the result for the current test case
            System.out.println("Case #" + test + ": ");
        }
    }
}