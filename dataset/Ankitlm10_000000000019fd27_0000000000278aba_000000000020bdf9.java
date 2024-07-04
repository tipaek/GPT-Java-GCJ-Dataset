import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {


    static class FastReader {
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

    static class Pair {
        int s;
        int e;
        int index;
        int turn;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tcs = sc.nextInt();
        Random random = new Random();
        for (int p = 0; p < tcs; p++) {
            int n = sc.nextInt();
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Pair pair = new Pair();
                pair.s = sc.nextInt();
                pair.e = sc.nextInt();
                pair.index = i+1;

                list.add(pair);
            }
Collections.sort(list, new Comparator<Pair>() {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.s-o2.s;
    }
});
            int turn  = 0;
            // o for J
            // 1 for C

            int jTurn = -1;
            int cTurn = -1;
            for(Pair pair:list)
            {
               if(pair.s<jTurn && pair.s<cTurn )
               {
                   turn = 5;
                   break;
               }
                if(pair.s>=jTurn)
                {
                    pair.turn = 0;
                    jTurn = pair.e;
                }
                else if(pair.s>=cTurn)
                {
                    pair.turn = 1;
                    cTurn = pair.e;
                }

            }

            if(turn == 5)
            {
                System.out.println("Case #"+(p+1)+": IMPOSSIBLE");
            continue;
            }


            Collections.sort(list, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.index-o2.index;
                }
            });
StringBuilder stringBuilder = new StringBuilder();
for(Pair pair:list)
{
    if(pair.turn==0)
        stringBuilder.append('C');
    else
        stringBuilder.append('J');
}
            System.out.println("Case #"+(p+1)+": "+stringBuilder);








        }

    }
}