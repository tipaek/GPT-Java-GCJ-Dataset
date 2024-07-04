import java.io.*;
import java.io.IOException;
import java.util.*;
//import javafx.util.Pair; 
//import java.util.concurrent.LinkedBlockingDeque;
 
 
 
//import sun.net.www.content.audio.wav;
 
import java.text.DecimalFormat;
 
public class Solution {
    
    public static long mod = (long)Math.pow(10, 9)+7 ;
    public static double epsilon=0.00000000008854;//value of epsilon
    public static InputReader sc = new InputReader(System.in);
    public static PrintWriter pw = new PrintWriter(System.out);
    
    public static void diji(PriorityQueue<Pair> q,ArrayList<ArrayList<Pair>> a){
        //int vis[]=new int[a.size()];
        boolean vis[]=new boolean[a.size()];
        //vis[0]=1;
        Arrays.fill(vis, false);
        int n=a.size();
        long val[]=new long[n];
 
        long inf=Long.MAX_VALUE;
        Arrays.fill(val, inf);
        q.add(new Pair(0, 0));
        val[0]=0;
        int p[]=new int[n];
        p[0]=-1;
        while(q.size()>0){
            Pair r=q.remove();
            if(vis[r.i])
            continue;
            vis[r.i]=true;///removed
            int u=r.i;
            for(int i=0;i<a.get(u).size();i++){
 
                int v=a.get(u).get(i).i;
                long w=a.get(u).get(i).j;
                    if(val[v]>r.j+w){
                        p[v]=u;
                        val[v]=r.j+w;
                        q.add(new Pair(v, val[v]));
                    }
            }
        }
        //pw.println(Arrays.toString(p));
        int i=n-1;
        Stack<Integer> st=new Stack<>();
        if(val[i]==inf)
        {
            pw.println(-1);
            return;
        }
        while(i!=-1){
            st.add(i+1);
            i=p[i];
        }
        while(st.size()>0){
            pw.print(st.pop()+" ");
        }
        
 
    }
    public static int countSet(int a){
        int c=0;
        while(a>0){
            a&=(a-1);
            c++;
        }
        return c;
    }
    public static void Zfunction(String s){
        int n=s.length();
        int a[]=new int[n];
        int r1=0,r2=1;
        for(int i=1;i<n;){
            int f=0;
            while(r2<n&&s.charAt(r1)==s.charAt(r2)){
                r1++;
                r2++;
            }
            a[i]=r1;
            i++;
            int l2=1;
            for(;i<r2;i++){
                if(i+a[l2]<r2)
                a[i]=a[l2++];
                else{
                    f=1;
                    r1=r2-i;
                    break;
                }
            }
            if(f==0){
                r2=i;
                r1=0;
            }
 
        }
        pw.println(Arrays.toString(a));
    }
    public static void hieghtBfs(int r,int h[],ArrayList<ArrayList <Integer>> a,int p[],int vis[]){/// top to bottom
		Deque<Integer> q=new LinkedList<>();
		q.add(r);
		int c=0;
		p[r]=-1;
		vis[r]=1;
		while(q.size()>0){
			int l=q.size();
			while(l-->0){
				int v=q.remove();
				h[v]=c;
				for(int i=0;i<a.get(v).size();i++){
                    int u=a.get(v).get(i);
                    
					if(vis[u]==0){
                        //pw.print(u+" ");
						p[u]=v;
						vis[u]=1;
						q.add(u);
					}
				}
            }
            //pw.print("\n");
			c++;
		}
    }
    
