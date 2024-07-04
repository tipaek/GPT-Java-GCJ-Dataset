import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        FastReader in = new FastReader();
        OutputWriter out = new OutputWriter(outputStream);
        Taska solver=  new Taska();
        solver.solve(in,out);
        out.close();
    }
}
class Taska{
    public void solve(FastReader in,OutputWriter out) {
        int t=in.nextInt();
        for(int ca=1;ca<=t;ca++){
            int n=in.nextInt();
            int[][] ar= new int[n][2];
            for(int i=0; i<n;i++){
                ar[i][0]=in.nextInt();
                ar[i][1]=in.nextInt();
            }
            interval C= new interval(-1,-1);
            interval J= new interval(-1,-1);
            StringBuilder res= new StringBuilder();
            boolean flag= true;
            for(int i=0; i<n;i++){
                interval temp= new interval(ar[i][0],ar[i][1]);
                if(!temp.doesOverlap(C)){
                    res.append('C');
                    C= temp;
                }
                else {
                    if(!temp.doesOverlap(J)){
                        res.append('J');
                        J=temp;
                    }
                    else {
                        flag=false;
                        break;
                    }
                }
            }
            out.print("Case #"+""+ca+": ");
            if(flag){
                out.print(res.toString());
            }
            else {
                out.print("IMPOSSIBLE");
            }
            out.println();
        }
    }
}
class interval{
    int a;
    int b;
    public interval(int a,int b){
        this.a=a;
        this.b=b;
    }
    public boolean doesOverlap(interval temp){
        if((this.a<=temp.a && this.b<=temp.a) || (this.a>=temp.b && this.b>=temp.b)){
            return false;
        }
        return true;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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
class OutputWriter extends PrintWriter {

    public OutputWriter(OutputStream outputStream) {
        super(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

}
class Pair<U, V> {
    final U first;
    final V second;
    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (!first.equals(pair.first))
            return false;
        return second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    public static <U, V> Pair <U, V> of(U a, V b) {
        return new Pair<>(a, b);
    }
}