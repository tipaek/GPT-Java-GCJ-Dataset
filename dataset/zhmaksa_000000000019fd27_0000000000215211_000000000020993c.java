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

            int[] ch = new int[101];
            int cCount = 0;
            int[] rh = new int[101];
            int rCount = 0;

            int sum = 0;
            for(int j= 0; j<s; j++){
                for(int k= 0; k<s; k++){
                    square[j][k] = scanner.nextInt();
                    if(j==k){
                        sum = sum + square[j][k];
                    }
                }
            }

            for(int j= 0; j<s; j++){
                for(int k= 0; k<s; k++){
                    ch[square[j][k]]++;
                    if(ch[square[j][k]]>1){
                        cCount++;
                        break;
                    }
                }
                ch = new int[101];
            }

            for(int j= 0; j<s; j++){
                for(int k= 0; k<s; k++){
                    rh[square[k][j]]++;
                    if(rh[square[k][j]]>1){
                        rCount++;
                        break;
                    }
                }
                rh = new int[101];
            }
            System.out.println("Case #" + (i+1) + ": " + sum + " " + cCount + " " + rCount);
        }
    }
}
