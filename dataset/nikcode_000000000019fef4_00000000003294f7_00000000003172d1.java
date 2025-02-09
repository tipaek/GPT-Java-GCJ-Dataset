import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 2/5/2020 AD
 * Time: 12:42
 */
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            List<Double> input = new ArrayList<>();
            Map<Double, Integer> count = new HashMap<>();
            for (int j = 0; j < n; j++) {
                double in = sc.nextDouble();
                input.add(in);
                count.put(in, count.getOrDefault(in, 0) + 1);
            }
            
            int minCut = minCut(n, d, input, count);
            System.out.println("Case #" + i + ": " + minCut);

        }
    }

    public static int minCut(int n, int d, List<Double> input, Map<Double, Integer> count) {
        if (n == 1)
            return d - 1;

        List<Integer> list = count.values().stream().collect(Collectors.toList());
        if (list.contains(d))
            return 0;

        if (d == 2)
            return 1;

        if (d == 3) {
            Collections.sort(list, (p, q) -> q - p);
            if(list.get(0) == 2) {
                double key = 0;
                for (int i = 0; i < input.size() - 1; i++) {
                    if(input.get(i) == input.get(i + 1))
                        key = input.get(i);
                }

                for (int i = 0; i < input.size(); i++) {
                    if(input.get(i) > key)
                        return 1;
                }
            }
            Collections.sort(input);
            for (int i = 0; i < input.size() - 1; i++) {
                for (int j = i + 1; j < input.size(); j++) {
                    if (input.get(j) == 2 * input.get(i))
                        return 1;
                }
            }
        }

        return d - 1;
    }
}
