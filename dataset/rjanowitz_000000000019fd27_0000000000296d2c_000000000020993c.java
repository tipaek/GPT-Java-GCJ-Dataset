/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Miss Moxi
 */
public class Vestigium {

    /**
     * @param args the command line arguments
     */

    static Queue<Integer> input;
    
    static void Matrix(int N, int x) {
        
        int[][] M = new int[N][N];
        int[] M_rowcheck = new int[N];
        
        int k = 0; //trace
        int r = 0;
        int c = 0;
        
        for (int row = 0; row < N; row++) { //load Matrix M
            for (int col = 0; col < N; col++) {
                M[row][col] = input.remove();
                if (row == col) {
                    k = k + M[row][col];
                }
            }
        }
        
        for (int row = 0; row < N; row++) { //row traversal
            for (int col = 0; col < N; col++) {
                if (M_rowcheck[(M[row][col])-1] < 1) {
                    M_rowcheck[M[row][col]-1]++;
                }
                else {
                    r++;
                    M_rowcheck = new int[N];
                    break;
                }
            }
            M_rowcheck = new int[N];
        }
        
        for (int col = 0; col < N; col++) { //row traversal
            for (int row = 0; row < N; row++) {
                if (M_rowcheck[(M[row][col])-1] < 1) {
                    M_rowcheck[M[row][col]-1]++;
                }
                else {
                    c++;
                    M_rowcheck = new int[N];
                    break;
                }
            }
            M_rowcheck = new int[N];
        }
        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new LinkedList<>(); 
        
        for(String s : args){
            input.add(Integer.parseInt(s));
            //System.out.print(s);
        }
       
        int T = input.remove();
        
        for (int k = 0; k < T; k++) {
            int N = input.remove();
            Matrix(N, k+1);
        }
    }
}


       /* 
    try {
      File myObj = new File("test.txt");
      Scanner myReader = new Scanner(myObj);
      int N = myReader.nextInt();
      int[][] M = new int[N][N];
      System.out.println(N);
      int i = 0;
      for (int j = 0; j < N; j++) {
      while (myReader.hasNextInt() && i < N) {
          M[i][j] = myReader.nextInt();
        //System.out.println(M[i][j]);
        i++;
      }
      i = 0;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();  
    }
    
    System.out.println(M[i][j]);
} */