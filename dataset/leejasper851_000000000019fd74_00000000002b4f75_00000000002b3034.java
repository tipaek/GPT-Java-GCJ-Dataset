import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            int numPats = Integer.parseInt(reader.readLine());
            String[] pats = new String[numPats];
            for (int i = 0; i < numPats; i++) {
                pats[i] = reader.readLine();
            }
            
            String prefix = "";
            String postfix = "";
            String body = "";
            boolean pos = true;
            for (String pat : pats) {
                int ast0 = -1;
                int ast1 = -1;
                for (int i = 0; i < pat.length(); i++) {
                    if (pat.charAt(i) == '*') {
                        if (ast0 == -1) {
                            ast0 = i;
                        }
                        ast1 = i;
                    }
                }
                
                if (ast0 > 0) {
                    String patPre = pat.substring(0, ast0);
                    if (patPre.length() == prefix.length()) {
                        if (!patPre.equals(prefix)) {
                            pos = false;
                            break;
                        }
                    } else if (patPre.length() < prefix.length()) {
                        if (!patPre.equals(prefix.substring(0, ast0))) {
                            pos = false;
                            break;
                        }
                    } else {
                        if (!patPre.substring(0, prefix.length()).equals(prefix)) {
                            pos = false;
                            break;
                        }
                        prefix = patPre;
                    }
                }
                
                if (ast1 < pat.length()-1) {
                    String patPost = pat.substring(ast1 + 1);
                    if (patPost.length() == postfix.length()) {
                        if (!patPost.equals(postfix)) {
                            pos = false;
                            break;
                        }
                    } else if (patPost.length() < postfix.length()) {
                        if (!patPost.equals(postfix.substring(postfix.length() - patPost.length()))) {
                            pos = false;
                            break;
                        }
                    } else {
                        if (!patPost.substring(patPost.length() - postfix.length()).equals(postfix)) {
                            pos = false;
                            break;
                        }
                        postfix = patPost;
                    }
                }
                
                if (ast0 != ast1) {
                    String currBody = pat.substring(ast0 + 1, ast1);
                    for (int i = 0; i < currBody.length(); i++) {
                        if (currBody.charAt(i) != '*') {
                            body += currBody.charAt(i);
                        }
                    }
                }
            }
            
            if (!pos) {
                writer.println("Case #" + caseN + ": *");
                continue;
            }
            writer.println("Case #" + caseN + ": " + prefix + body + postfix);
        }
        reader.close();
        writer.close();
    }
}