import java.util.*;
class Main
{
	public static void main(String[] args) {
		int t,i=0,k=0,count=0,v=0,c=0;
		String r="\0";
		int []st=new int[10],e=new int[10];
		
		Scanner s = new Scanner(System.in);
		t=s.nextInt();
		for(i=0;i<t;i++)
		{
		    int n;
		    n=s.nextInt();
		    for(k=0;k<n;k++)
		    {
		        st[k]=s.nextInt();
		        e[k]=s.nextInt();
		    }
		    
		    for(k=0;k<n;k++)
		    {
		        
		            if(k==0)
		            {
		                r='j'+r;
		                
		                
		            }
		            else if(k>0)
		            {
		                if(st[k]==e[k-1]  || st[k]>e[k-1] || st[k]<e[k])
		                {
		                    r=r+'c';
		                    k++;
		                    
		                }
		                else if(st[k]<e[v])
		                {
		                    c++;
		                    v++;
		                    break;
		                }
		                else if(st[k]==e[k-1]  || st[k]>e[k-1])
		                {
		                    r=r+'j';
		                    k++;
		                }
		                
		            }
		            
		        
		    }
		    if(c==0)
		    {
		    System.out.println("case #"+t+": "+r);
		    }
		    else if(c!=0)
		    {
		        System.out.println("IMPOSSIBLE");
		    }
		}
	}
}
