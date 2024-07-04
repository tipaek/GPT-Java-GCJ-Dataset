import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int tNum = sc.nextInt(), tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			String s = sc.next();
			
			StringBuilder result = new StringBuilder();
			
			char[] ch=s.toCharArray();
			int curLevel=0;
			
			for(int i=0;i<ch.length;i++) {

				int cur=Integer.parseInt(String.valueOf(ch[i]));
				
				if(curLevel<cur) {
					for(int j=curLevel;j<cur;j++) {
						result.append("(");
					}
					curLevel=cur;
				}
				
				if(curLevel>cur) {
					for(int j=cur;j<curLevel;j++) {
						result.append(")");
					}
					curLevel=cur;
				}

				result.append(cur);
				
			}
			if(curLevel>0) {
				for(int j=0;j<curLevel;j++) {
					result.append(")");
				}
			}

			
			
			System.out.println(String.format("Case #%d: %s" , tCurr, result));
			
			
		}
		
		System.out.flush();
	}

}