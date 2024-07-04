import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    static  class Fract implements Comparable<Fract>{
        long x;
        int y;
        String s;
        public Fract(long x, int y){
            int gcd = BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
            this.x = x/gcd;
            this.y = y/gcd;
            this.s = x + "|"+y;
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        public boolean equals(Fract a){
            return s.equals(a.s);
        }
        @Override
        public int compareTo(Fract fract) {
            return Long.compare(this.x*fract.y, fract.x*this.y);
        }
    }
    static class Piece{
        int cost;
        int freq;
        int ind;
        Piece(int cost, int freq, int ind){
            this.cost=cost;
            this.freq = freq;
            this.ind = ind;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            long a[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(a);
            Map<Fract, PriorityQueue<Piece>> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < d; k++) {
                    Fract f = new Fract(a[j], k+1);
                    Piece piece = new Piece(k, k+1, j);
                    PriorityQueue<Piece> queue = map.getOrDefault(f,new PriorityQueue<>(Comparator.comparingInt(p->-p.cost)));
                    queue.add(piece);
                    map.put(f,queue);
                }
            }
            int minCost = d-1;
            for (Map.Entry<Fract, PriorityQueue<Piece>> entry: map.entrySet()) {
                if (minCost==0)
                    break;
                int cost = 0;
                int freq = 0;

                HashSet<Integer> cutPs = new HashSet<>();
                while (!entry.getValue().isEmpty()){

                    if (freq>=d)
                        break;
                    Piece p = entry.getValue().remove();
                    cutPs.add(p.ind);
                    if (freq+p.freq<=d){
                        cost+=p.cost;
                        freq+=p.freq;
                    }else{
                        cost+=d-freq;
                        freq=d;
                        break;
                    }
                }
                if (freq<d){
                    for (int j = 0; j < n&&freq<d; j++) {
                        if (!cutPs.contains(j)){
                            long tmp = (a[j]*entry.getKey().y)/entry.getKey().x;
                            freq+=tmp;
                            cost+=tmp;
                        }
                    }
                }
                if (freq>=d&&minCost>cost)
                    minCost=cost;

            }
            sb.append("Case #").append(i+1).append(": ").append(minCost).append("\n");
        }
        System.out.println(sb);
    }
}
