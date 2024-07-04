import java.util.*;
import java.io.*;

class Solution {
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
            int[][]time=new int[n][3];
            for(int i=0;i<n;i++){
                time[i][0]=sc.nextInt();
                time[i][1]=sc.nextInt();
                time[i][2]=i;
            }
            Arrays.sort(time,new Comparator<int[]>(){
                public int compare(int[] t1,int[] t2){
                    if(t1[0]==t2[0]){
                        return t1[1]-t2[1];
                    }
                    return t1[0]-t2[0];
                }
            });
            String ans=solve(time,n);
            System.out.println("Case #"+p+": "+ans);
        }

    }
    public static String solve(int[][] time,int n){
        char[] ans=new char[n];
        int cs=time[0][0];
        int ce=time[0][1];
        ans[time[0][2]]='C';
        int js=-1;
        int je=-1;
        for(int i=1;i<n;i++){
            if(time[i][0]>=ce){
                cs=time[i][0];
                ce=time[i][1];
                ans[time[i][2]]='C';

            }else if(js==-1 || time[i][0]>=je){
                js=time[i][0];
                je=time[i][1];
                ans[time[i][2]]='J';

            }else{
                return new String("IMPOSSIBLE");
            }
        }
        return new String(ans);
    }


}