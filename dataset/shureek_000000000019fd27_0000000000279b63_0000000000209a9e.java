import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		int b = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			
			int qCount=b/10+b+1;
			char[] answer = new char[b];
			
			for(int i=1;i<=qCount;i++) {
				if((i % 10)==1) {
					System.out.println("1");
					System.out.flush();
					sc.nextInt();
					continue;
				} else {
					int curBit = i-1-((i-1)/10);
					System.out.println(curBit);
					System.out.flush();
					answer[curBit-1] = (char)(sc.nextInt()+'0');
				}
			}

			String result = new String(answer);
			System.out.println(answer);
			System.out.flush();
			
			String isCorrect = sc.next();
			
			if(isCorrect.equals("N")) {
				break;
			}
			
			
		}
		
		System.out.flush();
	}
	
	

}
