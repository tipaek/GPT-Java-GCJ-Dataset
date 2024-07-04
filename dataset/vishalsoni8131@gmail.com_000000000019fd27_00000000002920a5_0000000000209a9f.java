import java.util.*;
class Sample{
static Scanner sc=new Scanner(System.in);
	public static void main(String []args){
		 System.out.println("Enter number of test Cases:");
		 int T=sc.nextInt();
		 String s,str="";
		 int i,j,flag1;
		 if(T>=1 && T<=100)
		 	for(i=0;i<=T;i++){
		       flag1=0;
		       s=sc.nextLine();
		       int size=s.length();
		        if(size>=1 && size<=100)
		        { if(i>=1)
		             str=str+"\nCase #"+i+":";
		        	for(j=0;j<size;j++)
		        	{if(s.charAt(j)=='0')
		        		{if(flag1==1)
		        			 {
		        			 	str=str+')'+0;
		        			    flag1=0;
		        			 }
		        			 else
		        			 	str=str+0;
		        		}
                        if(s.charAt(j)=='1')
		        		{   
		        			if(flag1==0)
		        			{ str=str+"(1";
		        			  flag1=1;
		        			}
		        			else if(size==j+1)
		        				{str=str+1+")";
		        				}
		        				else
		        				 str=str+1;
		        		}
		        		if(j==size-1&& s.charAt(j)=='1')
		        		{str=str+")";
		        		}
		        	}
		        }
		   }
            System.out.println(str); 
	}
}