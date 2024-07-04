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
			int roww =obj.countrow(arr,n);
			int trace = obj.tracefind(arr,n);
			int column = obj.columnn(arr,n);
   str[i-1]="Case #"+i+": "+trace+" "+roww+" "+column;
            }
			
			for(String c : str)
			{
				System.out.println(c);
			}
            }
        
  
	
	int countrow(int[][] arr,int n)
	{
		int row = 0;
		int m=1;
		int br = 0;
		for(int i = 0;i<n;i++)
		{
		for(int j=0;j<n-1;j++)
		{ 
	     int key = arr[i][j];
	      br=0;
		for(int k=j+1;k<n;k++)
		{
			if(key==arr[i][k])
			{
				//System.out.println("i="+i+ " j="+j+" k=" + k+" key="+key+" arr[j][k]=" + arr[i][k]);
				row++;
				br=1;
				break;
			}
		}
            if(br!=0)
             break;	
		}
		}
			return row;
		}
		
		
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
		int columnn(int[][] arr, int n)
		{
			int column = 0;
			int br = 0;
		for(int i = 0;i<n;i++)
		{
		for(int j=0;j<n-1;j++)
		{ 
	     int key = arr[j][i];
	      br=0;
		for(int k=j+1;k<n;k++)
		{
			if(key==arr[k][i])
			{
				//System.out.println("i="+i+ " j="+j+" k=" + k+" key="+key+" arr[j][k]=" + arr[i][k]);
				column++;
				br=1;
				break;
			}
		}
            if(br!=0)
             break;	
		}
		}
			return column;
		}
	}
	
	
	
	
	/*str[i]="Case #"+i+": "+trace+" "+roww+" "+column;
            }
			
			for(String c : str)
			{
				System.out.println(c);
			}*/