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

        Map<Long, Set<Character>> digitMap = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        for(int i=0;i<10000;i++){
            long Qi = sc.nextLong();
            String R = sc.next();
            res.putIfAbsent(Qi, new HashSet<>());
            res.get(Qi).add(R);

            for(Character c:R.toCharArray()){
                allChars.add(c);
            }

            if(getKeta(Qi) == R.length()){
                long tk = topKeta(Qi);
                digitMap.putIfAbsent(tk, new HashSet<>());
                digitMap.get(tk).add(R.charAt(0));
            }
        }
        //System.out.println(digitMap);

        Map<Long, Character> dmap = new HashMap<>();
        for(long i=1;i<=8;i++){
            Set<Character> diff = getDiff(digitMap.get(i+1), digitMap.get(i));
            if(diff.size() == 1){
                dmap.put(i+1, getFirst(diff));
            }
        }
        dmap.put(1L, getFirst(digitMap.get(1L)));
        for(long i=1;i<=9;i++){
            allChars.remove(dmap.get(i));
        }
        dmap.put(0L, getFirst(allChars));

        for(long i=0;i<10;i++){
            System.out.print(dmap.get(i));
        }
        System.out.println();
    }

    private static int getKeta(long a){
        int keta=0;
        while(a>0){
            a/=10;
            keta++;
        }
        return keta;
    }

    private static <T> T getFirst(Set<T> p){
        List<T> rr = new ArrayList<>(p);
        return rr.get(0);
    }

    private static long topKeta(long p){
        int keta = getKeta(p);
        for(int i=0;i<keta-1;i++) {
            p /= 10;
        }
        return p;
    }

    private static <T> Set<T> getDiff(final Set<T> st1,final Set<T> st2){
        Set<T> ret = new HashSet<>(st1);
        ret.removeAll(st2);
        return ret;
    }
}
