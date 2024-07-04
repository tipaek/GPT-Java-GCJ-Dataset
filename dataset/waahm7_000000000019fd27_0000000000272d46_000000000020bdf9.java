import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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


    static class Activity implements Comparable<Activity>{
        int start;
        int end;
        int index;
        char ch;
        Activity(int start,int end,int index){
            this.start=start;
            this.end=end;
            this.index=index;
        }


        @Override
        public int compareTo(Activity o) {
            return start-o.start;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases=fr.nextInt();
        for(int l=0;l<testCases;l++) {

            int num=fr.nextInt();
            Activity activity[]=new Activity[num];
            for(int k=0;k<num;k++){
                int start=fr.nextInt();
                int end=fr.nextInt();
                activity[k]=new Activity(start,end,k);
            }

            int c=-1;
            int j=-1;
            boolean imp=false;
            Arrays.sort(activity);
            for(Activity a:activity){
                if(a.start>=c){
                    c=a.end;
                    a.ch='C';
                }else if(a.start>=j){
                    j=a.end;
                    a.ch='J';
                }else{

                    System.out.println("Case #"+(l+1)+": IMPOSSIBLE");
                    imp=true;
                    break;
                }
            }
            if(!imp){
                char ch[]=new char[num];
                for(Activity a:activity)
                    ch[a.index]=a.ch;
                System.out.println("Case #"+(l+1)+": "+new String(ch));

            }
        }
    }
}
