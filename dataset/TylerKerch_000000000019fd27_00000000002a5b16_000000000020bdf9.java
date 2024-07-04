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
        	String[] ans = new String[n2];
        	
        	int[][] arr = new int[n2][3];
        	for(int j = 0; j < n2; j++)
        	{
        		key.nextLine();
        		arr[j][0] = key.nextInt();
        		arr[j][1] = key.nextInt();
        		arr[j][2] = j;
        	}
        	
        	
        	
        	Arrays.sort(arr,new Comparator<int[]>() {
 	            public int compare(int[] thisOne, int[] other) {
 	                if((thisOne[1]-thisOne[0]) - (other[1]-other[0]) <= 0)
 	                	return 1;
 	                else
 	                	return -1;
 	            }
 	        });
        	boolean[] arrJ = new boolean[1441];
        	boolean[] arrC = new boolean[1441];
        
        	for(int j = 0; j < n2; j++)
        	{
        		//System.out.println(arr[j][0]);
        		if(arrJ[arr[j][0]] == false && arrJ[arr[j][1]-1] == false)
        		{
        			for(int k = arr[j][0]; k < arr[j][1]; k++)
        			{
        				arrJ[k] = true;
        				
        			}
        			ans[arr[j][2]] = "J";
        			//System.out.println("J");
        		}else if(arrC[arr[j][0]] == false && arrC[arr[j][1]-1] == false)
        		{
        			for(int k = arr[j][0]; k < arr[j][1]; k++)
        			{
        				arrC[k] = true;
        				//System.out.println("called");
        			}
        			ans[arr[j][2]] = "C";
        			//System.out.println("C");
        		}else
        		{
        			str = "IMPOSSIBLE";
        			//System.out.println("CALLED");
        			break;
        		}
        		
        	}
        		if(str.equals("IMPOSSIBLE"))
        			System.out.println("Case #" + (i+1) + ": " + str);
        		else
        		{
        			System.out.print("Case #" + (i+1) + ": ");
        			for(int j = 0; j < n2; j++)
        			{
        				System.out.print(ans[j]);
        			}
        			System.out.println();
        		}
            
        }
      
    }

}