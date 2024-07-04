import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0])
                    return ints[1] - t1[1];
                return ints[0] - t1[0];
            }
        };

        int t = in.nextInt(), n, start, end, cind, jind;
        ArrayList<int[]> tl;
        boolean c, j, impos;
        char[] out;
        for (int z = 1; z <= t; z++) {
            n = in.nextInt();
            out = new char[n];
            impos = false;
            tl = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                start = in.nextInt();
                end = in.nextInt();
                int[] tmp = new int[3];
                tmp[0] = start;
                tmp[1] = 1;
                tmp[2] = i;
                tl.add(tmp);
                tmp = new int[3];
                tmp[0] = end;
                tmp[2] = i;
                tl.add(tmp);
            }
            tl.sort(cmp);
            c = false;
            j = false;
            cind = jind = 0;
            for (int[] a : tl){
                if(a[1] == 1) {
                    if(!c && !j) {
                        out[a[2]] = 'J';
                        j = true;
                        jind = a[2];
                    } else if (!c && j) {
                        out[a[2]] = 'C';
                        c = true;
                        cind = a[2];
                    } else if (!j && c){
                        out[a[2]] = 'J';
                        j = true;
                        jind = a[2];
                    } else if (c && j) {
                        impos = true;
                        break;
                    }
                } else if (a[1] == 0) {
                    if(c && !j)
                        c = false;
                    else if(!c && j)
                        j = false;
                    else if(c && j) {
                        if(jind == a[2]) j = false;
                        else c = false;
                    }
                }
            }
            if(impos) pw.println("Case #" + z + ": IMPOSSIBLE");
            else {
                pw.print("Case #" + z + ": ");
                for (int i = 0; i < n; i++)
                    pw.print(out[i]);
                pw.println();
            }
        }
        pw.close();
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = null;
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
}
