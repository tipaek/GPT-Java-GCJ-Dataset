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
            int n = in.nextInt();
            int sum = 0;
            int col = 0;
            int row = 0;
            HashSet<Integer> rowSet[] = new HashSet[n];
            HashSet<Integer> colSet[] = new HashSet[n];
            boolean rowVis[] =new boolean[n];
            boolean colVis [] =new boolean[n];

            for (int j = 0; j < n; j++) {
                rowSet[j] = new HashSet<>();
                colSet[j] = new HashSet<>();
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int x = in.nextInt();
                    if (j == k)
                        sum += x;

                    if (rowSet[j].contains(x)&&!rowVis[j]) {
                        row++;
                        rowVis[j] = true;
                    }

                    if (colSet[k].contains(x)&& !colVis[k]) {
                        col++;
                        colVis[k] = true;
                    }

                    rowSet[j].add(x);
                    colSet[k].add(x);
                }
            }

            System.out.println("Case #"+i+": "+ sum +" "+ row+" "+ col);

        }
    }
}
