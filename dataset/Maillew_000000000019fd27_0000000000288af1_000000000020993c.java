/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;
/**
 *
 * @author billy
*/
class GoogleJam {

    /**
     * @param args the command line arguments
     */
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
   static StringTokenizer st;

   

    public static void main(String[] args) throws IOException {
        int t = readInt();
        
        for (int z =0; z<t; z++){
            int n = readInt();
            int[][] a = new int[n][n];
            for (int i =0; i<n; i++){
                for (int j =0; j<n; j++){
                    a[i][j] = readInt();
                }
            }
            int sum = 0;
            
            for (int i =0; i<n; i++){
                sum+=a[i][i];
            }
            int row = 0;
            int col = 0;
            
            for (int i =0; i<n; i++){//rows
                int[] freq = new int[n+1];
                for (int j =0; j<n; j++){//col, checks each row
                    freq[a[i][j]]++;
                }
                for (int k =0; k<=n; k++){
                    if (freq[k]>1){
                        row++;
                        break;
                    }
                }
            }
            for (int i =0; i<n; i++){//col
                int[] freq = new int[n+1];
                for (int j =0; j<n; j++){//rows, checks each col
                    freq[a[j][i]]++;
                }
                for (int k =0; k<=n; k++){
                    if (freq[k]>1){
                        col++;
                        break;
                    }
                }
            }
          System.out.println ("Case #" + (z+1) + ": " + sum + " " + row + " " + col);  
        }
    }






   static String read () throws IOException {
       while (st == null || !st.hasMoreTokens())
           st = new StringTokenizer(br.readLine().trim());
       return st.nextToken();
   }
   static long readLong () throws IOException {
       return Long.parseLong(read());
   }
   static int readInt () throws IOException {
       return Integer.parseInt(read());
   }
   static double readDouble () throws IOException {
       return Double.parseDouble(read());
   }
   static char readChar () throws IOException {
       return read().charAt(0);
   }
   static String readLine () throws IOException {
       return br.readLine().trim();
   }
    
}
