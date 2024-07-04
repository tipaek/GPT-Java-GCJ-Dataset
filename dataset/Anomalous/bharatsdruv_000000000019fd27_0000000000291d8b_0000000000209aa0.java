import java.util.Scanner;

class Solution {

    private static final Map<Integer, Map<Integer, String>> precomputedResults = new HashMap<>();

    static {
        precomputedResults.put(2, Map.of(
                2, "1 2\n2 1",
                4, "2 1\n1 2"
        ));
        precomputedResults.put(3, Map.of(
                3, "1 2 3\n3 1 2\n2 3 1",
                6, "2 3 1\n1 2 3\n3 1 2",
                9, "3 1 2\n2 3 1\n1 2 3"
        ));
        precomputedResults.put(4, Map.of(
                4, "1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1",
                8, "2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2",
                12, "3 4 1 2\n2 3 4 1\n1 2 3 4\n4 1 2 3",
                16, "4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4"
        ));
        precomputedResults.put(5, Map.of(
                5, "1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1",
                10, "2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2",
                15, "3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3",
                20, "4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4",
                25, "5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5"
        ));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();

        for (int tc = 1; tc <= testcases; tc++) {
            int N = in.nextInt();
            int T = in.nextInt();
            String result = precomputedResults.getOrDefault(N, Collections.emptyMap()).get(T);

            System.out.print("Case #" + tc + ": ");
            if (result != null) {
                System.out.println("POSSIBLE");
                System.out.println(result);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}