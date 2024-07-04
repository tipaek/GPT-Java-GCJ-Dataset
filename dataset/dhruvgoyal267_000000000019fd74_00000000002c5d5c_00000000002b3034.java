import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t  = s.nextInt();
		int  n;
		String str[];
        int temp = t;
		while(t-->0)
		{
		    n = s.nextInt();
		    s.nextLine();
		    str = new String[n];
            for(int i =0;i<n;i++)
                str[i] = s.nextLine();
                
                String main ="*";
             for(int i =0;i<n;i++)
            {
                 str[i].replace("*","");
                boolean flag = true;
                for(int j =0;j<n;j++)
                {
                    if(str[i].contains(str[j].substring(1)) == false)
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    main = str[i].substring(1);
            }
		    System.out.println("Case #"+(temp-t) + ": " +main);
		}
	}
}
