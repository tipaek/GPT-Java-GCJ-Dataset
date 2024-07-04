import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            int operationCount = 0;

            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            while (rows > 1) {
                for (int i = 0; i < cols - 1; i++) {
                    operationCount++;
                    listA.add(rows * (cols - 1) - i);
                    listB.add(rows - 1);
                }
                rows--;
            }

            System.out.printf("Case #%d: %d%n", caseNum, operationCount);
            for (int i = 0; i < operationCount; i++) {
                System.out.printf("%d %d%n", listA.get(i), listB.get(i));
            }
        }
    }
}