
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    
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
   
    Scanner input = new Scanner(System.in);
    
    int caseNum = 0;
      
    int t =  input.nextInt();
    int a = input.nextInt();
    int b = input.nextInt();
      
    while (t-- > 0) {
        
        int x = -5;
        int y = -5;
        
        boolean found = false;
        
        for(int i=0;i<11;i++){
            
            if(found)
                break;
            
            for(int j=0;j<11;j++){
                
                System.out.println(x+" "+y);
                
                String str = input.nextLine();
                
                if(str.equals("CENTER")){
                    found = true;
                    break;
                }
            
                x++;
            }
            
            if(found)
                break;
            
            y++;
            x = -5;
        }
        
    }
    

  }
}
