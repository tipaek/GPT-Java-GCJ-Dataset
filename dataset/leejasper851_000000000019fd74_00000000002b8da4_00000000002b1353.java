import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            int goal = Integer.parseInt(reader.readLine());
            
//            if (goal <= 1000) {
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
//            }
        }
        reader.close();
        writer.close();
    }
}