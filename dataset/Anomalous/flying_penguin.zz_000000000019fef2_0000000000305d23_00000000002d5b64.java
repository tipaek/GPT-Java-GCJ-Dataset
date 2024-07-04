import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            
            int a = rows * (columns - 1);
            int b = rows - 1;
            
            System.out.println("Case #" + t + ": " + (rows - 1) * (columns - 1));
            
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < columns - 1; j++) {
                    System.out.println(a + " " + b);
                    a--;
                }
                b--;
            }
        }
    }
}