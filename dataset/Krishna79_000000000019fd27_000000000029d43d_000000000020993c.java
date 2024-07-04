import java.util.Scanner;
class CodeJamPro1{	
	public static void main(String...args){
		Scanner sc=new Scanner(System.in);
		int testCases=sc.nextInt();
		boolean isRowRepeated=false;
		boolean isColumnRepeated=false;
		int rowRepeated=0;
		int columnRepeated=0;
		int sum=0;
		for(int i=0;i<testCases;i++){
			int orderOfMatrix=sc.nextInt();
			int matrix[][]=new int[orderOfMatrix][orderOfMatrix];
			for(int j=0;j<orderOfMatrix;j++)
				for(int k=0;k<orderOfMatrix;k++)
					matrix[j][k]=sc.nextInt();
			sum=0;
			rowRepeated=0;
			columnRepeated=0;
			for(int j=0;j<orderOfMatrix;j++){
				sum=sum+matrix[j][j];
				isRowRepeated=false;
				isColumnRepeated=false;
				for(int k=0;k<orderOfMatrix;k++){
					int element=matrix[j][k];
					for(int z=0;z<orderOfMatrix;z++){
						if(element==matrix[j][z]&&k!=z){
							rowRepeated++;
							isRowRepeated=true;
							break;
						}
					}
					if(isRowRepeated==true)break;	
				}
				for(int k=0;k<orderOfMatrix;k++){
					int element=matrix[k][j];
					for(int z=0;z<orderOfMatrix;z++){
						if(element==matrix[z][j]&&k!=z){
							columnRepeated++;
							isColumnRepeated=true;
							break;
						}
					}
					if(isColumnRepeated==true)break;
				}
				
			}
			System.out.println("Case #"+(i+1)+": "+sum+" "+rowRepeated+" "+columnRepeated);
		} 
	}	
}