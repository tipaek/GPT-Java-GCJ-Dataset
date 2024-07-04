public class sameArray {
	static int column=0;
	static int row=0;	
	static int sum=0;
	public static void main (String[] args) {		
		int [][] arr=new int[][]{{1,2,4,5},{1,4,5,2},{4,2,5,1},{5,4,2,1}};
		for(int x=0;x<4;x++){
			for(int y=0;y<3;y++){
				if(arr[x][y]==arr[x][y+1]){
					row=row+1;
					break;
				}
			}
		}
		for(int j=0;j<4;j++){
			for(int i=0;i<3;i++){
				if(arr[i][j]==arr[i+1][j]){
					column=column+1;
					break;
				}
			}
		}
		for (int n=0; n<4; n++) 
        sum += arr[n][n]; 
		System.out.println(sum+" "+column+" "+row);
	}
}
					
				

