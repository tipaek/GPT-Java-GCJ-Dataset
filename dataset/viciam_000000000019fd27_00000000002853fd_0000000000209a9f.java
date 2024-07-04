import java.util.*;

public class Solution  {
		int [][] cases;
		public Solution (){
			
		}
			
		public String solvePuzzle(int nr, int [] inputs){
			String result = "";
			int currentDepth = 0;
			for (int i: inputs){
				while(i>currentDepth){
					currentDepth++;
					result = result + "(";
				}
				while(i<currentDepth){
					currentDepth--;
					result = result + ")";
				}
				result = result +i;
			}
			while(0<currentDepth){
				currentDepth--;
				result = result + ")";
			}
			return "Case #"+nr+": "+result;
		}
		
		public void run(){
			parseInput();
			
			for (int i=0; i< cases.length; i++){
				System.out.println(solvePuzzle((i+1), cases[i]));
			}
		}
		public void parseInput(){		
			Scanner s= new Scanner(System.in);
			int nrCases = Integer.parseInt(s.nextLine());
			cases = new int[nrCases][];
			
			for (int i=0; i<nrCases; i++){
				String st = s.nextLine();
				cases[i] = new int[st.length()];
				for (int j=0; j< st.length(); j++){
					cases[i][j] = Integer.parseInt(st.charAt(j)+"");
				}
			}
			s.close();
		}
		public static void main(String[] args) {
			(new Solution ()).run();
		}
	}

