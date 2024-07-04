package codeJamA;
import java.util.*; 

class Cell {
	  Set<Integer> hash_Set = new HashSet<Integer>();
	}
class ProblemA {

	public static void main(String[] args) {
		
		Scanner tmp = new Scanner(System.in);
		
		int T=tmp.nextInt();
		for (int i=1;i<=T;i++) {
			
			int k=0,r=0,c=0;
			int N=tmp.nextInt();
			
			Cell[] rows = new Cell[N];
			Cell[] columns = new Cell[N];
			
			for(int j=0;j<N;j++) {
				rows[j]=new Cell();
			}
			for (int l=0;l<N;l++) {
				columns[l]=new Cell();
			}
			for(int j=0;j<N;j++) {
				for (int l=0;l<N;l++) {
					int current=tmp.nextInt();
					if(j==l) {
						k+=current;
					}
					
					rows[j].hash_Set.add(current);
					columns[l].hash_Set.add(current);
				}
			}
			
			for(int j=0;j<N;j++) {
				if(rows[j].hash_Set.size()<N)
					r++;
			}
			for (int l=0;l<N;l++) {
				if(columns[l].hash_Set.size()<N)
					c++;
			}	
				
			System.out.println("Case #"+i+":"+k+" "+r+" "+c+" ");
		}
		
		tmp.close();
	}

}
