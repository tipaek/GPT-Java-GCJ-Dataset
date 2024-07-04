import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution {
	
	static int[] data;
	static int B;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		
		int T = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=T; i++){
			
			data = new int[B];
			int totalQueries = 0;
			int k1 = -1, k2 = -1;
			
			for(int j=0; j<B/2; j++){

				System.out.println(j+1);
				data[j] = Integer.parseInt(scanner.nextLine());
				System.out.println(B-j);
				data[B-1-j] = scanner.nextInt();
				
				totalQueries+=2;
				
				if(data[j] == data[B-1-j] && k1 == -1){
					k1 = j;
					//System.out.println("k1 = " + k1);
				}
				if(data[j] != data[B-1-j] && k2 == -1){
					k2 = j;
					//System.out.println("k2 = " + k2);
				}
					
				//printData();
				
				if(totalQueries%10 <=1 && totalQueries>0){
				
					boolean x1 = true, x2 = true;
					
					if(k1!=-1){
						System.out.println(k1+1);
						x1 = (scanner.nextInt()!=data[k1]);
						totalQueries++;
						
					}
					if(k2!=-1){
						System.out.println(k2+1);
						x2 = (scanner.nextInt()!=data[k2]);
						totalQueries++;
					}
					
					if(k1!=-1 && k2!=-1){
						if(x1 && x2){
							complement();
						}
						else if(x1 && !x2){
							complement();
							flip();
						}
						else if(!x1 && x2){
							flip();
						}
						
					}
					else{
						if(k1!=-1 && x1){
							complement();
						}
						if(k2!=-1 && x2){
							flip();
						}
					}
					
					//printData();
				}
				
				if(totalQueries > 145){
					break;
				}
				
				
			}
			
			printData();

		}
	}
	
	static void flip(){
		for(int i=0; i<B/2; i++){
			int aux = data[i];
			data[i] = data[B-1-i];
			data[B-1-i] = aux;
		}
	}
	
	static void complement(){
		for(int i=0; i<B; i++){
			data[i] = 1-data[i];
		}
	}
	
	static void printData(){
		for(int i=0; i<B; i++){
			System.out.print(data[i]);
		}
		System.out.println();
	}
	
	
}
