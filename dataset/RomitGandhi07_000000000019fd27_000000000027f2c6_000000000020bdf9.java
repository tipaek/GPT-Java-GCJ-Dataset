import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;

public class Solution implements Runnable 
{
    public static void main(String args[]) throws Exception 
    {
        new Thread(null, new Solution(),"Solution",1<<27).start();
    }


    public void run()
    {
        InputReader sc = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t=sc.nextInt();
        for(int x=1;x<=t;++x){
            int n=sc.nextInt();
            int st=0,et=0;
            ArrayList<Demo> al=new ArrayList<Demo>();
            char[] ct=new char[n];
            for(int i=0;i<n;++i){
                st=sc.nextInt();
                et=sc.nextInt();
                al.add(new Demo(st,et,i));
            }
            Collections.sort(al,new sortByS());
            int curc=-1,curj=-1,temp=0;
            boolean flag=false;
            String ans="";
            for(int i=0;i<n;++i){
                temp=al.get(i).s;
                if(temp>=curc){
                    ct[al.get(i).i]='C';
                    curc=al.get(i).e;
                }
                else if(temp>=curj){
                    ct[al.get(i).i]='J';
                    curj=al.get(i).e;
                }
                else{
                    flag=true;
                    ans="IMPOSSIBLE";
                    break;
                }
            }
            if(!flag){
                ans=new String(ct);
            }
            System.out.println("Case #"+x+": "+ans);
            System.out.flush();
        }
        w.close();
    }

    static class InputReader 
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) 
        {
            this.stream = stream;
        }
        
        public int read()
        {
            if (numChars==-1) 
                throw new InputMismatchException();
            
            if (curChar >= numChars) 
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                
                if(numChars <= 0)               
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine()
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
        public int nextInt() 
        {
            int c = read();
            
            while(isSpaceChar(c)) 
                c = read();
            
            int sgn = 1;
        
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            
            int res = 0;
            do
            {
                if(c<'0'||c>'9') 
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c)); 
        
            return res * sgn;
        }
        
        public long nextLong() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;
            
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
        
        public double nextDouble() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') 
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
    
        public String readString() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = read();
            } 
            while (!isSpaceChar(c));
            
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) 
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next()
        {
            return readString();
        }
        
        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
    
    
    // if modulo is required set value accordingly
    public static long[][] matrixMultiply2dL(long t[][],long m[][])
    {
        long res[][]= new long[t.length][m[0].length];
        
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                res[i][j]=0;
                for(int k=0;k<t[0].length;k++)
                {
                    res[i][j]+=t[i][k]+m[k][j];
                }
            }
        }
        
        return res;
    }
    
    static void Seive(){
        int temp=1000001;
        boolean[] flag=new boolean[temp];
        Arrays.fill(flag,true);
        flag[0]=false;
        flag[1]=false;
        for (int i=2;i<=Math.sqrt(temp);++i) {
            if (flag[i]) {
                for (int j=2;i*j<temp;++j) {
                    flag[i*j]=false;
                }
            }
        }
    }

    static long combination(long n,long r)
    {
        long ans=1;
        for(long i=0;i<r;i++)
        {
            ans=(ans*(n-i))/(i+1);
        }
        return ans;
    }

    // **just change the name of class from Main to reuquired**
    
}

class Demo{
    int s=0,e=0,i=-1;
    public Demo(int s,int e,int i){
        this.s=s;
        this.e=e;
        this.i=i;
    }
}

class sortByS implements Comparator<Demo>{
    public int compare(Demo a,Demo b){
        return a.s-b.s;
    }
}