import java.util.*;

public class Solution {//Code Jam quals 2020, 
	Scanner sc;
	public void applyC(int[] X) {
		for (int i=0; i<X.length; i++)
			if (X[i]==0) X[i]=1;
			else X[i]=0;
	}
	public void applyR(int[] X) {
		for (int i=0; i<X.length/2; i++) {
			int tmp=X[i];
			X[i]=X[X.length-1-i];
			X[X.length-1-i]=tmp;
		}
	}
	public boolean playGame(int B) {
		if (B==10) {
		   StringBuilder answer = new StringBuilder();
		   for (int i=0; i<B; i++) {
			   System.out.println(i+1);
			   answer.append(sc.nextInt());
			   sc.nextLine();
		   }
		   System.out.println(answer.toString());
		   String reply = sc.nextLine();
		   if (reply.equals("Y")) return true;
		   else return false;
		}
		if (B==20) {
			int [] inter = new int[10];
			int [] exter = new int [10];
			int palind_i=-1;
			int palind_e=-1;
			int antind_i=-1;
			int antind_e=1;
			for (int i=0; i<5; i++) {
				System.out.println(i+1);
				exter[i]=sc.nextInt();
				sc.nextLine();
				System.out.println(B-i);
				exter[B/2-1-i]=sc.nextInt();
				sc.nextLine();
				if ((exter[i]==exter[B/2-1-i])&&(palind_e==-1)) palind_e=i;
				if ((exter[i]!=exter[B/2-1-i])&&(antind_e==-1)) antind_e=i;
			}
			for (int i=0; i<5; i++) {
				System.out.println(B/4+i+1);
				inter[i]=sc.nextInt();
				sc.nextLine();
				System.out.println(15-i);
				inter[B/2-1-i]=sc.nextInt();
				sc.nextLine();
				if ((inter[i]==inter[B/2-1-i])&&(palind_i==-1)) palind_i=i;
				if ((inter[i]!=inter[B/2-1-i])&&(antind_i==-1)) antind_i=i;
			}
			// Check what happens to exterior
			if ((palind_e==-1)||(antind_e==-1)) {
				   System.out.println(1);
				   int tmp=sc.nextInt();
				   sc.nextLine();
				   if (tmp!=exter[0]) applyC(exter);
			} else {
				boolean needC=false;
				boolean needR=false;
				System.out.println(palind_e+1);
				int tmp=sc.nextInt();
				sc.nextLine();
				if (tmp!=exter[palind_e]) needC=true;
				System.out.println(antind_e+1);
				tmp=sc.nextInt();
				sc.nextLine();
				if (((needC)&&(tmp==exter[antind_e])) || ((!needC)&&(tmp!=exter[antind_e]))) needR=true;
				if (needC) applyC(exter);
				if (needR) applyR(exter);
			}
			// Check what happens to interior
						if ((palind_i==-1)||(antind_i==-1)) {
							   System.out.println(6);
							   int tmp=sc.nextInt();
							   sc.nextLine();
							   if (tmp!=inter[0]) applyC(inter);
						} else {
							boolean needC=false;
							boolean needR=false;
							System.out.println(palind_i+6);
							int tmp=sc.nextInt();
							sc.nextLine();
							if (tmp!=exter[palind_i]) needC=true;
							System.out.println(antind_i+6);
							tmp=sc.nextInt();
							sc.nextLine();
							if (((needC)&&(tmp==inter[antind_i])) || ((!needC)&&(tmp!=inter[antind_i]))) needR=true;
							if (needC) applyC(inter);
							if (needR) applyR(inter);
						}
						//produce result
						StringBuilder answer = new StringBuilder();
						for (int i=0; i<5; i++) answer.append(exter[i]);
						for (int i=0; i<10; i++) answer.append(inter[i]);
						for (int i=5; i<10; i++) answer.append(exter[i]);
						System.out.println(answer.toString());
						String reply = sc.nextLine();
						if (reply.equals("Y")) return true;
						else return false;
						
		}
		return false;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		int B=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			boolean res = sol.playGame(B);
			if (!res) return;
		}
		
		 
	}
}
