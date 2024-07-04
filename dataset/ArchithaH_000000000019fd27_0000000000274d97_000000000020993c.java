import java.util.*;
import java.io.*;
import java.lang.Math;

public class Codejam
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int test_cases = scan.nextInt();
        for(int t=1;t<=test_cases;t++)
        {
            int row=scan.nextInt();
            int[][] arr=new int[row][row];
            int dup_col=0;
            int dup_row=0;
            for(int i=0; i<row; i++)
            {
                for(int j=0; j<row; j++)
                {
                    arr[i][j] = scan.nextInt();
                }
            }  
           for(int i=0; i<row; i++)
                {
                                HashSet<Integer> set_r=new HashSet<>();

                    for(int j=0; j<row; j++)
                    {
                        if(set_r.contains(arr[i][j]))
                        {
                            dup_row++;
                            break;
                        }
                        else
                        {
                            set_r.add(arr[i][j]);
                        }
                    }
                }  
           for(int i=0; i<row; i++)
                {
                                 HashSet<Integer> set_c=new HashSet<>();

                    for(int j=0; j<row; j++)
                    {
                        if(set_c.contains(arr[j][i]))
                        {
                            dup_col++;
                            break;
                        }
                        else
                        {
                            set_c.add(arr[j][i]);
                        }
                    
                    }
                    
                }
           int sum=0;
           for(int i=0;i<row;i++)
           {
               sum+=arr[i][i];
           }
           
           System.out.println("Case #"+t+": "+sum+" "+dup_row+" "+dup_col); 

        }
        
          
         
        
    }
    
}