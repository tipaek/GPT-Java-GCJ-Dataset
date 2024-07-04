import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			String ori = br.readLine().trim();
		    int N=Integer.parseInt(ori);
			int a[][]=new int[N][N],sum=0,cntr=0,cntc=0,cnt=0;
			for(int i=0;i<N;i++)
			{
			    String l=br.readLine().trim();
				String b[]=l.split(" ");
				for(int j=0;j<N;j++)
				{
					
					a[i][j] = Integer.parseInt(b[j]);
				}
			}
			for(int i=0;i<N;i++)
			{
			    cnt=0;
				for(int j=0;j<N;j++)
				{
					if(i==j)
					{
					    sum+=a[i][j];
					}
					for(int k=j+1;k<N;k++)
					{
					    if(a[i][j]==a[i][k])
					    {
					        cnt++;
					    }
					}
				}
				if(cnt>0)
					{
					    cntr++;
					}
			}
			for(int j=0;j<N;j++)
			{
			    cnt=0;
			    for(int i=0;i<N;i++)
			    {
			        for(int k=i+1;k<N;k++)
			        {
			            if(a[i][j]==a[k][j])
			            {
			                cnt++;
			            }
			        }
			    }
			    if(cnt>0)
					{
					    cntc++;
					}
			}
			System.out.println("Case #" + t + ": " + sum + " " + cntr+" "+cntc);
		}
	}
}