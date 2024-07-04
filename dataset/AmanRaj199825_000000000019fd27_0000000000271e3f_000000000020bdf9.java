import java.util.*;
import java.io.*;
class Triple
{
   Integer x;
	Integer y;
	Integer z;
	public Triple(Integer x, Integer y, Integer z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Triple() {
		super();
	}
	
	
}
 class Solution {
	public static void main(String[] args) {
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			   Integer T=Integer.parseInt(br.readLine());
			   int x=0;
			   while(T-->0)
			   {
				   x+=1;
				   Integer N=Integer.parseInt(br.readLine());
				   List<Triple> list=new ArrayList<>();
				   for(int i=0;i<N;i++)
				   {
					   String [] strarr=br.readLine().trim().split("\\s+");
					   Triple t=new Triple(Integer.parseInt(strarr[0]),Integer.parseInt(strarr[1]),i);
					   list.add(t);
				   }
	            Collections.sort(list,(a1,a2)->a1.x-a2.x);
	              int cend=-1,jend=-1;
	              boolean flag=true;
	              char [] res=new char[N];
	              for(int i=0;i<N;i++)
	              {
	            	  if(cend<=list.get(i).x)
	            	  {
	            		  res[list.get(i).z]='C';
	            		  cend=list.get(i).y;
	            	  }
	            	  else if(jend<=list.get(i).x)
	            	  {
	            		  res[list.get(i).z]='J';
	            		  jend=list.get(i).y;
	            	  }
	            	  else
	            	  {
	            		  flag=false;
	            		  break;
	            	  }
	              }
				  StringBuffer sb=new StringBuffer();
				  for(int i=0;i<N;i++)
				  {
					  sb.append(res[i]);
				  }
				  if(flag)
				  {
					  System.out.println("Case #"+x+": "+sb.toString());
				  }
				  else
				  {
					  System.out.println("Case #"+x+": "+"IMPOSSIBLE");

				  }
			   }
		}
		catch(Exception e)
		{
			
		}
	}

}
