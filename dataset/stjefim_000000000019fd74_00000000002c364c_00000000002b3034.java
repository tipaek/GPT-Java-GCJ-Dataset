import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;


public class Solution {
    public static BufferedWriter out;

    public static void main(String[] args) throws Exception {
        Scan in = new Scan();
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = in.scanInt();

        for (int t = 0; t < T; t++) {
            int N = in.scanInt();
            int maxLen = 0;
            int maxIndex = 0;
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String str = in.scanString();
                if (str.length() > maxLen) {
                    maxLen = str.length();
                    maxIndex = i;
                }
                strings.add(str);
            }

            String answer = strings.get(maxIndex).substring(1);
            boolean is = true;

            for (int i = 0; i < N; i++) {
                String str = strings.get(i).substring(1);
                if (!answer.contains(str)) {
                    is = false;
                }
            }

            if (is) {
                out.write(String.format("Case #%d: %s\n", t + 1, answer));
            } else {
                out.write(String.format("Case #%d: %s\n", t + 1, "*"));
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
