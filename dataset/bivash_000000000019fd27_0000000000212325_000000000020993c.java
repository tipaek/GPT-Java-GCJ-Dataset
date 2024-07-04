import java.util.Arrays;
import java.util.Scanner;

class Vestigium
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int a=0; a<t; a++) {
            int n = input.nextInt();
            int nums[][] = new int[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    nums[i][j] = input.nextInt();
                }
                System.out.println();
            }
            System.out.println("Case #"+(a+1)+": "+diagSum(nums)+" "
                    +duplicateRow(nums)+" "+duplicateCol(nums));
        }
    }
    
    public static long diagSum(int[][] arr) {
        long sum=0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
    
    public static int duplicateRow(int[][] arr) {
        int countRow = 0;
        for(int i=0; i<arr.length; i++) {
            int[] list = new int[arr.length];
            for(int j=0; j<arr.length; j++) {
                list[j] = arr[i][j];
            }
            Arrays.sort(list);
            for(int k=0; k<list.length-1;k++) {
                if(list[k]==list[k+1]) {
                    countRow++;
                    break;
                }
            }
        }
        return countRow;
    }
    
    public static int duplicateCol(int[][] arr) {
        int countCol = 0;
        for(int i=0; i<arr.length; i++) {
            int[] list = new int[arr.length];
            for(int j=0; j<arr.length; j++) {
                list[j] = arr[j][i];
            }
            Arrays.sort(list);
            for(int k=0; k<list.length-1;k++) {
                if(list[k]==list[k+1]) {
                    countCol++;
                    break;
                }
            }
        }
        return countCol;
        
    }

}
