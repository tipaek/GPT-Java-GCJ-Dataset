import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static class in   {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) throws FileNotFoundException {
            //reader = new BufferedReader(new FileReader("jacks_candy_shop.txt"));
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
    // for bad input
    static String ReadLn(int maxLg) {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n'))
                    break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0))
            return (null);
        return (new String(lin, 0, lg));
    }
    public static void main(String[] args) throws IOException {
        in.init(System.in);
        int t = in.nextInt();
        for (int i = 1; i <=t ; i++) {
            String x = in.next();
            String ans = "";
            int opened = 0;
            int last = 0;
            for (int j = 0; j < x.length(); j++) {
                int c = x.charAt(j) - '0';
                if(c > last){
                    for (int k = 0; k < c - last; k++) {
                        ans+= "(";
                        opened ++;
                    }

                }else if (c < last){
                    for (int k = 0; k < last - c; k++) {
                        ans+= ")";
                        opened --;
                    }
                }

                ans += c;
                last = c;
            }

            for (int j = 0; j < opened; j++) {
                ans+= ")";
            }

            System.out.println("Case #"+i+": " + ans);

        }
    }
}
