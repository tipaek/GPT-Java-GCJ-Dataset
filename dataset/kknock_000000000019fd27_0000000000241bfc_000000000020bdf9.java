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
            List<Pair> pairListC = new ArrayList<Pair>();
            List<Pair> pairListJ = new ArrayList<Pair>();
            String res = new String("");
            for(int j = 1; j <= N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                pairList.add(new Pair(start, end));
            }

            for(int j = 0; j < pairList.size(); j++) {
                Pair curr = pairList.get(j);
                if(inArray(curr, pairListC)) {
                    pairListC.add(curr);
                    res = res.concat("C");
                } else if(inArray(curr, pairListJ)) {
                    pairListJ.add(curr);
                    res = res.concat("J");
                }
            }

            if (res.length() < pairList.size()) {
                results[i-1] = "Case #"+i+": IMPOSSIBLE";
            } else {
                results[i-1] = "Case #"+i+": "+ res;
            }
        }
        in.close();
        for (String s: results) {
            System.out.println(s);
        }
    }

    public static boolean inArray(Pair num, List<Pair> nums) {
        for(Pair n: nums) {
            if(overlaps(n, num)) {
                return false;
            }
        }
        return true;
    }

    public static boolean overlaps(Pair n1, Pair n2) {
        if(n1.start < n2.end && n2.start < n1.end) {
            return true;
        }
        return false;
    }
}
