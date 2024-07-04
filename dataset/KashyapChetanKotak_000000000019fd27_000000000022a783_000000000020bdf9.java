import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


class EntryComparator implements Comparator<SimpleEntry<Integer, Integer>>{

	@Override
	public int compare(SimpleEntry<Integer, Integer> arg0, SimpleEntry<Integer, Integer> arg1) {
		if(arg0.getKey().compareTo(arg1.getKey())==0)
			return 1;
		return arg0.getKey().compareTo(arg1.getKey());
	}

}

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=Integer.parseInt(sc.nextLine());
		for(int i=0; i<tc; i++) {
			int n=sc.nextInt();
			char[] chars = new char[n];
			Arrays.fill(chars,'*');
			StringBuilder result=new StringBuilder(String.copyValueOf(chars));
			boolean imp=false;
			HashMap<Character,Integer> per=new HashMap<Character,Integer>();
			per.put('C',0);
			per.put('J',0);
			TreeMap<SimpleEntry<Integer,Integer>,Integer> times=new TreeMap<SimpleEntry<Integer,Integer>,Integer>(new EntryComparator());
//			System.out.println("==============");
			for (int j = 0; j < n; j++) {
				times.put(new SimpleEntry<Integer,Integer>(sc.nextInt(),j),sc.nextInt());
//				System.out.println(times.toString());
			}
//			System.out.println("==============");
			for(Entry<SimpleEntry<Integer, Integer>, Integer> time:times.entrySet()) {
//				int currJ=(int) time.getValue().getValue();
				int si=time.getKey().getKey();
				int ei=time.getValue();
//				System.out.println("si:"+si+" ei:"+ei);
				if(imp)
					continue;
				char avaiPer='Z';
				if(per.get('C')<=si)
					avaiPer='C';
				else if(per.get('J')<=si)
					avaiPer='J';
//				System.out.println("avai "+ avaiPer);
				if(avaiPer=='Z') {
					result=new StringBuilder("IMPOSSIBLE");
					imp=true;
				} else {
//					result.insert((int) time.getKey().getValue(), avaiPer);
					result.setCharAt(time.getKey().getValue(), avaiPer);
					per.put(avaiPer,ei);
//					System.out.println(result);
				}
			}
			System.out.println("Case #"+(i+1)+": "+result.toString().replace("*",""));
		}// tc end
		sc.close();
	}//main end
}





