import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> ans = new ArrayList<>();
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        sc.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> inputs = new ArrayList<>();
            List<List<Integer>> unSortedInputs = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String temp = sc.nextLine();
                String[] temp1 = temp.split(" ");
                List<Integer> input = new ArrayList<>();
                for (int k = 0; k < temp1.length; k++) {
                    input.add(Integer.parseInt(temp1[k]));
                }
                inputs.add(input);
                unSortedInputs.add(input);
            }
            List<List<Integer>> sortedList = getSortedList(inputs);
            List<String> tempAns = new ArrayList<>();
            boolean c = true, j = true, isImpossible = false;
            int x = 0, y = 0;
            for (int k = 0; k < sortedList.size(); k++) {
                x=0;
                y=0;
                for (int a = k - 1; a >= 0; a--) {
//                    if (x!=1 || y!=1) {
                    if (tempAns.get(a).equals("C") && x != 1) {
                        if (sortedList.get(k).get(0) >= sortedList.get(a).get(1))
                            c = true;
                        else
                            c = false;
                        x = 1;
                    } else if (tempAns.get(a).equals("J") && y != 1) {
                        if (sortedList.get(k).get(0) >= sortedList.get(a).get(1))
                            j = true;
                        else
                            j = false;
                        y = 1;
                    } else if (x == 1 && y == 1) {
                        break;
                    }
                }
                if (c) {
                    tempAns.add("C");
                } else if (j) {
                    tempAns.add("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }
            if (isImpossible) {
                ans.add("Case #" + i + ": IMPOSSIBLE");
            } else {
                String anss = "";
                for (int k = 0; k < unSortedInputs.size(); k++) {
                    for (int a = 0; a < sortedList.size(); a++) {
                        if (unSortedInputs.get(k).equals(sortedList.get(a))) {
                            anss = anss + tempAns.get(a);
                            break;
                        }
                    }
                }
                ans.add("Case #" + i + ": " + anss);
            }
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }

    private static List<List<Integer>> getSortedList(List<List<Integer>> inputs) {
        for (int i = 0; i < inputs.size() - 1; i++) {
            for (int j = i + 1; j < inputs.size(); j++) {
                if (inputs.get(i).get(0) > inputs.get(j).get(0)) {
                    List<Integer> temp = inputs.get(i);
                    inputs.set(i, inputs.get(j));
                    inputs.set(j, temp);
                }
            }
        }
        return inputs;
    }
}