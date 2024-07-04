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
    public boolean doesOverlap(int[] a, int[] b){
        return a[1]>b[0];
    }
    public char getPer(char a){
        return a=='J' ? 'C':'J';
    }
    public void solve(FastReader in,OutputWriter out) {
        int t=in.nextInt();
        for(int ca=1;ca<=t;ca++){
            int n=in.nextInt();
            int[][] ar=  new int[n][2];
            Map<int[],Integer>map =new HashMap<>();
            for(int i=0; i<n;i++){
                int s=in.nextInt();
                int e=in.nextInt();
                ar[i][0]=s;
                ar[i][1]=e;
                map.put(ar[i],i);
            }
            char[] res= new char[n];
            Arrays.sort(ar, new Comparator<int[]>() {
                @Override
                public int compare(int[] t1, int[] t2) {
                    return t1[0]-t2[0];
                }
            });
            boolean flag=false;
            Stack<int[]> CStack= new Stack<>();
            Stack<int[]> JStack= new Stack<>();
            char person= 'J';
            for(int i=0; i<n;i++){
                res[map.get(ar[i])]=person;
                if(i<n-1 && doesOverlap(ar[i],ar[i+1])){
                    if(person=='J'){
                        JStack.push(ar[i]);
                        person=getPer(person);
                        if(!CStack.isEmpty() && doesOverlap(CStack.peek(),ar[i+1])){
                            flag=true;
                            break;
                        }
                    }
                    else {
                        CStack.push(ar[i]);
                        person =getPer(person);
                        if(!JStack.isEmpty() && doesOverlap(JStack.peek(),ar[i+1])){
                            flag=true;
                            break;
                        }
                    }
                }
                else {
                    if(person=='J'){
                        JStack.push(ar[i]);
                    }
                    else {
                        CStack.push(ar[i]);
                    }
                }
            }
            out.println("Case #"+ca+": "+(flag ? "IMPOSSIBLE": new String(res)));
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