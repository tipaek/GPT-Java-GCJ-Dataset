import java.util.*;
import java.io.*;

class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>(Collections.singletonList(1)));

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }

    static class Item {
        int val, r, k;

        public Item(int val, int r, int k) {
            this.val = val;
            this.r = r;
            this.k = k;
        }
    }

    public static String Pascal(int sum) {
        int rows = (int) Math.sqrt(sum);
        List<List<Integer>> triangle = generate(rows);
        List<int[]> indices = new ArrayList<>();
        Stack<Item> stack = new Stack<>();
        stack.push(new Item(1, 0, 0));
        compute(sum, indices, triangle, stack);
        return stringify(indices);
    }

    public static String stringify(List<int[]> indices) {
        StringBuilder res = new StringBuilder();
        for (int[] val : indices) {
            res.append(val[0] + 1).append(" ").append(val[1] + 1).append("\n");
        }
        return res.toString();
    }

    static int[] rowOffsets = new int[]{1, 1, -1, -1, 0, 0};
    static int[] colOffsets = new int[]{1, 0, -1, 0, 1, -1};

    public static List<int[]> compute(int target, List<int[]> indices, List<List<Integer>> triangle, Stack<Item> stack) {
        int sum = 0;
        while (!stack.isEmpty() && sum != target) {
            Item item = stack.pop();
            if (target - item.val < sum) continue;
            if (target - item.val == sum) {
                indices.add(new int[]{item.r, item.k});
                continue;
            } else {
                sum += item.val;
                indices.add(new int[]{item.r, item.k});
            }
            for (int i = 0; i < rowOffsets.length; i++) {
                int new_r = rowOffsets[i] + item.r;
                int new_c = colOffsets[i] + item.k;
                if (new_r < 0 || new_r >= triangle.size() || new_c < 0 || new_c >= triangle.get(new_r).size()) continue;
                int value = triangle.get(new_r).get(new_c);
                stack.push(new Item(value, new_r, new_c));
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int sum = in.nextInt();
            System.out.println("Case #" + i + ": " + Pascal(sum));
        }
        in.close();
    }
}