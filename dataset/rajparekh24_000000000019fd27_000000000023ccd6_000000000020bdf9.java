import java.io.*;
import java.util.*;

public class Solution {

    // Complete the maximumSum function below.
    public static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
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
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
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

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] >=entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }

    // private static final FastReader scanner = new FastReader();


    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader scanner = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        int a=scanner.nextInt();
        for(int i=0;i<a;i++){
            int n=scanner.nextInt();
            int rui[][]=new int[n][2];
            ArrayList<int[][]> ruiindex=new ArrayList<>();
            for(int j=0;j<n;j++){
                int ti=scanner.nextInt();
                int tf=scanner.nextInt();
                rui[j][0]=ti;
                rui[j][1]=tf;
                int[][] x =new int[1][2];
                x[0][0]=ti;
                x[0][1]=tf;
                ruiindex.add(x);
            }
            sortbyColumn(rui,0);
            ArrayList<int[][]> C=new ArrayList<>();
            ArrayList<int[][]> J=new ArrayList<>();
            char[] anser=new char[n];
            int cc=0;
            int jc=0;
            boolean anst=false;
            for(int j=0;j<n;j++){
                int ti=rui[j][0];
                int tf=rui[j][1];
                boolean cf=false;
                boolean jf=false;
                for(int[][] o:C){
                    if(((ti>=o[0][0])&&ti<o[0][1])||((tf>o[0][0])&&tf<=o[0][1]))
                    {
                        cf=true;
                        break;
                    }
                }
                if(!cf){
                            int[][] x=new int[1][2];
                            x[0][0]=ti;
                            x[0][1]=tf;
                            C.add(x);
                            int pos=0;
                            for(int[][] o:ruiindex){
                                if(o[0][0]==ti&&o[0][1]==tf&&anser[pos]!='C')
                                    break;
                                pos++;
                            }
                            //w.println(pos);
                            anser[pos]='C';
                            cc++;
                    }
                else{
                    for(int[][] o:J){
                        if(((ti>=o[0][0])&&ti<o[0][1])||((tf>o[0][0])&&tf<=o[0][1]))
                        {
                            jf=true;
                            break;
                        }
                    }
                    if(!jf){
                        int[][] x=new int[1][2];
                        x[0][0]=ti;
                        x[0][1]=tf;
                        J.add(x);
                        int pos=0;
                        for(int[][] o:ruiindex){
                            if(o[0][0]==ti&&o[0][1]==tf&&anser[pos]!='J')
                                break;
                            pos++;
                        }
                        //w.println(pos);
                        anser[pos]='J';
                        jc++;
                    }
                    else {
                        anst=true;
                    }
                }
            }
            if(anst)
                w.println("Case #"+(i+1)+": IMPOSSIBLE");
            else{
                StringBuilder ans=new StringBuilder("");
                for(int j=0;j<n;j++)
                    ans.append(anser[j]);
                w.println("Case #"+(i+1)+": "+ans);
            }

        }
        w.close();
    }
}