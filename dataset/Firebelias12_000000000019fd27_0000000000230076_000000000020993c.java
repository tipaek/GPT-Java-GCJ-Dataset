import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in);
        int cases = myObj.nextInt();

        for(int i = 0;i < cases; i++){

            int n = myObj.nextInt();

            int[][] square = new int[n][n];

            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    square[j][k] = myObj.nextInt();
                }
            }

            int trace = 0;
            int repeatR = 0;
            int repeatC = 0;

            for(int z = 0; z < n; z++){
                trace += square[z][z];
            }

            for(int z = 0; z < n; z++){
                boolean flagR = false;
                for( int l = 0; l < n; l++){
                    int value = square[z][l];
                    for(int m = l+1; m < n; m++){
                        if(square[z][m] == value){
                                repeatR++;
                                flagR = true;
                                break;
                        }
                    }
                    if(flagR)
                        break;
                }
            }

            for(int z = 0; z < n; z++){
                boolean flagC = false;
                for( int l = 0; l < n; l++){
                    int value = square[l][z];
                    for(int m = l+1; m < n; m++){
                        if(square[m][z] == value){
                            repeatC++;
                            flagC = true;
                            break;
                        }
                    }
                    if(flagC)
                        break;
                }
            }

            System.out.println("Case #" + (i+1) +": " + trace + " " + repeatR + " " + repeatC);

        }

    }

}
