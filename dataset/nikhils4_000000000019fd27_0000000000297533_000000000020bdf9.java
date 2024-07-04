import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

class Solution
{

    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 




    public static void main(String[] args) throws IOException
    {
        Reader sc = new Reader();
        int test=sc.nextInt();
        int caseno = 1;
        while(test-->0)
        {
            int n=sc.nextInt();
            int[][] sch=new int[n][2];
            int[][] copyarr=new int[n][2];
            for(int j=0;j<n;j++)
            {
                int start = sc.nextInt();
                int end = sc.nextInt();
                sch[j][0]=start;
                sch[j][1]=end;
                copyarr[j][0]=start;
                copyarr[j][1]=end;
            }
            for(int j=0;j<n-1;j++)
            {
                for(int k=0;k<n-j-1;k++)
                {
                    if(sch[k][0]>sch[k+1][0])
                    {
                        int temp = sch[k][0];
                        sch[k][0] = sch[k+1][0];
                        sch[k+1][0] = temp;
                        temp = sch[k][1];
                        sch[k][1] = sch[k+1][1];
                        sch[k+1][1] = temp;
                    }
                    if(sch[k][0]==sch[k+1][0])
                    {
                        if(sch[k][1]>sch[k+1][1])
                        {
                            int temp = sch[k][1];
                            sch[k][1] = sch[k + 1][1];
                            sch[k + 1][1] = temp;
                        }
                    }
                }
            }
            char[] ch=new char[n];
            int cam=-1;
            int jam=-1;
            int possible=0;
            for(int j=0;j<n;j++)
            {
                int val=-1;
                for(int k=0;k<n;k++)
                {
                    if(sch[j][0]==copyarr[k][0] && sch[j][1]==copyarr[k][1])
                    {
                        copyarr[k][0]=-1;
                        copyarr[k][1]=-1;
                        val=k;
                        break;
                    }
                }
                if(sch[j][0]>=cam)
                {
                    ch[val]='C';
                    cam=sch[j][1];
                }
                else if(sch[j][0]>=jam)
                {
                    ch[val]='J';
                    jam=sch[j][1];
                }
                else
                {
                    possible=1;
                    break;
                }
            }
            String s= new String(ch);
            if(possible==0)
                System.out.println("Case #"+ caseno++ +": "+s);
            else
                System.out.println("Case #"+ caseno++ +": IMPOSSIBLE");
        }
    }
}