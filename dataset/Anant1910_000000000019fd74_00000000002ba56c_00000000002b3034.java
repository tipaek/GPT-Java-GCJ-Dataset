import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;

class Solution
{ 
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

    public static void main(String[] args) 
    {
        FastReader input = new FastReader();

        int T = input.nextInt();
        for(int t = 1; t <= T; t++)
        {
            int n = input.nextInt();
            String p[] = new String[n];
            for(int i = 0; i < n; i++)
            {
                p[i] = input.nextLine();
            }
            Vector<String> a = new Vector<String>();
            for(int i = 0; i < n; i++)
            {
                if(p[i].charAt(0) != '*')
                {
                    String b[] = p[i].split("*"); 
                    for(int j = 0; j < b.length; i++)
                    {
                        a.add(b[i]);
                    }
                }
                else
                {
                    a.add(p[i].substring(1));
                }
            }
            String out = "";
            int siz = 0;
            int o = 0;
            for(int i = 0; i < n ; i++)
            {

                if(p[i].length() > o)
                {
                    siz = i;
                    o = p[i].length();
                }
                for(int j = 0; j < n; j++)
                {
                    
                    if( i != j)
                    {
                       //System.out.println(a.toString());

                        if(!a.elementAt(i).contains(a.elementAt(j)))
                        {
                            if(!a.elementAt(j).contains(a.elementAt(i)))
                            {
                                out = "*";
                                break;
                            }
                        }
                    }
                }
            }
            if(out != "*")
            {
                for(int i = 0; i < p[siz].length(); i++)
                {
                    int m = 0;
                    if(p[siz].charAt(i) == '*')
                    {
                        
                        String q = p[siz].substring(m,i);
                        String r = p[siz].substring(i + 1,p[siz].length());
                        out = q + "A" + r;
                    }
                }
            }
            System.out.println("Case #"+t+": "+out);
        }
    } 
} 