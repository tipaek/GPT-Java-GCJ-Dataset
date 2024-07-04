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

            HashMap<Pair, String> mp = new HashMap<>();
            Pair[] pairList = new Pair[N];
            List<Pair> pairListC = new ArrayList<Pair>();
            List<Pair> pairListJ = new ArrayList<Pair>();
            for(int j = 0; j < N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                pairList[j] = new Pair(start, end);
            }

            Pair[] pairList2 = pairList.clone();
            // Comparator to sort the pair according to second element
            Arrays.sort(pairList, new Comparator<Pair>() {
                @Override public int compare(Pair p1, Pair p2)
                {
                    return p1.start - p2.start;
                }
            });

            for(int j = 0; j < pairList.length; j++) {
                Pair curr = pairList[j];
                if(inArray(curr, pairListC)) {
                    pairListC.add(curr);
                    mp.put(curr, "C");
                } else if(inArray(curr, pairListJ)) {
                    pairListJ.add(curr);
                    mp.put(curr, "J");
                }
            }

            StringBuilder res = new StringBuilder("");

            for(int j = 0; j < pairList2.length; j++) {
                res.append(mp.getOrDefault(pairList2[j], ""));
            }

            if (res.toString().length() < pairList.length) {
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
