import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int text_case = in.nextInt();
        for (int q = 1; q <= text_case; q++) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                int d = Integer.parseInt(String.valueOf(s.charAt(i)));
                for(int b =0;b<d;b++){
                    sb.append('(');
                }
                sb.append(d);
                for(int b =0;b<d;b++){
                    sb.append(')');
                }
            }
            StringBuilder sd = new StringBuilder();

            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i) == ')'){
                    if(i+1<sb.length()){
                        if(sb.charAt(i+1) == '('){
                            i+=2;
                        }
                    }
                }
                sd.append(sb.charAt(i));

            }
//            System.out.println(sb.toString());
            System.out.println("Case #"+q+": "+sd.toString());
        }
    }
}
