 import java.util.Scanner;

 public class Solution  {
 public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        
        int T,N;
        
        T= input.nextInt();
        N = input.nextInt();
        
        int[][] list = new int[N][N];
        
        for(int i = 0;i<list.length;i++)
            for(int j = 0;j<list[0].length;j++)
                list[i][j]=input.nextInt();
        
        // the trace
        int k = 0;
        for(int i = 0;i<list.length;i++)
            k+=list[i][i];
        
        // repeated elments in rows
        int r = 0;
        
        for(int i = 1;i<list.length;i++)
            for(int j = 1;j<list[0].length;j++)
                if(list[j][i] == list[j-1][i-1])
                    r++;
        
        //repeated elemnts in colums
        int c = 0;
        
         for(int i = 1;i<list.length;i++)
            for(int j = 1;j<list[0].length;j++)
                if(list[i][j] == list[i-1][j-1])
                    c++;
        
        
         System.out.println("The sum of the digonal is" +k);
         System.out.println("the number of repeated elements in rows is" +k);
         System.out.println("The number of repeated elements in colums is "+ c);
         
    }
 }
  