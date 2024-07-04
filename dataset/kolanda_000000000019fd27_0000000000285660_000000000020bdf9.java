import java.util.*;
public class Solution {
	
	   public static int[] sort1(int arr[]) 
	    { 
	        int n = arr.length;
	        int brr[]=new int[n];
	        for (int i = 1; i < n; ++i) { 
	            int key = arr[i]; 
	            int j = i - 1; 
	            while (j >= 0 && arr[j] > key) { 
	                arr[j + 1] = arr[j];
	                brr[j+1] = brr[j];
	                j = j - 1; 
	            } 
	            arr[j + 1] = key; 
	            brr[j + 1] = i;
	        }
			return brr; 
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
			boolean impflag=false;
			boolean jfree=true;
			boolean cfree=true;
			n=sc.nextInt();
			int starr[]=new int[n];
			int starr1[]=new int[n];
			int endarr[]=new int[n];
			
			int idxarrsr[]=new int[n];
			
			char[] ress=new char[n];
			
			for(int i=0;i<n;i++)
			{
				starr[i]=sc.nextInt();
				starr1[i]=starr[i];
				endarr[i]=sc.nextInt();
			}
			idxarrsr=sort1(starr);
			
			
	        for(int f=0;f<idxarrsr.length;f++)
	        {  
	            st = starr1[idxarrsr[f]];
	            et = endarr[idxarrsr[f]];
	            if(jfree)
	            {
	            	ress[idxarrsr[f]]='J';
	            	js=st;
	            	je=et;
	            	jfree=false;
	            }
	            else if(cfree)
	            {
	            	ress[idxarrsr[f]]='C';
	            	cs=st;
	            	ce=et;
	            	cfree=false;
	            }
	            else
	            {
	            	if(st>=je)
	            	{
	            		ress[idxarrsr[f]]='J';
		            	js=st;
		            	je=et;
	            	}
	            	else if (st>=ce)
	            	{
	            		ress[idxarrsr[f]]='C';
		            	cs=st;
		            	ce=et;
	            	}
	            	else
	            	{
	            		impflag=true;
	            		break;
	            	}
	            }
	        }

	        String res1="";
	        for(int m=0;m<ress.length;m++)
	        {
	        	res1=res1+ress[m];
	        }
	        if (!impflag)
	        {
	        	fin.add(res1);
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
