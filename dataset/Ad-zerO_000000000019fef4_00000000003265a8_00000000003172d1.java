    import java.io.*;
    import java.io.IOException;
    import java.util.*;
    //import javafx.util.Pair; 
    //import java.util.concurrent.LinkedBlockingDeque;
    
    
    
    //import sun.net.www.content.audio.wav;
    
    import java.text.DecimalFormat;
    
   public  class Solution {
        
        public static long mod = (long)Math.pow(10, 9)+7 ;
        public static double epsilon=0.00000000008854;//value of epsilon
        public static InputReader sc = new InputReader(System.in);
        public static PrintWriter pw = new PrintWriter(System.out);
        
        
        
        public static boolean hieghtBfs(int r,int h[],ArrayList<ArrayList <Integer>> a,int vis[]){/// top to bottom
            Deque<Integer> q=new LinkedList<>();
            q.add(r);
            int c=1;
            //p[r]=-1;
            vis[r]=1;
            h[r]=c;
            boolean pos=true;
            while(q.size()>0){
                int l=q.size();
                while(l-->0){
                    int v=q.remove();
                    
                    for(int i=0;i<a.get(v).size();i++){
                        int u=a.get(v).get(i);
                        if(vis[u]==0){
                            //pw.print(u+" ");
                            //p[u]=v;
                            vis[u]=1;
                            h[u]=c+1;
                            q.add(u);
                        }
                        else{
                            if((h[u]&1)==(h[v]&1)){
                                return false;
                            }
                            
                        }
                    }
                }
                //pw.print("\n");
                c++;
            }
            return pos;
        }
        
        
        public static ArrayList<ArrayList <Integer>> GetGraph(int n,int m){
            ArrayList<ArrayList <Integer>> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                int u=sc.nextInt()-1;
                int v=sc.nextInt()-1;
                a.get(u).add(v);
                a.get(v).add(u);
            } 
            return a;
        }
        public static ArrayList<ArrayList <Pair>> GetGraphWieghted(int n,int m){
            ArrayList<ArrayList <Pair>> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                int u=sc.nextInt()-1;
                int v=sc.nextInt()-1;
                int w=sc.nextInt();
                a.get(u).add(new Pair(v, w));
                a.get(v).add(new Pair(u, w));
            } 
            return a;
        }
       
        public static long pow(long x,long y,long mod){
            long ans=1;
            //If u know that mod=prime than don't do phi just write (mod-1) instead
            pw.println(Long.toBinaryString(y));
            x%=mod;
            while(y>0){
                if((y&1)==1){
                    ans=(ans*x)%mod;
                }
                pw.println(ans);
                y=y>>1;
                x=(x*x)%mod;
            }
            pw.println(ans);
            return ans;
        }
        public static void main(String[] args) {
            // code starts..
           
            int q=sc.nextInt();
            for(int q0=1;q0<=q;q0++){
               int n=sc.nextInt();
               long d=sc.nextLong();
               long a[]=scanLongArray(n);
               Arrays.sort(a);
               long d1=d;
               long min=d-1;
               for(int i=0;i<n;i++){
                   Long v[][]=new Long[n][2];
                   
                   for(int j=0;j<n;j++){
                       v[j][0]=a[j]/a[i];
                       if(a[j]%a[i]==0)
                       v[j][0]-=1;
                       v[j][1]=a[j]/a[i];
                   }
                   Arrays.sort(v,i,n,lpair());
                   long c=0;
                   long f=0;
                   d=d1;
                   
                   for(int j=i;j<n;j++){
                    if(d-v[j][1]<0){            
                        c+=d;
                        f+=d;
                        break;
                    }
                    f+=v[j][1];
                    d-=v[j][1];
                    c+=v[j][0];
                   }
                   if(d==0)
                   min=Math.min(min, c);
               }
               pw.println("Case #" + q0 + ": " + min);

            }
                
            // Code ends...
            pw.flush();
            pw.close();
        }
        public static Comparator<Integer> C(){
            return 
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);//for descending
                }
            };
        }
        public static Comparator<Pair> di(){
            return 
            new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    Long a=o1.j;
                    Long b=o2.j;
                    return a.compareTo(b);//ascending
                }
            };
        }
        static class tripletL implements Comparable<tripletL> {
            Long x, y, z;
    
            tripletL(long x, long y, long z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }
    
            public int compareTo(tripletL o) {
                int result = x.compareTo(o.x);
                if (result == 0)
                    result = y.compareTo(o.y);
                if (result == 0)
                    result = z.compareTo(o.z);
    
                return result;
            }
    
            public boolean equlas(Object o) {
                if (o instanceof tripletL) {
                    tripletL p = (tripletL) o;
                    return (x - p.x == 0) && (y - p.y ==0 ) && (z - p.z == 0);
                }
                return false;
            }
    
            public String toString() {
                return x + " " + y + " " + z;
            }
    
            public int hashCode() {
                return new Long(x).hashCode() * 31 + new Long(y).hashCode() + new Long(z).hashCode();
            }
        }
        public static String Doubleformate(double a,int n){
            String s="";
            while(n-->0){
                s+='0';
            }
            DecimalFormat f =new DecimalFormat("#0."+s);
            return f.format(a);
        }
    
        public static Comparator<Integer[]> column(int i){
            return 
            new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                // return o1[i].compareTo(o2[i]);//for ascending
                    return o2[i].compareTo(o1[i]);//for descending
                }
            };
        }
        public static Comparator<Long[]> column1(int i){
            return 
            new Comparator<Long[]>() {
                @Override
                public int compare(Long[] o1, Long[] o2) {
                    return o1[i].compareTo(o2[i]);//for ascending
                    //return o2[i].compareTo(o1[i]);//for descending
                }
            };
        }
        public static Comparator<Long[]> lpair(){
            return 
            new Comparator<Long[]>() {
                @Override
                public int compare(Long[] o1, Long[] o2) {
                    int result=o1[0].compareTo(o2[0]);
                    if(result==0)
                    result=o2[1].compareTo(o1[1]);
                    return result;
                }
            };
        }
        public static Comparator<Integer[]> pair(){
            return 
            new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    int result=o1[0].compareTo(o2[0]);
                    if(result==0)
                    result=o1[1].compareTo(o2[1]);
                    return result;
                }
            };
        }
        public static Comparator<Integer[]> Triplet(){
            return 
            new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                
                        for(int i=0;i<3;i++){
                            for(int j=i+1;j<3;j++){
                                for(int k=0;k<3;k++){
                                    for(int p=k+1;p<3;p++){
                                        if((o1[i]==o2[k]&&o1[j]==o2[p])||(o1[j]==o2[k]&&o1[i]==o2[p])){
    
                                        }
                                    }
                                }
                            }
                        }
                        int result=o1[0].compareTo(o2[0]);
                        if(result==0)
                        result=o1[1].compareTo(o2[1]);
                        if(result==0)
                        result=o1[2].compareTo(o2[2]);
                        return result;
                }
            };
        }
        
        
        public static String reverseString(String s){
            StringBuilder input1 = new StringBuilder(); 
            input1.append(s);  
            input1 = input1.reverse();
            return input1.toString();
        }
        public static int[] scanArray(int n){
            int a[]=new int [n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
    
            return a;
        }
        public static long[] scanLongArray(int n){
            long a[]=new long [n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextLong();
    
            return a;
        }
        public static String [] scanStrings(int n){
            String a[]=new String [n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextLine();
    
            return a;
        }
        
    }
    class Pair{
        long i;
        long j;
        Pair(long a,long b){
            i=a;
            j=b;
        }
    }
    class InputReader {
    
            private final InputStream stream;
            private final byte[] buf = new byte[8192];
            private int curChar, snumChars;
            private SpaceCharFilter filter;
    
            public InputReader(InputStream stream) {
                this.stream = stream;
            }
    
            public int snext() {
                if (snumChars == -1)
                    throw new InputMismatchException();
                if (curChar >= snumChars) {
                    curChar = 0;
                    try {
                        snumChars = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (snumChars <= 0)
                        return -1;
                }
                return buf[curChar++];
            }
    
            public int nextInt() {
                int c = snext();
                while (isSpaceChar(c)) {
                    c = snext();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = snext();
                }
                int res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
    
            public long nextLong() {
                int c = snext();
                while (isSpaceChar(c)) {
                    c = snext();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = snext();
                }
                long res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
    
            public int[] nextIntArray(int n) {
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = nextInt();
                }
                return a;
            }
    
            public String readString() {
                int c = snext();
                while (isSpaceChar(c)) {
                    c = snext();
                }
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = snext();
                } while (!isSpaceChar(c));
                return res.toString();
            }
    
            public String nextLine() {
                int c = snext();
                while (isSpaceChar(c))
                    c = snext();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = snext();
                } while (!isEndOfLine(c));
                return res.toString();
            }
    
            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
    
            private boolean isEndOfLine(int c) {
                return c == '\n' || c == '\r' || c == -1;
            }
    
            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }