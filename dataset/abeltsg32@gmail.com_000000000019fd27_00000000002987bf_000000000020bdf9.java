import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String schedule(int[][] intervals, int caseNumber) {
        String result = "";
        ArrayList<int[]> Clist = new ArrayList<int[]>();
        ArrayList<int[]> Jlist = new ArrayList<int[]>();
        for (int index = 0; index < intervals.length; index++) {
            if (validate(Clist, intervals[index])) {
                result += 'C';
                Clist.add(intervals[index]);
            } else if (validate(Jlist, intervals[index])) {
                result += 'J';
                Jlist.add(intervals[index]);
            } else {
                return "Case #" + (caseNumber + 1) + ": " + "IMPOSSIBLE";
            }
        }

        return "Case #" + (caseNumber + 1) + ": " + result;
    }

    // validates if the interval belongs to either Jamie or Cameroon
    public static boolean validate(ArrayList<int[]> checkList, int[] list) {
        for (int index = 0; index < checkList.size(); index++) {
            if (list[0] >= checkList.get(index)[0] && list[0] < checkList.get(index)[1]
                    || list[1] > checkList.get(index)[0] && list[1] <= checkList.get(index)[1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTasteCase = scanner.nextInt();
        String result = "";
        int testCaseCounter = 0;
        while (numTasteCase > 0) {
            int size = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] s = new int[size][2];

            for (int i = 0; i < size; i++) {
                String[] sRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < 2; j++) {
                    int sItem = Integer.parseInt(sRowItems[j]);
                    s[i][j] = sItem;
                }
            }
            result = result + schedule(s, testCaseCounter) + "\n";
            numTasteCase--;
            testCaseCounter++;
        }
        System.out.println(result);
    }
}