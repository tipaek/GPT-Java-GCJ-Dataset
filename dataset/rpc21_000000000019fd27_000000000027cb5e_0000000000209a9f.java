import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int test = 1; test<=t; test++){
            String s = in.next();
            StringBuilder out = new StringBuilder();
            int open = 0;
            for(int i=0; i<s.length(); i++){
                int num = Integer.parseInt(s.substring(i, i+1));
                if(num>open){
                    for(int q=0; q<num-open; q++){
                        out.append("(");
                    }
                    out.append(num);
                    open = num;
                } else if (num==open){
                    out.append(num);
                } else {
                    for(int q=0; q<open-num; q++){
                        out.append(")");
                    }
                    out.append(num);
                    open = num;
                }
            }
            for(int q=0; q<open; q++){
                out.append(")");
            }
            System.out.println(String.format("Case #%d: %s", test, out.toString()));
        }
    }
}
