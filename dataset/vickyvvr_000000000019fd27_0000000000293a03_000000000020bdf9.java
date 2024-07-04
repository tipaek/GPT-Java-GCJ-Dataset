import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int j = 1; j <= t; ++j) {
			int N = in.nextInt();
			int startArray[] = new int[N];
			int endArray[] = new int[N];
			String result = "";
			Map<Integer, String> cMap = new HashMap<Integer, String>();
		    Map<Integer, String> jMap = new HashMap<Integer, String>();
			outer:
			for(int i=0;i<N;i++)
			{
				int start = in.nextInt();
				int end = in.nextInt();
				startArray[i] = start;
				endArray[i] = end;
				if(cMap.isEmpty() && jMap.isEmpty())
				{
					cMap.put(start, "C");
					result += "C";
				}
				else
				{
					int temp = i-1;
					boolean cFlag = true;
					boolean jFlag = true;
					while(temp >=0)
					{
						if((start > startArray[temp] && start < endArray[temp]) ||(end > startArray[temp] && end < endArray[temp])) 
						{
							if(cMap.containsKey(startArray[temp]))
							{
								cFlag = false;
							}
							if(jMap.containsKey(startArray[temp]))
							{
								jFlag = false;
							}
						}
						temp -= 1;
					}
					if(cFlag && jFlag)
					{
					    cMap.put(start, "C");
					    result += "C";
					    continue;
					}
					if(cFlag)
					{
					    cMap.put(start, "C");
					    result += "C";
					}
					if(jFlag)
					{
					    jMap.put(start, "J");
					    result += "J";
					}
		            if(!cFlag && !jFlag)
		            {
					    result= "IMPOSSIBLE";
					    break outer;
					}
				}
			}
			System.out.println("Case #" + j + ": " +result);
		}
	}
}