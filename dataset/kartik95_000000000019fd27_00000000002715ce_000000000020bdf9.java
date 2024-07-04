import java.util.HashMap;
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
				int a[][] = new int[n][2];
				TreeMap<Integer, Integer> treeMap = new TreeMap<>();
				for (int i = 0; i < n; i++)
				{
					int key=0;
					int value=0;
					for (int k = 0; k < 2; k++)
					{
						a[i][k] = in.nextInt();
						if(k==0)
							key = a[i][k];
						else
							value = a[i][k];
					}
					treeMap.put(key, value);
				}
				
				HashMap<Integer, String> hm = new HashMap<>();
				for (Entry<Integer, Integer> entry : treeMap.entrySet()) 
				{
					if(entry.getKey()>=c)
					{
						c = entry.getValue();
						hm.put(entry.getKey(), "C");
					}
					else if(entry.getKey()>=j)
					{
						j = entry.getValue();
						hm.put(entry.getKey(), "J");
					}
					else
					{
						break;
					}
				}
				
				for (int i = 0; i < n; i++)
				{
					if(hm.containsKey(a[i][0]))
						s.append(hm.get(a[i][0]));
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
