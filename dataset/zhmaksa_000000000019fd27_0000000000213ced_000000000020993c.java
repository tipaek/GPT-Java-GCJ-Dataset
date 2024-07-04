import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int line = scanner.nextInt();

        for(int i= 0; i<line; i++){
            int s = scanner.nextInt();
            int[][] square = new int[s][s];

            int[] ch = new int[100];
            int cmax = 0;
            int[] rh = new int[100];
            int rmax = 0;

            int sum = 0;
            for(int j= 0; j<s; j++){
                for(int k= 0; k<s; k++){
                    square[j][k] = scanner.nextInt();
                    ch[square[j][k]]++;
                    if(j==k){
                        sum = sum + square[j][k];
                    }
                }
                int tempMax = getMax(ch);
                if(tempMax > cmax){
                    cmax = tempMax;
                }
                ch = new int[100];
            }

            for(int j= 0; j<s; j++){
                for(int k= 0; k<s; k++){
                    rh[square[k][j]]++;
                }
                int tempMax = getMax(rh);
                if(tempMax > rmax){
                    rmax = tempMax;
                }
                rh = new int[100];
            }
            System.out.println("Case #" + (i+1) + ": " + sum + " " + cmax + " " + rmax);
        }
    }

    public static int getMax (int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        if (max == 1) return 0;
        return max;
    }
}
