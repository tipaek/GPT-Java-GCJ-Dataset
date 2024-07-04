import java.util.*;
import java.io.*;
public class Solution
{

    public static void main(String [] args)
    {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            String [] q = new String [n];
            for (int i = 0; i < n; i++) q[i] = sc.next();
            Arrays.sort(q, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.indexOf("*") == o2.indexOf("*")) {
                        return o2.length() - o1.length();
                    }
                    return o2.indexOf("*") - o1.indexOf("*");
                }
            }); String res = q[0]; boolean ans =true;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < q[i].length(); j++) {
                    int m = q[i].indexOf("*");
                    if (q[i].substring(0, m).equals(q[0].substring(0, m))) {
                        for (int k = m + 2; k <= q[i].length(); k++) {
                            if (res.contains(q[i].substring(m + 1, k))) continue;
                            else if (!res.contains("*")) {
                                ans = false;
                            } else {
                                res = res.substring(0, m) + q[i].substring(k-1, k) + res.substring(m+1);
                            }
                        }
                    } else {
                        ans = false;
                    }
                }
            }
            if (res.substring(0, 1).equals("*")) res = res.substring(1); int index = res.indexOf("*");
            if (index != -1) res = res.substring(0, index) + res.substring(index + 1);
            if (!ans) out.println("*"); else out.println(res);
            t--;
        }
        out.close();
    }






    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }



    }

}