
import java.util.*;


public class Solution {
	private static int n;
	private static ArrayList<Integer> num = new ArrayList<Integer>();
	private static ArrayList<Integer> begin = new ArrayList<Integer>();
	private static ArrayList<Integer> end = new ArrayList<Integer>();
	private static boolean have(ArrayList<Integer> a, ArrayList<Integer> b) {
		for (int i = 0; i < b.size(); i++) {
			if(a.contains(b.get(i))) return false;
		}
		return true;
	}
	private static String solve() {
		int c = 0 , j = 0;
		ArrayList<Integer> cam = new ArrayList<Integer>();
		ArrayList<Integer> jam = new ArrayList<Integer>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		String t = "";
		int cas = 0;
		for(int i = 0; i < n; i++) {
			m.addAll(num.subList(begin.get(i)+1, end.get(i)));
			if(cas == 0) {
			if(c < 2 & have(cam,m)) {
				t+="C";
				c++;
				j--;
				cam.addAll(m);
				cam.add(begin.get(i));
				cam.add(end.get(i));
				cas = 1;
			}else if(j < 2 & have(jam,m)) {
				t+="J";
				j++;
				c--;
				jam.addAll(m);
				jam.add(begin.get(i));
				jam.add(end.get(i));
				cas = 0;
			}else {
				t = "IMPOSSIBLE";
				break;
			}}else if(cas == 1) {
				if(j < 2 & have(jam,m)) {
					t+="J";
					j++;
					c--;
					jam.addAll(m);
					jam.add(begin.get(i));
					jam.add(end.get(i));
					cas = 0;
				}else if(c < 2 & have(cam,m)) {
					t+="C";
					c++;
					j--;
					cam.addAll(m);
					cam.add(begin.get(i));
					cam.add(end.get(i));
					cas = 1;
				}else {
					t = "IMPOSSIBLE";
					break;}
			}else {
				if(c < 2 & have(cam,m)) {
					t+="C";
					c++;
					cam.addAll(m);
					cam.add(begin.get(i));
					cam.add(end.get(i));
					cas = 1;
				}else if(j < 2 & have(jam,m)) {
					t+="J";
					j++;
					jam.addAll(m);
					jam.add(begin.get(i));
					jam.add(end.get(i));
					cas = 0;
				}else {
					t = "IMPOSSIBLE";
					break;}
			}
			m.clear();
		}
		
		return t;
	}

	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 1441; i++) num.add(i);
        int t = input.nextInt();
        for(int i = 1;i <= t;i++) {
        	n = input.nextInt();
        	for (int j = 0; j < n; j++) {
				begin.add(input.nextInt());
				end.add(input.nextInt());
			}
            System.out.println("Case #"+i+": "+ solve());
            begin.clear();
            end.clear();
        }
		
	}
}
    



