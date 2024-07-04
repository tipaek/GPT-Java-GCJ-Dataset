import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ", 2);
        int amount = Integer.parseInt(info[0]);
        int bits = Integer.parseInt(info[1]);
        for (int i = 0; i < amount; i++) {
            process(bits, scanner);
        }
    }

    private static void process(int bits, Scanner scanner) {
        int[] requestCount = {0};
        int[][] pairs = determinePairs(scanner, bits, requestCount);

        int[] staticPair = pairs[0];
        int[] dynamicPair = pairs[1];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < bits; i++) numbers.add(-1);

        int position = 0;
        while (position < bits / 2) {
            if (requestCount[0] % 10 == 0) {
                adjust(numbers, staticPair, dynamicPair, scanner, requestCount);
            } else {
                numbers.set(position, query(position, scanner));
                if (staticPair != null && dynamicPair != null) {
                    numbers.set(bits - position - 1, query(bits - position - 1, scanner));
                    requestCount[0]++;
                }
                requestCount[0]++;
                position++;
            }
        }

        if (staticPair == null) {
            for (int i = 0; i < bits / 2; i++) {
                numbers.set(bits - i - 1, 1 - numbers.get(i));
            }
        } else if (dynamicPair == null) {
            for (int i = 0; i < bits / 2; i++) {
                numbers.set(bits - i - 1, numbers.get(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int num : numbers) result.append(num);
        System.out.println(result);
        if (scanner.nextLine().equals("N")) System.exit(0);
    }

    private static void adjust(List<Integer> numbers, int[] staticPair, int[] dynamicPair, Scanner scanner, int[] requests) {
        int newStaticValue = -1;
        if (staticPair != null) {
            newStaticValue = query(staticPair[0], scanner);
            requests[0]++;
        }

        int newDynamicValue = -1;
        if (dynamicPair != null) {
            newDynamicValue = query(dynamicPair[0], scanner);
            requests[0]++;
        }

        if ((newStaticValue == -1 && newDynamicValue != dynamicPair[1]) || (newDynamicValue == -1 && newStaticValue != staticPair[1])) {
            flip(numbers);
            if (newStaticValue == -1) {
                dynamicPair[1] = newDynamicValue;
            } else {
                staticPair[1] = newStaticValue;
            }
        }
        if (newStaticValue != staticPair[1]) {
            flip(numbers);
            if (newDynamicValue == dynamicPair[1]) {
                reverse(numbers);
            }
        } else {
            if (newDynamicValue != dynamicPair[1]) {
                reverse(numbers);
            }
        }

        staticPair[1] = newStaticValue;
        dynamicPair[1] = newDynamicValue;
    }

    private static int[][] determinePairs(Scanner scanner, int bits, int[] requests) {
        int[] staticPair = null;
        int[] dynamicPair = null;
        int position = 0;

        while ((staticPair == null || dynamicPair == null) && position < bits / 2) {
            for (int i = 0; i < 10 && (staticPair == null || dynamicPair == null) && position < bits / 2; i++) {
                int firstValue = query(position, scanner);
                int secondValue = query(bits - position - 1, scanner);

                if (firstValue == secondValue) {
                    if (staticPair == null) staticPair = new int[]{position, -1};
                } else {
                    if (dynamicPair == null) dynamicPair = new int[]{position, -1};
                }

                position++;
                requests[0] += 2;
            }
        }

        if (staticPair != null) {
            staticPair[1] = query(staticPair[0], scanner);
            requests[0]++;
        }
        if (dynamicPair != null) {
            dynamicPair[1] = query(dynamicPair[0], scanner);
            requests[0]++;
        }

        return new int[][]{staticPair, dynamicPair};
    }

    private static void reverse(List<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++) {
            list.add(i, list.remove(j));
        }
    }

    private static void flip(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 1 - list.get(i));
        }
    }

    private static int query(int position, Scanner scanner) {
        System.out.println(position + 1);
        return Integer.parseInt(scanner.nextLine());
    }
}