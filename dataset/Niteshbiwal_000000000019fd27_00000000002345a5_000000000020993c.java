import java.io.*;
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

public static void main(String aegs[])
{
    int n;
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    int a[][] = new int[n][n]; 
    for (i = 0; i < n; i++) 
                for (j = 0; j < n; j++) 
                    a[i][j] = in.nextInt();
     
    for (i = 0; i < n; i++) { 
                for (j = 0; j < n; j++) 
                    System.out.print(a[i][j] + "  "); 
                System.out.println(); 
    }            
    printDiagonalSums(a,n);
}

}