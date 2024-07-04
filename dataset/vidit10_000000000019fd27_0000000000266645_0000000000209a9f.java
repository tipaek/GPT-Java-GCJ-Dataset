import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i1 = 1; i1 <= t; ++i1) {
            String s = in.nextLine();
            //System.out.println(s);
            int n = s.length();
            StringBuilder sb = new StringBuilder("");
            int openBr=0;
            for(int i=0;i<n;i++){
                int currD = s.charAt(i)-'0';
                if(currD < openBr){
                    while(openBr>currD){
                        sb.append(")");
                        openBr--;
                    }
                }else if(currD > openBr){
                    while(openBr<currD){
                        sb.append("(");
                        openBr++;
                    }
                }
                sb.append(s.charAt(i));
            }
            while(openBr>0){
                sb.append(")");
                openBr--;
            }
            System.out.println("Case #" + i1 + ": " + sb.toString());
        }
    }
}