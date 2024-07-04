import java.io.*; 
import java.util.*; 
class Solution
{
	public static void main(String stg[])
	{
		int test;
		Scanner sc=new Scanner(System.in);
		test=sc.nextInt();
		int count=1;
		while(test>=1)
		{
			int n=sc.nextInt();
			String str="J";
		      ArrayList<Integer> initmin = new ArrayList<Integer>(n-1);
		      ArrayList<Integer> initmax = new ArrayList<Integer>(n-1);
		      ArrayList<Integer>  cmin= new ArrayList<Integer>();
		      ArrayList<Integer> cmax = new ArrayList<Integer>();
		      ArrayList<Integer> jmin = new ArrayList<Integer>();
		      ArrayList<Integer> jmax = new ArrayList<Integer>();
		      
		      for(int i=0;i<n;i++)
		      {
		    	  if(i==0)
		    	  {
		    		  jmin.add(sc.nextInt());
		    		  jmax.add(sc.nextInt());
		    	  }
		    	  else
		    	  {
		    	  initmin.add(sc.nextInt());
		    	  initmax.add(sc.nextInt());
		    	  }
		      }
		      
		     
		      for(int i=0;i<n-1;i++)
		      {
		    	  boolean jflag=true;
		    	  boolean cflag=true;
		    	  for(int jind=0;jind<jmin.size();jind++)
		    	  {
		    		  if( (jmin.get(jind)<=initmin.get(i) && initmin.get(i)<jmax.get(jind)) || (jmin.get(jind)<initmax.get(i) && initmax.get(i)<=jmax.get(jind)))
		    		  {
		    			  jflag=false;
		    			  break;
		    		  }
		    	  }
		
		    	  if(jflag==false)
		    	  {
		    		  if(cmin.size()==0)
		    		  {
		    			  cmin.add(initmin.get(i));
		    			  cmax.add(initmax.get(i));
		    			  str=str+"C";
		    		  }
		    		  else
		    		  {
		    			  for(int cind=0;cind<cmin.size();cind++)
				    	  {
				    		  if( (cmin.get(cind)<=initmin.get(i) && initmin.get(i)<cmax.get(cind)) || (cmin.get(cind)<initmax.get(i) && initmax.get(i)<=cmax.get(cind)))
				    		  {
				    			  cflag=false;
				    			  break;
				    		  }
				    	  } 
		    			  if(cflag)
		    			  {
		    				  cmin.add(initmin.get(i));
		    				  cmax.add(initmax.get(i));
		    				  str=str+"C";
		    			  }
		    		  }
		    	  }
		    	  else
		    	  {
		    		  jmin.add(initmin.get(i));
		    		  jmax.add(initmax.get(i));
		    		  str=str+"J";
		    	  }
		    	  if(!cflag&&!jflag)
		    	  {
		    		  str="IMPOSSIBLE";
		    	  }
		      }
		      
			
		      System.out.println("Case #"+count+": "+str);
			count++;
			
			
			test--;
		}
	}
}