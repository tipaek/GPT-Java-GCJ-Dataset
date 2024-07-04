import java.util.*;

public class Solution {

    public static void sortByColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(entry -> entry[col]));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        ArrayList<Integer[][]> testCases = new ArrayList<>();
        s.nextLine();

        for (int number = 0; number < testCase; number++) {
            int al = Integer.parseInt(s.nextLine());
            if (al != 0) {
                Integer[][] array = new Integer[al][2];
                for (int row = 0; row < array.length; row++) {
                    String rowInput = s.hasNextLine() ? s.nextLine() : "";
                    String[] values = rowInput.split(" ");
                    for (int col = 0; col < array[row].length; col++) {
                        array[row][col] = !values[col].isEmpty() ? Integer.parseInt(values[col]) : 0;
                    }
                }
                testCases.add(array);
            }
        }

        s.close();

        for (int val = 0; val < testCases.size(); val++) {
            Integer[][] array = testCases.get(val);
            int num = array.length;
            int[] nums = new int[num];
            String[] result = new String[num];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = array[i][0];
            }

            sortByColumn(array, 0);

            String[] code = new String[num];
            code[0] = "C";
            int compare = array[0][1];

            for (int row = 1; row < array.length; row++) {
                if (array[row][0] >= compare) {
                    code[row] = "C";
                    compare = array[row][1];
                }
            }

            int start = 0;
            for (int i = 0; i < code.length; i++) {
                if (code[i] == null) {
                    start = i;
                    break;
                }
            }

            compare = array[start][0];
            for (int row = start; row < array.length; row++) {
                if (array[row][0] >= compare && code[row] == null) {
                    code[row] = "J";
                    compare = array[row][1];
                }
            }

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (array[i][0].equals(nums[j])) {
                        result[i] = code[j];
                    }
                }
            }

            boolean isImpossible = Arrays.stream(result).anyMatch(Objects::isNull);
            boolean isCJ = array.length == 2 && array[0][0].equals(array[1][0]) && array[0][1].equals(array[1][1]);

            StringBuilder output = new StringBuilder("Case #").append(val + 1).append(": ");
            if (isImpossible) {
                output.append("IMPOSSIBLE");
            } else if (isCJ) {
                output.append("CJ");
            } else {
                for (String res : result) {
                    output.append(res);
                }
            }
            System.out.println(output.toString());
        }
    }
}