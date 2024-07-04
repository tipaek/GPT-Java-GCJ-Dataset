import java.util.Scanner;
public class Solution{
   
    public static void main(String args[]) {
      int test,
		i,
		j,
		k = 0;
        Scanner sc=new Scanner(System.in);
		test = sc.nextInt();
		for (k = 0; k < test; k++)
		{
	    String s=sc.next();
	    String ans1="";
	    StringBuilder ans=new StringBuilder(ans1);  
	    int nopen=0;
	
	        for(i=0;i<s.length();i++)
	        {
	           int x= Character.getNumericValue(s.charAt(i));
	           if(x==nopen)
	           {
	               ans.append(x);
	               
	           }
	            else if(x>nopen)
	           {
	                for(j=0;j<(x-nopen);j++)
	                    ans.append("(");
	                ans.append(x);
	                nopen=nopen+(x-nopen);
	           }
	           else if(x<nopen)
	           {
	                for(j=0;j<(nopen-x);j++)
	                    ans.append(")");
	                ans.append(x);
	                nopen=nopen-(nopen-x);

	           }
	        }
	        if(nopen!=0)
	        {
	            for(i=0;i<nopen;i++)
	            {
	                ans.append(")");
	            }
	        }
	           System.out.println("Case #"+(k+1)+":"+" "+ans);
		}
    }
}