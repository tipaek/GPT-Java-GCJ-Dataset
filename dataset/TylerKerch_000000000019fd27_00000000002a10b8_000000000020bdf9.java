import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();
       
        for(int i = 0; i < n; i++)
        {
        	key.nextLine();
        	String str = "";
        	int n2 = key.nextInt();
        	
        	boolean onJ = true;
        	int[][] arr = new int[n2][2];
        	for(int j = 0; j < n2; j++)
        	{
        		key.nextLine();
        		arr[j][0] = key.nextInt();
        		arr[j][1] = key.nextInt();
        	}
        	boolean[] arrJ = new boolean[1441];
        	boolean[] arrC = new boolean[1441];
        	
        	for(int j = 0; j < n2; j++)
        	{
        		if(arrJ[arr[j][0]] == false && arrJ[arr[j][1]] == false)
        		{
        			for(int k = arr[j][0]; k < arr[j][1]; k++)
        			{
        				arrJ[k] = true;
        			}
        			str = str + "J";
        		}else if(arrC[arr[j][0]] == false && arrC[arr[j][1]] == false)
        		{
        			for(int k = arr[j][0]; k < arr[j][1]; k++)
        			{
        				arrC[k] = true;
        			}
        			str = str + "C";
        		}else
        		{
        			str = "IMPOSSIBLE";
        			break;
        		}
        		
        	}
           
            	System.out.println("Case #" + (i+1) + ": " + str);
            
        }
      
    }

}