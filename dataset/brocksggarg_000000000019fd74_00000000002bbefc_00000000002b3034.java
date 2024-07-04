import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #"+i+": "+solve(br, i));
		}
	}

	private static String solve(BufferedReader br, int t) throws IOException {
		System.out.println();
		int n=Integer.parseInt(br.readLine());
		Map<Integer, Integer> map=new HashMap<>();
		Map<Integer, Integer> map2=new HashMap<>();
		Map<Integer, Boolean> last=new HashMap<>();
		Map<Integer, Boolean> start=new HashMap<>();
		ArrayList<String> l=new ArrayList<>();
		for(int i=0;i<n;i++) {
			l.add(br.readLine());
			last.put(i, true);
			start.put(i, true);
			map2.put(i, 0);
			map.put(i, l.get(i).length()-1);
		}
		String res="";
		//check from last
		while(true) {
			char check='@';
			char c = 0;
			for(int j=0;j<n;j++) {
				
				if(last.get(j)) {
					 c=l.get(j).charAt(map.get(j));
					if(c=='*') {
						last.put(j, false);
					}
					else if(check=='@') {
						check=c;
						map.put(j,map.get(j)-1);
					}else {
						if(check!=c) {
							return "*";
						}
						map.put(j,map.get(j)-1);
					}
					
				}
			}
			if(check=='@') {
				break;
			}else {
				res=res+check;
			}
		}
		
		String startRes="";
		//check from start
		while(true) {
			char check='@';
			char c = 0;
			for(int j=0;j<n;j++) {
				
				if(start.get(j)) {
					 c=l.get(j).charAt(map2.get(j));
					if(c=='*') {
						start.put(j, false);
					}
					else if(check=='@') {
						check=c;
						map2.put(j,map2.get(j)+1);
					}else {
						if(check!=c) {
							return "*";
						}
						map2.put(j,map2.get(j)+1);
					}
					
				}
			}
			if(check=='@') {
				break;
			}else {
				startRes=startRes+check;
			}
		}
		
		
		
		
		
		
		
		String mid="";
		
			for(int j=0;j<n;j++) {
				mid=mid+l.get(j).substring(map2.get(j), map.get(j)+1);
			}
		
		mid.replace("*","");
		String md="";
		for(char w:mid.toCharArray()) {
			if(w!='*') {
				md=md+w;
			}
		}
		String r="";
		for(char w:res.toCharArray()) {
			r=w+r;
		}
		startRes=startRes+md+r;
		return startRes;
	}
}
