import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            int operationCount = 0;

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            while (rows > 1) {
                for (int i = 0; i < columns - 1; i++) {
                    operationCount++;
                    aList.add(rows * (columns - 1) - i);
                    bList.add(rows - 1);
                }
                rows--;
            }
            
            System.out.println(String.format("Case #%d: %d", testCase, operationCount));
            for (int i = 0; i < operationCount; i++) {
                System.out.println(String.format("%d %d", aList.get(i), bList.get(i)));
            }
        }
    }
}