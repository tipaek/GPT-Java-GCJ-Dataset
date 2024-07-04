import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;


public class Solution {

    public static int[] twos;
    public static BufferedWriter out;
    public static int N;

    public static void main(String[] args) throws Exception {
        Scan in = new Scan();
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = in.scanInt();
        twos = new int[30];
        twos[0] = 1;
        for (int i = 1; i < 30; i++) {
            twos[i] = 2 * twos[i - 1];
        }
        for (int t = 0; t < T; t++) {
            N = in.scanInt();
            out.write(String.format("Case #%d:\n", t + 1));
            int NN = N;
            ArrayList<Integer> take = new ArrayList<>();
            for (int i = 29; i >= 0; i--) {
                if (NN >= twos[i] + i) {
                    take.add(i);
                    NN -= (twos[i] + i);
                    break;
                }
            }

            for (int i = take.get(0) - 1; i >= 0; i--) {
                if (NN >= twos[i] - 1) {
                    take.add(i);
                    NN -= (twos[i] - 1);
                }
            }
            int curentrow = 0;
            boolean start = true;
            for (int i = take.size() - 1; i >= 0; i--) {
                int r = take.get(i) + 1;
                if (curentrow != r - 1) {
                    for (int j = curentrow + 1; j < r; j++) {
                        if (start) {
                            out.write(j + " " + "1" + "\n");
                        } else {
                            out.write(j + " " + j + "\n");
                        }
                    }
                }
                curentrow = r;
                if (start) {
                    for (int c = 1; c <= r; c++) {
                        out.write(r + " " + c + "\n");
                    }
                } else {
                    for (int c = r; c >= 1; c--) {
                        out.write(r + " " + c + "\n");
                    }
                }
                start = !start;
            }

            for (int i = 0; i < NN; i++) {
                if (start) {
                    out.write((curentrow + i + 1) + " " + "1" + "\n");
                } else {
                    out.write((curentrow + i + 1) + " " + (curentrow + i + 1) + "\n");
                }
            }


        }
        out.close();
    }


    static class Scan
    {
        private byte[] buf=new byte[1024];
        private int index;
        private InputStream in;
        private int total;
        public Scan()
        {
            in=System.in;
        }
        public int scan()throws IOException
        {
            if(total<0)
                throw new InputMismatchException();
            if(index>=total)
            {
                index=0;
                total=in.read(buf);
                if(total<=0)
                    return -1;
            }
            return buf[index++];
        }
        public int scanInt()throws IOException
        {
            int integer=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    integer*=10;
                    integer+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }
        public double scanDouble()throws IOException
        {
            double doub=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n)&&n!='.')
            {
                if(n>='0'&&n<='9')
                {
                    doub*=10;
                    doub+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            if(n=='.')
            {
                n=scan();
                double temp=1;
                while(!isWhiteSpace(n))
                {
                    if(n>='0'&&n<='9')
                    {
                        temp/=10;
                        doub+=(n-'0')*temp;
                        n=scan();
                    }
                    else throw new InputMismatchException();
                }
            }
            return doub*neg;
        }
        public String scanString()throws IOException
        {
            StringBuilder sb=new StringBuilder();
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            while(!isWhiteSpace(n))
            {
                sb.append((char)n);
                n=scan();
            }
            return sb.toString();
        }
        private boolean isWhiteSpace(int n)
        {
            if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
                return true;
            return false;
        }
    }
}
