import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		for(int t=1;t<=x;t++) {
			int tasks=s.nextInt();
			int refNum=10000;
			//int[][] stEn=new int[tasks][2];
			List<Integer> l=new ArrayList<Integer>();
			List<Integer> l1=new ArrayList<Integer>();
			Map<Character,Integer> curTsk=new HashMap<Character,Integer>();
			Map<Integer,String> taskMap=new HashMap<Integer,String>();
			curTsk.put('C',0);
			curTsk.put('J',0);
			for(int i=0;i<tasks;i++) {
				int num1=s.nextInt();
				int num2=s.nextInt();
				l.add(num1*refNum+num2);
				l1.add(num1*refNum+num2);
			}
			Collections.sort(l1);
			StringBuffer st=new StringBuffer("");
			
			for(int i:l1)
			{
				int start=i/refNum;
				int end=i%refNum;
				int c=curTsk.get('C');
				int j=curTsk.get('J');
				if(c%refNum<=start) {
					curTsk.put('C',i);
					if(taskMap.get(i)==null)
						taskMap.put(i,"C");
					else
						taskMap.put(i,taskMap.get(i)+"C");
				}
				else
				if(j%refNum<=start) {
						curTsk.put('J',i);
						if(taskMap.get(i)==null)
							taskMap.put(i,"J");
						else
							taskMap.put(i,taskMap.get(i)+"J");
					}
				else {
				st=new StringBuffer("IMPOSSIBLE");
				break;
				}	
			}
			List<Integer> l2=new ArrayList<Integer>();
			if(!"IMPOSSIBLE".contentEquals(st)) {
				for(int i:l) {
					int count=0;
					if(l2.contains(i))
						count=1;
					st.append(taskMap.get(i).charAt(count)+"");
					l2.add(i);
				}
			}
			System.out.println("Case #"+t+": "+st);
			
		}
	}
}
