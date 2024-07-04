
import java.util.*;
import java.io.*;
    public class Solution {
        public static int hasDuplicatesinCol(int[][] a){
            int c = 0;
            //boolean duplicate = false;
            for(int row = 0; row < a.length ; row++){
                for(int col = 1 ; col < a[row].length ; col++){
                    int n = a[row][col];
                    if(n == a[row++][col]){
                        c++;
                    }


                    }

            }
            return c;

        }
        public static int hasDuplicatesinRow(int[][] a){
            int r = 0;
            boolean duplicate = false;
            for(int row = 0; row < a.length ; row++){
                for(int col = 0 ; col < a[row].length ; col++){
                    int n = a[row][col];
                    if(n == a[row][col++]){
                        duplicate = true;
                    }


                }if(duplicate == true)
                    r++;

            }
            return r;

        }

//static boolean noDupes(int[][] array) {
//    for (int i=0; i < array.length; i++) { //row
//        HashSet<Integer> set = new HashSet<Integer>();
//        for (int j=0; j < array.length; j++) {//col
//            if (set.contains(array[j][i])) return false;
//            set.add(array[j][i]);
//        }
//    }
//    return true;
//}


        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.


            int c = 0;

            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int m = in.nextInt();
                int[][]arr = new int[n][n];
                //int m = in.nextInt();
                //populating 2D array
                for(int count = 0; count < arr.length; count++){ //row
                    for(int j = 0; j < arr[count].length; j++){ //col
                        arr[count][j] = in.nextInt();
                    }
                }
                //System.out.println(Arrays.deepToString(arr));

                System.out.println("Case #" + i + ": "+(n + m) + " " +hasDuplicatesinRow(arr) + " "+hasDuplicatesinCol(arr) );
            }
        }
    }

