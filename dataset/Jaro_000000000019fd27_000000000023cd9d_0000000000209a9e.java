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
            byte[] buf = new byte[102]; // line length
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

        void merge(int[][]x, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
          int[][]L = new int[n1][3];
          int[][]R = new int[n2][3];
            for (int i = 0; i < n1; ++i)
               { L[i][0]= x[l + i][0];
                L[i][1]=x[l+i][1];
                L[i][2]=x[l+i][2];   }
            for (int j = 0; j < n2; ++j)
                {R[j][0]= x[m + 1 + j][0];
                R[j][1]=x[m+1+j][1];
                R[j][2]=x[m+1+j][2];
                }
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i][0]<= R[j][0]) {
                    x[k][0]= L[i][0];
                    x[k][1]=L[i][1];
                    x[k][2]=L[i][2];
                    i++;
                } else
                {
                    x[k][0]= R[j][0];
                    x[k][1]=R[j][1];
                    x[k][2]=R[j][2];
                    j++;
                }
                k++;
            }
            while (i < n1)
            {
                x[k][0] = L[i][0];
                x[k][1]=L[i][1];
                x[k][2]=L[i][2];
                i++;
                k++;
            }
            while (j < n2)
            {
                x[k][0]= R[j][0];
                x[k][1]=R[j][1];
                x[k][2]=R[j][2];
                j++;
                k++;
            }
        }
        public void sort(int[] []x, int l, int r)
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
        int a,b,c,d,e,f,g,h,i,j,k;
        String s, t,u,v,w;
        a=in.nextInt();
        c=in.nextInt();
        for(b=1;b<=a;b++)
        {
              int[]z=new int[c];
              System.out.println("1");
              d=in.nextInt();
              f=-1;g=-1;h=i=j=0;
              for(d=0;d<149;d+=2)
              {
                     if(d%10==0&&d>0)
                     {
                            if(f>=0)
                            {
                                   System.out.println(f+1);
                                   e=in.nextInt();
                                   if(z[f]!=e)
                                   {
                                         i=1;
                                   }
                            }
                            else
                            {
                                  System.out.println("1");
                                  e=in.nextInt();
                            }
                            if(g>=0)
                            {
                                    System.out.println(g+1);
                                    e=in.nextInt();
                                    if(z[g]!=e)
                                    {
                                          j=1;
                                    }
                            }
                            else
                            {
                                  System.out.println("1");
                                  e=in.nextInt();
                           }
                           d+=2;
                            if(i==1&&j==1)
                            {
                                  for(k=0;k<h;k++)
                                  {
                                          z[k]=z[k]==1?0:1;
                                          z[c-k-1]=z[c-k-1]==1?0:1;
                                 }
                           }
                           else if(i==1)
                           {
                                 for(k=0;k<h;k++)
                                 {
                                         if(z[k]==z[c-k-1])
                                               z[k]=z[c-k-1]=z[k]==0?1:0;
                                 }
                           }
                           else if(j==1)
                           {
                                 for(k=0;k<h;k++)
                                 {
                                       if(z[k]!=z[c-k-1])
                                       {
                                               z[k]=z[k]==0?1:0;
                                               z[c-k-1]=z[c-k-1]==0?1:0;
                                       }
                                  }
                            }
                     }
                     System.out.println(h+1);
                     z[h]=in.nextInt();
                     System.out.println(c-h);
                     z[c-h-1]=in.nextInt();
                     if(z[h]==z[c-h-1])
                           f=h;
                     else
                           g=h;
                     h++;
                     if(h==c/2)
                           break;
              }
              t="";
              for(d=0;d<c;d++)
              {
                     t+=z[d]==0?"0":"1";
              }
              System.out.println("Case #"+b+": "+t);
              s=in.readLine();
              if(s=="N")
              break;
        }
    }
}