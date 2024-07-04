import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = in.nextInt();
				
		for(int i=1;i<=testCount;i++){
			int matSize = in.nextInt();
			Set[] rows = new Set[matSize];
			Set[] cols = new Set[matSize];
			int trace=0,rowF=0,colF=0;
			
			for(int count=0;count<matSize;count++){
				rows[count] = new HashSet<Integer>();
			}
			for(int count=0;count<matSize;count++){
				cols[count] = new HashSet<Integer>();
			}
			for(int j=0;j<matSize;j++){
				for(int k=0;k<matSize;k++){
					int num = in.nextInt();
					rows[j].add(num);
					cols[k].add(num);
					if(j==k){
						trace+=num;
					}
				}
			}
			for(Set val: rows){
				if(val.size()!=matSize){
					rowF++;
				}
			}
			for(Set val: cols){
				if(val.size()!=matSize){
					colF++;
				}
			}
			System.out.println("Case #"+i+": "+trace+" "+rowF+" "+colF+"");
		}
	}
}