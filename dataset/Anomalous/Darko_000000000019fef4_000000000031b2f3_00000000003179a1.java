import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void execute() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int u = scanner.nextInt();
            char[] mapping = new char[10];
            
            for (int i = 0; i < 10000; i++) {
                long query = scanner.nextLong();
                char[] response = scanner.next().toCharArray();
                
                for (int j = response.length - 1; j >= 0; j--) {
                    long digit = query % 10;
                    query /= 10;
                    mapping[(int) digit] = response[j];
                }
            }
            
            System.out.printf("Case #%d: %s\n", caseIndex, String.valueOf(mapping));
        }
    }

    public static void main(String[] args) {
        new Solution().execute();
    }
}