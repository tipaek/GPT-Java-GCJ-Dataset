import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(scanner.nextLine());

            List<int[]> flist = new ArrayList<>();
            int k = 0;
            int r = 0;
            int c = 0;

            for (int j = 0; j < d; j++) {
                int[] listRow = Arrays.stream(scanner.nextLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

                flist.add(listRow);

                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;
                for (int num : listRow) {
                    if (!rowSet.add(num)) {
                        hasDuplicateInRow = true;
                    }
                }
                if (hasDuplicateInRow) {
                    r++;
                }
            }

            for (int numbers = 0; numbers < flist.size(); numbers++) {
                k += flist.get(numbers)[numbers];
            }

            for (int col = 0; col < d; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInCol = false;
                for (int row = 0; row < d; row++) {
                    int num = flist.get(row)[col];
                    if (!colSet.add(num)) {
                        hasDuplicateInCol = true;
                    }
                }
                if (hasDuplicateInCol) {
                    c++;
                }
            }

            results.add(new int[] { i + 1, k, r, c });
        }

        for (int[] result : results) {
            System.out.printf("Case #%d: %d %d %d%n", result[0], result[1], result[2], result[3]);
        }
    }
}