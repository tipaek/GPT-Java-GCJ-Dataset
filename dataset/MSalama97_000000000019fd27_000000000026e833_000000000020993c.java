import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner; 


class p1 {
	public static int getR(int[][] input) {
		int res = 0;
		for(int i  = 0 ; i<input.length ; i++) {
			res+= input[i][i] ;
		}
			return res ;	
	}
	public static int getRRep(int[][] input) {
		int res = 0;
		ArrayList<Integer> passed = new ArrayList<Integer>();
		for(int i  = 0 ; i<input.length ; i++) {
			for(int j = 0 ; j<input[i].length;j++) {
				if(passed.contains(input[i][j])) {
					res+=1 ;
					break;
				}
				else {
					passed.add(input[i][j]) ;
				}
			}
			passed = new ArrayList<Integer>();
	}
		return res;
}
	public static int getCRep(int[][] input) {
		int res = 0;
		ArrayList<Integer> passed = new ArrayList<Integer>();
		for(int i  = 0 ; i<input.length ; i++) {
			for(int j = 0 ; j<input.length;j++) {
				
				if(passed.contains(input[j][i])) {
					res+=1 ;
					break;
				}
				else {
					passed.add(input[j][i]) ;
				}
			}
			passed = new ArrayList<Integer>();
			
	}
		return res;
}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String res = "";
		int numberOfCases = Integer.parseInt(sc.next());
		for(int i = 0 ; i<numberOfCases;i++) {
			int size = Integer.parseInt(sc.next());
			int[][] inputCase = new int[size][size];
			//System.out.println("Size = " + size);
			
			for(int i1 = 0 ; i1<size ; i1++) {
				  for(int j = 0 ; j <size ; j++) {
					  inputCase[i1][j] = Integer.parseInt(sc.next());
				  }
					
				
			}
			if(i == numberOfCases -1) {
			res += "Case #"+(i+1)+": " + getR(inputCase)+" " + getRRep(inputCase)+" " + getCRep(inputCase);
            System.out.println("Case #"+(i+1)+": " + getR(inputCase)+" " + getRRep(inputCase)+" " + getCRep(inputCase));
			}
			else
		   res += "Case #"+(i+1)+": " + getR(inputCase)+" " + getRRep(inputCase)+" " + getCRep(inputCase) +"\n";
		   System.out.println("Case #"+(i+1)+": " + getR(inputCase)+" " + getRRep(inputCase)+" " + getCRep(inputCase));
		}
		
		
		//System.out.println(res);

	}

}
