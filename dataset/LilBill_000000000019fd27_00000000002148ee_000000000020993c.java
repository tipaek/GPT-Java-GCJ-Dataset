import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();


        for (int index = 0; index < cases ; index++) {
            int columns = sc.nextInt();
            int rows = columns;
            int k = 0, r = 0, c =0;
            int twoD[][] = new int[rows][columns];
            int twoD2[][] = new int[columns][rows];
            int casePrint = 1;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    twoD[i][j] = sc.nextInt();
                    twoD2[j][i] = twoD[i][j];
                    if( i == j){
                        k += twoD[i][i];
                    }
                }
            }

            for (int i2 = 0; i2 < rows ; i2++) {
                if (!unique(twoD[i2])){
                    r++;
                }
                if (!unique(twoD2[i2])){
                    c++;
                }
            }
            int temp = index +1;
            System.out.println("Case #" + temp + ": " + k + " " + " " + r + " " + c);

        }
    }

    public static boolean unique(int[] twoD){
       HashSet<Integer> count = new HashSet<Integer>();
        for (int num: twoD) {
            if (count.contains(num)){
            
                return false;
            } else{
                count.add(num);
            }
        }
        return true;
    }
}