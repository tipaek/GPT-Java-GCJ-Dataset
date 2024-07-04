import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args){
Scanner in = new Scanner(System.in);
int run = in.nextInt();
for(int m = 0; m<run;m++){
    int n = in.nextInt();
    int [][] sq = new int[n][n];
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n;j++){
            sq[i][j] = in.nextInt();
        }
    }
    int trace = 0;
    for(int i = 0; i<n; i++){
        trace += sq[i][i];
    }
    
    int colcount = 0;
    for(int i = 0; i<n; i++){
        boolean flag = false;
        for(int j = 0; j<n;j++){
            for(int k = 0; k<j;k++){
                if(sq[i][j] == sq[i][k]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                colcount++;
                break;
            }
        }
    }
    
    int rowcount = 0;
    for(int i = 0; i<n; i++){
        boolean flag = false;
        for(int j = 0; j<n;j++){
            for(int k = 0; k<j;k++){
                if(sq[j][i] == sq[k][i]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                rowcount++;
                break;
            }
        }
    }
    System.out.println("Case #" + m + ": "  +trace + " " + colcount + " " + rowcount); 
}

}
}