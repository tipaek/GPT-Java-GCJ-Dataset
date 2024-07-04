import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class Vestigium {

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