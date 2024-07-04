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
            String s=in.nextLine();
            int n=s.length();
            int[] ar= new int[n];
            int max=Integer.MIN_VALUE;
            int index= 0;
            for(int i=0; i<n;i++){
                ar[i]=s.charAt(i)-'0';
                if(ar[i]>max){
                    max= ar[i];
                    index=i;
                }
            }
            int index1=index;
            int max1=max;
            String[] res= new String[n+1];
            while(index>=0){
                StringBuilder st= new StringBuilder();
                if(index==0){
                    for(int i=0; i<max;i++){
                        st.append('(');
                    }
                }
                else if(ar[index-1]<ar[index]){
                    int diff= ar[index]-ar[index-1];
                    for(int i=0; i<diff;i++){
                        st.append('(');
                    }
                    max-= diff;
                }
                else{
                    int diff= ar[index-1]-ar[index];
                    max+= diff;
                    for(int i=0; i<diff;i++){
                        st.append(')');
                    }
                }
                res[index]= st.toString();
                index--;
            }
            while (index1<n){
                StringBuilder st= new StringBuilder();
                if(index1==n-1){
                    for(int i=0; i<max1;i++){
                        st.append(')');
                    }
                }
                else if(ar[index1+1]<ar[index1]){
                    int diff= ar[index1]-ar[index1+1];
                    for(int i=0; i<diff;i++){
                        st.append(')');
                    }
                    max1-=diff;
                }
                else {
                    int diff= ar[index1+1]-ar[index1];
                    for(int i=0; i<diff;i++){
                        st.append('(');
                    }
                    max1+=diff;
                }
                res[index1+1]= st.toString();
                index1++;
            }
            out.print("Case #"+ca+": ");
            for(int i=0; i<n;i++){
                out.print(res[i]+""+ar[i]);
            }
            out.println(res[n]);
        }
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