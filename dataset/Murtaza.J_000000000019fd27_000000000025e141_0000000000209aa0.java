import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            ArrayList<String> list = new ArrayList<>();

            for (Integer i = 0; i < n; i++) {
                list.add(Integer.toString(i + 1));
            }

            ArrayList<ArrayList<String>> arrays = new ArrayList<>();

            int length = (int) factorial(n);

            while (arrays.size() < length) {
                Collections.shuffle(list);
                ArrayList<String> clone = new ArrayList<>(Arrays.asList(list.toArray(new String[1])));
                if (!arrays.contains(list))
                    arrays.add(clone);
            }

            String[][] validArr = new String[n][n];

            Random r = new Random();
            for (int f = 0; f < 1000000; f++) {
                String[][] arr = new String[n][n];
                for (int i = 0; i < n; i++) {
                    int x = r.nextInt(arrays.size());
                    String[] clone = arrays.get(x).toArray(new String[1]).clone();
                    arr[i] = clone;
                }

                if (arr != null && isValid(n, arr, k)) {
                    validArr = arr.clone();
                    break;
                }
            }

            if (validArr[0][0] != null) {
                System.out.println("Case #" + t + ": " + "POSSIBLE");
                printArr(validArr);
            } else {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }

        }

        scanner.close();
    }

    private static void printArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static long factorial(int num) {
        long factorial = 1;
        for (int i = 1; i <= num; ++i) {
            factorial *= i;
        }
        return factorial;
    }

    public static boolean isValid(int n, String[][] arr, int trace) {

        int rowCount = 0;
        int colCount = 0;
        int _trace = 0;

        for (int j = 0; j < n; j++) {
            boolean added = false;
            for (int k = 0; k < n; k++) {
                if (!added) {
                    for (int l = 0; l < n; l++) {
                        if (l != k && Integer.parseInt(arr[j][l]) == Integer.parseInt(arr[j][k])) {
                            rowCount++;
                            added = true;
                            break;
                        }
                    }
                } else
                    break;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean added = false;
            for (int k = 0; k < n; k++) {
                if (!added) {
                    for (int l = 0; l < n; l++) {
                        if (l != k && Integer.parseInt(arr[l][j]) == Integer.parseInt(arr[k][j])) {
                            colCount++;
                            added = true;
                            break;
                        }
                    }
                } else
                    break;
            }
        }

        for (int j = 0; j < n; j++) {
            _trace += Integer.parseInt(arr[j][j]);
        }

        return _trace == trace && (rowCount == 0 && colCount == 0);
    }
}