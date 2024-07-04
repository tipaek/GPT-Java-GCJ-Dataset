import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws java.lang.Exception {
        Scanner ob = new Scanner(System.in);
        int T = ob.nextInt();
        for (int t = 0; t < T; t++) {
            String s = ob.next();
            int[] arr = new int[s.length()];
            int pqo = 0;
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - 48;
                if (arr[i] != 0) {
                    pqo = 1;
                }
            }
            if (pqo == 0) {
                System.out.println("Case #" + (t+1) + ": " + s);
                continue;

            }
            Arrays.sort(arr);
            int b = arr[s.length() - 1];
            String r = "";
            StringBuffer str = new StringBuffer(r);
            HashMap<Integer, StringBuffer> map = new HashMap<Integer, StringBuffer>();
            for (int i = 0; i < b; i++) {
                str.insert(0, "(");
                str.append(")");
                StringBuffer brac = new StringBuffer();
                brac.append(str);
                map.put(i + 1, brac);
            }

            int p = s.charAt(0) - 48;
            int v = p;
            StringBuffer st = new StringBuffer("");
            st.append(map.get(p));
            st.insert(p, s.substring(0, 1));

            for (int i = 1; i < s.length(); i++) {
                int c = s.charAt(i) - 48;

                if (v - c == 0) {
                    st.insert(p + 1, s.substring(i, i + 1));
                    p = p + 1;
                    v = c;
                    // System.out.println(String.valueOf(st) + "here");
                    continue;
                } else if (v - c > 0) {
                    st.insert(p + v - c + 1, s.substring(i, i + 1));
                    p = p + v - c + 1;
                    v = c;
                    // System.out.println(String.valueOf(st) + "here1");
                } else {
                    StringBuffer ni = new StringBuffer(map.get(c - v));
                    // System.out.println(String.valueOf(st) + "here34 " + " " +
                    // String.valueOf(ni));
                    // System.out.println(c - v);
                    ni.insert(c - v, s.substring(i, i + 1));
                    String nit = String.valueOf(ni);
                    st.insert(p + 1, nit);
                    p = p + c - v + 1;
                    v = c;
                    // System.out.println(String.valueOf(st) + "here34 " + nit + " " +
                    // String.valueOf(ni));
                }

            }
            System.out.println("Case #" + (t+1) + ": " + String.valueOf(st));

        }
    }
}
