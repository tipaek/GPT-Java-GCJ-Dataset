import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #" + t + ": ");
            System.out.println(solve(sc));
        }
    }
    private static int solve(Scanner sc){
        int N = sc.nextInt();
        int D = sc.nextInt();
        long[] A = new long[N];
        SortedMap<Long, Integer> cnts = new TreeMap<>();
        Set<Long> keys = new HashSet<>();
        int cntMax = 0;
        for(int i=0;i<N;i++){
            A[i] = sc.nextLong() * D;
            cnts.putIfAbsent(A[i], 0);
            cnts.put(A[i], cnts.get(A[i])+1);
            cntMax = Math.max(cntMax, cnts.get(A[i]));
            keys.add(A[i]);
        }
        Arrays.sort(A);
        int globalMin = Integer.MAX_VALUE;
        Map<Double, Long> tanis = new HashMap<>();
        for(int d=1;d<=D;d++){
            for(int num=0;num<A.length;num++){
                long key = num*100+d;
                tanis.put((double)A[num]/(double)d, key);
            }
        }
        List<Double> sortedTanis = new ArrayList<>(tanis.keySet());
        Collections.sort(sortedTanis, Comparator.reverseOrder());
        for(Double t:sortedTanis){
            long key = tanis.get(t);
            long d = key%100;
            long num = (key-d)/100;
            int ans = minCutChoosing((int)num, (int)d, A, D);
            if(ans != Integer.MAX_VALUE){
                globalMin = Math.min( ans, globalMin);
            }

        }
        return globalMin;
    }

    private static int minCutChoosing(final int num, final int d, long[] A, final int D){
        long tani = A[num];
        List<Long> target = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            target.add(A[i]*d);
        }
        return minCnt(tani, target, D);
    }

    private static int minCnt(final long tani, final List<Long> sortedA, int D){
        PriorityQueue<Harvest> pq = new PriorityQueue<>(Comparator.comparingLong(Harvest::getDiff).thenComparing(p->-p.getGetHon()));
        for(Long p:sortedA) {
            Harvest toAdd;
            if(p % tani == 0){
                toAdd = new Harvest(p/tani-1, p/tani);
            }else{
                toAdd = new Harvest(p/tani, p/tani);
            }
            pq.add(toAdd);
        }
        int sum=0;
        int cut = 0;
        Harvest h=null;
        while(sum < D && !pq.isEmpty()){
            h = pq.poll();
            if(sum + h.getGetHon() > D){
                cut += (D-sum);
                sum = D;
            }else {
                sum += h.getGetHon();
                cut += h.cutCnt;
            }
        }
        if(sum < D){
            return Integer.MAX_VALUE;
        }else{
            return cut;
        }
    }

    private static class Harvest{
        long cutCnt;
        long getHon;
        Harvest(long cutCnt, long getHon){
            this.cutCnt = cutCnt;
            this.getHon = getHon;
        }
        public long getDiff(){
            return -(getHon-cutCnt);
        }
        public long getGetHon(){
            return getHon;
        }
        @Override
        public String toString(){
            return cutCnt + "-" + getHon;
        }
    }

}
