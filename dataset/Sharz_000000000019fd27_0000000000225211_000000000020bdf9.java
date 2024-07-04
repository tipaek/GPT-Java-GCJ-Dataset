import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int s,e, jindex = 0, cindex = 0;
            int [] arr = new int[n];
            int j[][] = new int [n][2];
            int c[][] = new int [n][2];
            int tmp1,tmp2;
            boolean jflag = false, cflag = false, flag = false;
            for (int itr = 0; itr < n; itr++) {
                s = in.nextInt();
                e = in.nextInt();
                for (int k = 0; k< jindex; k++) {
                    tmp1 = j[k][0];
                    tmp2 = j[k][1];
                    if ((s >= tmp1 && s < tmp2) || (e >= tmp1 && e < tmp2)) {
                        jflag = true;
                        break;
                    }
                }
                if (jflag) {
                    for (int k = 0; k< cindex; k++) {
                        tmp1 = c[k][0];
                        tmp2 = c[k][1];
                        if ((s >= tmp1 && s < tmp2) || (e >= tmp1 && e < tmp2)) {
                            cflag = true;
                            break;
                        }
                    }
                    if (cflag) {
                        System.out.print("Case #" + i + ": ");
                        System.out.print("IMPOSSIBLE");
                        cflag = false;
                        flag = true;
                        break;
                    } else {
                        c[cindex][0] = s;
                        c[cindex][1] = e;
                        cindex++;
                    }
                    arr[itr] = 1;
                    jflag = false;
                } else {
                    j[jindex][0] = s;
                    j[jindex][1] = e;
                    jindex++;
                }
            }
            if (!flag) {
                System.out.print("Case #" + i + ": ");
                for (int itr = 0; itr < n; itr++) {
                    if (arr[itr] == 1)
                        System.out.print("C");
                    else
                        System.out.print("J");
                }
                flag = false;
            }

            System.out.print(System.lineSeparator());
        }
	}
}
