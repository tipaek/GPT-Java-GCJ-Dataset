import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []results = new String[cases];
        for (int i = 1; i <= cases; i++) {
            int N = in.nextInt();

            int cFirst = -1;
            int jFirst = -1;
            int cLast = -1;
            int jLast = -1;

            StringBuilder res = new StringBuilder("");

            for(int j = 1; j <= N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if(start >= cLast || end <= cFirst) {
                    cLast = end;
                    cFirst = start;
                    res.append("C");
                } else if(start >= jLast || end <=jFirst) {
                    jLast = end;
                    jFirst = start;
                    res.append("J");
                }
            }

            if (res.length() != N) {
                results[i-1] = "Case #"+i+": IMPOSSIBLE";
            } else {
                results[i-1] = "Case #"+i+": "+ res.toString();
            }
        }
        in.close();
        for (String s: results) {
            System.out.println(s);
        }
    }
}
