import java.io.*; 
import java.util.Scanner;
class Solution { 
    public static void main (String[] args) { 
        int n = 5; 
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
        printPascal(n);
        System.out.println("Case #"+i+":");
        }
    } 

    public static void printPascal(int m) 
    { 
        // An auxiliary array to store generated pascal triangle values 
        int[][] arr = new int[m][m];  
         Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // Iterate through every line and print integer(s) in it 
        for (int line = 0; line < m; line++) 
        { 
            // Every line has number of integers equal to line number 
            for (int i = 0; i <= line; i++) 
            { 
                // First and last values in every row are 1 
                if (line == i || i == 0) 
                    arr[line][i] = 1; 
                else // Other values are sum of values just above and left of above 
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i]; 
            } 
            //System.out.println(""); 
        } 
        int sum=0;
        for (int line = 0; line < m; line++) 
        { 
            // Every line has number of integers equal to line number 
            for (int i = 0; i <= line; i++) 
            { 
                sum=sum+arr[line][i];
                if(sum>n)
                sum=sum-arr[line][i];
                else
                System.out.println((line+1)+" "+(i+1));
            } 
        } 
    }
}