import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for (int a = 0; a < tests; a++) {
            StringBuilder result = new StringBuilder();
            int N = input.nextInt();
            int b = 0;

            List<Integer> C = new ArrayList<>();
            List<Integer> J = new ArrayList<>();
            Set<Integer> cset = new HashSet<>();
            Set<Integer> jset = new HashSet<>();

            while (b < N) {
                int start = input.nextInt();
                int finish = input.nextInt();
                cset.clear();
                cset.addAll(C);
                jset.clear();
                jset.addAll(J);
                List<Integer> array = new ArrayList<>();

                for (int i = start; i < finish; i++) {
                    array.add(i);
                }

                cset.retainAll(array);
                jset.retainAll(array);

                if (cset.isEmpty()) {
                    C.addAll(array);
                    result.append('C');
                } else if (jset.isEmpty()) {
                    J.addAll(array);
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                b++;
            }

            System.out.println("Case #" + (a + 1) + ": " + result);
        }
    }
}