import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int testCase = 1;
        while (t-- > 0){
            int n = s.nextInt();
            int[][] nums = new int[n][n];

            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = s.nextInt();
                    if(i == j){
                        sum += nums[i][j];
                    }
                }
            }
            HashSet<Integer> set;
            int rowCount = 0, colCount = 0;
            for (int i = 0; i < n; i++) {
                set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(nums[i][j])){
                        rowCount++;
                        break;
                    }else {
                        set.add(nums[i][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(nums[j][i])){
                        colCount++;
                        break;
                    }else {
                        set.add(nums[j][i]);
                    }
                }
            }

            System.out.println("Case #" + testCase++ + ": " + sum + " " + rowCount + " " + colCount);

        }
    }
}

