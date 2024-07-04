import java.util.*;
import java.io.*;

class Solution {
    static int max=0;
    static List<Integer> maxPath=new ArrayList<>();
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
            } catch (Exception e) {
                System.out.println(e);
            }
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



    public static void main(String args[])throws Exception {
        FastReader sc = new FastReader();
        int t=sc.nextInt();
        for(int p=1;p<=t;p++){
            int n=sc.nextInt();
            List<Set<Integer>> rowSet=new ArrayList<Set<Integer>>();
            List<Set<Integer>> colSet=new ArrayList<Set<Integer>>();

            for(int i=0;i<n;i++){
                rowSet.add(new HashSet<>());
                colSet.add(new HashSet<>());
            }

            int diag=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int x=sc.nextInt();
                    rowSet.get(i).add(x);
                    colSet.get(j).add(x);
                    if(i==j){
                        diag+=x;
                    }
                }
            }
            int r=0,c=0;
            for(int i=0;i<n;i++){
                if(rowSet.get(i).size()!=n)
                    r++;
                if(colSet.get(i).size()!=n)
                    c++;
            }
            System.out.println("Case #"+p+": "+diag+" "+r+" "+c);
        }
    }


}