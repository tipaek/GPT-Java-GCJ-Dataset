
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int k=0; k<T; k++) {
			List<Map.Entry<Integer, Integer>> l = new LinkedList<>();
			int R = in.nextInt();
			int S = in.nextInt();
// 			for (int i=1; i<=S; i++) {
// 				for (int j=1; j<=R; j++) {
// 					l.add(new AbstractMap.SimpleEntry<Integer, Integer>(j,i));
// 				}
// 			}
			// for (Map.Entry<Integer, Integer> e: l) {
			// 	System.out.println(e.getKey()+":"+e.getValue());
			// }
			// boolean flag = true; int count = 0;
			// while(flag) {
			// 	count++;
			// List<Map.Entry<Integer, Integer>> list = new LinkedList<>();
			// for(int i=R;i<((R*S)-(R-1));i++) {
			// 	list.add(l.get(i));
			// }
			// for(int i=0;i<R;i++) {
			// 	list.add(l.get(i));
			// }
			// for(int i = ((R*S)-(R-1)) ; i <R*S; i++) {
			// 	list.add(l.get(i));
			// }
			// for (Map.Entry<Integer, Integer> e: list) {
			// 	System.out.println(e.getKey()+":"+e.getValue());
			// }
			// flag=false;
			// }
			int x = (int) (Math.log((R*S)-1) / Math.log(2));
			System.out.println("Case #"+(k+1)+": "+x);
			S= (((R*S)-R)-1);
			for(int i = 0;i <x;i++) {
				System.out.println(R+" "+S);
				if(R>=S) {
					R=R-1;
					S=S-1;
				} else {
					S=S-1;
				}
			}
		}
	}
}