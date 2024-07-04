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
        	int jNum = 0;
        	int cNum = 0;
        	int which = 0;
        	for(int j = 0; j < n2; j++)
        	{
        		which = 0;
        		if(arrJ[arr[j][0]] == false && arrJ[arr[j][1]-1] == false && arrC[arr[j][0]] == false && arrC[arr[j][1]-1] == false)
        		{
        			if(jNum >= cNum)
        				which = 1;
        			else 
        				which = 2;
        			//System.out.println(which);
        		}
        		if(arrJ[arr[j][0]] == false && arrJ[arr[j][1]-1] == false && (which == 0 || which == 1))
        		{
        			for(int k = arr[j][0]; k < arr[j][1]; k++)
        			{
        				arrJ[k] = true;
        				jNum++;
        			}
        			str = str + "J";
        			//System.out.println("J");
        		}else if(arrC[arr[j][0]] == false && arrC[arr[j][1]-1] == false && (which == 0 || which == 2))
        		{
        			for(int k = arr[j][0]; k < arr[j][1]; k++)
        			{
        				arrC[k] = true;
        				cNum++;
        			}
        			str = str + "C";
        			//System.out.println("C");
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