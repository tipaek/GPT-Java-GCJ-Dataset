import java.util.*;
import java.io.*;
     
public class test 
{    
    public static void main(String[] args) { 
        FastReader in = new FastReader();
        
        int t = in.nextInt();
        for(int ts=1;ts<=t;ts++) {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    arr[i][j] = in.nextInt();
                    if(i==j) k+= arr[i][j];
                }
            }

            for(int i=0;i<n;i++) {
                HashSet<Integer> hash = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(hash.contains(arr[i][j])) {
                        r++;
                        break;
                    }
                    hash.add(arr[i][j]);
                }
            }
            for(int i=0;i<n;i++) {
                HashSet<Integer> hash = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(hash.contains(arr[j][i])) {
                        c++;
                        break;
                    }
                    hash.add(arr[j][i]);
                }
            }
            System.out.println("Case #" +ts+": "+ k+" "+r+" "+c);
        }
    }
 
    static int gcd(int a, int b){ return (b==0) ? a : gcd(b, a%b); }
    static class FastReader { 
        BufferedReader br; StringTokenizer st; 
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); } 
      
        String next() { while (st == null || !st.hasMoreElements()) { 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e) { e.printStackTrace(); } }
            return st.nextToken(); } 
        int nextInt() { return Integer.parseInt(next()); } 
        long nextLong() { return Long.parseLong(next()); } 
        double nextDouble() { return Double.parseDouble(next()); } 
        char nextChar() { return next().charAt(0); }
        String nextLine() { String str = ""; try { str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; }
     
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            String[] str = nextLine().split(" ");
            for(int i=0;i<n;i++) 
                arr[i] = Integer.parseInt(str[i]);
            return arr;    
        } 
    } 
}