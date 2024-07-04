import java.util.ArrayList;
import java.util.Scanner;

class Vestigium
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        String ans[] = new String[t];
        for(int a=0; a<t; a++) {
            int n = input.nextInt();
            int nums[][] = new int[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    nums[i][j] = input.nextInt();
                }
            }
            ans[a] = "Case #"+(a+1)+": "+diagSum(nums)+" "
                    +duplicateRow(nums)+" "+duplicateCol(nums);
        }
        
        for(String s: ans) {
            System.out.println(s);
        }
    }
    
    public static int diagSum(int[][] arr) {
        int sum=0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
    
    public static int duplicateRow(int[][] arr) {
        int countRow = 0;
        for(int i=0; i<arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<arr.length; j++) {
                if(list.contains(arr[i][j])) {
                    countRow++;
                    break;
                }
                else {
                    list.add(arr[j][i]);
                }
            }
        }
        return countRow;
    }
    
    public static int duplicateCol(int[][] arr) {
        int countCol = 0;
        for(int i=0; i<arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<arr.length; j++) {
                if(list.contains(arr[j][i])) {
                    countCol++;
                    break;
                }
                else {
                    list.add(arr[j][i]);
                }
            }
        }
        return countCol;
    }
}


