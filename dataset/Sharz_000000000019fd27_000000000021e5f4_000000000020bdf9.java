import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int [] j = new int [24*60];
            int [] c = new int [24*60];
            int n = in.nextInt();
            int [] arr = new int[n];
            int st,et;
            int index = -1;
            boolean flag = false;
            a:
            for (int itr = 0; itr < n; itr++) {
                index++;
                st = in.nextInt();
                et = in.nextInt();
                for (int k = st; k< et; k++){
                    if (j[k] == 1) {
                        for (int l = st; l< et; l++) {
                            if (c[l] == 1) {
                                System.out.print("IMPOSSIBLE");
                                flag = true;
                                break a;
                            }
                            c[l] = 1;
                        }
                        arr[index] = 1;
                        k -= 1;
                        while (k >= st) {
                            j[k] = 0;
                            k--;
                        }
                        break;
                    }
                    j[k] = 1;
                }
            }
            if (!flag) {
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
