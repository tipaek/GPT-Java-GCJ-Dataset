
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static boolean check (int[] array){
        // sort the array in natural or reverse order
        int [] sorted = array.clone();
     Arrays.sort(sorted);

        // prev stores the previous element for current element in the array
        int prev = 0;

        // do for every element in the array
        for (int e : sorted)
        {
            // if two consecutive elements is found to be equal,
            // duplicate is found
            if (e==(prev))
                return true;
            // set current element as previous
            prev = e;
        }

        // no duplicate found
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tt = scan.nextInt();

        for (int t = 0; t <tt ; t++) {
            int size = scan.nextInt();
            int sum=0;
            int rows=0;
            int columns=0;
            int [][] arr = new int[size][size];

            for (int i = 0; i <size ; i++) {
                for (int j = 0; j <size ; j++) {
                    arr[i][j]=scan.nextInt();
                    if(i==j)
                        sum+=arr[i][j];
                }
            }
            for (int i = 0; i <size ; i++) {//rows
                if(check(arr[i]))
                    rows++;
            }
            int[] col = new int[size];
            for (int i = 0 ; i < size ; i++) {
                for (int j = 0 ; j < size; j++) {
                    col[j] = arr[j][i];
                }
                if (check(col))
                    columns++;
            }
            System.out.println("Case #"+(t+1)+": " + sum + " "+ rows +" " + columns);
        }
    }
}
