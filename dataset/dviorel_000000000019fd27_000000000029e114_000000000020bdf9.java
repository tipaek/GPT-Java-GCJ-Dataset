import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++){
            int n = sc.nextInt();
            StringBuilder output = new StringBuilder();
            List<Pair> c = new ArrayList<Pair>();
            List<Pair> j = new ArrayList<Pair>();
            boolean impossible = false;
            for(int i = 0; i < n; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                Pair p = new Pair(s, e);
                if (p.canInsert(c)){
                    c.add(p);
                    output.append("C");
                    continue;
                }
                if (p.canInsert(j)){
                    j.add(p);
                    output.append("J");
                    continue;
                }
                impossible = true;
            }
            if (impossible){
                output = new StringBuilder("IMPOSSIBLE");
            }
            System.out.printf("Case #%d: %s%n", q, output.toString());
        }
    }

    static class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        public boolean canInsert(List<Pair> pairs){
            for(Pair pair: pairs){
                if(!this.notIntersect(this, pair)){
                    return false;
                }
            }
            return true;
        }
        private boolean notIntersect(Pair p1, Pair p2){
            return p1.end <= p2.start || p1.start >= p2.end;
        }
    }

}
