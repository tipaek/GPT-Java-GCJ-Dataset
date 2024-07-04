import java.io.*;
import java.util.*;

public class Answer {
	public static void main(String[] args) throws Exception
	{
		String[] left = {"", "(", "((", "(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
		String[] right = {"", ")", "))", ")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
		
        	Scanner s = getScanner();
        	String line = s.nextLine();
        	int T = Integer.parseInt(line);
		for (int i = 0; i < T; i++)
		{
        		line = s.nextLine();
        		int pre = 0;
        		StringBuffer output = new StringBuffer();
        		for (int j=0; j < line.length(); j++)
        		{
        			int a = Integer.parseInt("" + line.charAt(j));
        			if ( a > pre)
        				output.append(left[a-pre]);
        			else if (a < pre)
        				output.append(right[pre-a]);
        			output.append(a);
        			if ( j == line.length() - 1)
        				output.append(right[a]);
        			pre = a;
        		}
        		System.out.println("Case #" + (i+1) + ": " + output.toString());
        	}
	}
	
	static Scanner getScanner() throws Exception
	{
		return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//return new Scanner(new File("input.txt"));
        }
        
}

  