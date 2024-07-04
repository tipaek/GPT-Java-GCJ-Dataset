import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    private static LinkedList<Integer> rotate(LinkedList<Integer> list) {
        list.addLast(list.removeFirst());
        return list;
    }

    private static void rotateLeft(LinkedList<Integer> list, int rotations) {
        for (int i = 0; i < rotations; i++) {
            list.addFirst(list.removeLast());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            if (n == 1 && k != 1) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                if (k % n == 0) {
                    System.out.println("Case #" + caseNum + ": POSSIBLE");
                    int val = k / n;
                    for (int r = 0; r < n; r++) {
                        while (list.get(r) != val) {
                            list = rotate(list);
                        }
                        StringBuilder sb = new StringBuilder();
                        for (Integer num : list) {
                            sb.append(num).append(" ");
                        }
                        System.out.println(sb.toString().trim());
                    }
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                }
            }
        }
    }
}