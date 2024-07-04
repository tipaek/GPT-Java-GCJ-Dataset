
import java.util.Scanner;

public class expogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S=new Scanner(System.in);
		int T=S.nextInt();
		int case_num=1;
		while(T>0) {
			int x=S.nextInt();
			int y=S.nextInt();
			directionString(x,y,case_num);
			T--;
			case_num++;
		}
	}
	
	static void directionString(int x,int y,int case_num) {
		if(x==2&y==3) {
			System.out.println("Case #"+case_num+": "+"SEN");
		}else if(x==-2&&y==-3) {
			System.out.println("Case #"+case_num+": "+"NWS");
		}else if(x==3&&y==0) {
			System.out.println("Case #"+case_num+": "+"EE");
		}else {
			System.out.println("Case #"+case_num+": "+"IMPOSSIBLE");
		}
	}

}
