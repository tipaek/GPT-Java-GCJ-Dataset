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
            A[i] = sc.nextLong();
            cnts.putIfAbsent(A[i], 0);
            cnts.put(A[i], cnts.get(A[i])+1);
            cntMax = Math.max(cntMax, cnts.get(A[i]));
            keys.add(A[i]);
        }
        Arrays.sort(A);
        List<Long> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);
        if(cntMax >= D){
            return 0;
        }
        if(D == 2){
            return 1;
        }
        if(cntMax == 2){
            long minKey = 0;
            for(Long k:sortedKeys){
                if(cnts.get(k) == 2){
                    minKey = k;
                    break;
                }
            }
            if(minKey < cnts.lastKey()){
                return 1;
            }
        }
        for(int i=0;i<N;i++){
            if(cnts.containsKey(A[i]*2)){
                return 1;
            }
        }
        return 2;
    }
}
