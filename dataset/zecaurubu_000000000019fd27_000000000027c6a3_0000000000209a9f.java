import java.util.*;
import java.io.*;

public class Solution {
    
    /*
    021 - 0
    0((2 - 2
    0((2)1 - 1
    0((2)1)
    
    312 - 0
    (((3))1 - 1
    
    
    */
    
    static String work(String input) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : input.toCharArray()) {
            int val = (int)(c - '0');
            if (val - level > 0) {
                for (int i = 0; i < (val - level); i++) {
                    sb.append('(');
                }
            } else if (val - level < 0) {
                for (int i = 0; i < (level - val); i++) {
                    sb.append(')');
                }
            }
            level = val;
            sb.append(c);
        }
        for (int i = 0; i < level; i++) {
            sb.append(')');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int ntests = in.nextInt();
        
        for (int i = 0; i < ntests; i++) {
            String str = in.nextLine().trim();
            String answer = work(str);
            System.out.printf("Case #%d: %s\n",i+1,answer);
        }
    }
}