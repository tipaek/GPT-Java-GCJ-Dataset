import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javafx.util.Pair;


public class Solution {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=Integer.parseInt(sc.nextLine());
		for(int i=0; i<tc; i++) {
			int n=sc.nextInt();
			char[] chars = new char[n];
			Arrays.fill(chars,' ');
			StringBuilder result=new StringBuilder(String.copyValueOf(chars));
			char lastTask='C';
			boolean imp=false;
			HashMap<Character,Integer> per=new HashMap<Character,Integer>();
			per.put('C',-1);
			per.put('J',-1);
			TreeMap<Integer,Pair<Integer,Integer>> times=new TreeMap<Integer,Pair<Integer,Integer>>();
			for (int j = 0; j < n; j++) {
				times.put(sc.nextInt(),new Pair<Integer,Integer>(sc.nextInt(),j));
			}
			for(Entry<Integer, Pair<Integer, Integer>> time:times.entrySet()) {
				int si=time.getKey(),ei=time.getValue().getKey();
//				System.out.println("si:"+si+" ei:"+ei);
				if(imp)
					continue;
				char avaiPer='Z';
				if(per.get('C')<=si)
					avaiPer='C';
				if(per.get('J')<=si)
					avaiPer='J';
//				System.out.println("avai"+ avaiPer);
				if(avaiPer=='Z') {
					result=new StringBuilder("IMPOSSIBLE");
					imp=true;
				} else {
//					System.out.println((int)time.getValue().getValue());
					result.insert((int) time.getValue().getValue(), avaiPer);
					per.put(avaiPer,ei);
				}
			}
			System.out.println("Case #"+(i+1)+": "+result.toString().replace(" ",""));
		}// tc end
	}//main end
}





