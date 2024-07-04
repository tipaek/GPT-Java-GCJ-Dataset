import java.util.Scanner;

/**
 * Made and solved successfully by the Prodigy Programmer
 * Author: Julian Paniagua
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            String zeroLedNumbers = scanner.next();
            
            for (int i = 1; i <= 9; i++) {
                zeroLedNumbers = zeroLedNumbers.replaceAll("([" + i + "-9]+)", "($1)");
            }
            
            System.out.println(zeroLedNumbers);
        }
        
        scanner.close();
    }

}