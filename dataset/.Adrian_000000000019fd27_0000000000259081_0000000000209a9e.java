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

    private static void solve(int b, Scanner scanner) {
        int[] requests = {0};


        int[][] pairs = getPairs(scanner, b, requests);

        int[] staticPair = pairs[0];
        int[] dynamicPair = pairs[1];

        List<Integer> numbers = new ArrayList<>();
        int position = 0;
        for (int i = 0; i < b; i++) numbers.add(-1);

        while (position != b / 2) {
            if (requests[0] % 10 == 0) {
                update(numbers, staticPair, dynamicPair, scanner, requests);
            } else {
                numbers.set(position, get(position, scanner));
                if (staticPair != null && dynamicPair != null) {
                    numbers.set(b - position - 1, get(b - position - 1, scanner));
                    requests[0] += 1;
                }
                requests[0] += 1;

                position++;
            }
        }

        if (staticPair == null) {
            for (int i = 0; i < b / 2; i++) {
                numbers.set(b - i - 1, 1 - numbers.get(i));
            }
        } else if (dynamicPair == null) {
            for (int i = 0; i < b / 2; i++) {
                numbers.set(b - i - 1, numbers.get(i));
            }
        }

        String result = "";
        for (int i : numbers) result += i;
        System.out.println(result);
        if(scanner.nextLine().equals("N")) System.exit(0);
    }

    private static void update(List<Integer> numbers, int[] staticPair, int[] dynamicPair, Scanner scanner, int[] requests) {
        int staticNew = -1;
        if (staticPair != null) {
            staticNew = get(staticPair[0], scanner);
            requests[0] += 1;
        }

        int dynamicNew = -1;
        if (dynamicPair != null) {
            dynamicNew = get(dynamicPair[0], scanner);
            requests[0] += 1;
        }

        if ((staticNew == -1 && dynamicNew != dynamicPair[1]) || (dynamicNew == -1 && staticNew != staticPair[1])) {
            invert(numbers);
            if (staticNew == -1) {
                dynamicPair[1] = dynamicNew;
            } else {
                staticPair[1] = staticNew;
            }
        }
        if (staticNew != staticPair[1]) {
            invert(numbers);
            if (dynamicNew == dynamicPair[1]) {
                reverse(numbers);
            }
        } else {
            if (dynamicNew != dynamicPair[1]) {
                reverse(numbers);
            }
        }

        staticPair[1] = staticNew;
        dynamicPair[1] = dynamicNew;
    }

    private static int[][] getPairs(Scanner scanner, int b, int[] requests) {
        int[] staticPair = null;
        int[] dynamicPair = null;

        int position = 0;
        while ((staticPair == null || dynamicPair == null) && position < b / 2) {
            for (int i = 0; i < 10 && (staticPair == null || dynamicPair == null) && position < b / 2; i++) {
                int v0 = get(position, scanner);
                int v1 = get(b - position - 1, scanner);

                if (v0 == v1) {
                    if (staticPair == null) staticPair = new int[]{position, -1};
                } else {
                    if (dynamicPair == null) dynamicPair = new int[]{position, -1};
                }

                position++;
                requests[0] += 2;
            }
        }

        if (staticPair != null) {
            staticPair[1] = get(staticPair[0], scanner);
            requests[0] += 1;
        }
        if (dynamicPair != null) {
            dynamicPair[1] = get(dynamicPair[0], scanner);
            requests[0] += 1;
        }

        return new int[][]{
                staticPair,
                dynamicPair
        };
    }

    private static void reverse(List<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++) {
            list.add(i, list.remove(j));
        }
    }

    private static void invert(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 1 - list.get(i));
        }
    }

    private static int get(int position, Scanner scanner) {
        System.out.println(position + 1);
        int result = Integer.parseInt(scanner.nextLine());
        return result;
    }
}
