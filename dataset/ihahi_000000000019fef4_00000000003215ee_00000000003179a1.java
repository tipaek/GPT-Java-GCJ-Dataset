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

        Map<Character, Integer> cnts = new HashMap<>();
        for(int i=0;i<10000;i++){
            long Qi = sc.nextLong();
            String R = sc.next();
            Character tk = R.charAt(0);
            cnts.putIfAbsent(tk, 0);
            cnts.put(tk, cnts.get(tk)+1);
            for(Character d:R.toCharArray()) {
                allChars.add(d);
            }
        }
        //System.out.println(cnts);
        Map<Integer, Character> digits = new HashMap<>();
        for(Map.Entry<Character, Integer> e:cnts.entrySet()){
            digits.put(e.getValue(), e.getKey());
        }
        List<Integer> li = new ArrayList<>(digits.keySet());
        Collections.sort(li, Comparator.reverseOrder());
        allChars.removeAll(digits.values());

        System.out.print(getFirst(allChars));
        for(Integer i:li){
            System.out.print(digits.get(i));
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
