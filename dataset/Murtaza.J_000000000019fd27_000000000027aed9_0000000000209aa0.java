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

            ArrayList<ArrayList<String>> validArr = new ArrayList<>();

            int possibilities = (int) factorial(length);
            ArrayList<ArrayList<ArrayList<String>>> possArrayList = new ArrayList<>();

            while (possArrayList.size() < possibilities) {
                Collections.shuffle(arrays);
                ArrayList<ArrayList<String>> clone = new ArrayList<ArrayList<String>>();
                clone.addAll(arrays);
                if (!possArrayList.contains(arrays))
                    possArrayList.add(clone);
            }

            for (int i = 0; i < possibilities; i++) {
                ArrayList<ArrayList<String>> arrayLists = possArrayList.get(i);
                ArrayList<ArrayList<String>> newArrayList = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    newArrayList.add(arrayLists.get(j));
                }

                if (isValid(n, newArrayList, k)) {
                    validArr = newArrayList;
                    break;
                }
            }

            if (!validArr.isEmpty()) {
                System.out.println("Case #" + t + ": " + "POSSIBLE");
                printArr(validArr);
            } else {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }

        }

        scanner.close();
    }

    private static void printArr(ArrayList<ArrayList<String>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
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

    public static boolean isValid(int n, ArrayList<ArrayList<String>> arr, int trace) {

        int rowCount = 0;
        int colCount = 0;
        int _trace = 0;

        for (int j = 0; j < n; j++) {
            boolean added = false;
            for (int k = 0; k < n; k++) {
                if (!added) {
                    for (int l = 0; l < n; l++) {
                        if (l != k && Integer.parseInt(arr.get(j).get(l)) == Integer.parseInt(arr.get(j).get(k))) {
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
                        if (l != k && Integer.parseInt(arr.get(l).get(j)) == Integer.parseInt(arr.get(k).get(j))) {
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
            _trace += Integer.parseInt(arr.get(j).get(j));
        }

        return _trace == trace && (rowCount == 0 && colCount == 0);
    }
}