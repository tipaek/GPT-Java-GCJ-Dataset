import java.util.*;
import java.io.*;
public class Solution{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        public FastReader(File file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
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
    static class job{
        int s,e,index;
        job(int s,int e,int index){
            this.s=s;
            this.e=e;
            this.index=index;
        }
    }
    public static void main(String[]abc){
        FastReader in=new FastReader();
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        int t=in.nextInt(),Case=1;
        while(t-->0){
            int c=-1,j=-1,n=in.nextInt();
            job[]jobs=new job[n];
            for(int i=0;i<n;i++)
                jobs[i]=new job(in.nextInt(),in.nextInt(),i);
             Arrays.sort(jobs, new Comparator<job>() {
                @Override
                public int compare(job o1, job o2) {
                    return o1.s==o2.s?o1.e-o2.e:o1.s-o2.s;
                }
            });
            char[]ans=new char[n];

            for(int i=0;i<n;i++){
                if(jobs[i].s>=c){
                    c=jobs[i].e;
                    ans[jobs[i].index]='C';
                }else if(jobs[i].s>=j){
                    j=jobs[i].e;
                    ans[jobs[i].index]='J';
                }else{
                    ans="IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            out.println("Case #"+(Case++)+": "+new String(ans));
        }
        out.flush();
    }
}