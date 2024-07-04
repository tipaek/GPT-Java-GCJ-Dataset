import java.util.*;
class Vestigium
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
		String[] str = new String[T];
        for(int i=1;i<=T;i++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
			
			
			/////////////////////// reading array input 
            for(int j = 0 ;j<n;j++)
            {
                for(int k = 0;k<n;k++)
                arr[j][k] = sc.nextInt(); 
            }
			Vestigium obj = new Vestigium();
			String roww =obj.countrow(arr,n);
			int trace = obj.tracefind(arr,n);
			//int column = obj.columnn(arr,n);
   str[i-1]="Case #"+i+": "+trace+" "+roww;
            }
			
			for(String c : str)
			{
				System.out.println(c);
			}
            }
        
  
	//////////////////roww
	String countrow(int[][] arr,int n)
	{
		//HashMap<Integer,Integer> row  = new HashMap<Integer,Integer>();
		int row=0; int column=0;
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
		}
		return row+" "+column;
		}
		/////////////////////////////trace
		
		int tracefind(int[][] arr, int n)
		{
			int trace = 0;
			for(int i=0;i<n;i++)
			{
				trace = trace+arr[i][i];
			}
			return trace;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		///////////column
		/*
		int columnn(int[][] arr, int n)
		{
			int column=0;
		for(int i = 0;i<n;i++)
		{
			HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
				for(int j=0;j<n;j++)
				{
					if(hm.containsKey(arr[j][i]))
					hm.put(arr[j][i],hm.get(arr[j][i])+1);
				    else
						hm.put(arr[j][i],1);
				}
				
			if(hm.size()!=n)
				column++;
		}
		return column;
		}
		*/
		}
		

	
	
	
	
	/*str[i]="Case #"+i+": "+trace+" "+roww+" "+column;
            }
			
			for(String c : str)
			{
				System.out.println(c);
			}*/