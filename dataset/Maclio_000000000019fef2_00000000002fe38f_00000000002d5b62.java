import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i=1; i<=T; i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			scanner.nextLine();
			
			boolean xNeg = false;
			boolean yNeg = false;
			if(x<0){
				xNeg = true;
				x = Math.abs(x);
			}
			if(y<0){
				yNeg = true;
				y = Math.abs(y);
			}
			
			String xBin = "";
			String yBin = "";
			
			int a = x;
			while(a>0){
				xBin += a%2;
				a = a/2;
			}
			a = y;
			while(a>0){
				yBin += a%2;
				a = a/2;
			}
			
			//System.out.println(xBin);
			String answer = "";
			int l = Math.min(xBin.length(), yBin.length());
			int L = Math.max(xBin.length(), yBin.length());
			
			for(int j=l; j<L; j++){
				if(x<y){
					xBin += '0';
				}
				else{
					yBin += '0';
				}
			}
			
			//System.out.println(xBin + " " + yBin);
			String aux = xBin;
			
			boolean reverseNegX = false;
			boolean reverseNegY = false;
			if(!Compatible(xBin, yBin)){
				
				xBin = Complement(xBin, xBin.length());
				yBin+='0';
				L++;
				xNeg = !xNeg;
				reverseNegX = true;
			}
			
			//System.out.println(xBin + " " + yBin);
			
			if(!Compatible(xBin, yBin)){
				reverseNegX = false;
				xNeg = !xNeg;
				reverseNegY = true;
				yNeg = !yNeg;
				
				yBin = Complement(yBin, yBin.length()-1);
				xBin = aux + '0';
			}
			
			//System.out.println(xBin + " " + yBin);
			
			for(int j=0; j<L; j++){
				if(j==L-1){
					if(reverseNegX){
						xNeg = !xNeg;
					}
					if(reverseNegY){
						yNeg = !yNeg;
					}
				}
				if(xBin.charAt(j)=='1' && yBin.charAt(j)=='0'){
					if(xNeg){
						answer += 'W';
					}
					else{
						answer += 'E';
					}
				}
				else if(xBin.charAt(j)=='0' && yBin.charAt(j)=='1'){
					if(yNeg){
						answer += 'S';
					}
					else{
						answer += 'N';
					}
				}
				else{
					answer = "IMPOSSIBLE";
					break;
				}
			}
			
			
			System.out.println("Case #" + i + ": " + answer);
		}
	}
	
	static boolean Compatible(String a, String b){
		boolean compatible = true;
		for(int j=0;j<a.length();j++){
			if(a.charAt(j)=='1' && b.charAt(j)=='1'){
				compatible = false;
			}
		}
		
		return compatible;
	}
	
	static String Complement(String s, int n){
		String r = "1";	
		for(int j=1; j<n; j++){
			if(s.charAt(j)=='1'){
				r+='0';
			}
			else{
				r+='1';
			}
		}
		r+='1';
	
		return r;
	}
}