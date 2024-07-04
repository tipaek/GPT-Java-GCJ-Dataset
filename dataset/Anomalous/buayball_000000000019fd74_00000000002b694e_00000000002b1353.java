import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int currentCase = 1; currentCase <= testCases; currentCase++) {
            int numberOfLines = scanner.nextInt();
            System.out.println("Case #" + currentCase + ":");
            
            for (int i = 0; i < numberOfLines; i++) {
                System.out.println((i + 1) + " 1");
            }
        }
    }
}