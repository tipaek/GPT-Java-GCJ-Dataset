import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().read();
    }

    public void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            testCase(t, br);
        }
        br.close();
    }

    public void testCase(int testNumber, BufferedReader br) throws Exception {
        String[] temp = br.readLine().split(" ");
        int r = Integer.parseInt(temp[0]);
        int s = Integer.parseInt(temp[1]);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < r; j++) {
                list.add(j + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
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

            sb.append(A.size()).append(" ").append(B.size()).append("\n");
            count++;
        }

        print(testNumber, count, sb.toString());
    }

    public void print(int testNumber, int count, String result) {
        System.out.format("Case #%d: %d\n%s", testNumber, count, result);
    }
}