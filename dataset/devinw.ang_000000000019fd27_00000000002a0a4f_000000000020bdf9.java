import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = sc.nextInt();
		for(int i = 0;i<n;i++) {
			solve(i+1,sc,out);
		}
		out.close();
	}
	public static void solve(int testNumber, FastReader sc, PrintWriter pw) {
        int n  = sc.nextInt(); 
        PriorityQueue<tup> pq = new PriorityQueue<>();
        int[] x = new int[n];
        int track = 0;
        for(int i=0;i<n;i++){
            pq.add(new tup(sc.nextInt(),i+1));
            pq.add(new tup(sc.nextInt(),-i-1));
        }
        int full1 = -2;
        int full2 = -2;
        while(!pq.isEmpty()){
            tup c = pq.poll();
            if(c.b>0){
                if(full1==-2){
                    full1=c.b;
                }
                else if(full2==-2){
                    full2=c.b;
                    x[c.b-1]=1;
                }
                else{
                pw.printf("Case #%d: IMPOSSIBLE%n",testNumber);
                return;
                }
            }
            else{
                if(full1==-c.b){
                    full1=-2;
                }
                if(full2==-c.b){
                    full2=-2;
                }
            }
        }
        pw.printf("Case #%d: ",testNumber);
        for(int z : x){
            pw.print(z==0?'C':'J');
        }
        pw.println();
    }

	static class tup implements Comparable<tup>{
    int a,b;
    tup(int a, int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public int compareTo(tup o2){
        return a==o2.a?Integer.compare(b,o2.b):Integer.compare(a,o2.a);
    }
	}
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

