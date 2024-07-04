import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int rank = scanner.nextInt();
            int suit = scanner.nextInt();
            int j = (rank * suit) - (rank + 1);
            System.out.println("Case #" + caseNumber + ": " + ((rank - 1) * (suit - 1)));
            
            for (int i = rank; i > 1; i--) {
                for (int s = 1; s < suit; s++, j--) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}