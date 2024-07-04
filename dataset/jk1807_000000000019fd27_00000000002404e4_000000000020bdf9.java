import java.util.*;
public class VisibleVerdict
{
	public static void main(String[] args) {
		int t,i=0,k=0,count=0,v=0,c=0;
		//char r= 'a';]
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
		                //System.out.println("case #"+t+": "+r);
		                
		            }
		            else if(k>0)
		            {
		                if(st[k]==e[k-1]  || st[k]>e[k-1])
		                {
		                    r=r+'c';
		                    //System.out.println("case #"+t+": "+r);
		                    
		                }
		                else if(st[k]<e[v])
		                {
		                    c++;
		                    v++;
		                }
		                else if(st[k]==e[k-1]  || st[k]>e[k-1])
		                {
		                    r=r+'j';
		                    //System.out.println("case #"+t+": "+r);
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
