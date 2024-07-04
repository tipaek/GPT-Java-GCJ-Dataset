import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
  
class Solution
{ 
    public static void main(String[] args) 
    { 
        FastReader s=new FastReader(); 
        int t = s.nextInt();
        for(int w = 0; w<t; w++){
            int n = s.nextInt();
            String ls = "";
            String[] p = new String[n];
            for (int i = 0; i<n; i++){
                p[i] = s.nextLine();
                if(p[i].length() > ls.length()){
                    ls = p[i];
                }
            }
            String ans = ls.substring(1);
            for (int i = 0; i<n; i++){
                String ch = p[i];
                ch = ch.substring(1);
                if(ls.indexOf(ch) < 0){
                    ans = "*";
                }
            }
            print(w,ans);

        }
        
    }
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static void print(int w, Object object){
        System.out.println("Case #" + (w+1) + ": " + object);
    } 
} 