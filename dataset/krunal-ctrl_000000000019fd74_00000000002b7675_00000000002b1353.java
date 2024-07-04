import java.util.Scanner;
class Solution{
	public static void main(String[] args){
		Scanner in=new Scanner (System.in);
		int T=in.nextInt();
		for(int t=1;t<=T;t++){
			int rows=in.nextInt();
			System.out.println("Case #"+t+": ");
			int sum=0;
			for(int i =0;i<rows;i++) {
            int number = 1;
            for(int j=0;j<=i;j++) {
				 if((number+sum)<=rows){  
				 	System.out.println((i+1)+" "+(j+1));
					sum+=number;
					}
				 number = number * (i - j) / (j + 1);             
            }
				
			}		
			
		}
	}
}