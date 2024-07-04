import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLine=0;
		LinkedList<String> lines=new LinkedList<String>();
		String line;
		while(sc.hasNextLine()) {
			line=sc.nextLine();
			if(numLine>0) {
				lines.add(line);
			}
			numLine++;
		}
		sc.close();
		for(int i=0; i<lines.size(); i++) {
			int totalPar=0;
			String strRetour="";
			char[] charArrLine=lines.get(i).toCharArray();
			for(char numChar : charArrLine) {
				int num=Integer.parseInt(String.valueOf(numChar));
				while(num<totalPar) {
					strRetour+=")";
					totalPar--;
				}
				while(num>totalPar) {
					strRetour+="(";
					totalPar++;
				}
				strRetour+=numChar;
			}
			while(0<totalPar) {
				strRetour+=")";
				totalPar--;
			}
			System.out.println("Case #"+(i+1)+": "+strRetour);
		}
	}

}
