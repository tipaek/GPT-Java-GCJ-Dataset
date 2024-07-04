import java.io.*;
import java.math.BigInteger;
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

            BigInteger a = new BigInteger(s);

            int k = s.length();
            if (k == 1) {

                int a1= Integer.parseInt(s);
                if(a1==0){

                    System.out.print("Case #" + p + ": " + 0);
                }
                for (int i = 0; i < a1; i++) {
                    ans = "(" + ans;
                }
                ans = ans + s;
                for (int i = 0; i < a1; i++) {
                    ans = ans + ")";
                }

                System.out.println("Case #" + p + ": " + ans);
                p++;
            } else {
                //int a = Integer.parseInt(s);
                BigInteger r1 = a .mod(new BigInteger("10"));
                int r=r1.intValue();
                for (int i = 0; i < r; i++) {
                    ans = ans + ")";
                }
                ans = r + ans;
                a = a.divide(new BigInteger(("10")));
                BigInteger gg1 = a .mod(new BigInteger("10"));
                int gg = gg1.intValue();
                int a1=a.intValue();
                while (a1> 0) {


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
                    r1 = a .mod(new BigInteger("10"));
                    r=r1.intValue();
                    a = a.divide(new BigInteger(("10")));
                    a1= a.intValue();
                    gg1 = a .mod(new BigInteger("10"));
                    gg = gg1.intValue();







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
