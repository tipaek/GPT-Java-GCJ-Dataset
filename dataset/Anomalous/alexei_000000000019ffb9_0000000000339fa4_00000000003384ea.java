import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            long counter = 1;
            
            while (true) {
                if (counter > left && counter > right) {
                    counter--;
                    if (counter == 0) counter = 1;
                    break;
                }
                if (right > left) {
                    right -= counter;
                } else {
                    left -= counter;
                }
                counter++;
            }
            
            System.out.println("Case #" + caseNumber + ": " + counter + " " + left + " " + right);
        }
    }
}