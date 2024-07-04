import java.util.*;
import java.io.*;
class Solution{
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            row.add(1);

            for (int j = 0; j < numRows; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
    static class Item{
        int val, r, k;
        public Item(int val , int r, int k){
            this.val = val;
            this.r = r;
            this.k = k;
        }
    }
    public static String Pascal(int sum){
        int rows = (int)Math.sqrt(sum);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle = generate(rows);
        List<int[]> indices = new ArrayList<>();
        Stack<Item> st = new Stack<>();
        st.push(new Item(1, 0, 0));
        compute(sum, indices, triangle, st);
        return Stringify(indices);
    }
    public static String Stringify(List<int[]> indices){
        String res = "";
        for(int[] val: indices){
            res+= val[0]+1;
            res+= " ";
            res+= val[1]+1;
            res+= "\n";
        }
        return res;
    }
    static int[] rows = new int[]{1,1,-1,-1,0, 0};
    static int[] cols = new int[]{1,0,-1,0, 1, -1};
    public static List<int[]> compute(int target, List<int[]> indices, List<List<Integer>> triangle, Stack<Item> st){
        int sum = 0;
        while(!st.isEmpty() && sum!=target){
            Item item = st.pop();
            if(target - item.val < sum) continue;
            if(target - item.val == sum){
                indices.add(new int[]{item.r, item.k});
                continue;
            }
            else{
                sum+= item.val;
                indices.add(new int[]{item.r, item.k});
            }
            for(int i=0;i<rows.length;i++){
                int new_r = rows[i] + item.r;
                int new_c = cols[i] + item.k;
                if(new_r<0|| new_r>=triangle.size()||new_c<0||new_c>=triangle.get(0).size()) continue;
                int value = triangle.get(new_r).get(new_c);
                st.push(new Item(value, new_r, new_c));
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int sum = in.nextInt();
            System.out.println("Case #" + i + ": " + Pascal(sum));
        }

    }
}