    public static int hieght(int r,int h[],ArrayList<ArrayList <Integer>> a,int vis[],int p[]){//bottom Up
        vis[r]=1;
		for(int i=0;i<a.get(r).size();i++){
			int v=a.get(r).get(i);
			if(vis[v]==0){
				p[v]=r;
                h[r]+=Math.max(1+hieght(v, h, a, vis,p),h[r]);
			}
        }
		return h[r];
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
    public static void fun(int r,int dp[][],ArrayList<ArrayList <Integer>> a,int vis[],int p[],int k){//bottom Up
        vis[r]=1;
		for(int i=0;i<a.get(r).size();i++){
            int v=a.get(r).get(i);
            dp[r][0]=1;
			if(vis[v]==0){
				p[v]=r;
                fun(v, dp, a, vis, p,k);
                dp[r][1]++;
                for(int j=1;j<k;j++){
                    dp[r][j+1]+=dp[v][j];
                }
			}
        }
	}
   
    
    public static void main(String[] args) {
        // code starts..
        int q=sc.nextInt();
        int b=sc.nextInt();
       // sc.nextLine();
      // int t=0;
        for(int p=1;p<=q;p++){
            int a[][]=new int[b][4];
            int f=0;int f1=-1,f2=-1,t=0;
            for(int i=0;i<b/2;i++){
                pw.println(i+1);
                pw.flush();
                int k1=sc.nextInt();
                pw.println(b-i);
                pw.flush();
                int k2=sc.nextInt();
                if(k1!=k2&&f1==-1){
                    f1=i;
                }
                if(k1==k2&&f2==-1){
                    f2=i;
                }
                if(f==0){
                   a[i][0]=k1;
                   a[i][1]=k1^1;
                   a[i][2]=k2;
                   a[i][3]=k2^1;
                   a[b-i-1][2]=k1;
                   a[b-i-1][3]=k1^1;
                   a[b-i-1][0]=k2;
                   a[b-i-1][1]=k2^1;
                }
                if(f==1){
                    a[i][1]=k1;
                    a[i][0]=k1^1;
                    a[i][3]=k2;
                    a[i][2]=k2^1;
                    a[b-i-1][3]=k1;
                    a[b-i-1][2]=k1^1;
                    a[b-i-1][1]=k2;
                    a[b-i-1][0]=k2^1; 
                 }
                 if(f==2){
                    a[i][0]=k2;
                    a[i][1]=k2^1;
                    a[i][2]=k1;
                    a[i][3]=k1^1;
                    a[b-i-1][2]=k2;
                    a[b-i-1][3]=k2^1;
                    a[b-i-1][0]=k1;
                    a[b-i-1][1]=k1^1; 
                 }
                 if(f==3){
                    a[i][1]=k2;
                    a[i][0]=k2^1;
                    a[i][3]=k1;
                    a[i][2]=k1^1;
                    a[b-i-1][3]=k2;
                    a[b-i-1][2]=k2^1;
                    a[b-i-1][1]=k1;
                    a[b-i-1][0]=k1^1; 
                 }
                t+=2;
                if(t%10==0){
                   if(f1==-1){
                       pw.println(1);
                       pw.flush();
                       int k=sc.nextInt();
                       if(k==a[0][0]){
                           f=0;
                       }
                       else{
                           f=1;
                       }
                   }
                   else if(f2==-1){
                        pw.println(f1+1);
                        pw.flush();
                        int k=sc.nextInt();
                        if(k==a[f1][0]){
                            f=0;
                        }
                        else{
                            f=2;
                        }
                    }
                    else{
                        int a1=0,a2=0;
                        pw.println(f1+1);
                        pw.flush();
                        int k=sc.nextInt();
                        if(k==a[f1][0]){
                            a1=0;
                            a2=3;
                        }
                        else{
                            a1=1;
                            a2=2;
                        }
                        pw.println(f2+1);
                        pw.flush();
                        k=sc.nextInt();
                        if(a[f2][a1]==k){
                            f=a1;
                        }
                        else{
                            f=a2;
                        }


                    }
                    t+=2;
                }
           }
           String s="";
           for(int i=0;i<b;i++){
            s+=a[i][f];
           }
           pw.println(s);
           pw.flush();
           String r=sc.nextLine();
           if(r.charAt(0)=='N'){
               break;
           }
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
    int i;
    long j;
    Pair(int a,long b){
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