import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(scanner.nextLine());
            List<int[]> flist = new ArrayList<>();
            int k = 0, r = 0, c = 0;

            for (int j = 0; j < d; j++) {
                int[] listRow = Arrays.stream(scanner.nextLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
                flist.add(listRow);

                Set<Integer> rowSet = new HashSet<>();
                for (int num : listRow) {
                    if (!rowSet.add(num)) {
                        r++;
                        break;
                    }
                }
            }

            for (int j = 0; j < d; j++) {
                k += flist.get(j)[j];
            }

            for (int j = 0; j < d; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int l = 0; l < d; l++) {
                    if (!colSet.add(flist.get(l)[j])) {
                        c++;
                        break;
                    }
                }
            }

            results.add(new int[]{i + 1, k, r, c});
        }

        for (int[] result : results) {
            System.out.println("Case #" + result[0] + ": " + result[1] + " " + result[2] + " " + result[3]);
        }
    }
}