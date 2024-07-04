import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for(int i = 0; i < n; i++){
            int sum = 0;
            int len = Integer.parseInt(s.nextLine());
            int[][] nums = new int[len][len];
            for(int row = 0; row < len; row++){
                String[] str = s.nextLine().split(" ");
                for(int col = 0; col < len; col++){
                    nums[row][col] = Integer.parseInt(str[col]);
                    if(row == col){
                        sum+= nums[row][col];
                    }
                }
            }
            int rowCount = 0;
            int colCount = 0;
            for(int row = 0; row < len; row++){
                if(isRepeat(nums, row)){
                    rowCount++;
                }
                if(isRepeatCol(nums,row)) {
                    colCount++;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + sum + " " + rowCount + " " + colCount);
        }

    }
    public static boolean isRepeat(int[][] nums, int rowNum){
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1 ; j < len; j++) {
                if (nums[rowNum][i] == nums[rowNum][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isRepeatCol(int[][] nums, int colNum) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i][colNum] == nums[j][colNum]) {
                    return true;
                }
            }
        }
        return false;
    }
}