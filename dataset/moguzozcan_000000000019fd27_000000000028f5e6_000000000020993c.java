import java.util.*;

public class Solution {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = Integer.parseInt(s.nextLine());
        int testCaseNumber = 1;

        List<List<String>> matrix = new ArrayList<>();
        while (T > 0) {
            int rowNumber = 0;
            int k = 0, r = 0, c = 0;
            int N = Integer.parseInt(s.nextLine());
            if (N == 1) {
                int line = Integer.parseInt(s.nextLine());
                System.out.println("Case #" + testCaseNumber + ": " + line + " " + 0 + " " + 0);
            } else {
                while (N > 0) {
                    String line = s.nextLine();
                    String[] numbers = line.split(" ");
                    matrix.add(Arrays.asList(numbers));
                    k += Integer.parseInt(numbers[rowNumber]);
                    rowNumber++;
                    N--;
                }
                for(int i = 0; i < N; i++) {
                    Set<String> rowSet = new HashSet<>(matrix.get(i));
                    if (rowSet.size() != N) {
                        r++;
                    }
                    Set<String> columns = new HashSet<>();
                    for(int j = 0; j < N; j++) {
                        columns.add(matrix.get(j).get(i));
                    }
                    if (columns.size() != N) {
                        c++;
                    }
                }
                System.out.println("Case #" + testCaseNumber + ": " + k + " " + r + " " + c);
            }
            T--;
            testCaseNumber++;
        }
    }
}