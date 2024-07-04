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
    public boolean doesOverlap(int[] ar, int s,int e){
        for(int i=s;i<e;i++){
            if(ar[i]==1){
                return true;
            }
        }
        return false;
    }
    public void solve(FastReader in,OutputWriter out) {
        int t=in.nextInt();
        for(int ca=1;ca<=t;ca++){
            int n=in.nextInt();
            Pair<Integer,Integer>[] ar=  new Pair[n];
            Map<Pair<Integer,Integer>,Integer>map =new HashMap<>();
            for(int i=0; i<n;i++){
                int s=in.nextInt();
                int e=in.nextInt();
                ar[i]= new Pair<>(s,e);
                map.put(ar[i],i);
            }
            char[] res= new char[n];
            Arrays.sort(ar, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> t1, Pair<Integer, Integer> t2) {
                    if(t1.first>t2.first){
                        return 1;
                    }
                    else if(t1.first<t2.first){
                        return -1;
                    }
                    else {
                        if(t1.second>t2.second){
                            return 1;
                        }
                        else if(t1.second<t2.second){
                            return -1;
                        }
                        else {
                            return 0;
                        }
                    }
                }
            });
            boolean flag=true;
            HashSet<Integer> set= new HashSet<>();
            set.add(0);
            int prev=0;
            for(int i=1; i<n;i++){
                if(ar[i].first>=ar[prev].second){
                    set.add(i);
                    prev=i;
                }
            }
            HashSet<Integer> set2= new HashSet<>();
            prev=-1;
            for(int i=0;i<n;i++){
                if(set.contains(i)){
                    continue;
                }
                else {
                   if(prev==-1){
                       set2.add(i);
                       prev=i;
                   }
                   else if(ar[i].first>=ar[prev].second) {
                       set2.add(i);
                       prev=i;
                   }
                   else {
                       flag=false;
                       break;
                   }
                }
            }
            out.print("Case #"+ca+": ");
            if(!flag){
                out.print("IMPOSSIBLE");
            }
            else {
                for (int k : set) {
                    res[map.get(ar[k])] = 'C';
                }
                for (int k : set2) {
                    res[map.get(ar[k])] = 'J';
                }
                for(int i=0; i<n;i++){
                    out.print(res[i]);
                }
            }
            out.println();
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