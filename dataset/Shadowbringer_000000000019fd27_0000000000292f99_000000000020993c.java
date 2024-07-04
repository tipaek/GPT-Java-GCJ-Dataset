import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = in.nextInt();
				
		for(int i=1;i<=testCount;i++){
			int matSize = in.nextInt();
			int[] rows = new int[matSize];
			int[] cols = new int[matSize];
			int trace=0,rowF=0,colF=0;
			
			for(int j=0;j<matSize;j++){
				for(int k=0;k<matSize;k++){
					int num = in.nextInt();
					rows[j]+=num;
					cols[k]+=num;
					if(j==k){
						trace+=num;
					}
				}
			}
			int critValue = ((1+matSize)*matSize)>>1;
			for(int val: rows){
				if(val!=critValue){
					rowF++;
				}
			}
			for(int val: cols){
				if(val!=critValue){
					colF++;
				}
			}
			System.out.println("Case #"+i+": "+trace+" "+rowF+" "+colF+"");
		}
	}
}