import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
public class Solution
{
	public static void main (String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int l=0;l<t;l++)
		{
		    int n=scan.nextInt();
		    int st[]=new int[n];
		    int et[]=new int[n];
		    HashMap<Integer,Integer> map1=new HashMap<>();
		    HashMap<Integer,Integer> map2=new HashMap<>();
		    for(int i=0;i<n;i++)
		    {
		        st[i]=scan.nextInt();
		        et[i]=scan.nextInt();
		        map1.put(et[i],st[i]);
		    }
		    
		    Arrays.sort(st);
		    Arrays.sort(et);
		    for(int i=0;i<n;i++)
		    {
		        map2.put(st[i],i);
		    }
		    int i=0,j=0;
		    String ans="";
		    int kitne_used=0;
		    char free='C';
		    boolean flag=true;
		    while(i<n)
		    {
		        if(st[i]<et[j] && kitne_used>=2)
		        {
		            System.out.println("Case #"+(l+1)+": "+"IMPOSSIBLE");
		            flag=false;
		            break;
		        }
		        else if(st[i]<et[j] && kitne_used<2)
		        {
		            //System.out.println("Came1");
		            if(free=='C')
		            {
		                ans+='C';
		                free='J';
		            }
		            else 
		            {
		                ans+='J';
		                free='C';
		            }
		            i++;
		            kitne_used+=1;
		        }
		        else if(st[i]>et[j])
		        {
		            //System.out.println("Came2");
		            free=ans.charAt(map2.get(map1.get(et[j])));
		            kitne_used--;
		            j++;
		        }
		        else if(st[i]==et[j])
		        {
		           // System.out.println("Came3");
		            free=ans.charAt(map2.get(map1.get(et[j])));
		            j++;
		            i++;
		            ans+=free;
		        }
		    }
		    if(flag)
		    System.out.println("Case #"+(l+1)+": "+ans);
		}
	}
}