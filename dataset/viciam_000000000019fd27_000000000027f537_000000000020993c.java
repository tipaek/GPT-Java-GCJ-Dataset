import java.util.*;

public class Latin {
	int cases [][][];
	
	public Latin(){
		
	}
		
	public String solvePuzzle(int nr, int [][] square){
		int k=0, r=0, c=0;
		HashSet<Integer> rowVisited, colVisited;
		
		for (int i=0; i< square.length; i++){
			rowVisited = new HashSet<Integer>();
			for (int j=0; j< square.length; j++){
				if(rowVisited.contains(square[i][j])){
					r++;
					j= square.length;
				}					
				 else 
					rowVisited.add(square[i][j]);

			}
			k += square[i][i]; 
		}
		for (int i=0; i< square.length; i++){
			colVisited = new HashSet<Integer>();
			for (int j=0; j< square.length; j++){
				if(colVisited.contains(square[j][i])){
					c++;
					j= square.length;
				}
				 else 
					 colVisited.add(square[j][i]);

			}
		}
		return "Case #"+nr+": "+k+" "+r+" "+c;
	}
	public void run(){
		parseInput();
		
		for (int i=0; i< cases.length; i++){
			System.out.println(solvePuzzle(i, cases[i]));
		}
	}
	public void parseInput(){		
		Scanner s= new Scanner(System.in);
		int nrCases = Integer.parseInt(s.nextLine());
		cases = new int[nrCases][][];
		
		for (int i=0; i<nrCases; i++){
			int size = Integer.parseInt(s.nextLine());
			cases[i] = new int[size][size];
			for (int j=0; j< size; j++){
				String[] nrs = s.nextLine().split(" ");
				for (int k=0; k< size; k++){
					cases[i][j][k] =  Integer.parseInt(nrs[k]);
				}
			}
		}
	}
	public static void main(String[] args) {
		(new Latin()).run();
	}

}
