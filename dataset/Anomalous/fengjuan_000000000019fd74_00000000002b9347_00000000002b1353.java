import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            String binaryString = Integer.toBinaryString(N - 30);
            System.out.println("Case #" + i + ":");
            
            int row = 1;
            int col = 1;
            int count = 0;
            
            if (N < 30) {
                for (int j = 0; j < N; j++) {
                    System.out.println(row + " " + col);
                    row++;
                    if (col < 0) col++;
                }
            } else {
                for (int j = binaryString.length() - 1; j >= 0; j--) {
                    System.out.println(row + " " + col);
                    
                    if (binaryString.charAt(j) == '1') {
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
                        count++;
                    }
                    
                    row++;
                    col = (col <= 1) ? 1 : row;
                }
                
                for (int j = 0; j < 30 - count; j++) {
                    System.out.println(row + " " + col);
                    row++;
                    col = (col == 1) ? 1 : row;
                }
            }
        }
    }
}