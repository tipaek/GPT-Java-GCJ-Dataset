import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by kareem on 3/19/2020.
 */
public class Solution {

    static int n, row, col;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();

        boolean flag = true;
        for (int i = 1; i <= testCases; i++) {
            n = s.nextInt();
            arr = new int[n][n];
            Set<Integer> set = new HashSet<Integer>();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int curr = s.nextInt();
                    arr[r][c] = curr;
                    if (flag) {
                        if (!set.contains(curr)) {
                            set.add(curr);
                        } else {
                            row++;
                            flag = false;
                        }
                    }

                }
                flag = true;
                set.clear();
            }


            testCase(i);
            row =0;
            col = 0;
        }

    }


    static void testCase(int caseNum) {
        int trace = 0;
        for(int i = 0; i < n ; i++){
           trace += arr[i][i];
        }

        Set<Integer> set = new HashSet<Integer>();

        for(int c = 0; c < n ; c++){
            for (int r  = 0 ; r< n; r ++){
               if(set.contains(arr[r][c])){
                   col++;
                   break;
               }else {
                   set.add(arr[r][c]);
               }

            }
            set.clear();
        }

        System.out.println( "Case #"+ caseNum +": "+ trace+" "+ row +" "+ col);
    }

}
