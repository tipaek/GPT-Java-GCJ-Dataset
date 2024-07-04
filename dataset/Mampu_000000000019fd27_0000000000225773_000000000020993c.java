    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= t; ++i) {
          
          int m = in.nextInt();
          //System.out.println("M "+m);
          int arr[][] = new int[m][m];
          
          for(int j=0;j<m;j++)
          {
            for(int k=0; k<m ; k++)
                arr[j][k] = in.nextInt();
          }
          //System.out.println("Entered"); 
          int trace = 0;
          int count[] = new int[m+1];
          boolean flag;
          int row = 0, col =0;
          for(int j=0;j<m;j++)
          {
            count = new int[m+1];
            flag = true;
            for(int k=0; k<m ; k++)
                {
                    if(j==k)
                        trace+= arr[j][k];
                    if(count[arr[j][k]] != 0 && flag)
                    {
                        row++;
                        flag = false;
                    }
                    else
                    	count[arr[j][k]]++;
                        
                }
                count = new int[m+1];
                flag = true;
                for(int k=0; k< m; k++)
                {
                    if(count[arr[k][j]] != 0 && flag)
                        {
                            col++;
                            flag = false;
                        }
                    count[arr[k][j]]++;
                }
                
          }
          sb.append(trace + " "+ row + " "+col+"\n");
        }
        System.out.print(sb.toString());
      }
    }