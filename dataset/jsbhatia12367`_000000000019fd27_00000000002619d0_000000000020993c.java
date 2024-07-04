import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int ii=0;
         while(T-->0)
            {
                int k=0,r=0,c=0;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] check = new int[n+1];
        for(int i=0;i<n;i++)
        {
            
            Arrays.fill(check,0);
            int flag=0;
           int[] temp = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
           for(int j=0;j<n;j++)
           {
               if(i==j)
               k+=temp[j];
             arr[i][j] = temp[j]; 
             if(check[temp[j]]>0 && flag==0)
             {
                 r++;
                 flag=1;
             }
             else
             {
                check[temp[j]]++; 
             }
           }
           
        }
        
        for(int j=0;j<n;j++)
        {
            Arrays.fill(check,0);
            for(int i=0;i<n;i++)
            {
              if(check[arr[i][j]]>0)
             {
                 c++;
                 break;
             }
             else
             {
                check[arr[i][j]]++; 
             }  
            }
        }
        
        ii++;
        System.out.println("Case #"+ii+": "+k+" "+r+" "+c);
            }
    
	}
}