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
            String ls = "";
            String[] p = new String[n];
            for (int i = 0; i<n; i++){
                p[i] = sc.nextLine();
                if(p[i].length() > ls.length()){
                    ls = p[i];
                }
            }
            String ans = ls.substring(1);
            String start = "";
            String end = "";
            start = p[0].substring(0, p[0].indexOf('*'));
            end = p[0].substring(p[0].lastIndexOf('*') + 1);
            for(int i = 1; i<n; i++){
                String s = p[i].substring(0, p[i].indexOf('*'));
                String e = p[i].substring(p[i].lastIndexOf('*') + 1);
                if(s.length() > start.length()){
                    if(s.indexOf(start) > -1){
                        start = s;
                    } else{
                        ans = "*";
                        break;
                    }
                } else{
                    if(start.indexOf(s) < 0){
                        ans = "*";
                        break;
                    }
                }
                if(e.length() > end.length()){
                    if(e.indexOf(end) > -1){
                        end = e;
                    } else{
                        ans = "*";
                        break;
                    }
                } else{
                    if(start.indexOf(e) < 0){
                        ans = "*";
                        break;
                    }
                }
            }

            if(start.length() > end.length()){
                if(start.indexOf(end) > -1){
                    ans = start;
                } else{
                    ans = start.concat(end);
                }
            } else if(start.length() < end.length()){
                if(end.indexOf(start) > -1){
                    ans = end;
                } else{
                    ans = start.concat(end);
                }
            } else{
                if(start.indexOf(end) > -1){
                    ans = start;
                } else{
                    ans = start.concat(end);
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