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
            char[] str = new char[100];
            int check = 1;
            for (String s:strings)
            {
                for (int j = 0; j < s.length(); j++)
                {
                    if (str[99 - j] == '\0' || str[99 - j] == '*')
                    {
                        // replace
                        str[99 - j] = s.charAt(s.length() - 1 - j);
                    }
                    // check equality
                    else if (str[99 - j] != s.charAt(s.length() - 1 - j) && s.charAt(s.length() - 1 - j) != '*')
                    {
                        // fail
                        check = 0;
                        break;
                    }
                }
            }
            if (check == 0 || max_len > 10001)
            {
                System.out.println("*");
            }
            else
            {
                // print
                for (Character c:str)
                {
                    if (c == '*')
                        System.out.print("A");
                    else if (c != '\0')
                        System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}
