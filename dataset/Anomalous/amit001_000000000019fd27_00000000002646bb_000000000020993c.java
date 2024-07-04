import java.util.Scanner;

class Code {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int caseNumber = 1;

            while (t > 0) {
                int n = sc.nextInt();
                int[][] arr = new int[n][n];
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                // Read matrix and calculate trace
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += arr[i][j];
                        }
                    }
                }

                // Check for row repeats
                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!rowSet.add(arr[i][j])) {
                            rowRepeats++;
                            break;
                        }
                    }
                }

                // Check for column repeats
                for (int i = 0; i < n; i++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!colSet.add(arr[j][i])) {
                            colRepeats++;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
                t--;
                caseNumber++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}