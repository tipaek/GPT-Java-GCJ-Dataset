/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution
{       
    
	    static void arrsort(int ar[],int bt[],int n)
	    {  int temp;
	        for(int i = 0 ; i <n; i++)
		  {
			for(int  j=0;  j < n-(i+1) ; j++)
			{
				if( ar[j] > ar[j+1] )
				{
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
					temp = bt[j];
					bt[j] = bt[j+1];
					bt[j+1] = temp;
					
				}
			}
		  }
	    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int i,j,n,m,p,s,t,y;
	    t=sc.nextInt();
	    String st="",w="";
	    for(i=0;i<t;i++)
	    { n=sc.nextInt();
	      int a[]=new int[n];
	      int d[]=new int[n];
	      int dr[]=new int[n];
	      //ArrayList<Integer> al=new ArrayList<>();
	      HashMap<Integer,String> hm=new HashMap<>();
	      PriorityQueue<Integer> pq=new PriorityQueue<>();
	      for(j=0;j<n;j++)
	      {  a[j]=sc.nextInt();
	     // al.add(a[j]);
	         d[j]=sc.nextInt();
	         dr[j]=d[j];
	       //  al.add(d[j]);
	      }
	        arrsort(a,d,n);   
	        int ct=1;
	        for(j=1;j<n;j++)
	        { if(d[j]==d[j-1])
	          ct++;
	            if(ct>2)
	            break;
	        }
	        if(j==n)
	         {     st="C";
	          boolean used[]=new boolean[2];
	          pq.add(d[0]);
	          hm.put(d[0],"C");
	          used[0]=true;
	          for(j=1;j<n;j++)
	          {  if(a[j]>=pq.peek())
	                { int k=pq.poll();
	                    w=hm.get(k);
	                    if(w.equals("C"))
	                    {used[0]=false;
	                    pq.add(d[j]);
	                    if(!hm.containsKey(d[j]))
	                     hm.put(d[j],"C");
	                     else
	                     hm.put(d[j],hm.get(d[j])+"C");
	                     used[0]=true;
	                     st+="C";
	                    }
	                    else if(w.equals("J"))
	                    {used[1]=false;
	                    pq.add(d[j]);
	                    if(!hm.containsKey(d[j]))
	                    hm.put(d[j],"J");
	                    else
	                     hm.put(d[j],hm.get(d[j])+"J");
	                    used[1]=true;
	                    st+="J";
	                    }
	                    else
	                    { used[0]=false;
	                        used[1]=false;
	                        pq.add(d[j]);
	                        hm.put(d[j],"C");
	                        used[0]=true;
	                        
	                    }
	                }
	                else if(a[j]<d[j-1])
	                { if(used[0]&&used[1])
	                 break;
	                    else if(!used[0])
	                    {  if(!hm.containsKey(d[j]))
	                        hm.put(d[j],"C");
	                        else
	                        hm.put(d[j],hm.get(d[j])+"C");
	                    st+="C";
	                    pq.add(d[j]);
	                        used[0]=true;
	                    }
	                    else
	                    {  if(!hm.containsKey(d[j]))
	                        hm.put(d[j],"J");
	                        else
	                        hm.put(d[j],hm.get(d[j])+"J");
	                    st+="J";
	                    pq.add(d[j]);
	                        used[1]=true;
	                    }
	                }
	              
	          }
	          
	         if(j==n)
	        {   String z="";
	          for(int x=0;x<n;x++)
	          { if(hm.get(d[x]).length()==2)
	              { z+=hm.get(dr[x]);
	                  x++;
	              }
	              else
	              z+=hm.get(dr[x]);
	          }
	            System.out.println("Case #"+(i+1)+": "+z);
	        }
	        else
	        System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
	         }
	         else{
	        
	        System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
	         }
	       }
	   /*    if(j==n)
	        System.out.println("Case #"+(i+1)+": "+st);
	        else
	        System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE"); for(i=0;i<n;i++)
	          System.out.println(a[i]+" "+d[i]);
	          */
	    
		
	}
}
