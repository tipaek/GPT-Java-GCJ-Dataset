import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    FastReader in = new FastReader();

    public static void main(String[] args) throws IOException{
        new Solution().solveTests();
    }

    public void solveTests() throws IOException {
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            System.out.println(String.format("Case #%d: ", i + 1) + solveTest());
        }
    }

    class Interval{
        int start, end, pos;
        String person;
        public Interval(int start, int end, String person, int pos){
            this.start = start;
            this.end = end;
            this.person = person;
            this.pos = pos;
        }

    }

    class Data{
        int lastC = 0;
        int lastJ = 1;
        Interval[] total;
    }

    public String solveTest(){
        int n = in.nextInt();
        Interval[] intervals = new Interval[n + 2];

        for(int i = 2; i < n + 2; i++){
            intervals[i] = new Interval(in.nextInt(), in.nextInt(), null, i);
        }
        intervals[0] = new Interval(-1, -1, null, 0);
        intervals[1] = new Interval(-1, -1, null, 1);
        Arrays.sort(intervals, (o1, o2) -> o1.end - o2.end);



        Data d = new Data();
        d.total = intervals;

        String s = processData(d);
        if("IMPOSSIBLE".equals(s)){
            return "IMPOSSIBLE";
        }

        Arrays.sort(d.total, (o1, o2) -> o1.pos - o2.pos);

        StringBuilder builder = new StringBuilder();

        for(int i = 2; i < d.total.length; i++){
            builder.append(d.total[i].person);
        }

        return builder.toString();


    }

    private String processData(Data d) {

        for(int i = 2; i < d.total.length; i++){
            Interval currenet = d.total[i];
            Interval lastC = d.total[d.lastC];
            Interval lastJ = d.total[d.lastJ];
            if(currenet.start < lastC.end && currenet.start < lastJ.end){
                return "IMPOSSIBLE";
            }
            if(currenet.start >= lastC.end){
                d.lastC = i;
                currenet.person = "C";
            } else {
                d.lastJ = i;
                currenet.person = "J";
            }
        }

        return null;
    }


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

}
