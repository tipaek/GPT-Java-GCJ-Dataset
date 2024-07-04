import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    static class Pair<L,R> {
        private L l;
        private R r;
        public int index;
        public Pair(L l, R r, int ind){
            this.l = l;
            this.r = r;
            this.index = ind;
        }
        public L getL(){ return l; }
        public R getR(){ return r; }
        public void setL(L l){ this.l = l; }
        public void setR(R r){ this.r = r; }
    }

    public static boolean isPossible(List<Integer> start, List<Integer> end) {
        int total = 0;

        int i=0, j = 0;

        while(i<start.size() && j < end.size()) {

            if(start.get(i) < end.get(j)) {
                total++;
                if(total > 2) {
                    return false;
                }
                i++;
            } else {
                total--;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.valueOf(bufferedReader.readLine());
        for(int i=0; i<tc; i++) {
            int total = Integer.valueOf(bufferedReader.readLine());
            List<Integer> start = new ArrayList<>();
            List<Integer> end = new ArrayList<>();

            List<Pair<Integer, Integer>> pairs = new ArrayList<>();

            for(int j = 0; j<total; j++) {
                String []abc = bufferedReader.readLine().split(" ");
                int a = Integer.valueOf(abc[0]);
                int b = Integer.valueOf(abc[1]);
                start.add(a);
                end.add(b);
                pairs.add(new Pair<Integer, Integer>(a, b, j));
            }

            Collections.sort(start);
            Collections.sort(end);

            boolean isPos = isPossible(start, end);
            if(!isPos) {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            } else {
                Collections.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        return o1.l.compareTo(o2.l);
                    }
                });
                int cs = -1, ce=-1, js = -1, je=-1;
                char []chs = new char[pairs.size()];
                for(Pair<Integer, Integer> p:pairs) {
                    if(p.l >= ce || p.r <= cs) {
                        ce = p.r;
                        cs = p.l;
                        chs[p.index] = 'C';
                    } else {
                        je = p.r;
                        js = p.l;
                        chs[p.index] = 'J';
                    }
                }
                System.out.println("Case #"+(i+1)+": "+new String(chs));
            }
        }
    }

}