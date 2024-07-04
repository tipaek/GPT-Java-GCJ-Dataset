import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {

//        Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/vyachs/code/codejam/z3.txt")));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int sliceNum = in.nextInt();
            int customerNum = in.nextInt();

            List<Long> slices = new ArrayList<>();
            for (int i = 0; i < sliceNum; i++) {
                slices.add(in.nextLong());
            }

            int numberOfEquals = getNumberOfEquals(slices);
            String result = "5";
            if (customerNum == 2) {
                result = numberOfEquals >= 2 ? "0" : "1";
            } else if (customerNum == 3) {
                if (numberOfEquals >= 3) {
                    result = "0";
                } else if (numberOfEquals == 2 || oneTwiceHigherThanAnother(slices)) {
                    result = "1";
                } else {
                    result = "2";
                }
            }

            System.out.println(String.format("Case #%s: %s", caseIndex, result));
        }
    }

    private static boolean oneTwiceHigherThanAnother(List<Long> slices) {
        for (int i = 0; i < slices.size() - 1; i++) {
            for (int j = i + 1; j < slices.size(); j++) {
                long a = slices.get(i);
                long b = slices.get(j);
                if (a / b == 2 && a % b == 0) {
                    return true;
                }
                if (b / a == 2 && b % a == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getNumberOfEquals(List<Long> slices) {
        Map<Long, Integer> count = new HashMap<>();
        for (Long slice : slices) {
            if (count.containsKey(slice)) {
                count.put(slice, count.get(slice) + 1);
            } else {
                count.put(slice, 1);
            }
        }
        return count.values().stream().max(Integer::compare).get();
    }

}