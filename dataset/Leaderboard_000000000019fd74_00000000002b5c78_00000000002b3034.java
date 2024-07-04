import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
    public static void main(String[] args) {
        FastReader keyboard = new FastReader();
        int T = keyboard.nextInt();
        for (int i = 0; i < T; i++) {
            int N = keyboard.nextInt();
            ArrayList<String> strings = new ArrayList<>();
            System.out.print("Case #" + (i + 1) + ": ");
            int max_len = 0;
            int max_ind = 0;
            for (int j = 0; j <N; j++) {
                strings.add(keyboard.nextLine());
                if (strings.get(strings.size() - 1).length() > max_len)
                    max_ind = j;
                max_len = Math.max(strings.get(strings.size() - 1).length(), max_len);
            }
            // backward scan
            LinkedList<Character> str = new LinkedList<>();
            int check = 1;
            for (int j = 0; j < max_len; j++)
            {
                if (check == 0)
                    break;
                for (int k = 0; k < N - 1; k++)
                {
                    // valid?
                    if (j < strings.get(k).length() - 1 && j < strings.get(k + 1).length() - 1)
                    {
                        // check!
                        if (strings.get(k).charAt(strings.get(k).length() - j - 1) != strings.get(k + 1).charAt(strings.get(k + 1).length() - j - 1))
                        {
                            // no way!
                            check = 0;
                            break;
                        }
                    }
                }
          //      str.add(str.size() - 1, strings.get(0).charAt(strings.get(0).length() - j - 1));
            }
            if (check == 0 || str.size() > 10000)
            {
                System.out.println("*");
            }
            else
            {
                StringBuilder res = new StringBuilder(strings.get(max_ind));
                res.deleteCharAt(0);
                System.out.println(res.toString());
            }
        }
    }
}
