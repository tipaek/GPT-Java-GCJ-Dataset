import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t,acu,x,i,l;
		String cad;
		t = sc.nextInt();
		for(l=1; l<=t; l++){
			cad = sc.next();
			acu = 0;
			System.out.print("Case #" + l + ": ");
			for(i=0; i<cad.length(); i++){
				x = cad.charAt(i) - '0';
				if(acu < x){
					while(acu < x){
						System.out.print("(");
						acu++;
					}
				}
				else{
					while(acu > x){
						System.out.print(")");
						acu--;
					}
				}
				System.out.print(cad.charAt(i));
			}
			x = 0;
			if(acu < x){
				while(acu < x){
					System.out.print("(");
					acu++;
				}
			}
			else{
				while(acu > x){
					System.out.print(")");
					acu--;
				}
			}
			System.out.println();
		}
	}
}