package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            char[] ca = s.toCharArray();
            ArrayList<Character> cl = new ArrayList<>();
            
            // Add initial opening brackets
            for (int j = 0; j < ca[0] - '0'; j++) {
                cl.add('(');
            }
            cl.add(ca[0]);
            
            // Process the rest of the characters
            for (int k = 1; k < ca.length; k++) {
                int diff = ca[k] - ca[k - 1];
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        cl.add('(');
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        cl.add(')');
                    }
                }
                cl.add(ca[k]);
            }
            
            // Add closing brackets for the last character
            for (int j = 0; j < ca[ca.length - 1] - '0'; j++) {
                cl.add(')');
            }
            
            // Convert ArrayList to String
            StringBuilder result = new StringBuilder();
            for (char c : cl) {
                result.append(c);
            }
            
            System.out.println("#" + i + ": " + result);
        }
        
        out.flush();
        out.close();
    }
}