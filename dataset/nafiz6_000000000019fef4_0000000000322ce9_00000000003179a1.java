import java.util.*;
import java.io.*;

class Pair {
	public int i,j;
    public	StringBuilder sb;
	public Pair(int i, int j) {
		this.i = i;
		this.j=j;
		sb = new StringBuilder();
	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		for (int z = 1; z <= t; ++z) {
			int u = in.nextInt();
			HashMap<String, Character>  maxV = new HashMap<>();
			HashMap<String, Boolean>  isZero = new HashMap<>();
			for (int i=0;i<10000;i++){
				String sq = in.next();
				String r = in.nextLine();
				r = r.substring(1);
					
				int j=1;
				if (r.length()<sq.length())j=0;
				for (; j < r.length(); j++) {
					String c = "" + r.charAt(j);
					if (!maxV.containsKey(c)) {
						maxV.put(c, '9');
					}
					if (!isZero.containsKey(c)) {
						isZero.put(c, true);
					}
				}
				Character maxDig = sq.charAt(0); 
				if (r.length()==sq.length()){
					String start = ""+r.charAt(0);
					if (maxV.containsKey(start)){
						if (maxV.get(start)>maxDig){
							maxV.put(start, maxDig);
						}
					}	
					else{
						maxV.put(start, maxDig);
					}
					isZero.put(start, false);
				}
			}
			
		
			System.out.print("Case #" + z + ": ");
			boolean found =false;
			String[] output = new String[10];
			Iterator hmIterator = maxV.entrySet().iterator();
			while (hmIterator.hasNext()){
				Map.Entry  entry = (Map.Entry)hmIterator.next();
				if (isZero.get((String)entry.getKey())){output[0]=(String)entry.getKey(); continue;}
				output[(char)entry.getValue()-'0']=(String)entry.getKey();
//				System.out.println((int)entry.getValue() + " " + entry.getKey() + " " + isZero.get((String)entry.getKey()));
			}
		
			for (int i=0;i<output.length;i++){
				System.out.print(output[i]);
			}
			System.out.println();



		}
	}
}
