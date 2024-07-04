import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String [] args ) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int tt=0;tt<t;tt++) {
            
            String s = scanner.next();
            int n = s.length();
            Stack<Integer> stack = new Stack<>();
            String ans = "";
            
            for(int i=0;i<n;i++) {
                int d = s.charAt(i) - '0';

                if(i-1 >=0) {
                    int prevD = s.charAt(i-1) - '0';
                    if (prevD > d) {
                        char [] ch = new char[prevD-d];
                        Arrays.fill(ch,')');
                        ans+=new String(ch);
                        ans+=s.charAt(i);
                        ch = new char[prevD-d];
                        Arrays.fill(ch, ')');
                        //ans+=new String(ch);
                    }
                    else {
                        char [] ch = new char[d-prevD];
                        Arrays.fill(ch, '(');
                        ans+=new String(ch);
                        ans+=s.charAt(i);
                    }
                }
                else {
                    char [] ch = new char[d];
                    Arrays.fill(ch, '(');
                    ans+=new String(ch);
                    ans+=s.charAt(i);
                }
                
                if(i==n-1) {
                    char [] ch = new char[d];
                    Arrays.fill(ch, ')');
                    ans+=new String(ch);

                }
            }

            System.out.println("Case #" + (tt+1) + ": " + ans);
        }
    }
    
}