import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*


 */


public class Solution {


    public static void main(String[] args) throws Exception {
        String fileName = "read_v.txt";
        Scanner in = new Scanner(System.in );
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream(fileName));
//        PrintStream o = new PrintStream(new FileOutputStream(fileName + ".out"));
        PrintStream o = new PrintStream(System.out);
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream("resource/gcj2020/qr/read_v.txt"));
        int cases = in.nextInt();
        for (int i = 0; i<cases; i++ ) {
            o.println(solve(in, i));
        }
        in.close();

        o.close();
    }

    private static String solve(Scanner in, int cc) {
        int n =  in.nextInt();
        int d =  in.nextInt();
        long[] a = new long[n];
        Map<Long, Integer> countPerSize = new HashMap<>();
        for (int i = 0; i<n; i++) {
            a[i] = in.nextLong();
            int count = countPerSize.getOrDefault(a[i], 0);
            countPerSize.put(a[i], (count+1));
        }
        long key = findMaxKey(countPerSize);
        int value = countPerSize.get(key);
        if (value >= d ) {
            return "Case #" + (cc+1) +": 0" ;
        }
        Set<Long> biggers = findBiggers(countPerSize, key);
        if (d == 2 ){
            return "Case #" + (cc+1) +": 1";
        }
        if (value ==2  && biggers.size()>0) {
            return "Case #" + (cc+1) +": 1";
        }

        if (biggers.size() > 0) {
            for (Long l : biggers) {
                if (l == 2*key) {
                   return "Case #" + (cc+1) +": " + 1;
                }
            }
        }
        return "Case #" + (cc+1) +": " + 2;
    }

    private static Set<Long> findBiggers(Map<Long, Integer> countPerSize, long key) {
        return countPerSize.keySet().stream().filter(i -> i>key).collect(Collectors.toSet());
    }

    private static long findMaxKey(Map<Long, Integer> countPerSize) {
        long maxKey = -1;
        int max = 0;
        for (Map.Entry<Long, Integer> entry: countPerSize.entrySet() ) {
            if (entry.getValue()> max) {
                max = entry.getValue();
                maxKey = entry.getKey();
            } else {
                if (entry.getValue()== max && maxKey > entry.getKey()) {
                    maxKey = entry.getKey();
                }
            }
        }
        return maxKey;
    }

}
