import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte t = scanner.nextByte();
        byte[][][] cases = new byte[t][][];
        
        for (byte caseIndex = 0; caseIndex < t; caseIndex++) {
            byte n = scanner.nextByte();
            cases[caseIndex] = new byte[n][n];
            for (byte rowIndex = 0; rowIndex < n; rowIndex++) {
                for (byte colIndex = 0; colIndex < n; colIndex++) {
                    cases[caseIndex][rowIndex][colIndex] = scanner.nextByte();
                }
            }
        }
        
        for (byte caseIndex = 0; caseIndex < t; caseIndex++) {
            System.out.print("Case #" + (caseIndex + 1) + ": ");
            
            byte n = (byte) cases[caseIndex].length;
            short trace = 0;
            for (byte i = 0; i < n; i++) {
                trace += cases[caseIndex][i][i];
            }
            System.out.print(trace + " ");
            
            byte duplicateRows = 0;
            for (byte rowIndex = 0; rowIndex < n; rowIndex++) {
                boolean[] seen = new boolean[n];
                for (byte colIndex = 0; colIndex < n; colIndex++) {
                    if (seen[cases[caseIndex][rowIndex][colIndex]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[cases[caseIndex][rowIndex][colIndex]] = true;
                }
            }
            System.out.print(duplicateRows + " ");
            
            byte duplicateCols = 0;
            for (byte colIndex = 0; colIndex < n; colIndex++) {
                boolean[] seen = new boolean[n];
                for (byte rowIndex = 0; rowIndex < n; rowIndex++) {
                    if (seen[cases[caseIndex][rowIndex][colIndex]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[cases[caseIndex][rowIndex][colIndex]] = true;
                }
            }
            System.out.println(duplicateCols);
        }
    }
}