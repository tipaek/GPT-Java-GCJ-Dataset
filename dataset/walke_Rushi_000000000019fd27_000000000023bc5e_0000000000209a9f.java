import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int p = 1;
        while (t-- > 0) {
            String s = br.readLine();
            String s1=s;
            String ans = "";
            int h=0;


            int k = s.length();
            if (k == 1) {
                int a = Integer.parseInt(s);
                if(a==0){
                    System.out.print("Case #" + p + ": " + 0);
                }
                for (int i = 0; i < a; i++) {
                    ans = "(" + ans;
                }
                ans = ans + s;
                for (int i = 0; i < a; i++) {
                    ans = ans + ")";
                }

                System.out.println("Case #" + p + ": " + ans);
                p++;
            } else {
                int a = Integer.parseInt(s);
                int r = a % 10;
                for (int i = 0; i < r; i++) {
                    ans = ans + ")";
                }
                ans = r + ans;
                a = a / 10;
                int gg = a%10;
                while (a> 0) {


                        if (gg - r > 0) {
                            for (int i = 0; i < gg - r; i++) {
                                ans = ")" + ans;
                            }
                        } else if (gg - r < 0) {
                            for (int i = 0; i < r - gg; i++) {
                                ans = "(" + ans;
                            }
                        }
                        ans = gg + ans;
                      r=gg;
                      a=a/10;
                      gg=a%10;







                }
                for (int i = 0; i < r; i++) {
                    ans = "(" + ans;
                }
                while(s1.charAt(h)=='0' && h<s1.length()-1){
                    ans="0"+ans;
                    s1.substring(h);
                    h++;
                }


                System.out.println("Case #" + p + ": " + ans);
                p++;

            }
        }
    }
}
