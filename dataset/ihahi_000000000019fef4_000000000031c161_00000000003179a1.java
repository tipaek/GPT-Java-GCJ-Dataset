import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #" + t + ": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        long U = sc.nextLong();
        Map<Long, Set<String>> res = new HashMap<>();
        for(int i=0;i<10000;i++){
            long Qi = sc.nextLong();
            String R = sc.next();
            res.putIfAbsent(Qi, new HashSet<>());
            res.get(Qi).add(R);
        }
        Map<Long, String> dmap = new HashMap<>();
        for(long i=1;i<=10;i++){
            Set<String> diff = getDiff(res.get(i+1), res.get(i));
            if(diff.size() == 1){
                String a = new ArrayList<>(diff).get(0);
                dmap.put(i+1, a);
            }
        }
        dmap.put(0L, dmap.get(10L).substring(1));
        dmap.put(1L, dmap.get(10L).substring(0,1));
        for(long i=0;i<10;i++){
            System.out.print(dmap.get(i));
        }
        System.out.println();
    }
    private static Set<String> getDiff(final Set<String> st1,final Set<String> st2){
        Set<String> ret = new HashSet<>(st1);
        ret.removeAll(st2);
        return ret;
    }
}
