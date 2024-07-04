import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {

            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i<n; i++){
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            
            double[][] dir = new double[n][n];
            for (int i = 0; i<n; i++){
                for (int j = 0; j<n; j++){
                    if (i!=j){
                        if (x[i]!=x[j]){
                            dir[i][j] = (1.0*(y[i]-y[j]))/(x[i]-x[j]);
                        }
                        else{
                            if (y[i]>y[j]){
                                dir[i][j] = Math.sqrt(26786);
                            }
                            else{
                                dir[i][j] = -Math.sqrt(25869);
                            }
                        }
                        
                    }
                    else{
                        dir[i][i] = Math.sqrt(5);
                    }
                }
            }
            double eps = 0.000000000001;
            double maxDir;
            int maxNum = 0;
            boolean[] inv = new boolean[n];
            for (int i=0; i<n; i++){
                for (int j= i+1; j<n; j++){
                    double currDir = dir[i][j];
                    for (int k = 0; k<n; k++){
                       inv[k] = false; 
                    }
                    for (int i1 = 0; i1 <n ; i1++){
                        for (int j1 = 0; j1<n; j1++){
                            if (Math.abs(dir[i1][j1] -dir[i][j])<eps){
                                inv[i1] = true;
                                inv[j1] = true;
                            }
                        }
                    }
                    int count = 0;
                    for (int k = 0; k<n; k++){
                        if (inv[k]){
                            count++;
                        }
                    }
                    if (count>maxNum){
                        maxNum = count;
                        maxDir = dir[i][j];
                    }
                    
                }
            }
            int result = (n>(maxNum+2))? (maxNum+2): n;
            

            System.out.println("Case #" + t + ": "+result);
        }
    }

}