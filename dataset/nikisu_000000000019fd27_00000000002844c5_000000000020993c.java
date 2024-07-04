import java.util.*; 

class vestigium {

	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		
		int cases  = input.nextInt(); 

		for(int i=0; i<cases; i++) {
			int s = input.nextInt(); 
			int[][] frame = new int [s][s]; 
			int trace = 0; 
			int rowsR = 0; 
			int colsR = 0;
			
			for(int x=0; x<s; x++) {
				ArrayList<Integer> rowR = new ArrayList<Integer>(); 
				boolean rowCounted = false; 
				for(int y=0; y<s; y++) {
					frame[x][y] = input.nextInt(); 
					if(rowR.contains(new Integer(frame[x][y]))==true&& rowCounted==false) {
						rowsR++;
						rowCounted = true;
					}else if(rowR.contains(new Integer(frame[x][y]))==false&&rowCounted==false){
						rowR.add(new Integer(frame[x][y])); 
					}
					if(y==x) trace+=frame[x][y];
				}
				
			}
			
			for(int x=0; x<s; x++) {
				ArrayList<Integer> colR = new ArrayList<Integer>(); 
				for(int y=0; y<s; y++) {
					if(colR.contains(new Integer(frame[y][x]))==true) {
						colsR++;
						break;
					}else {
						colR.add(new Integer(frame[y][x])); 
					} 
				}
				
			}
			
			System.out.println("Case #"+(i+1)+": "+trace+" "+rowsR+" "+colsR);
			
			
		}
	}
}
