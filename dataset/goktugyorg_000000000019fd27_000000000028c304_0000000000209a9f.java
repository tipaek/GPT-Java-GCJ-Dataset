import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        String input = in.nextLine();

        for (int i = 1; i <= t; ++i) 
        { 	
        	int count = 0;
        	input = in.nextLine();
        	StringBuilder str = new StringBuilder("");
        	
        	for (int j = 0; j < input.length(); j++) 
        	{
				int num = Integer.parseInt(input.charAt(j) + "");
				if(count == num)
				{
					str.append(num);
				}
				else if(count < num)
				{
					IntStream.range(0, num-count).forEach(x -> str.append("("));
					str.append(num);
					count = num;
				}
				else if(num < count)
				{
					IntStream.range(0, count-num).forEach(x -> str.append(")"));
					str.append(num);
					count = num;
				}
        	}
        	
        	IntStream.range(0, count).forEach(x -> str.append(")"));
        	
        	System.out.println("Case #" + i + ": " + str);
        }
        in.close();
	
	}

}