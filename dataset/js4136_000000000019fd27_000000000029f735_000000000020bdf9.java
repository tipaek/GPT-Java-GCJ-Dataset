import java.io.*;
import java.util.*;

public class Solution
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class  Data{
        int start;
        int end ;
        int index;

        public Data(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();

            Data[] students = new Data[n];

            for (int j = 0; j < n; j++) {
                Data data = new Data(s.nextInt(), s.nextInt(), j);
                students[j] = data;
            }

            Arrays.sort(students, new Comparator<Data>() {
                @Override
                public int compare(Data first, Data second) {
                    return first.start - second.start;
                }
            });


            int endC = 0, endJ = 0;
            boolean invalid = false;
            char out[] = new char[n];
            for (int j = 0; j < n; j++) {
                Data data = students[j];
                if (data.start >= endC) {
                    endC = data.end;
                    out[data.index] = 'C';
                } else if (data.start >= endJ) {
                    endJ = data.end;
                    out[data.index] = 'J';
                } else {
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + new String(out));
            }
        }
    }
}