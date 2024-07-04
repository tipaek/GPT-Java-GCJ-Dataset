import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        int i = 0;

        while (i < t ) {

            int n = in.nextInt();

            int [] [] arr = new int[n][n];

            int sum = 0;
            int numRow = 0;
            int numCol = 0;

            for(int j = 0 ; j < n ; ++j) {
                boolean uniqueRow= true;
                for(int k  = 0 ; k < n ; ++k) {
                    int val = in.nextInt();
                    if(j == k) {
                        sum += val;
                    }
                    arr[j][k] = val;

                    if(uniqueRow) {
                        int temp = k-1;
                        while(temp >= 0 && arr[j][temp] != val) {
                            --temp;
                        }
                        if(temp >= 0 && arr[j][temp] == val) {
                            uniqueRow = false;
                            ++numRow;
                        }
                    }
                }
            }

            for(int j = 0 ; j < n ; ++j) {
                boolean uniqueColumn = true;
                for(int k = 0 ; k < n ; ++k) {
                    int val = arr[k][j];
                    if(uniqueColumn) {
                        int temp = k-1;

                        while(temp >= 0 && arr[temp][j] != val) {
                            --temp;
                        }
                        if(temp >= 0 && arr[temp][j] == val) {
                            uniqueColumn = false;
                            ++numCol;
                        }
                    }
                }
            }


            System.out.println("Case #" + (i+1) + ": "+sum+" "+numRow+" "+numCol);


            ++i;
        }

    }

}