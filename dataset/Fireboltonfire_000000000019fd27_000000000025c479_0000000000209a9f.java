import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String s = in.next();
            System.out.println("Case #" + (i + 1) + ": " + getNestedString(s));
        }
        in.close();
    }
    
    public static String getNestedString(String s){
        char lastChar = '0';
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int diff = s.charAt(i) - lastChar;
            lastChar = s.charAt(i);
            for(int j = 0; j < diff; j++){
                res.append('(');
            }
            for(int j = 0; j > diff; j--){
                res.append(')');
            }
            res.append(lastChar);
        }
        for(int j = 0; j > '0' - lastChar; j--){
            res.append(')');
        }
        return res.toString();
    }
}