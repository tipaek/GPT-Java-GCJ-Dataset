import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            String sPrime = solution(in.nextLine());
            System.out.println("Case #" + i + ": " + sPrime);
        }
    }
    
    public static String solution(String digits) {
  
        String sPrime = "";
    
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (c == '1') {
                sPrime += "(1";
                while (i < digits.length() - 1) {
                    i++;
                    c = digits.charAt(i);
                    if (c == '0') {
                        i--;
                        break;
                    } else {sPrime += c;}
                }
                sPrime += ')';
            } else {
                sPrime += '0';
            }
        }
        return sPrime;
    }
}