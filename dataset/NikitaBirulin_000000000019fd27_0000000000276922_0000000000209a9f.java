import java.util.*;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		sc.nextLine();
		
		String str[] = new String[cnt];
		
		for (int i = 0; i < cnt; i++) {
			
			str[i] = sc.nextLine();
			
		}
		
		for (int i = 0; i < cnt; i++) {
			
			String srtd = "Case #"+ (i + 1) + ": " + answ(str[i], 0);
			
			for (int e = 0; e <= 9; e++) {
				
				srtd = srtd.replace(")(", "");
				
			}
			
			System.out.println(srtd);
			
		}
		
	}
	
	public static String answ(String str, int pos) {
		
		if (str.length() <= pos) return "";
		
		StringBuffer rtd = new StringBuffer();
		
		switch (str.charAt(pos)) {
			
			case ('0'): rtd.append("0"); break;
			case ('1'): rtd.append("(1)"); break;
			case ('2'): rtd.append("((2))"); break;
			case ('3'): rtd.append("(((3)))"); break;
			case ('4'): rtd.append("((((4))))"); break;
			case ('5'): rtd.append("(((((5)))))"); break;
			case ('6'): rtd.append("((((((6))))))"); break;
			case ('7'): rtd.append("(((((((7)))))))"); break;
			case ('8'): rtd.append("((((((((8))))))))"); break;
			case ('9'): rtd.append("(((((((((9)))))))))"); break;
			
		}
		
		return rtd.append(answ(str, pos + 1)).toString();
		
	}

}