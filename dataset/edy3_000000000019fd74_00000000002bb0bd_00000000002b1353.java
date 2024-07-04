import java.util.*;
import java.util.AbstractMap.*;

class Solution {
    static List<Map.Entry<Long, Long>> walk(long sum) {
        List<Map.Entry<Long, Long>> anwer = new ArrayList<>(500);

        int runningSum = 1;
        anwer.add(new SimpleEntry<>(1L, 1L));

        long i;
        for (i = 1; ; ++i) {
            if (runningSum == sum) {
                break;
            }
            if (runningSum + i <= sum) {
                anwer.add(new SimpleEntry<>((i + 1), 2L));
                runningSum += i;
            } else {
                break;
            }
        }

        while (runningSum < sum) {
            anwer.add(new SimpleEntry<>(i, 1L));
            runningSum += 1;
            --i;
        }


        return anwer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            long sum = in.nextLong();
            List<Map.Entry<Long, Long>> result = walk(sum);
            System.out.println(String.format("Case #%d: ", i));
            for (int j = 0; j < result.size(); ++j) {
                System.out.println(result.get(j).getKey() + " " + result.get(j).getValue());
            }
        }
    }
}