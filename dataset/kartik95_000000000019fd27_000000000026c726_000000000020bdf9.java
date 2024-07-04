import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		int n;
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int noOfTestCase = in.nextInt();
			for (int z = 0; z < noOfTestCase; z++) {
				int c = 0;
				int j = 0;
				StringBuilder s = new StringBuilder();
				n = in.nextInt();
				
				TreeMap<Integer, Integer> treeMap = new TreeMap<>();
				for(int i=0; i<n; i++)
				{
					int key = in.nextInt();
					int value = in.nextInt();
					treeMap.put(key, value);
				}
				
				for (Entry<Integer, Integer> entry : treeMap.entrySet()) 
				{
					if(entry.getKey()>=c)
					{
						s.append("C");
						c = entry.getValue();
					}
					else if(entry.getKey()>=j)
					{
						s.append("J");
						j = entry.getValue();
					}
					else
					{
						s = new StringBuilder().append("IMPOSSIBLE");
						break;
					}
				}
				
				int testCaseNo = z + 1;
				System.out.println("Case #" + testCaseNo + ":" + " " + s.toString());
			}
		} catch (Exception e) {
		} finally {
			in.close();
		}

	}

}
