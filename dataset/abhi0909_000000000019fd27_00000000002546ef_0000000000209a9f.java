import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;

		int t = sc.nextInt();
		int num = 1;
		
		while(t-- > 0) {
			
			String str = sc.next();
			
			LinkedList<String> list = new LinkedList<String>();
			
			for(int i=0; i<str.length(); i++) {
				
				int temp = Integer.parseInt(Character.toString(str.charAt(i)));
				Integer index = temp;
				while(temp-- > 0) {
					list.addLast("(");
				}
				
				list.addLast(index.toString());
				
				while(index-- > 0) {
					list.addLast(")");
				}
			}
			
			//System.out.println(list);
			int i =1 ;
			while(i < list.size()) {
				
				if(list.get(i).equals("(") && list.get(i-1).equals(")")) {
					list.remove(i);
					i--;
					list.remove(i);
					i--;
				}else {
					i++;
				}
			}
			
			//System.out.println(list);
			StringBuilder res = new StringBuilder();
			
			for(int j=0; j<list.size(); j++) {
				res.append(list.get(j));
			}
			
			System.out.println("Case #"+ num+": "+res.toString());
			num++;
		}
	}

}
