
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k1=sc.nextInt();
		int flag=0;
	for(int t=1;t<=k1;t++)
	{
	    int n=sc.nextInt();
	    int k=sc.nextInt();
	    int flag2=0;
	    int flag3=0;
	    int flag4=0;
	    int flag5=0;
	    if(n==2)
	    {
	        if(k==2)
	        { System.out.println("Case #"+t+": "+"POSSIBLE");
	            System.out.println("1 "+"2");
	            System.out.println("2 "+"1");
	            flag2=1;
	        }
	        if(k==4)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            System.out.println("2 "+"1");
	            System.out.println("1 "+"2");	         
	            flag2=1;
	        }
	    }
	    else if(n==3)
	    {
	        if(k==3)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag3=1;
	            System.out.println("1 "+"2 "+"3");
	            System.out.println("2 "+"1 "+"3");
	            System.out.println("3 "+"2 "+"1");
	        }
	        if(k==6)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag3=1;
	            System.out.println("2 "+"3 "+"1");
	            System.out.println("1 "+"2 "+"3");
	            System.out.println("3 "+"1 "+"2");	            
	        }
	        if(k==9)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag3=1;
	            System.out.println("3 "+"1 "+"2");
	            System.out.println("2 "+"3 "+"1");
	            System.out.println("1 "+"2 "+"3");	            
	        }

	    }
	    else if(n==4)
	    {
	        if(k==4)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("1 2 3 4");
	         System.out.println("4 1 2 3");
	         System.out.println("3 4 1 2");
	         System.out.println("2 3 4 1");
	        }
	        if(k==6)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("1 2 3 4");
	         System.out.println("2 1 4 3");
	         System.out.println("3 4 2 1");
	         System.out.println("4 3 1 2");
	            
	        }
	        if(k==8)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("2 3 4 1");
	         System.out.println("1 2 3 4");
	         System.out.println("4 1 2 3");
	         System.out.println("3 4 1 2");
	            
	        }
	        if(k==10)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("2 3 1 4");
	         System.out.println("3 2 4 1");
	         System.out.println("4 1 3 2");
	         System.out.println("1 4 2 3");
	        }
	        if(k==12)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("3 4 1 2");
	         System.out.println("2 3 4 1");
	         System.out.println("1 2 3 4");
	         System.out.println("4 1 2 3");
	        }
	        if(k==14)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("3 4 1 2");
	         System.out.println("4 3 2 1");
	         System.out.println("1 2 4 3");
	         System.out.println("2 1 3 4");
	            
	        }
	        if(k==16)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag4=1;
	         System.out.println("4 1 2 3");
	         System.out.println("3 4 1 2");
	         System.out.println("2 3 4 1");
	         System.out.println("1 2 3 4");
	            
	        }
	    }
	    else {
	        if(k==5)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("1 2 3 4 5");
	         System.out.println("5 1 2 3 4");
	         System.out.println("4 5 1 2 3");
	         System.out.println("3 4 5 1 2");
	         System.out.println("2 3 4 5 1");
	            
	        }
	        if(k==7)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("1 2 3 4 5");
	         System.out.println("5 1 2 3 4");
	         System.out.println("2 4 1 5 3");
	         System.out.println("3 5 4 2 1");
	         System.out.println("4 3 5 1 2");
	            
	        }
	        if(k==8)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("2 1 3 4 5");
	         System.out.println("5 2 1 3 4");
	         System.out.println("1 4 2 5 3");
	         System.out.println("3 5 4 1 2");
	         System.out.println("4 3 5 2 1");
	            
	        } 
	        if(k==9)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("1 3 2 4 5");
	         System.out.println("5 1 3 2 4");
	         System.out.println("3 4 1 5 2");
	         System.out.println("2 5 4 3 1");
	         System.out.println("4 2 5 1 3");
	            
	        }
	        if(k==10)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("2 1 3 4 5");
	         System.out.println("5 2 1 3 4");
	         System.out.println("4 5 2 1 3");
	         System.out.println("3 4 5 2 1");
	         System.out.println("1 3 4 5 2");
	            
	        }
	        if(k==11)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("3 1 2 4 5");
	         System.out.println("5 3 1 2 4");
	         System.out.println("1 4 3 5 2");
	         System.out.println("2 5 4 1 3");
	         System.out.println("4 2 5 3 1");
	            
	        }
	        if(k==12)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("2 3 1 4 5");
	         System.out.println("5 2 3 1 4");
	         System.out.println("3 4 2 5 1");
	         System.out.println("1 5 4 3 2");
	         System.out.println("4 1 5 2 3");
	            
	        }
	        if(k==13)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("3 2 1 4 5");
	         System.out.println("5 3 2 1 4");
	         System.out.println("2 4 3 5 1");
	         System.out.println("1 5 4 2 3");
	         System.out.println("4 1 5 3 2");
	            
	        }
	        if(k==14)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("2 4 1 3 5");
	         System.out.println("5 2 4 1 3");
	         System.out.println("4 3 2 5 1");
	         System.out.println("1 5 3 4 2");
	         System.out.println("3 1 5 2 4");
	            
	        }
	        if(k==15)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("3 2 1 4 5");
	         System.out.println("5 3 2 1 4");
	         System.out.println("4 5 3 2 1");
	         System.out.println("1 4 5 3 2");
	         System.out.println("2 1 4 5 3");
	            
	        }
	        if(k==16)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("4 2 1 3 5");
	         System.out.println("5 4 2 1 3");
	         System.out.println("2 3 4 5 1");
	         System.out.println("1 5 3 2 4");
	         System.out.println("3 1 5 4 2");
	            
	        }
	        if(k==17)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("3 4 1 2 5");
	         System.out.println("5 3 4 1 2");
	         System.out.println("4 2 3 5 1");
	         System.out.println("1 5 2 4 3");
	         System.out.println("2 1 5 3 4");
	            
	        }
	        if(k==18)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("4 3 1 2 5");
	         System.out.println("5 4 3 1 2");
	         System.out.println("3 2 4 5 1");
	         System.out.println("1 5 2 3 4");
	         System.out.println("2 1 5 4 3");
	            
	        }
	        if(k==19)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("5 2 1 4 3");
	         System.out.println("3 5 2 1 4");
	         System.out.println("2 4 5 3 1");
	         System.out.println("1 3 4 2 5");
	         System.out.println("4 1 3 5 2");
	            
	        }
	        if(k==20)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("4 2 1 3 5");
	         System.out.println("5 4 2 1 3");
	         System.out.println("3 5 4 2 1");
	         System.out.println("1 3 5 4 2");
	         System.out.println("2 1 3 5 4");
	            
	        }
	        if(k==21)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("5 3 1 4 2");
	         System.out.println("2 5 3 1 4");
	         System.out.println("3 4 5 2 1");
	         System.out.println("1 2 4 3 5");
	         System.out.println("4 1 2 5 3");
	            
	        }
	        if(k==22)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("4 5 1 2 3");
	         System.out.println("3 4 5 1 2");
	         System.out.println("5 2 4 3 1");
	         System.out.println("1 3 2 5 4");
	         System.out.println("2 1 3 4 5");
	            
	        }
	        if(k==23)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("5 4 1 2 3");
	         System.out.println("3 5 4 1 2");
	         System.out.println("4 2 5 3 1");
	         System.out.println("1 3 2 4 5");
	         System.out.println("2 1 3 5 4");
	            
	        }
	        if(k==25)
	        {System.out.println("Case #"+t+": "+"POSSIBLE");
	            flag5=1;
	         System.out.println("5 2 3 4 1");
	         System.out.println("1 5 2 3 4");
	         System.out.println("4 1 5 2 3");
	         System.out.println("3 4 1 5 2");
	         System.out.println("2 3 4 1 5");
	            
	        }

	    }
	    
	    if(flag2==1||flag3==1||flag4==1||flag5==1)
	    {
	        flag=1;
	    }
	    else{
	        System.out.println("Case #"+t+": "+"IMPOSSIBLE");
	    }
	
	    
	}
	    
	}
}