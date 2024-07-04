import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
        FastReader fr = new FastReader();
        int testCases=fr.nextInt();
        for(int l=0;l<testCases;l++) {
            int size = fr.nextInt();
            HashSet<Integer> rowHashSet[] = new HashSet[size];

            HashSet<Integer> colHashSet[] = new HashSet[size];

            HashSet<Integer> duplicateRows = new HashSet<>();

            HashSet<Integer> duplicateCols = new HashSet<>();


            for (int i = 0; i < size; i++) {
                rowHashSet[i] = new HashSet<>();
                colHashSet[i] = new HashSet<>();
            }

            long sum = 0;
            for (int i = 0; i < size; i++) {

                for (int j = 0; j < size; j++) {
                    int val = fr.nextInt();
                    if (rowHashSet[i].contains(val)) {
                        duplicateRows.add(i);
                    }
                    if (colHashSet[j].contains(val)) {
                        duplicateCols.add(j);
                    }
                    rowHashSet[i].add(val);
                    colHashSet[j].add(val);
                    if (i == j) sum += val;

                }
            }
            System.out.println("Case #"+(l+1)+": "+sum+" "+ duplicateRows.size()+" "+duplicateCols.size());
        }
    }
}
