import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
        int T = sc.nextInt();
		String[] strarr = new String[T];
		for(int i=1;i<=T;i++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for(int j = 0 ;j<n;j++)
            {
                for(int k = 0;k<n;k++)
                arr[j][k] = sc.nextInt();
            }
			Solution obj = new Solution();
			String str =obj.Program(arr,n);

  strarr[i-1]="Case #"+i+": "+str;
  
  
            }
			for(String s : strarr)
  {
	  System.out.println(s);
  }

            }
        
  

	String Program(int[][] arr,int n)
	{

		int trace=0,row=0; int column=0;
		for(int i = 0;i<n;i++)
		{HashMap<Integer,Integer> columnn = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
				for(int j=0;j<n;j++)
				{
					if(hm.containsKey(arr[i][j]))
					hm.put(arr[i][j],hm.get(arr[i][j])+1);
				    else
						hm.put(arr[i][j],1);
					
					
					if(columnn.containsKey(arr[j][i]))
					columnn.put(arr[j][i],columnn.get(arr[j][i])+1);
				    else
						columnn.put(arr[j][i],1);
				}
				
			if(hm.size()!=n)
				row++;
			
			if(columnn.size()!=n)
				column++;
			
		trace+=arr[i][i];
		}
		return trace+" "+row+" "+column;
		}
		
	
		}
		
		
		
		
		
		
		
		
		
		
	