import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i<t; i++){
            int size = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[size][size];
            for(int j=0; j<size; j++){
                String[] row = sc.nextLine().split(" ");
                for(int k=0; k<size; k++){
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }
            String output = "Case #" + (i+1) + ": ";
            int trace=0, r= 0, c = 0;
            for(int j=0; j<size; j++){
                int tempc = 0, tempr = 0;
                for(int k=0; k<size;k++){
                    if(j == k){
                        trace += matrix[j][k];
                    }
                    if(tempr == 0){
                        for(int l = k+1; l<size; l++){
                            if(matrix[j][k] == matrix[j][l]){
                                tempr++;
                                break;
                            }
                        }
                    }
                    if(tempc == 0){
                        for(int l = k+1; l<size; l++){
                            if(matrix[k][j] == matrix[l][j]){
                                tempc++;
                                break;
                            }
                        }
                    }
                    
                }
                r += tempr;
                c += tempc;
            }
            output += trace + " " + r + " " + c;
            System.out.println(output);
        }
    }
}