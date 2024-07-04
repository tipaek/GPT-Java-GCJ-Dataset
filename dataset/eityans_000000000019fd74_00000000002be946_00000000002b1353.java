

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			int N = Integer.parseInt(sc.next());
			System.out.println("Case #"+(t+1)+": ");
			if(N==1){
				System.out.println("1 1");
			}else{
				int tmp = N/2;
				if(N<=998){
					
					for(int i=0; i<tmp; i++){
						System.out.println(""+(i+1)+" "+ (i+1));
						if(i==0 && N%2 == 1)System.out.println("2 1");
					}
					System.out.println(""+(tmp+1)+" "+ (tmp));
				}
				else if(N <= 1000){
					for(int i=0; i<498; i++){
						if(i==3 && N==999)System.out.println("4 3");
						if(i==4 && N==1000)System.out.println("5 4");
						System.out.println(""+(i+1)+" "+ (i+1));
						
					}
					System.out.println(""+(499)+" "+ (498));
				}
			}
			
			
			
			
		}
		
		
		sc.close();
		return;
	}
	

	
}
