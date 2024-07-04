import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer pruebas = Integer.parseInt(sc.nextLine());
		for(int i=0;i<pruebas;i++) {
			String[] s = sc.nextLine().split("");
			String res = "";
			Integer unoactivo = 0;
			for(int i2=0; i2<s.length;i2++) {
				if(s[i2].equals("1") && unoactivo==0) {
					res = res + "(1";
					if(i2==s.length-1) {
						res = res + ")";
					}
					unoactivo = 1;
				}else if(s[i2].equals("1") && unoactivo==1) {
					res = res + "1";
					if(i2==s.length-1) {
						res = res + ")";
					}
				}else if(s[i2].equals("0") && unoactivo==1){
					unoactivo = 0;
					res = res + ")0";
				}else {
					res = res + "0";
				}
			}
			System.out.println("Case #" + (i+1) + ": " + res);
			
		}
		sc.close();

	}

}