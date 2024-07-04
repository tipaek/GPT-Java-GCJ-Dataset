import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        in.nextLine();
        StringBuilder output = new StringBuilder();
        ArrayList<ArrayList<Integer>> list;
        ArrayList<Integer> subList;
        for (int i = 1; i <= tc; i++) {
            int n = in.nextInt();
            in.nextLine();
            list = new ArrayList<>();
            while (n-- > 0) {
                subList = new ArrayList<>();
                String line = in.nextLine();
                String[] ele = line.split(" ");
                for (int j = 0; j < ele.length; j++) {
                    subList.add(Integer.parseInt(ele[j]));
                }
                list.add(subList);
            }
            if (i == tc) {
                output.append("Case #" + i + ": " + calculateLatinSquare(list));
            } else {
                output.append("Case #" + i + ": " + calculateLatinSquare(list) + "\n");
            }
        }
        System.out.print(output);
    }

    static String calculateLatinSquare(ArrayList<ArrayList<Integer>> list) {
        StringBuilder output = new StringBuilder();
        int size = list.size();
        int xorSum = 0;
        int curSum = 0;
        int trace = 0;
        int r = 0, c = 0;
        for (int i = 1; i <= size; i++) {
            xorSum = xorSum ^ i;
        }
        for (int row = 0; row < list.size(); row++) {
            curSum = list.get(row).get(0) ^ list.get(row).get(1);
            for (int col = 2; col < list.get(0).size(); col++) {
                curSum ^= list.get(row).get(col);
            }
            if (curSum != xorSum) {
                r++;
            }
        }
        trace = list.get(0).get(0) + list.get(1).get(1);
        for (int col = 0; col < list.get(0).size(); col++) {
            curSum = list.get(0).get(col) ^ list.get(1).get(col);
            for (int row = 2; row < list.size(); row++) {
                curSum ^= list.get(row).get(col);
                if (row == col) {
                    trace += list.get(row).get(col);
                }
            }
            if (curSum != xorSum) {
                c++;
            }
        }
        return output.append(trace + " " + r + " " + c).toString();
    }
}
