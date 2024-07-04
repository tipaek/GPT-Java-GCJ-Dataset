import java.util.*;

public class Solution {
	
	public static HashMap sortbykey(HashMap hm) 
	{ 
		ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hm.keySet()); 
	          
	        Collections.sort(sortedKeys);
	        return hm;
	 } 
	  	  
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int tc;
		tc=sc.nextInt();
		ArrayList fin=new ArrayList();
		for(int t=0;t<tc;t++)
		{
			int n,s,e,st,et,js=0,je=0,cs=0,ce=0;
			String res="";
			boolean impflag=false;
			boolean jfree=true;
			boolean cfree=true;
			n=sc.nextInt();
			HashMap hm=new HashMap();
			HashMap hmr=new HashMap();
			for(int i=0;i<n;i++)
			{
				s=sc.nextInt();
				e=sc.nextInt();
				hmr.put(s,e);
				hm.put(s,e);
			}
			hm=sortbykey(hm);
			
			Iterator hmIterator = hm.entrySet().iterator(); 
		
	        while (hmIterator.hasNext()) 
	        { 
	            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
	            st = (int)mapElement.getKey(); 
	            et = (int)mapElement.getValue();
	            if(jfree)
	            {
	            	//res=res + 'J';
	            	hmr.replace(st,'J');
	            	js=st;
	            	je=et;
	            	jfree=false;
	            }
	            else if(cfree)
	            {
	            	//res=res + 'C';
	            	hmr.replace(st,'C');
	            	cs=st;
	            	ce=et;
	            	cfree=false;
	            }
	            else
	            {
	            	if(st>=je)
	            	{
	            		//res=res + 'J';
		            	hmr.replace(st,'J');
	            	}
	            	else if (st>=ce)
	            	{
	            		//res = res + 'C';
		            	hmr.replace(st,'C');
	            	}
	            	else
	            	{
	            		//res="IMPOSSIBLE";
	            		impflag=true;
	            		break;
	            	}
	            }
	        }

	        if (!impflag)
	        {
				Iterator resIterator = hmr.entrySet().iterator(); 
		        while (resIterator.hasNext()) 
		        { 
		            Map.Entry mapElement = (Map.Entry)resIterator.next(); 
		            char rv = (char)mapElement.getValue();
		            res=res+rv;
		        }
		        fin.add(res);
	        }
	        else
	        {
	        	fin.add("IMPOSSIBLE");
	        }
		}
		for(int z=0;z<fin.size();z++)
		{
			System.out.println("Case #"+(z+1)+": " +fin.get(z));
		}
	}
}
