
/* MOHD SADIQ
    mohdsadiq058
    */
import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String strVal() throws IOException {
        return br.readLine().trim();
    }

    private long longVal() throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    private int intVal() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private double doubleVal() throws IOException {
        return Double.parseDouble(br.readLine().trim());
    }

    private int[] intArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    private long[] longArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }
        return a;
    }

    private double[] doubleArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(s[i]);
        }
        return a;
    }

    private String[] stringArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    private char[] charArr() throws IOException {
        return br.readLine().trim().toCharArray();
    }

    static class Pair<K, V> {
        K first;
        V second;

        Pair(K a, V b) {
            first = a;
            second = b;
        }

        Pair() {
        }
    }

    public long powMod(long x, long y, long mod) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x) % mod;
            }
            y /= 2;
            x = (x * x) % mod;
        }
        return res;
    }

    public static long mod = (long) Math.pow(10, 9) + 7;

    // static HashSet<Integer> hs = new HashSet<Integer>();

    public static String listToString(ArrayList<Character> al) {
        StringBuffer sb = new StringBuffer();
        for (char i : al) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static String solve() throws IOException {
        Solution obj = new Solution();
        // long[] arr = obj.longArr();
        int u = obj.intVal();
        ArrayList<Pair<Long, String>> al = new ArrayList<>();
        int n = (int) (1e4);
        int k = 1;
        for (int i = 0; i < n; i++) {
            // long[] val = obj.longArr();
            String[] val = obj.stringArr();
            Pair p = new Pair();
            p.first = Long.parseLong(val[0]);
            p.second = val[1];
            al.add(p);
        }
        HashSet<Character> hs = new HashSet<>();
        char[] ch = new char[10];
        // for (long i = 0; i < 10; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (al.get(j).first == i) {
        //             if (!hs.contains(al.get(j).second.charAt(0))) {
        //                 hs.add(al.get(j).second.charAt(0));
        //                 ch[(int) i] = al.get(j).second.charAt(0);
        //             }
        //         }
        //     }
        // }
        boolean bo = false;
        for (int i = 0; i < n; i++) {
            String val = al.get(i).second;
            for (int j = 0; j < val.length(); j++) {
                if (!hs.contains(val.charAt(j))) {
                    // ch[0] = val.charAt(j);
                    // System.out.println(ch[0]+" sadiq");
                    // bo = true;
                    // break;
                    hs.add(val.charAt(j));
                }
            }
            if(hs.size()==10) break;
            // if (bo)
            //     break;
        }
        int ind =0;
        for(char i:hs){
            ch[ind++]=i;
        }
        return new String(ch) + "";
    }

    public static void main(String[] args) throws IOException {
        Solution ob = new Solution();
        int total_test_case = ob.intVal();
        // int total_test_case = 1;
        StringBuffer ans = new StringBuffer();
        String k;
        for (int test_case = 1; test_case <= total_test_case; test_case++) {
            k = ob.solve();
            // System.out.println(k);
            ans.append("Case #" + test_case + ": " + k + "\n");
            // ans.append(k + "\n");
        }
        System.out.print(ans);
    }
}
