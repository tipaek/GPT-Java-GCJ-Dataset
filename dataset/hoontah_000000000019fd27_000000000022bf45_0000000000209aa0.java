import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int a = in.nextInt();
          int b = in.nextInt();
          if(a < 3 && b > 2){
            System.out.println("Case #" + i + ": IMPOSSIBLE");
          }
          else{
            if(a == 1 && b == 1){
                System.out.println("Case #" + i + ": POSSIBLE");
                System.out.println("1");
            }
            else if(a==2 && b == 2){
                System.out.println("Case #" + i + ": POSSIBLE");
                System.out.println("1 2");
                System.out.println("2 1");
            }
            else{
                if(b < a || b > a*a){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
                else{
                    if(b%a == 0){
                        System.out.println("Case #" + i + ": POSSIBLE");
                        int gold = b/a;
                        String ans = "" + gold;
                        for(int q = 1; q <= a; q++){
                            if(q != gold){
                                ans = ans + q;
                            }
                        }
                        System.out.println(ans);
                        String bed = "";
                        for(int p = 0; p < ans.length()-1; p++){
                            bed = ans.substring(0,p) + ans.substring(p+1, p+2) + ans.substring(p,p+1) + ans.substring(p+2);
                            ans = bed;
                            System.out.println(bed);
                        }
                    }
                }
            }
          }
        }
      }
}

