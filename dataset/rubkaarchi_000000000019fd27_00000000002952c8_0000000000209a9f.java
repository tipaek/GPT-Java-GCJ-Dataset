import java.util.*;
import java.io.*;
public class Solution  {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        int caseNum = in.nextInt();
        for(int i = 0; i < caseNum;i++) {
            calculate(i+1);
        }
    }

    private static void calculate(int caseNum){
        String str = in.next();

        int open = 0;
        int first = str.charAt(0) - '0';
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < first;i++) {
            sb.append('(');
            open++;
        }

        sb.append(first);

        for(int i = 1; i < str.length();i++) {
            int cur = str.charAt(i) - '0';

            if(cur == open) {
                sb.append(cur);
            } else if(cur > open) {
                int diff = cur - open;
                for(int j = 0;j < diff;j++) {
                    sb.append('(');
                    open++;
                }

                sb.append(cur);
            } else {
                int diff = open - cur;
                for(int j = 0; j < diff;j++) {
                    sb.append(')');
                    open--;
                }

                sb.append(cur);
            }
        }

        for(int j = 0; j < open;j++) {
            sb.append(')');
        }

        System.out.println("Case #" + caseNum + " " + sb.toString());
    }

}
