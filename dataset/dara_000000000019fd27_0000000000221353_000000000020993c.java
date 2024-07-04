import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
	// write your code here
        int t=0; // Number of test cases
        int n=0; // Number of lines in matrix
        String line; // read each matrix line
        String[] splitLine; // Split the line
        int[][] arr=new int[1][1]; // to hold matrix
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t = reader.nextInt(); // Number of test cases
        reader.nextLine();
        String[] ans= new String[t];
        int trace=0; // calculate traces
        int h=0; //horizontal
        int rcount=0; //horizontal count
        int ccount =0; // vertical count

        for(int p=0;p<t;p++){ // iterate through all test cases
            n=reader.nextInt();
            reader.nextLine();
            arr= new int[n][n];
            for(int q=0;q<n;q++){ // Allocate numbers to matrix
                line=reader.nextLine();
                splitLine=line.split(" ");
                for(int r=0;r<n;r++){
                    arr[q][r]=Integer.parseInt(splitLine[r]);
                 }
            }
            rcount=0;
            ccount=0;
            trace=0;
            boolean rcounted=false;
            boolean ccounted=false;
        for(int i=0;i<n;i++) {
            rcounted=false;
            ccounted=false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += arr[i][j];
                }
                for (int k = j + 1; k < n; k++) {
                    if (arr[i][j] == arr[i][k] && rcounted == false) {
                        rcount++;
                        rcounted = true;
                        break;
                    }
                }
                    for (int l = j + 1; l < n; l++) {
                        if (arr[j][i] == arr[l][i] && ccounted == false) {
                            ccount++;
                            ccounted = true;
                            break;
                        }
                    }

            }
        }

            ans[p]="Case #"+(p+1) +":" + trace +" "+rcount + " "+ ccount;
       }
        for(int q=0;q<t;q++){
            System.out.println(ans[q]);
        }

    }


}