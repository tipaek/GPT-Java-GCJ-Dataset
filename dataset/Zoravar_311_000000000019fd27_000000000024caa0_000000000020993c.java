import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder op = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> c[] = new HashSet[n + 1];
            HashSet<Integer> r[] = new HashSet[n + 1];
            for (int i = 0; i <= n; i++) {
                c[i] = new HashSet<Integer>();
                r[i] = new HashSet<Integer>();
            }
            int k = 0, rc = 0, cc = 0;
            boolean[] visR = new boolean[n + 1], visC = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int no = Integer.parseInt(s[j]);
                    if (i == j)
                        k += no;
                    if (c[j].contains(no)){
                        if (!visC[j]) {
                            cc++;
                            visC[j] = true;
                        }
                    }else c[j].add(no);

                    if (r[i].contains(no)){
                        if (!visR[i]) {
                            rc++;
                            visR[i] = true;
                        }
                    }else r[i].add(no);
                }
            }
            op.append("Case #"+t+": "+k+" "+rc+" "+cc+"\n");
        }
        System.out.println(op);
    }

}
