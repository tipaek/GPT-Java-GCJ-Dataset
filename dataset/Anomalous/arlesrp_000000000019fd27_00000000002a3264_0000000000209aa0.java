import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    private static LinkedList<Integer> rotateRight(LinkedList<Integer> list) {
        list.addLast(list.removeFirst());
        return list;
    }

    private static void rotateLeft(LinkedList<Integer> list, int rotations) {
        for (int i = 0; i < rotations; i++) {
            list.addFirst(list.removeLast());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            if (n == 1 && k != 1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                if (k % n == 0) {
                    System.out.println("Case #" + caseNumber + ": POSSIBLE");
                    int targetValue = k / n;
                    for (int i = 0; i < n; i++) {
                        while (list.get(i) != targetValue) {
                            list = rotateRight(list);
                        }
                        StringBuilder result = new StringBuilder();
                        for (Integer num : list) {
                            result.append(num).append(" ");
                        }
                        result.setLength(result.length() - 1); // Remove trailing space
                        System.out.println(result.toString());
                    }
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
            }
        }
    }
}