import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String number = sc.next();
            StringBuilder crossnumber = new StringBuilder();
            int previousNum = 0;
            
            for (char c : number.toCharArray()) {
                int currentNum = Character.getNumericValue(c);
                if (currentNum > previousNum) {
                    crossnumber.append("(".repeat(currentNum - previousNum));
                } else if (currentNum < previousNum) {
                    crossnumber.append(")".repeat(previousNum - currentNum));
                }
                crossnumber.append(c);
                previousNum = currentNum;
            }
            
            crossnumber.append(")".repeat(previousNum));
            System.out.println("Case #" + (i + 1) + ": " + crossnumber);
        }
        
        sc.close();
    }
}