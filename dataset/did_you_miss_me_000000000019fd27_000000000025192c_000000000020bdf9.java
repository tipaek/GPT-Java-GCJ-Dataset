import java.io.*;
import java.util.*;
import java.lang.*;


class Solution implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
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

    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();
        int temp2 = t;

        while (t-- != 0) {

            int n = in.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for (int i = 0; i < s.length; i++){
                s[i] = in.nextInt();
                e[i] = in.nextInt();
            }

            //sorting according to starting time
            TreeMap<Integer,Integer> timeValues = new TreeMap<>();
            for (int i = 0; i < s.length; i++){
                timeValues.put(s[i],e[i]);
            }

            //w.println(timeValues);

            // get the values and keys in sorted order int array values
            Set<Integer> keysset = timeValues.keySet();
            int[] values = new int[n];
            int j = 0;
            for (int i : keysset){

                values[j] = timeValues.get(i);
                j++;
            }
            int[] keys = new int[n];
            j = 0;
            for (int i : keysset){

                keys[j] = i;
                j++;
            }
            int[] startTime = Arrays.copyOf(keys,keys.length);
            int[] endTime = Arrays.copyOf(values,values.length);

//            for (int i = 0; i < values.length; i++){
//                w.println(values[i]);
//            }

            //impossible case
            String ans = "";
            for (int i = 2; i < startTime.length; i++){
                if (startTime[i] < endTime[i-1] && startTime[i] < endTime[i-2]){
                    ans = "IMPOSSIBLE";
                }
            }


            if (!ans.equals("IMPOSSIBLE")){

                HashMap<Integer,String> hashMap = new HashMap<>();
                ans = "J";

                hashMap.put(startTime[0],"J");

                for (int i = 1; i < startTime.length; i++){
                    if (startTime[i] < endTime[i-1]){
                        if (ans.endsWith("J")){
                            ans = ans.concat("C");
                            hashMap.put(startTime[i],"C");
                        }
                        else {
                            ans = ans.concat("J");
                            hashMap.put(startTime[i],"J");
                        }
                    }
                    else {
                        ans = ans.concat(ans.substring(ans.length()-1));
                        hashMap.put(startTime[i],ans.substring(ans.length()-1));
                    }
                }

//                w.println(hashMap);
                ans = hashMap.get(s[0]);
                for (int i = 1; i < s.length; i++){
                    ans = ans.concat(hashMap.get(s[i]));
                }

            }
            int caseNo = temp2 - t;
            w.println("Case #"+caseNo+": " + ans );
        }

        w.flush();
        w.close();
    }


}