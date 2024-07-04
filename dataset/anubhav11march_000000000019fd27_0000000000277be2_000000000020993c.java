import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for(int k=0; k<n; k++){
            int x = inp.nextInt();
            int[][] a = new int[x][x];
            for(int i=0; i<x; i++){
                for(int j=0; j<x; j++){
                    a[i][j] = inp.nextInt();
                }
            }
            int trace=0, R=0, C=0;
            int[] badR=new int[x+1], badC= new int[x+1];
            for(int i=0; i<x; i++){
                badR = new int[x+1];
                badC = new int[x+1];
                boolean bR=false, bC=false;
                for(int j=0; j<x; j++){
                    if(badR[a[i][j]] == 1 && !bR) {
                        R++;
                        bR = true;
                    }
                    else
                        badR[a[i][j]] = 1;
                    if(badC[a[j][i]] == 1 && !bC) {
                        C++;
                        bC = true;
                    }
                    else
                        badC[a[j][i]] = 1;
                    if(i==j)
                        trace+=a[i][j];
                }
            }
            System.out.println("Case #" + (k+1) +  " " + trace + " " + R + " " + C );
        }
    }
}