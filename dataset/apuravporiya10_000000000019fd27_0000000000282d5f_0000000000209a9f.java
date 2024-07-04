import java.io.*;
import java.util.*;
class Solution {

    public static void getBracket(StringBuilder st, int n) {
        if(n > 0) {
            for(int i = 0; i < n; i++) {
                st.append('(');
            }
        }
        else {
            n = n*(-1);
            for(int j = 0; j < n; j++) {
                st.append(')');
            }
        }
    }

    public static void getAnswer(String s, int i) {
        int n = s.length();
        StringBuilder s3 = new StringBuilder();

        char cr = s.charAt(0);
        int a = cr - '0';
        getBracket(s3, a);
        s3.append(cr);
        int cnt = a;
                
        for(int j = 1; j < n; j++) {
            getBracket(s3, s.charAt(j) - s.charAt(j - 1));
            s3.append(s.charAt(j));
            cnt += s.charAt(j) - s.charAt(j - 1);
        }

        getBracket(s3, -1 * cnt);

        System.out.println("Case #" + i + ": " + s3);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();

        int i = 1;
        while(i <= t) {
            String s = sc.next();
            getAnswer(s, i);
            i++;
        }
    }
}