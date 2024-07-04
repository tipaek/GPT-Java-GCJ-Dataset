import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int index = 1; index <= cases; index++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String recorrido = sc.nextLine().trim();
			int pasos = recorrido.length();
			boolean found = false;
			int result = 0;
			
			for(int i = 1; i <= pasos; i++) {
				switch(recorrido.charAt(i - 1)) {
				case 'N':
					y += 1;
					break;
				case'S':
					y -= 1;
					break;
				case 'E':
					x += 1;
					break;
				case 'W':
					x -= 1;
					break;
				}
				
				if(Math.abs(x) + Math.abs(y) <= i) {
					found = true;
					result = i;
					break;
				}
			}
			
			System.out.println("Case #" + index + ": " + (found ? result : "IMPOSSIBLE"));
		}
		
		sc.close();
	}

}