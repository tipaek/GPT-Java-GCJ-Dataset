import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        
        for (int testCase = 0; testCase < testCount; testCase++) {
            int requiredResult = Integer.parseInt(sc.nextLine());
            System.out.println("Case #" + (testCase + 1) + ":");
            
            if (requiredResult <= 500) {
                for (int r = 1; r <= requiredResult; r++) {
                    System.out.println(r + " 1");
                }
            } else if (requiredResult <= 1000) {
                int currTotal = 1;
                int currRow = 2;
                boolean moveToLeft = true;
                System.out.println("1 1");
                
                while (currTotal < requiredResult) {
                    if (moveToLeft) {
                        if (currRow - 1 <= requiredResult - currTotal) {
                            currTotal += currRow - 1;
                            System.out.println(currRow + " " + (currRow - 1));
                        }
                        moveToLeft = false;
                    } else {
                        currTotal++;
                        System.out.println(currRow + " " + currRow);
                        currRow++;
                        moveToLeft = true;
                    }
                }
            } else {
                int powerOf2Row = 0;
                while (Math.pow(2, powerOf2Row) < requiredResult) {
                    powerOf2Row++;
                }
                powerOf2Row--;
                if (requiredResult - Math.pow(2, powerOf2Row) < powerOf2Row) {
                    powerOf2Row--;
                }
                // The original code seems to be incomplete or incorrect for this case.
                // Additional logic may be required here to handle cases where requiredResult > 1000.
            }
        }
        
        sc.close();
    }
}