import java.io.BufferedInputStream;
import java.util.*;


/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %d";
        for (int cas = 1; cas <= n; cas++) {
            int np = sc.nextInt();
            List<double[]> list = new ArrayList<>();
            int tmp = np;
            while (tmp-- > 0) {
                list.add(new double[]{sc.nextDouble(), sc.nextDouble()});
            }
            Map<Double, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j)[0] == list.get(i)[0]) {
                        if (map.containsKey(Double.MAX_VALUE)) {
                            map.get(Double.MAX_VALUE).add(i);
                            map.get(Double.MAX_VALUE).add(j);
                        } else {
                            Set<Integer> set = new HashSet<>();
                            set.add(i);
                            set.add(j);
                            map.put(Double.MAX_VALUE, set);
                        }
                        continue;
                    }
                    double v = (list.get(j)[1] - list.get(i)[1]) / (list.get(j)[0] - list.get(i)[0]);
//                    v = v * 1000000000) / 1000000000;
                    if (map.containsKey(v)) {
                        map.get(v).add(i);
                        map.get(v).add(j);
                    } else {
                        Set<Integer> set = new HashSet<>();
                        set.add(i);
                        set.add(j);
                        map.put(v, set);
                    }
                }
            }
            int t = 0;
            for (Set<Integer> set : map.values()) {
                t = Math.max(t, set.size());
            }
            if (t % 2 == 0) {
                System.out.println(String.format(result, cas, Math.min(t + 2, np)));
            } else {
                System.out.println(String.format(result, cas, Math.min(t + 1, np)));
            }
        }
    }
}
