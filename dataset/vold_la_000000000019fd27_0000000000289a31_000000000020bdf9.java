import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Solution
{
    public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() {       
          @Override              
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
    } 
    public static void main(String args[])
    {
      Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t=in.nextInt();
      for (int case_num = 1; case_num <= t; case_num ++){
          int n=in.nextInt();
          int arr[][]= new int[n][3];
          int s[] = new int[n];
          String rs="";
          for(int i=0;i<n;i++)
        {for(int j=0;j<3;j++)
            {
                if(j==2)
                    arr[i][j] = i;
                    else
                arr[i][j] = in.nextInt();
                
        }
        rs=rs+"C";
    }
        sortbyColumn(arr,0); 
        int ctime= arr[0][1],jtime=-1;
        for(int i=1;i<n;i++)
        {
            if(arr[i][0]<ctime)
            {
                if(jtime <= arr[i][0])
                    {jtime = arr[i][1];
                     rs=rs.substring(0,arr[i][2])+ "J" + rs.substring(arr[i][2] + 1);
                    }
                else
                    {rs="IMPOSSIBLE";
                     break;}
            }
            else ctime= arr[i][1];
        }
        System.out.println("Case #"+case_num+": "+rs);
        }}}