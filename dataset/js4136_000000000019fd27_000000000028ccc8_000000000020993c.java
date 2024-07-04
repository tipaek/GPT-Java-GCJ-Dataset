import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
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
        Reader s=new Reader();
        int t = s.nextInt();
        for(int i=0; i<t; i++){
            int n = s.nextInt();
            int trace =0, row =0, col=0;
            List<Set<Integer>> listSet = new ArrayList<>();
            boolean[] checkCol = new boolean[n];
            for(int m=0; m<n; m++){
                listSet.add(new HashSet<>());
                checkCol[m] = false;
            }

            for(int j=0; j<n;j++){
                Set<Integer> rowSet = new HashSet<>();
                boolean isrow = false, iscol = false;

                for(int k=0; k<n;k++){

                    int val = s.nextInt();

                    if(j ==k){
                        trace+=val;
                    }

                    if(rowSet.contains(val)&&!isrow){
                        row++;
                        isrow = true;
                    } else{
                        rowSet.add(val);
                    }
                    Set<Integer> colSet = listSet.get(k);
                    boolean colStatus = checkCol[k];
                    if(colSet.contains(val) && !colStatus){
                        col++;
                        checkCol[k] = true;


                    }else{
                        colSet.add(val);
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+ row+" "+ col);



        }
    }
}