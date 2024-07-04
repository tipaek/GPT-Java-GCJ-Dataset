import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
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
  
    public static void main(String[] args) throws java.lang.Exception
    { 
        FastReader f=new FastReader(); 
        int T = f.nextInt(); int a=0;
        while (T-- > 0) 
        { 
            ++a;
            String s=f.nextLine();
            int l=s.length();
            char[] st=s.toCharArray();int x=0;int id=0;
            Vector< Character > v=new Vector< Character >();
            for(int i=0;i<l;i++)
            {
                x=(int)(st[i]-'0');
                if(x==0)
                {
                    v.add(st[i]);
                    ++id;
                }
                else if(x==1)
                {
                    v.add('(');
                    v.add('1');
                    id+=2;
                    for(int j=i+1;j<l;j++)
                    {
                        if(st[j]=='1')
                        {
                            v.add(st[j]);
                            ++id;
                        }
                        else
                        {
                            i=j-1;
                            j=l+1;
                        }
                    }
                    v.add(')');
                    ++id;
                }
            }
            System.out.print("Case #"+a+": ");
            for(int i=0;i<id;i++)
            {
                System.out.print(v.get(i));
            }
            System.out.println();
            v.clear();
        } 
    } 
} 

