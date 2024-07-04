import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class Solution {
    static List<Map.Entry<Long, Long>> walk(long sum) {
        List<Map.Entry<Long, Long>> answer = new ArrayList<>(500);
        long runningSum = 1;
        answer.add(new SimpleEntry<>(1L, 1L));

        long i;
        for (i = 1; runningSum < sum; ++i) {
            if (runningSum + i <= sum) {
                answer.add(new SimpleEntry<>(i + 1, 2L));
                runningSum += i;
            } else {
                break;
            }
        }

        while (runningSum < sum) {
            answer.add(new SimpleEntry<>(i, 1L));
            runningSum += 1;
            --i;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            long sum = scanner.nextLong();
            List<Map.Entry<Long, Long>> result = walk(sum);
            System.out.println(String.format("Case #%d:", i));
            for (Map.Entry<Long, Long> entry : result) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}