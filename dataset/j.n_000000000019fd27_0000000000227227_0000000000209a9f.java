
import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.io.*;
public class Solution {
    public static void solve(int t, String s){
        String result = "";
        Stack<Character> sprim = new Stack<>();
        int prev = 0;
        //System.out.println(s);
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int current = Integer.valueOf(String.valueOf(c));
            //System.out.println(current);
            //System.out.println(sprim.size());
            if ( sprim.size() == 0 || sprim.peek() == '0') {
                for (int k = 0; k < current; k++){
                    sprim.push('(');
                }
                sprim.push(c);
                for (int k = 0; k < current; k++){
                    sprim.push(')');
                }
                //System.out.println(sprim.toString());
            } else {
                if (current <= prev) {
                    for (int k = 0; k < current; k ++){
                        sprim.pop();
                    }
                    //for (int k = 0; k < current; k ++){
                    //    sprim.push('(');
                    //}
                    sprim.push(c);
                    for (int k = 0; k < current; k ++){
                        sprim.push(')');
                    }
                } else {
                    for (int k = 0; k < prev; k ++){
                        sprim.pop();
                    }
                    for (int k = 0; k < current - prev; k ++){
                        sprim.push('(');
                    }
                    sprim.push(c);
                    for (int k = 0; k < current; k ++){
                        sprim.push(')');
                    }
                }
            }

            prev = current;
        }
        String res = "";
        Iterator it = sprim.iterator();
        while (it.hasNext()){
            res += it.next();
        }
        System.out.println("Case #" + t + ": " + res);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            solve(i, s);
        }
    }
}
