import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String [] args) {
        Read read = new Read();
        Integer t = read.nextInt();

        for (int i = 1; i <= t; i++) {
            List<Set<Integer>> rowList = new ArrayList<>();
            List<Set<Integer>> colList = new ArrayList<>();
            Integer n = read.nextInt();
            Integer trace = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Integer x = read.nextInt();

                    if(rowList.size() < j+1) {
                        rowList.add(new HashSet<>());
                    }
                    rowList.get(j).add(x);

                    if(colList.size() < k+1) {
                        colList.add(new HashSet<>());
                    }
                    colList.get(k).add(x);

                    if(j==k) {
                        trace += x;
                    }
                }
            }

//            System.out.println(rowList);
//            System.out.println(colList);
            Integer r = 0, c = 0;

            for (int j = 0; j < n; j++) {
                if(rowList.get(j).size() < n) {
                    r++;
                }
                if(colList.get(j).size() < n) {
                    c++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }

    static class Read {

        BufferedReader br;
        StringTokenizer st;

        private Read() {
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
}
