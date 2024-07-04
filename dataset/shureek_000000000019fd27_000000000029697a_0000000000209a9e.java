import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		int b = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			
			int qCount=0;
			char[] answer = new char[b];
			

			int indA=0;
			int indB=0;
			int codeType=-1;
			int k=0;
			int round=0;
			
			
			while((qCount*2)<b) {
			
				if(codeType>=0) k=1;
				for(int i=1;i<=5-k;i++) { // find 10 bytes
					System.out.println(qCount+i);
					System.out.flush();
					answer[qCount+i-1] = (char)(sc.nextInt()+'0');
					System.out.println(b+1-i-qCount);
					System.out.flush();
					answer[b-i-qCount] = (char)(sc.nextInt()+'0');
				}
				qCount+=5-k;
				
				//System.out.println("before"+qCount);
				if(qCount*2>=b) break;
				//System.out.println("after"+b);
				
				
				if(codeType<2) {
					//find maximal different combination 01-00,01-11
				
					if(answer[0]==answer[b-1]) {
						codeType=0;
					} else codeType=1;
						
					for(int i=1+1;i<=(5+4*round);i++) {
						if(answer[i-1]==answer[b-i]) {
							if(codeType==0) {
								continue;
							} else {
								indB=i-1;
								codeType=3;
								break;
							}
						} else {
							if(codeType==1) {
								continue;
							} else {
								indB=i-1;
								codeType=2;
								break;
							}
						}
					}		
				}
	
				// test
				System.out.println(indA+1);
				System.out.flush();
				char testA = (char)(sc.nextInt()+'0');
				System.out.println(indB+1);
				System.out.flush();
				char testB = (char)(sc.nextInt()+'0');
				
				switch (codeType) {
		           case 0:
		           		{
		           			if(testA!=answer[indA]) {
		           				not(answer,(5+round*4));
		           			}
		           		}
	              
		                break;
		           case 1:
		          		{
		           			if(testA!=answer[indA]) {
		           				not(answer,(5+round*4));
		           			}
		           		}
		               
		                break;
		           case 2:
		          		{
		           			if((testA!=answer[indA])&&(testB!=answer[indB])) {
		           				not(answer,(5+round*4));
		           			} else if((testA==answer[indA])&&(testB!=answer[indB])) {
		           				change(answer,(5+round*4));
		           			} else if((testA!=answer[indA])&&(testB==answer[indB])) {
		           				notChange(answer,(5+round*4));
		           			} 
		           		}
	
		                break;
		           case 3:
		         		{
		          			if((testA!=answer[indA])&&(testB!=answer[indB])) {
		          				not(answer,(5+round*4));
		          			} else if((testA!=answer[indA])&&(testB==answer[indB])) {
		          				change(answer,(5+round*4));
		          			} else if((testA==answer[indA])&&(testB!=answer[indB])) {
		          				notChange(answer,(5+round*4));
		          			} 
		          		}
		
		                break;	               
		       }				
					
				
				round++;

				
			
			}
			
			
			
			//String result = new String(answer);
			System.out.println(answer);
			System.out.flush();
			
			String isCorrect = sc.next();
			
			if(isCorrect.equals("N")) {
				break;
			}
			
			
		}
		
		System.out.flush();
	}
	
	static void not(char[] str, int bytes) {
		int back=str.length-1;
		for(int i=0;i<bytes;i++) {
			str[i]=((str[i]=='1')?'0':'1');
			str[back-i]=((str[back-i]=='1')?'0':'1');
		}
	}
	
	static void change(char[] str, int bytes) {
		int back=str.length-1;
		for(int i=0;i<bytes;i++) {
			char temp=str[i];
			str[i]=str[back-i];
			str[back-i]=temp;
		}
	}

	static void notChange(char[] str, int bytes) {
		int back=str.length-1;
		for(int i=0;i<bytes;i++) {
			char temp=((str[i]=='1')?'0':'1');
			str[i]=((str[back-i]=='1')?'0':'1');
			str[back-i]=temp;
		}
	}
	

}