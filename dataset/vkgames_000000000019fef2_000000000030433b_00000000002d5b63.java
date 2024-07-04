import java.util.Scanner;

public class Solution {
	static Scanner sc;
	static boolean center = false;
	static int x,y;
	static int centerX = -1, centerY = -1;
	public static void main(String[] args) {
		 sc= new Scanner(System.in);
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		while(t>0) {
			t--;
			
			for(int i=-5;i<=5;i++){
			    if(center) break;
			    for(int j=-5;j<=5;j++){
			        System.out.println(i+ " " + j);
			        System.out.flush();
			        String s = sc.next();
			        if(s.equals("CENTER")){
			            center = true;
			            break;
			        }
			    }
			}
			if(center) continue;
	
	}
	}
}
