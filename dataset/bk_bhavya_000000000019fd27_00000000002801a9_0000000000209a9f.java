import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        int val = t;
        while(t-->0){
            String s = sc.nextLine();
            int count = 0;
            StringBuffer sb = new StringBuffer();
            int x = ((int)s.charAt(0) - 48);
            int y = 0;
            int z = 0;
            count += x;
            while(x != 0){
                sb.append("(");
                x--;
            }
            sb.append(s.charAt(0));
            for(int i = 1;i<s.length();i++){
                x = ((int)s.charAt(i) - 48);
                y = ((int)s.charAt(i-1) - 48);
                if(y == x)
                    sb.append(s.charAt(i));
                else if(y < x){
                    z = x-y;
                    while(z != 0){
                        sb.append("(");
                        count++;
                        z--;
                    }
                    sb.append(s.charAt(i));
                }
                else{
                    z = y-x;
                    while(z != 0){
                        sb.append(")");
                        count--;
                        z--;
                    }
                    sb.append(s.charAt(i));
                }
            }
            while(count-- != 0)
                sb.append(")");
            System.out.println("Case #"+(val-t)+": "+sb.toString());
        }
    }
}
class FastReader 
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