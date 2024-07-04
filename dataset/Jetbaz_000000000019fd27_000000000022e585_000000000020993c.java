package trails;

public class Vestigium {

	public static void main(String[] args)
	{

		
//		int [][] T1 = { {1,2,3,4},{2,1,4,3},{3,4,1,2},{4,3,2,1}};
		
//		int [][] T1 = { {2,2,2,2},{2,3,2,3},{2,2,2,3},{2,2,2,2}};
		
		int [][] T1 = { {2,1,3},{1,3,2},{1,2,3}};
		
		int col1 = 0;
		int row1 = 0;
		int trace1 = 0;
		int size = 4;
		int test = 1;
		
		for (int i = 0; i < T1.length; ++i)
		{
	        for(int j = 0; j < T1[i].length; ++j)
	        {
	        	
	        	if(i == j)
	        		trace1 += T1[i][j];
	        	
	        	
	        	for(int t = 0; t< T1[i].length-1; t++)
	        	{
	        		if(T1[i][t] == T1[i][t+1])
	        		{
	        			row1++;
	        			break;
	        		}
	        	}
	        	
	        	for(int t = 0; t< T1[i].length-1; t++)
	        	{
	        		if(T1[t][j] == T1[t+1][j]);
	        	}
	        }
		}
		
		System.out.println("Case #"+test+ ":  " + trace1 + "   "+ row1 + "   "+ col1);
		
		
	}
}