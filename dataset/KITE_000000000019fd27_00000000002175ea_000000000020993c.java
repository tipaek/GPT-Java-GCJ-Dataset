import java.util.Scanner;

public class Solution {
private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int len = scanner.nextInt();
        for(int i = 0; i < len ; i++)
        {
            int k = 0 , r = 0 , c = 0;
            int size = scanner.nextInt();
            scanner.nextLine();
            int[][] mat = new int[size][size];
            for(int j = 0; j < size ; j++)
            {

                String[] row = scanner.nextLine().split(" ");
                if(checkDuplicateItemRow(row)) r++;

                for(int l = 0 ; l < size ;l++)
                {
                    if(j == l) k+=Integer.parseInt(row[l]);
                    mat[l][j] = Integer.parseInt(row[l]);
                }
            }
            for(int m = 0; m < size ; m++)
                if(checkDuplicateItemColumn(mat[m])) c++;

    System.out.println("Case #" +(i+1)+ ": " + k +" "+ r+" " +c );

        }


    }

    public  static boolean checkDuplicateItemRow(String[] nums)
    {
        int n = nums.length;
        int count[] = new int[n+1];
        for (int i=0; i < n; i++)
        {
            if(++count[Integer.parseInt(nums[i])]  == 2)
              return  true;

        }
         return  false;

    }

    public  static boolean checkDuplicateItemColumn(int[] nums)
    {
        int n = nums.length;
        int count[] = new int[n+1];
        for (int i=0; i < n; i++)
        {
           if(++count[nums[i]]  == 2)
               return  true;
        }
        return  false;

    }

}