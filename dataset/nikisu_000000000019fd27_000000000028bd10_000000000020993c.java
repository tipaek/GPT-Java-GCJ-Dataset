import java.util.*; 

class vestigium {

	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		
		int c  = input.nextInt(); 

		for(int i=1; i<=c; i++) {
			int s = input.nextInt(); 
			int[][] frame = new int [s][s]; 
			int trace = 0; 
			int rowsR = 0; 
			int colsR = 0;
			
			for(int x=0; x<s; x++) {
				for(int y=0; y<s; y++) {
					frame[x][y] = input.nextInt(); 
					if(y==x) trace+=frame[x][y];
				}
				
			}
			
			for(int x=0; x<s; x++) {
				String rowR =""; 
				for(int y=0; y<s; y++) {
					if(rowR.indexOf(frame[x][y]+" ")>=0) {
						rowsR++;
						break;
					}else {
						rowR+=frame[x][y]+" ";
					} 
					
				}
			}
			
			for(int x=0; x<s; x++) {
				String colR = ""; 
				for(int y=0; y<s; y++) { 
					if(colR.indexOf(frame[y][x]+" ")>=0) {
						colsR++;
						break;
					}else {
						colR+=frame[y][x]+" ";
					} 
				}
				
			}
			
			System.out.println("Case #"+i+": "+trace+" "+rowsR+" "+colsR);
			
			
		}
		input.close(); 
	}
}
