import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
  
class Solution 
{ 
    public static void main(String[] args) 
    { 
        FastReader sc=new FastReader();
        int t = sc.nextInt();
        for(int w = 0; w<t; w++){
            int n = sc.nextInt();
            String[] p = new String[n];
            String ls = "";
            for (int i = 0; i<n; i++){
                String ss = sc.nextLine();
                ss = ss.replaceAll("\\*+", "*");
                p[i] = ss;
                if(ss.length() > ls.length()){
                    ls = ss;
                }
            }
            String ans = ls.substring(1);
            for(int i = 0; i<n; i++){
                String ch = p[i].substring(1);
                if(ans.indexOf(ch) < 0){
                    ans = "*";
                    break;
                }
            }
            print(w, ans);
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