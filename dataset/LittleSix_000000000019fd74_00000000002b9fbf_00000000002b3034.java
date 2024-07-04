import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = in.nextInt();
            in.nextLine();
            String[][] patterns = new String[N][3];
            int maxLIndex = -1;
            int maxLValue = -1;
            int maxRIndex = -1;
            int maxRValue = -1;
            for (int i = 0; i < N; i++) {
                String current = in.nextLine();
                String[] parts = current.split("\\*");
                int numParts = parts.length;
                if (numParts == 1) {
                    if (parts[0].length() > maxRValue) {
                        maxRIndex = i;
                        maxRValue = parts[0].length();
                    }
                    patterns[i][2] = parts[0];
                } else if (numParts == 2) {
                    if (parts[0].length() > maxLValue) {
                        maxLIndex = i;
                        maxLValue = parts[0].length();
                    }
                    patterns[i][0] = parts[0];
                    
                    if (parts[1].length() > maxRValue) {
                        maxRIndex = i;
                        maxRValue = parts[1].length();
                    }
                    patterns[i][2] = parts[1];
                } else {
                    String middle = "";
                    for (int j = 1; j < numParts - 1; j++) {
                        middle += parts[j];
                    }
                    patterns[i][1] = middle;
                    
                    if (parts[0].length() > maxLValue) {
                        maxLIndex = i;
                        maxLValue = parts[0].length();
                    }
                    patterns[i][0] = parts[0];
                    
                    if (parts[numParts - 1].length() > maxRValue) {
                        maxRIndex = i;
                        maxRValue = parts[numParts - 1].length();
                    }
                    patterns[i][2] = parts[numParts - 1];
                }
            }
            
            
            boolean possible = true;
            String targetL = "";
            if (maxLIndex != -1) {
                targetL = patterns[maxLIndex][0];
                for (int i = 0; i < N; i++) {
                    if(patterns[i][0] != null && !targetL.contains(patterns[i][0])) {
                        possible = false;
                    }
                }
            }
            
            String targetR = "";
            if (maxRIndex != -1) {
                targetR = patterns[maxRIndex][2];
                for (int i = 0; i < N; i++) {
                    if(patterns[i][2] != null && !targetR.contains(patterns[i][2])) {
                        possible = false;
                    }
                }
            }
            
            String result = "";
            if (possible) {
                result += targetL;
                for (int i = 0; i < N; i++) {
                    if (patterns[i][1] != null) {
                        result += patterns[i][1];
                    }
                }
                result += targetR;
            } else {
                result = "*";
            }
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}