import java.util.*;


public class Solution {
	private static int n;
	private static ArrayList<Integer> num = new ArrayList<Integer>();
	private static ArrayList<Integer> begin = new ArrayList<Integer>();
	private static ArrayList<Integer> end = new ArrayList<Integer>();
	private static String solve() {
		int c = 0 , j = 0;
		ArrayList<Integer> cam = new ArrayList<Integer>();
		ArrayList<Integer> jam = new ArrayList<Integer>();
		String t = "";
		for(int i = 0; i < n; i++) {
			if(c < 2 & !cam.contains(end.get(i)) & !cam.contains(begin.get(i))) {
				t+="C";
				c++;
				cam.addAll(num.subList(begin.get(i)+1, end.get(i)-1));
				j = 0;
			}else if(j < 2 & !jam.contains(end.get(i)) & !jam.contains(begin.get(i))) {
				t+="J";
				j++;
				jam.addAll(num.subList(begin.get(i)+1, end.get(i)-1));
				c = 0;
			}else {
				t = "IMPOSSIBLE";
				break;
			}
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
        }
		
	}
}
    