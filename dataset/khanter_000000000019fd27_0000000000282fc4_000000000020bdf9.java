import java.util.*;
public class Solution{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int z = 0;z<t;z++){
			int n = scan.nextInt();
			ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> j = new ArrayList<ArrayList<Integer>>();
			String ans = "";
			int s,e;
			boolean isC,isJ;
			for(int kk = 0;kk<n;kk++){
				s = scan.nextInt();
				e = scan.nextInt();
				ArrayList<Integer> tem = new ArrayList<>();
					tem.add(s);
					tem.add(e);
				isC = true;
				for(ArrayList<Integer> i: c){
					if ((s>i.get(0) && s<i.get(1)) || (e>i.get(0) && e<i.get(1)) || s == i.get(0) || e == i.get(1)){
						isC = false;
						break;
					}
				}
				if (isC == true){
					c.add(tem);
					ans+="C";
				}
				else{
					isJ = true;
					for(ArrayList<Integer> i: j){
						if ((s>i.get(0) && s<i.get(1)) || (e>i.get(0) && e<i.get(1)) || s == i.get(0) || e == i.get(1)){
							isJ = false;
							break;
						}
					}
					if (isJ == true){
						j.add(tem);
						ans+="J";
					}
					else{
						ans = "IMPOSSIBLE";
						break;
					}
				}
			}
			System.out.println("Case #"+(z+1)+": "+ans);
		}
	}
}