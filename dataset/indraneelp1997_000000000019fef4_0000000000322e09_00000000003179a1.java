import java.util.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;
import static java.util.Map.Entry.comparingByValue;

public class Solution
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int t1=1;t1<=t;t1++)
		{
			int u = sc.nextInt();
			int count[] = new int[26];
			Arrays.fill(count,Integer.MAX_VALUE);
			for(int k=1;k<=10000;k++)
			{
				String a = sc.next();
				String b = sc.next();
				if(a.length() == b.length())
				{
					int num = Character.getNumericValue(a.charAt(0));
					char s1 = b.charAt(0);
					if(count[s1-'A']>num)
						count[s1-'A']=num;
				}
			}
			Map<Integer,List<Character>> map = new HashMap<Integer,List<Character>>();
			for(int i=0;i<26;i++)
			{
				if(count[i]!=Integer.MAX_VALUE)
				{
					char a = (char)('A'+i);
					for(int j=0;j<=count[i];j++)
					{
						if(!map.containsKey(j))
							map.put(j,new ArrayList<Character>());
						map.get(j).add(a);
					}
				}
			}
			boolean flag[] = new boolean[26];
			Arrays.fill(flag,false);
			char arr[] =new char[10];
			Map<Integer, List<Character>> sorted = map.entrySet().stream()
    		.sorted(comparingByValue(comparingInt(List::size)))
    		.collect(toMap(
        				Map.Entry::getKey,
       				 	Map.Entry::getValue,
        				(a, b) -> { throw new AssertionError(); },
        				LinkedHashMap::new
    		)); 
    		for(Map.Entry<Integer,List<Character>> e : sorted.entrySet())
    		{
    			int num = e.getKey();
    			List<Character> val = e.getValue();
    			for(Character s11 :val)
    			{
    				if(flag[s11-'A']==false)
    				{
    					flag[s11-'A']=true;
    					arr[num]=s11;
    					break;
    				}
    			}
    		}
    		String ans = "";
    		for(int i=0;i<10;i++)
    			ans+=arr[i];
    		System.out.println(ans);
		}
	}
}