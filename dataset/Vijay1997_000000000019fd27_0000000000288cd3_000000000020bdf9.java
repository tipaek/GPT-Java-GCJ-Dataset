import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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
        FastReader s = new FastReader();
        Solution c=new Solution();
        int T=s.nextInt();
        for (int t=1;t<=T;t++){
            int n=s.nextInt();
            c.begEnd=new List[n];

            for (int i=0;i<n;i++){
                c.begEnd[i]=new ArrayList<>();
                c.begEnd[i].add(i);
                c.begEnd[i].add(s.nextInt());
                c.begEnd[i].add(s.nextInt());
            }

            c.ppReturn(t, n);
        }
    }

    private List<Integer>[] begEnd;
    void ppReturn(int t, int n){
        int[] cj=new int[n];
        Arrays.sort(begEnd, Comparator.comparingInt(o -> o.get(1)));

        int i=0;
        int prvEnd=-1;
        while (i<n){
            if (begEnd[i].get(1) >= prvEnd){
                cj[begEnd[i].get(0)]=1;
                prvEnd=begEnd[i].get(2);
            }
            i++;
        }

        i=0;
        prvEnd=-1;
        while (i<n){
            if (cj[begEnd[i].get(0)] == 0){
                if (begEnd[i].get(1) >= prvEnd){
                    cj[begEnd[i].get(0)]=2;
                    prvEnd=begEnd[i].get(2);
                }
                else {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
            i++;
        }

        StringBuilder sb=new StringBuilder();
        for (int a:cj){
            sb.append(a==1?'C':'J');
        }
        System.out.println("Case #"+t+": "+sb.toString());
    }
}
