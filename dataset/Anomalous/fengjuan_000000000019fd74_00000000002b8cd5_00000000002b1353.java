import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            String binaryString = Integer.toBinaryString(N - 30);
            System.out.println("Case #" + caseNumber + ":");
            
            int row = 1, col = 1, zeroCount = 0;
            
            if (N < 30) {
                for (int i = 0; i < N; i++) {
                    System.out.println(row + " " + col);
                    row++;
                    col = col < 0 ? col + 1 : col;
                }
            } else {
                for (int i = binaryString.length() - 1; i >= 0; i--) {
                    System.out.println(row + " " + col);
                    
                    if (binaryString.charAt(i) == '1') {
                        if (col == 1) {
                            for (col++; col <= row; col++) {
                                System.out.println(row + " " + col);
                            }
                        } else {
                            for (col--; col > 0; col--) {
                                System.out.println(row + " " + col);
                            }
                        }
                    } else {
                        zeroCount++;
                    }
                    
                    row++;
                    col = col == 0 ? 1 : row;
                }
                
                for (int i = 0; i < 30 - zeroCount; i++) {
                    System.out.println(row + " " + col);
                    row++;
                    col = col == 1 ? 1 : row;
                }
            }
        }
    }
}