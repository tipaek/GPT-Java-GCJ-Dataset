import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().processInput();
    }

    public void processInput() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 1; t <= T; t++) {
                handleTestCase(t, br);
            }
        }
    }

    public void handleTestCase(int testNumber, BufferedReader br) throws Exception {
        String[] input = br.readLine().trim().split(" ");
        int r = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= r; j++) {
                list.add(j);
            }
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        while (true) {
            int i = 1;
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();

            A.add(list.get(i - 1));
            while (i < list.size() && list.get(i) >= list.get(i - 1)) {
                A.add(list.get(i));
                i++;
            }

            if (A.isEmpty() || i >= list.size()) break;

            int high = A.get(A.size() - 1);
            while (i < list.size() && list.get(i) < high) {
                B.add(list.get(i));
                i++;
            }

            if (B.isEmpty()) break;

            for (int j = 0; j < B.size(); j++) {
                list.set(j, B.get(j));
            }
            for (int j = 0; j < A.size(); j++) {
                list.set(B.size() + j, A.get(j));
            }

            result.append(A.size()).append(" ").append(B.size()).append("\n");
            count++;
        }

        printResult(testNumber, count, result.toString());
    }

    public void printResult(int testNumber, int count, String result) {
        System.out.format("Case #%d: %d\n%s", testNumber, count, result);
    }
}