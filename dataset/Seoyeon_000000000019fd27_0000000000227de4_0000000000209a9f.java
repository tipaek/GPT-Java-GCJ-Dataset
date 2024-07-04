import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		String n[] = new String[t];
		String re="";
		int max[]= new int[t];
		int num[][] = new int[t][101];
		int b=0, a=0, se=0, m=0, hi=0;
		int stop[]= new int[t];
		int count[]= new int[t];
		for(int i=0; i<t; i++) {
			n[i] = scanner.next();
			for(int j=0; j<n[i].length(); j++) { 
				num[i][j] =  Character.getNumericValue(n[i].charAt(j));
				if(num[i][j]>0) stop[i] = 1;
				if(stop[i] !=1) count[i]++;
			}
		}
		
		for(int i=0; i<t; i++) {
			System.out.print("Case #"+(i+1)+": ");
			for(int j=0;j<n[i].length(); j++) {
				if(j<count[i]) System.out.print(num[i][j]);
				else {
					if(hi==0) se = num[i][j];
					else se = num[i][j]-num[i][j-1];
					if(se<0) se=0;
					for(int k=0; k<se; k++) {
						re = re+"(";
					}
					re = re+num[i][j];
					
					if(num[i][j]!=0) hi++;
					else hi=0;
					
					if(j == n[i].length()-1) se = num[i][j];
					else se = num[i][j]-num[i][j+1];
					if(se<0) se=0;
					for(int k=0; k<se; k++) {
						re = re+")";
					}
					
				}
			}
			hi=0;
			System.out.println(re);
			re = "";
		}
	}
}
			
	
