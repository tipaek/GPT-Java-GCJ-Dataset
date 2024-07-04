import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc=new Scanner(System.in);
	      int t=sc.nextInt();
	      sc.nextLine();
	       int i,j,k;
	      for(i=0;i<t;i++)
	      {
	          int n=sc.nextInt();
	          sc.nextLine();
	          int [][]a=new int[n][2];
	          for(j=0;j<n;j++)
	          {
	              for(k=0;k<2;k++)
	              a[j][k]=sc.nextInt();
	              sc.nextLine();
	          }
	          ArrayList<Integer> first=new ArrayList<Integer>();
	          ArrayList<Integer> second=new ArrayList<Integer>();
	          first.add(a[0][0]);
	          first.add(a[0][1]);
	          Collections.sort(first);
	          
	          String s="C";
	          int p=0;
	          for(k=1;k<n;k++)
	          {    p=0;
	              if(first.get(0)>=a[k][1])
	              {
	                  first.add(a[k][0]);
	                  first.add(a[k][1]);
	                  Collections.sort(first);
	                  p=1;
	                  s=s+"C";
	                  continue;
	              }
	             else if(first.get(first.size()-1)<=a[k][0])
	              {
	                  first.add(a[k][0]);
	                  first.add(a[k][1]);
	                  Collections.sort(first);
	                  p=1;
	                  s=s+"C";
	                  continue;
	              }
	              else
	                 {
	                     
	                     
	                         int l1=1;
	                         int  l2=2;
	                         while(l2<first.size())
	                         {
	                            if(first.get(l1)<=a[k][0]&&first.get(l2)>=a[k][1])
	                           {
	                               p=1;
	                               s=s+"C";
	                               first.add(a[k][0]);
	                                 first.add(a[k][1]);
	                                   Collections.sort(first);
	                               break;
	                           }
	                           else
	                              l1=l1+2;
	                              l2=l1+1;
	                           
	                         }//while
	                     
	                 }//else
	                 if(p==0)
	                 {
	                	 if(second.size()==0)
	                     {
	                		 second.add(a[k][0]);
	                        second.add(a[k][1]);
	                       s=s+"J";
	                     }
	                	 else
	                	 {
	                		 if(second.get(0)>=a[k][1])
	       	                  {
	       	                  second.add(a[k][0]);
	       	                  second.add(a[k][1]);
	       	                  Collections.sort(second);
	       	                  p=1;
	       	                  s=s+"J";
	       	                  continue;
	       	                }
	                	 
	       	               else if(second.get(second.size()-1)<=a[k][0])
	       	                {
	       	                  second.add(a[k][0]);
	       	                  second.add(a[k][1]);
	       	                  Collections.sort(second);
	       	                  p=1;
	       	                  s=s+"J";
	       	                  continue;
	       	                }
	   	                else
		                 {
		                     
		                     
		                         int l1=1;
		                         int  l2=2;
		                         while(l2<second.size())
		                         {
		                            if(second.get(l1)<=a[k][0]&&second.get(l2)>=a[k][1])
		                           {
		                               p=1;
		                               s=s+"J";
		                               second.add(a[k][0]);
		                                 second.add(a[k][1]);
		                                   Collections.sort(second);
		                               break;
		                            }
		                           else
		                              l1=l1+2;
		                              l2=l1+1;
		                           
		                         }//while
		                     
		                   }//else
	                		 
	                	 }
	                 }
	                 
	            }
	          if(s.length()==n)
	            System.out.println("Case #"+(i+1)+": "+s);
	          else
	        	  System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
	       } 
	    }
	}
