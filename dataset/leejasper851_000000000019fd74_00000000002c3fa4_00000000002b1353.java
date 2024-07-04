import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        
        long[][] triangle = new long[501][501];
        triangle[1][1] = 1;
        for (int i = 2; i <= 500; i++) {
            triangle[i][1] = 1;
            triangle[i][i] = 1;
            for (int j = 2; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                if (triangle[i][j] > 1000000000) {
                    triangle[i][j] = 0;
                }
            }
        }
        
        for (int caseN = 1; caseN <= numCases; caseN++) {
            int goal = Integer.parseInt(reader.readLine());
            
            if (goal <= 1000) {
                writer.println("Case #" + caseN + ":");
                writer.println("1 1");
                if (goal == 1) {
                    continue;
                }
                
                int currVal = 1;
                int lastVal = -1;
                for (int i = 1; i <= 45; i++) {
                    currVal += i;
                    if (currVal > goal) {
                        currVal -= i;
                        lastVal = i - 1;
                        break;
                    }
                }
                
                for (int i = 1; i <= lastVal; i++) {
                    writer.println(i+1 + " 2");
                }
                for (int i = 0; i < goal - currVal; i++) {
                    writer.println(lastVal+1 + i + " 1");
                }
            } else {
                writer.println("Case #" + caseN + ":");
                long currVal = 0;
                for (int i = 1; i <= 6; i++) {
                    currVal += triangle[i][i];
                    writer.println(i + " " + i);
                }
                int row = 7;
                int col = 6;
                while (currVal != goal) {
                    currVal += triangle[row][col];
                    if (currVal > goal) {
                        currVal -= triangle[row][col];
                        col--;
                        row -= 2;
                    } else {
                        writer.println(row + " " + col);
                    }
                    row++;
                }
            }
        }
        reader.close();
        writer.close();
    }
}