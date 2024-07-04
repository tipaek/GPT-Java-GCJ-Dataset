import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            String str = sc.next();
            char[] array = str.toCharArray();
            
            String open = "(";
            String close = ")";
            
            int max = Integer.MIN_VALUE;
            
            for(char c : array) {
                if (max < (int)(c - '0'))
                    max = (int)(c - '0');
            }
            
            String result = "";
            
            int start = (int)(array[0] - '0');
            int end = (int)(array[array.length-1] - '0');
            
            result += repeat(open, (int)(array[0] - '0'));
            
            for(int i=0; i<array.length-1; i++) {
                result += array[i];
                if ((int)array[i] >= (int)array[i+1])
                    result += repeat(close, (int)array[i] - (int)array[i+1]);
                else
                    result += repeat(open, (int)array[i+1] - (int)array[i]);
            }
            
            result += array[array.length-1];
            result += repeat(close, (int)(array[array.length-1] - '0'));
            
            System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static String repeat(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }
}