import java.io.*;
import java.util.Scanner;
public class vestigium{

static void printDiagonalSums(int [][]mat, int n)
{
    int DiagonalSum = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
        if (i == j) 
        DiagonalSum += mat[i][j]; 
        }   
    }
    System.out.println("Diagonal Sum:" + DiagonalSum);
}

public static void main(String args[])
{
    int n;
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    int a[][] = new int[n][n]; 
    for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    a[i][j] = in.nextInt();
     
    for (int i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) 
                    System.out.print(a[i][j] + "  "); 
                System.out.println(); 
    }            
    printDiagonalSums(a,n);
}

}