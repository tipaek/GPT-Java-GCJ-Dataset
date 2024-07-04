
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class I {
        int start, end;

        public I(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        ArrayList<String> lists=new ArrayList<>();
        for (int j = 1; j <= t; j++) {
            int n = s.nextInt();
            List<I> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int S = s.nextInt();
                int E = s.nextInt();
                list.add(new I(S, E));
            }
            String ans = check(list, n);
            lists.add("case #" + j + ": " + ans);
        }
        for (int i = 0; i <lists.size() ; i++) {
            System.out.println(lists.get(i));
        }
        s.close();
    }

    private static String check(List<I> list, int n) {

        Collections.sort(list, new Comparator<I>() {
            @Override
            public int compare(I i1, I i2) {
                return i1.start - i2.start;
            }
        });
        boolean C = true, J = false;
        String ans = "";
        int c = 0, j = 0;
        for (int i = 0; i < n; i++) {
            int s = list.get(i).start;
            int e = list.get(i).end;
            if (c <= s) {
                c = e;
                ans += 'C';
            } else if (j <= s) {
                j = e;
                ans += 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return ans;

    }
}
