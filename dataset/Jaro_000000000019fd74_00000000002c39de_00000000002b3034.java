import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.*;
public class Solution
{
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[999999]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
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

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        void merge(int[]x, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
          int[] L = new int[n1];
          int[] R = new int[n2];
            for (int i = 0; i < n1; ++i)
               { L[i] = x[l + i];
                L[i]=x[l+i];}
            for (int j = 0; j < n2; ++j)
                {R[j] = x[m + 1 + j];
                R[j]=x[m+1+j];}
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i]<= R[j]) {
                    x[k]= L[i];
                    x[k]=L[i];
                    i++;
                } else
                {
                    x[k]= R[j];
                    x[k]=R[j];
                    j++;
                }
                k++;
            }
            while (i < n1)
            {
                x[k] = L[i];
                x[k]=L[i];
                i++;
                k++;
            }
            while (j < n2)
            {
                x[k] = R[j];
                x[k]=R[j];
                j++;
                k++;
            }
        }
        public void sort(int[] x, int l, int r)
        {
            if (l < r)
            {
                int m = (l + r) / 2;
                sort(x, l, m);
                sort(x, m + 1, r);
                merge(x, l, m, r);
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        Reader in=new Reader();
        Reader op=new Reader();
        int a,b,c,d,e,f,g,h,i,j,k,l,m,n;
        String s,t,u,v,w;
        a=in.nextInt();
        for(b=1;b<=a;b++)
        {
              c=in.nextInt();
              String[]za=new String[c];
              String[]zb=new String[c];
              String[]zc=new  String[c];
              int[]x=new int[c];
              int[]ya= new int[c];
              int[]yb=new int[c];
              int[]yc=new int[c];
              g=h=0;
              for(d=0;d<c;d++)
               {     
                     za[d]=in.readLine();
                     x[d]=1;
                     ya[d]=za[d].length();
                     yb[d]=za[d].indexOf('*');
                     if(yb[d]>yb[g])
                         g=d;
                     yc[d]=ya[d]-za[d].lastIndexOf('*')-1;
                    if(yc[d]>yc[h])
                          h=d;
                     if(yb[d]>0)
                     zb[d]=za[d].substring(0,yb[d]);
                     if(yc[d]>0)
                     zc[d]=za[d].substring(za[d].lastIndexOf('*')+1);
               }
               f=0;
              for(d=0;d<yb[g];d++)
              {
                    for(e=0;e<c;e++)
                    {
                          if(d<yb[e])
                          {
                                if(zb[e].charAt(d)==zb[g].charAt(d))
                                {}
                                else
                                { f=1;break;  }
                         }
                   }
                   if(f==1)
                       break;
              }
              if(f==0)
              {
                    for(d=1;d<=yc[h];d++)
                    {
                            for(e=0;e<c;e++)
                            {
                                  if(d<=yc[e])
                                  {
                                        if(zc[e].charAt(yc[e]-d)==zc[h].charAt(yc[h]-d))
                                          {}
                                        else
                                        {  f=1;break;
                                      }
                                  }
                            }
                            if(f==1)
                            break;
                      }
              }
              if(f==1)
              t="*";
              else
              {
                if(zb[g]==null)
                zb[g]="";
                if(zb[h]==null)
                zb[h]="";
           
              t=zb[g]+zc[h];
              }
              System.out.println("Case #"+b+": "+t);
        }
    }
}