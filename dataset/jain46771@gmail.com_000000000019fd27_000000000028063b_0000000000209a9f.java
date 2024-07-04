import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        int testCases = 0;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = sc.nextInt();
        for (int t=0;t<testCases;t++) {
            String s = sc.next();
            StringBuffer sb = new StringBuffer();
            int prevOpen=0;
            for(char c: s.toCharArray() )
            {
                int no = c-'0';
                int i=0;
                for (i =0;i<prevOpen-no;i++)
                {
                    sb.append(")");
                }
                prevOpen -= i;
                for (i=0;i<no-prevOpen;i++) {
                    sb.append("(");
                }
                prevOpen += i;
                sb.append(no);
            }
            for (int i =0;i<prevOpen;i++)
            {
                sb.append(")");
            }
            System.out.println(sb.toString());

        }
    }
}
