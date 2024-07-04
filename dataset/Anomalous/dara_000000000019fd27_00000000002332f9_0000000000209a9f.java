import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = reader.nextInt(); // Number of test cases
        reader.nextLine();
        
        String[] results = new String[t];
        
        for (int i = 0; i < t; i++) {
            String s = reader.nextLine();
            StringBuilder news = new StringBuilder();
            boolean oneFound = false;
            
            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (currentChar == '1' && !oneFound) {
                    news.append("(");
                    oneFound = true;
                } else if (currentChar == '0' && oneFound) {
                    news.append(")");
                    oneFound = false;
                }
                news.append(currentChar);
            }
            
            if (oneFound) {
                news.append(")");
            }
            
            results[i] = "Case #" + (i + 1) + ": " + news.toString();
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }
}