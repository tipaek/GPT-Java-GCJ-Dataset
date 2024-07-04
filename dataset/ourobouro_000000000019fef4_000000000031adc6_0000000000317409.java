
import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    static class FastReader{
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            
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
        
        int nextInt() {
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
    
    

  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        int x = fastRead.nextInt();
        int y = fastRead.nextInt();
        
        
        
        String path = fastRead.next();
        
        caseNum++;
        
        if(x == 0 && y==0){
            out.println("Case #"+caseNum+": "+0);
            continue;
        }
        
        int mintime = -1;
        
        for(int i=0;i<path.length();i++){
            
            char ch = path.charAt(i);
            
            if(ch == 'N'){
                y++;
            }
            else if(ch == 'S'){
                y--;
            }
            else if(ch == 'E'){
                x++;
            }
            else{
                x--;
            }
            
            int time = Math.abs(x) + Math.abs(y);
            
            if(time <= (i+1)){
                mintime = i+1;
                break;
            }
        }
        
        
        
        if(mintime == -1){
            out.println("Case #"+caseNum+": IMPOSSIBLE");
        }
        else{
            out.println("Case #"+caseNum+": "+mintime);
        }
        
    }
    
      out.close();
  }
}
