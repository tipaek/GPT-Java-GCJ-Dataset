
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOFTestCases = Integer.parseInt(in.nextLine());
        for (int caseNumber = 1; caseNumber <= numberOFTestCases; caseNumber++) {
            String[] input = in.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            boolean possible = matrix(n,k,caseNumber);
            if(!possible)
            {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        in.close();
    }


     private static boolean matrix(int n, int k, int caseNumber)
     {
       //  long start = System.currentTimeMillis();
         //row
         Set[] rowSet = new Set[n];
         Set[] columnSet =new Set[n];
         for(int i=0;i<n;i++) {
             rowSet[i] = new HashSet<Integer>(n);
             columnSet[i] = new HashSet<Integer>(n);
         }
         int[][] mat = new int[n][n];
         boolean possible = matrix(mat,n,k,rowSet,columnSet,caseNumber,0,0,0);
      //   System.out.println((System.currentTimeMillis()-start)/60);
         return possible;
     }

    private static boolean matrix( int[][] mat,int n, int k,Set[] rowSet,Set[] columnSet, int caseNumber, int x, int y,int total)
    {
        //base case
        if(x==n)
        {
            if(total == k)
            {
                print(caseNumber,mat);
                return true;
            }
            return false;
        }

        for(int val=1;val<=n;val++)
        {


           if(rowSet[x].contains(val)||columnSet[y].contains(val))
           {
               continue;
           }

           if(x==y){
               if(val+total>k){
                   return false;
               }
               total += val;
           }

           rowSet[x].add(val);
           columnSet[y].add(val);
           mat[x][y]=val;

           if(y+1<n)
           {
               if(matrix(mat,n,k,rowSet,columnSet,caseNumber,x,y+1,total))
               {
                   return true;
               }
           }else
           {
               if(matrix(mat,n,k,rowSet,columnSet,caseNumber,x+1,0,total))
               {
                   return true;
               }
           }

           rowSet[x].remove(val);
           columnSet[y].remove(val);

            if(x==y) {
                total -= val;
            }

        }

        return false;
    }

    private static void print(int caseNumber,int[][] mat )
    {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for(int i=0;i<mat.length;i++) {
            for (int j = 0; j < mat.length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }



}

