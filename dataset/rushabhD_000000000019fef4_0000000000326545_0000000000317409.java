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
            int x1=sc.nextInt();
            int x2=sc.nextInt();
            String steps=sc.next();

            System.out.println("Case #"+p+": "+ans(x1,x2,steps.toCharArray()));
        }
    }
    private static String ans(int x,int y,char[] steps){
        if(x==0&&y==0)
            return ""+0;    
        int min=steps.length+1;

        for(int i=0;i<steps.length;i++){
            if(steps[i]=='S')
                --y;
            else if(steps[i]=='N')
                ++y;
            else if(steps[i]=='E')
                ++x;
            else if(steps[i]=='W')
                --x;

            if(dist(x,y)<=i+1)
                return i+1+"";

        }

        if(min==steps.length+1)
            return "IMPOSSIBLE";
        return min+"";



    }
    private static int dist(int x1,int y1){
        return Math.abs(x1)+Math.abs(y1);
    }

}