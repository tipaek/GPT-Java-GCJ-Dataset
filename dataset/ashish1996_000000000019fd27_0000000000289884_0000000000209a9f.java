
public class Solution {

	public static void main(String...ss) {
		Scanner s = new Scanner(System.in);
		int t1 = s.nextInt();
		int k=1;
		while(t1--!=0)
		{
		    String input=s.next();
		    String output="";
		    for(int i=0;i<input.length();i++)
		    {
		        if(input.charAt(i)=='1')
		        {
		        output=output+"(";
		        while(i<input.length()&&input.charAt(i)=='1'){
		            output=output+input.charAt(i);
		            i++;
		        }
		        
		        output=output+")";
		        }
		         if(i<input.length()&&input.charAt(i)=='0')
		        output=output+input.charAt(i);
		    }
		    System.out.print("Case #"+k+++": "+output);
			System.out.println();
		}
		
	}
		
		
}