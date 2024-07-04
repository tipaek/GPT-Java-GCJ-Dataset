import java.util.*;
import java.io.*;

public class Solution {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nbTest = sc.nextInt();
        for(int i = 0; i < nbTest; i++){
            int trace = 0;
            int col = 0;
            int row = 0;
            int nbCase = sc.nextInt();
            int valLigne = 0;
            for (int ta = 1; ta < nbCase; ta++){
                valLigne+=ta;
            }
            int tmp2 = 0;
            int[][] tab = new int[nbCase][nbCase];
            for (int j = 0; j < nbCase; j++){
                for (int k = 0; k < nbCase; k++){
                    int tmp = sc.nextInt();
                    if (j== k){
                        trace+= tmp;
                    }
                    tab[j][k] = tmp;
                    tmp2+=tmp;
                }
                if (tmp2 != valLigne){
                    row++;
                }
                tmp2 = 0;
            }

            int tmp3 =0;
            for(int a = 0; a < nbCase; a++){
                for (int b = 0; b < nbCase; b++){
                    tmp3+=tab[b][a];
                }
                if (tmp3 != valLigne){
                    col++;
                }
                tmp3 =0;
            }
            System.out.print("Case #" + (i+1) + ": " + trace + " " + row + " " + col);
        }
    }
}
