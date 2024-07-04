import java.util.*;
import java.io.*;

/**
 * CODEJAM20_3
 */
class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int w = 1; w <= t; w++) {
            int n = sc.nextInt();
            int points[] = new int[2 * n];
            Points points2[] = new Points[2 * n];
            for (int i = 0; i < 2 * n; i += 2) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points2[i] = new Points(x, i / 2, 1);
                points2[i + 1] = new Points(y, i / 2, -1);
            }
            Arrays.sort(points2);
            char ans[] = new char[n];

            Map<Integer, Character> map = new HashMap<Integer, Character>();
            boolean isBreak = false;

            for (int i = 0; i < 2 * n; i++) {
                points[i] = points2[i].number;
                //System.out.print(points[i] + " ");
            }
           // System.out.println();
            if (points[0] == points[points.length - 1]) {
                isBreak = true;
            }
            if (!isBreak) {
                for (int i = 0; i < 2 * n; i++) {
                    if (map.containsKey(points[i])) {
                        map.remove(points[i]);
                    } else {

                        if (map.size() > 0) {
                            for (Map.Entry<Integer, Character> temp : map.entrySet()) {
                                // System.out.println("key = "+temp.getKey()+" i = "+i+" value =
                                // "+temp.getValue());
                                if (temp.getValue() == 'C') {
                                    map.put(points[i], 'J');
                                    ans[points[i]] = 'J';
                                } else {
                                    map.put(points[i], 'C');
                                    ans[points[i]] = 'C';
                                }
                                break;
                            }
                        }

                        else {
                            map.put(points[i], 'C');
                            ans[points[i]] = 'C';
                        }
                    }
                }
            }
            System.out.print("Case #" + w + ": ");
            if (!isBreak)
                System.out.println(String.valueOf(ans));
            else
                System.out.println("IMPOSSIBLE");

        }
    }
}

class Points implements Comparable<Points> {
    int a, number, pos;

    Points(int a, int b, int pos) {
        this.a = a;
        this.number = b;
        this.pos = pos;
    }

    @Override
    public int compareTo(Points o) {
        // TODO Auto-generated method stub
        if (this.a == o.a)
            return this.number - o.number;
        else
            return this.a - o.a;
    }

}