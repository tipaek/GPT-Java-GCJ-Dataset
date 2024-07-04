import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            String line = reader.readLine();
            int[] digs = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                digs[i] = line.charAt(i) - 48;
            }
            
            String str = "";
            int numPars = 0;
            for (int i = 0; i < digs.length; i++) {
                while (numPars < digs[i]) {
                    str += "(";
                    numPars++;
                }
                while (numPars > digs[i]) {
                    str += ")";
                    numPars--;
                }
                str += digs[i];
            }
            while (numPars > 0) {
                str += ")";
                numPars--;
            }
            writer.println("Case #" + caseN + ": " + str);
        }
        reader.close();
        writer.close();
    }
}