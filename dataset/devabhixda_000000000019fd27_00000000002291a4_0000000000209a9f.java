import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = scan.next();
            int a = 0;
            StringBuilder sb = new StringBuilder(str);
            for(int j=0;j<str.length();j++) {
                if(str.charAt(j)!='0'){
                    int temp = Integer.parseInt(str.charAt(j)+"");
                    int ok=0;
                    while(temp-->0){
                        sb.insert(j+2*a, '(');
                        sb.insert(j+2*(a+1)+ok, ')');
                        ok++;
                    }
                    a+=ok;
                }
            }
            for(int j=0;j<sb.length()-1 ;j++){
                if(sb.charAt(j)==')' && sb.charAt(j+1)=='(') {
                    int b = j;
                    while(sb.charAt(b)==')' && sb.charAt(b+1)=='(') {
                        sb.deleteCharAt(b);
                        sb.deleteCharAt(b);
                        b-=1;
                    }
                }
            }
            System.out.println("Case #"+i+": "+sb.toString());
        }
    }
}