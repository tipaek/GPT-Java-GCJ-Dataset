import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            int moveCount = 0;

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            while (rows > 1) {
                for (int i = 0; i < columns - 1; i++) {
                    moveCount++;
                    aList.add(rows);
                    bList.add(rows * (columns - 1) - i - 1);
                }
                rows--;
            }

            System.out.printf("Case #%d: %d%n", caseNumber, moveCount);
            for (int i = 0; i < moveCount; i++) {
                System.out.printf("%d %d%n", aList.get(i), bList.get(i));
            }
        }
    }
}