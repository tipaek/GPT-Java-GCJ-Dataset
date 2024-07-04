import java.io.*;
import java.util.*;
class Solution {

    public static void getAnswer(int[] st, int[] et, int ct) {
        int c = 0;
        int j = -1;

        StringBuilder str = new StringBuilder();
        str.append("C");
        
        for(int i = 1; i < st.length; i++) {
            if(st[i] >= et[c] || et[i] <= st[c]) {
                c = i;
                str.append("C");
            }
            else if(j == -1 || st[i] >= et[j] || et[i] <= st[j]) {
                j = i;
                str.append("J");
            }
            else {
                str.replace(0, str.length() - 1, "IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + ct + ": " + str);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scn.nextInt();

        int ct = 1;
        while(ct <= t) {
            int n = scn.nextInt();

            int[] st = new int[n];
            int[] et = new int[n];
            for(int i = 0; i < n; i++) {
                st[i] = scn.nextInt();
                et[i] = scn.nextInt();
            }
            getAnswer(st, et, ct);
            ct++;
        }
    }
}