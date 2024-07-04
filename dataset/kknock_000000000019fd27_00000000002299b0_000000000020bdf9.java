import java.util.*;

class Solution {

    static class Pair {
        public Integer start;
        public Integer end;
        public Pair(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []results = new String[cases];
        for (int i = 1; i <= cases; i++) {
            int N = in.nextInt();

            List<Pair> pairList = new ArrayList<Pair>();
            String res = new String("");
            for(int j = 1; j <= N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                pairList.add(new Pair(start, end));
            }
            int cFirst = -1;
            int jFirst = -1;
            int cLast = -1;
            int jLast = -1;

            for(int j = 0; j < pairList.size(); j++) {
                Pair curr = pairList.get(j);
                if(curr.start >= cLast || curr.end <= cFirst) {
                    cLast = curr.end;
                    cFirst = curr.start;
                    res = res.concat("C");
                } else if(curr.start >= jLast || curr.end <=jFirst) {
                    jLast = curr.end;
                    jFirst = curr.start;
                    res = res.concat("J");
                }
            }

            if (res.length() < pairList.size()) {
                results[i-1] = "Case #"+i+": IMPOSSIBLE";
            } else {
                results[i-1] = "Case #"+i+": "+ res;
            }
        }
        for (String s: results) {
            System.out.println(s);
        }
        in.close();
    }
}
