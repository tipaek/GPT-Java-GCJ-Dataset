import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            int jarr[][] = new int[n][2];
            int carr[][] = new int[n][2];
            int tmp1, tmp2,jindex=0,cindex=0;
            boolean jflag = false, cflag = false, imp = false;
            String res = "";
            for (int itr = 0; itr < n; itr++) {
                tmp1 = in.nextInt();
                tmp2 = in.nextInt();
                for (int j=0;j<jindex;j++) {
                    if ((tmp1 >= jarr[j][0] && tmp1 < jarr[j][1]) ||
                            (tmp2 >= jarr[j][0] && tmp2 < jarr[j][1])) {
                        for (int k=0;k<cindex;k++) {
                            if ((tmp1 >= carr[k][0] && tmp1 < carr[k][1]) ||
                                    (tmp2 >= carr[k][0] && tmp2 < carr[k][1])) {
                                imp = true;
                                cflag = true;
                                break;
                            }
                        }
                        if (!cflag) {
                            carr[cindex][0] = tmp1;
                            carr[cindex][1] = tmp2;
                            cindex++;
                        }
                        jflag = true;
                        break;
                    }
                }
                if (!jflag) {
                    jarr[jindex][0] = tmp1;
                    jarr[jindex][1] = tmp2;
                    jindex++;
                    res+="J";
                } else if (!imp) {
                    res+="C";
                }
                jflag = false;
                cflag = false;
            }
            if(imp) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(res);
            }
        }
	}
}
