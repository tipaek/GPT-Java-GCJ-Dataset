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

    static int highestPowerof2(int n) 
    { 
        int p = (int)(Math.log(n)/Math.log(2)); 
        return (int)p;  
    }    

    static boolean booleanHighestPowerof2(int n) 
    { 
        double p = (Math.log(n)/Math.log(2)); 
        double t1=Math.ceil(p);
        double t2=Math.floor(p);
        if (t1==t2) {
            return true;
        }
        return false;
    }    

    public void run()
    {
        InputReader sc = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t=sc.nextInt();
        for (int z=1;z<=t;++z) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            String ans="";
            boolean flag=false,flag2=false,fflag=false;
            // w.println((x%2)+"::"+(y%2));
            if (Math.abs(x%2)==1 && Math.abs(y%2)==1) {
                ans="IMPOSSIBLE";
            }
            else if(Math.abs(x%2)==0 && Math.abs(y%2)==0){
                ans="IMPOSSIBLE";
            }
            else if (x==0) {
                if (y<0) {
                    y=Math.abs(y)+1;
                    flag=booleanHighestPowerof2(y);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        ans="S";
                        ans=ans.repeat(highestPowerof2(y));
                    }                
                }
                else{
                    ++y;
                    flag=booleanHighestPowerof2(y);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        ans="N";
                        ans=ans.repeat(highestPowerof2(y));
                    }
                }           
            }
            else if (y==0) {
                if (x<0) {
                    x=Math.abs(x)+1;
                    flag=booleanHighestPowerof2(x);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        ans="W";
                        ans=ans.repeat(highestPowerof2(x));
                    }                
                }
                else{
                    ++x;
                    flag=booleanHighestPowerof2(x);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        ans="E";
                        ans=ans.repeat(highestPowerof2(x));
                    }
                }      
            }
            else{
                if (x%2==0) {
                    if(x<0){flag=true;x=Math.abs(x);}
                    if(y<0){flag2=true;y=Math.abs(y);}
                    char[] c1=Integer.toBinaryString(x).toCharArray();
                    char[] c2=Integer.toBinaryString(y).toCharArray();
                    char[] c3=new char[Math.max(c1.length,c2.length)+1];
                    for (int i=0;i<Math.min(c1.length,c2.length)-1;++i) {
                        if (c1[i]=='1' && c2[i]=='1') {
                            c3[i+2]='N';
                            if (flag) {c3[i+1]='W';}
                            else{c3[i+1]='E';}
                            c3[i]='S';
                        }
                    }
                    ans=new String(c3);
                }
                else{
                    if(x<0){flag=true;x=Math.abs(x);}
                    if(y<0){flag2=true;y=Math.abs(y);}
                    char[] c1=Integer.toBinaryString(x).toCharArray();
                    char[] c2=Integer.toBinaryString(y).toCharArray();
                    char[] c3=new char[Math.max(c1.length,c2.length)+1];
                    for (int i=0;i<Math.min(c1.length,c2.length)-1;++i) {
                        if (c1[i]=='1' && c2[i]=='1') {
                            c3[i+2]='E';
                            if (flag2) {c3[i+1]='S';}
                            else{c3[i+1]='N';}
                            c3[i]='W';
                        }
                    }
                    ans=new String(c3);
                }
            }
            w.println("Case #"+z+": "+ans);
        }
        System.out.flush();
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