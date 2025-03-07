
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for (int h = 1; h <= t; h++) {
            str.append("Case #" + h + ":\n");
            int n = Integer.parseInt(br.readLine());
            boolean startFromLeft = true;
            int sk = 1;
            str.append("1 1 \n");
            int val = 1;
            while (val + 1 + sk <= n) {
                str.append((sk + 1) + " " + sk + "\n");
                val += sk;
                sk++;
            }
            n = n - val;
            if (n > 0) {
               // int k =0;
               /* while (lt + Math.pow(2, k) <= n) {
                    int sum = (int) Math.pow(2, k);
                    addRowElem(str, k + 1, startFromLeft, true, 0);
                    startFromLeft = !startFromLeft;
                    lt = lt + sum;
                    k++;
                }*/
                    int k = sk-1;
                    addRowElem(str, k + 1, false, false, n);
                    //n -= k;
                    //   startFromLeft = !startFromLeft;
            }
        }
        out.print(str);
        out.flush();
        br.close();
    }
    private static void addRowElem(StringBuilder str, int k, boolean startFromleft, boolean include, int n) {
        if(include) {
            if(startFromleft) {
                for (int i = 1; i <= k; i++) {
                    str.append(k+" "+i + "\n");
                }
            }else{
                for (int i = k; i >= 1; i--) {
                    str.append(k+" "+i + "\n");
                }
            }
        } else {
            int count=0;
            if(startFromleft) {
                for (int i = k; count<n; i++, count++) {
                    str.append(i+" "+1+ "\n");
                }
            }else{
                for (int i = k; count<n; i++,count++) {
                    str.append(i+" "+i + "\n");
                }
            }

        }
    }


}


