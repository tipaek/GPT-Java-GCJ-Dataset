import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int casenum=1; casenum<=t; casenum++){
            StringBuilder res = new StringBuilder();
            String s = scanner.next();
            int stack=0;
            for (char c: s.toCharArray()){
                int cnt=c-'0';
                while (stack>cnt){
                    res.append(")");
                    stack--;
                }
                while (stack<cnt){
                    res.append("(");
                    stack++;
                }
                res.append(c);
            }
            while (stack>0) {
                res.append(")");
                stack--;
            }
            
            System.out.println("Case #" + casenum + ": " + res.toString());
        }
        }
    }