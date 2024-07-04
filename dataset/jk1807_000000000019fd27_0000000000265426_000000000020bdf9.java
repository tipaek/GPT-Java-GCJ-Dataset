import java.util.*;
class Main
{
	public static void main(String[] args) {
		int t,i=0,k=0,count=0,v=0,c=0,n=0;
		String r="\0";
		int []st=new int[10],e=new int[10];
		
		Scanner s = new Scanner(System.in);
		t=s.nextInt();
		for(i=0;i<t;i++)
		{
		    
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
		                r='c'+r;
		            }
		            else if(k==1){
		                r=r+'j';
		            }
		            else if(k>1)
		            {
		                if(st[k]==e[k-1])
		                {
		                    
		                    if(r.charAt(r.length() - 1)  == 'j')
		                    {
		                        r=r+'j';
		                    }
		                    else if(r.charAt(r.length() - 1)  == 'c')
		                    {
		                        r=r+'c';
		                    }
		                }
		                else if(st[k]>e[v] || st[k]>e[k-1])
		                {
		                    r=r+'c';
		                }
		                else if(st[v]<st[k] && st[k]<e[v])
		                {
		                    c++;
		                    break;
		                }else if(st[k]<st[v])
		                {
		                    if(r.charAt(r.length() - 1)  == 'j')
		                    {
		                        r=r+'c';
		                    }
		                    else if(r.charAt(r.length() - 1)  == 'c')
		                    {
		                        r=r+'j';
		                    }
		                    
		                }
		                
		                
		            }
		            
		        
		    }
		    if(c==0)
		    {
		        i++;
		    System.out.println("case #"+i+": "+r);
		    }
		    else if(c!=0)
		    {
		        i++;
		        
		        c=0;
		        r="";
		        System.out.println("case #"+i+": IMPOSSIBLE");
		    }
		    
		    
		    if(i!=n){
		    --i;
		    }
		    
		    r="";
		}
	}
}

