import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		int N;
		int matrix[][];
		int count[][];
		int x,k,r,c;
		int i,j;
		
		T = Integer.parseInt(br.readLine());

		for(int t=0;t<T;t++)
		{
			//input
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			count = new int[N][N+1];
			k=0;r=0;c=0;
			for(i=0;i<N;i++)
			{
				String str[] = br.readLine().split(" ");
				for(j=0;j<N;j++)
				{
					matrix[i][j] = Integer.parseInt(str[j]);
					count[i][matrix[i][j]]++;
				}
			}
			
			x=t+1; 

			
			i=0;
			j=0;
			while(i<N && j<N)
			{
				
				k += matrix[i][j];
				i++;
				j++;
			}
			
			int max = Integer.MIN_VALUE;
			
			for(i=0;i<N;i++)
			{
				for(j=0;j<N+1;j++)
				{
					if(max<count[i][j])
					{
						max = count[i][j];
					}
				}
			}
			if(max==1)
			{
				r = max-1;
			}else {
				r = max;
			}
		
			max = Integer.MIN_VALUE;
			for(i=0;i<N+1;i++)
			{
				for(j=0;j<N;j++)
				{
					if(max<count[j][i])
					{
						max = count[j][i];
					}
				}
			}
			if(max==1)
			{
				c = max-1;
			}else {
				c = max;
			}
			
			System.out.println("Case #"+x+": "+ k + " " + r + " " + c);
			
		}	
	}
}
