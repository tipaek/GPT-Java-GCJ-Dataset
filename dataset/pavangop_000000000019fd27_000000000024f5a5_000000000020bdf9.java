import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		
		for (int i=0;i<cases;i++){
			int tasks = scanner.nextInt();
			int cS=0;
			int cE=0;
			int jS=0;
			int jE=0;
			String ans="";
			ArrayList<Integer[]> ansAlist= new ArrayList<Integer[]>();
			boolean flag=true;
			for(int j=0;j<tasks;j++) {
				int tS = scanner.nextInt();
				int tE = scanner.nextInt();
				Integer[] t = {tS,tE,j,-1};
				ansAlist.add(t);
			}
			ansAlist.sort((o1, o2) -> o1[0].compareTo(o2[0]));
			
			for(int k=0;k<tasks;k++){
				int tS = ansAlist.get(k)[0];
				int tE = ansAlist.get(k)[1];
				 if((tS<=cS && tE<cS)||(tS>=cE && tE>cE)){
				 	ansAlist.get(k)[3] = 1;
					cS = tS;
					cE = tE;
				} else if((tS<=jS && tE<jS)||(tS>=jE && tE>jE)){
					ansAlist.get(k)[3] = 2;
					jS = tS;
					jE = tE;
				} else {
				flag = false;
				}
			}
			
			if(flag){
				ansAlist.sort((o1, o2) -> o1[2].compareTo(o2[2]));
				for(Integer[] r: ansAlist){
					ans+= (r[3]==1?"C":"J");
				}
				System.out.println("Case #"+(i+1)+": "+ans);
			} else {
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}
				
		}
		scanner.close();
	}

}
