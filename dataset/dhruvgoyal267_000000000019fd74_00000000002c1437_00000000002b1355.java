import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t  = s.nextInt();
		int  r,c,PIL = -1,IL=0,ILC=0,a[][];
		ArrayList<Integer> index;
		int temp = t;
		while(t-->0)
		{
		    index = new ArrayList<Integer>();
		    PIL = -1;
		    IL = ILC = 0;
		    
		    r = s.nextInt();
		    c = s.nextInt();
		    a = new int[r][c];
		    for(int i =0;i<r;i++)
		    {
		        for(int j = 0;j<c;j++)
		        {
		            a[i][j] = s.nextInt();
		        }
		    }
		    
		    while(PIL!=IL)
		    {
		      index.clear();
		    PIL = IL;
		    IL = 0;
		    for(int i =0;i<r;i++)
		    {
		        for(int j =0;j<c;j++)
		        {
		            if(a[i][j] == -1)
		                continue;
		            IL+=a[i][j];
		        }
		    }
		    if(PIL == IL)
		        break;
		     ILC+=IL;
		    for(int i =0;i<r;i++)
		    {
		        for(int j =0;j<c;j++)
		        {
		            if(a[i][j] == -1)
		                continue;
		           int sum =0;
		           int total= 0;
		           int k  = j+1;
		           while(k!=j && k<c)
		           {
		               if(a[i][k] !=-1)
		                 {
		                    sum+=a[i][k];
		                    total++;
		                    break;
		                 }
		               k ++;
		           }
                    k =j-1;
		           while(k!=j && k>-1)
		           {
		               if(a[i][k] !=-1)
		                 {
		                    sum+=a[i][k];
		                    total++;
		                    break;
		                 }
		               k--;
		           }
		           
		            k  = i+1;
		           while(k!=i && k<r)
		           {
		               if(a[k][j] !=-1)
		                 {
		                     sum+=a[k][j];
		                 total++;
		                 break;
		                 }
		              k ++;
		           }
		           
		            k  = i-1;
		           while(k!=i && k>-1)
		           {
		               if(a[k][j] !=-1)
		                 {
		                     sum+=a[k][j];
		                 total++;
		                 break;
		                 }
		              k--;
		           }
		           if(total == 0)
		                continue;
		           if(((float)a[i][j])<((float)sum/(float)(total)))
		            {
		                index.add(i);
		                index.add(j);
		            }
		          }
		    }
		    
		    for(int i=0;i<index.size();i+=2)
		    {
		        a[index.get(i)][index.get(i+1)] = -1;
		    }
		    
		 }
		   
		    System.out.println("Case #"+(temp-t) + ": " +ILC);
		}
	}
}
