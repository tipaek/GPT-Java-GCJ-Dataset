import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int j = 0;
            List<int[]> list = new ArrayList<>(n);
            while (j < n) {
                int array[] = {in.nextInt(), in.nextInt()};
                list.add(array);
                j++;
            }

            String result = findSolution(list);
            System.out.println(String.format("Case #%d: %s", i, result));
        }
    }

    private static String findSolution(List<int[]> list) {
        int size = list.size();
        char charArray[] = new char[list.size()];
        List<Integer> indexList = new ArrayList<>(list.size());
        for (int i = 0; i <size ; i++) {
            indexList.add(i);
        }
        Collections.sort(indexList, (o1, o2) -> {
            int[] i1 = list.get(o1);
            int[] i2 = list.get(o2);
            int r = i1[0] - i2[0];
            return r == 0 ? i1[1] - i2[1] : r;
        });


        int preX = indexList.get(0);
        int preY = -1;
        char current = 'J';
        charArray[preX] = current;

        for (int i = 1; i < size; i++) {
            int index = indexList.get(i);
            int[] interval = list.get(index);
            if (current == 'J') {
                if (preX == -1 || list.get(preX)[1] <= interval[0]) {
                    preX = index;
                } else {
                    if (preY == -1 || list.get(preY)[1] <= interval[0]) {
                        preY = index;
                        current = 'C';
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            } else {
                if (preY == -1 || list.get(preY)[1] <= interval[0]) {
                    preY = index;
                } else {
                    if (preX == -1 || list.get(preX)[1] <= interval[0]) {
                        preX = index;
                        current = 'J';
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
            charArray[index] = current;
        }
        return new String(charArray);
    }
}
