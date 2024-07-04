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
            solve(bits, scanner);
        }
    }

    private static void solve(int bits, Scanner scanner) {
        int[] requestCount = {0};
        int[] staticPair = null;
        int[] dynamicPair = null;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < bits; i++) numbers.add(-1);

        int position = 0;
        while (position < bits / 2) {
            if (requestCount[0] != 0 && requestCount[0] % 10 == 0) {
                updateNumbers(numbers, staticPair, dynamicPair, scanner, requestCount);
            } else {
                int leftValue = query(position, scanner);
                int rightValue = query(bits - position - 1, scanner);

                if (staticPair == null && leftValue == rightValue) {
                    staticPair = new int[] { position, leftValue };
                }

                if (dynamicPair == null && leftValue != rightValue) {
                    dynamicPair = new int[] { position, leftValue };
                }

                numbers.set(position, leftValue);
                numbers.set(bits - position - 1, rightValue);
                requestCount[0] += 2;

                position++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int num : numbers) result.append(num);
        System.out.println(result.toString());

        if (scanner.nextLine().equals("N")) System.exit(0);
    }

    private static void updateNumbers(List<Integer> numbers, int[] staticPair, int[] dynamicPair, Scanner scanner, int[] requestCount) {
        int newStaticValue = -1;
        if (staticPair != null) {
            newStaticValue = query(staticPair[0], scanner);
            requestCount[0]++;
        }

        int newDynamicValue = -1;
        if (dynamicPair != null) {
            newDynamicValue = query(dynamicPair[0], scanner);
            requestCount[0]++;
        }

        if (dynamicPair == null || staticPair == null) {
            requestCount[0]++;
            query(0, scanner);
        }

        if (staticPair == null || newDynamicValue != dynamicPair[1] || newStaticValue != staticPair[1]) {
            invertList(numbers);
            if (staticPair != null) staticPair[1] = newStaticValue;
            if (dynamicPair != null) dynamicPair[1] = newDynamicValue;
            return;
        }

        if (newStaticValue != staticPair[1]) {
            invertList(numbers);
            if (newDynamicValue == dynamicPair[1]) {
                reverseList(numbers);
            }
        } else if (newDynamicValue != dynamicPair[1]) {
            reverseList(numbers);
        }

        if (staticPair != null) staticPair[1] = newStaticValue;
        if (dynamicPair != null) dynamicPair[1] = newDynamicValue;
    }

    private static int query(int position, Scanner scanner) {
        System.out.println(position + 1);
        String response = scanner.nextLine();
        if (response.equals("N")) System.exit(0);
        return Integer.parseInt(response);
    }

    private static void reverseList(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(size - i - 1));
            list.set(size - i - 1, temp);
        }
    }

    private static void invertList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 1 - list.get(i));
        }
    }
}