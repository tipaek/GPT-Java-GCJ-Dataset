import java.util.*;
import java.io.*;

public class Solution{
	
	public void solve(int test, Scanner sc){
		int t = sc.nextInt();
		int b = sc.nextInt();
		
		while(t > 0){
			int sameI = -1;
			int diffI = -1;
			
			int[] arr = new int[b+1];
			int len = (b+1)/2;
			
			int iter = 1;
			
			for(int i=1; i<=len; i++){
				if(iter%10 == 1){
					if(sameI > 0){
						System.out.println(sameI);
						int bit = (int)(sc.next().charAt(0)-'0');
						
						boolean changed = false;
						if(bit != arr[sameI]){
							changed = true;
						}
						
						if(changed){
							for(int j=sameI; j<i; j++){
								if(arr[j] == arr[b-j+1]){
									arr[j] = 1-arr[j];
									arr[b-j+1] = 1-arr[b-j+1];
								}
							}
						}
					}
					else{
						System.out.println("1");
						sc.next();
					}
					iter++;
					i--;
				}
				else if(iter%10 == 2){
					if(diffI > 0){
						System.out.println(diffI);
						int bit = (int)(sc.next().charAt(0)-'0');
						
						boolean changed = false;
						if(bit != arr[diffI]){
							changed = true;
						}
						
						if(changed){
							for(int j=diffI; j<i; j++){
								if(arr[j] != arr[b-j+1]){
									arr[j] = 1-arr[j];
									arr[b-j+1] = 1-arr[b-j+1];
								}
							}
						}
					}
					else{
						System.out.println("1");
						sc.next();
					}
					iter++;
					i--;
				}
				else{
					System.out.println(i);
					arr[i] = (int)(sc.next().charAt(0)-'0');
					int sec = b-i+1;
					System.out.println(sec);
					arr[sec] = (int)(sc.next().charAt(0)-'0');
					
					if((sameI < 0) && (arr[i] == arr[sec])){
						sameI = i;
					}
					else if((diffI < 0) && (arr[i] != arr[sec])){
						diffI = i;
					}
					
					iter += 2;
				}
			}
			
			StringBuilder strBuild = new StringBuilder();
			
			for(int i=1; i<=b; i++){
				if(arr[i] == 0){
					strBuild.append("0");
				}
				else{
					strBuild.append("1");
				}
			}
			
			String res = strBuild.toString();
			
			System.out.println(res);
			
			String response = sc.next();
			if(response.equals("N")){
				return;
			}
			
			t--;
		}
	}
	
	public Solution(){
		Scanner sc = new Scanner(System.in);
		int tests = 1;
        
        for(int t=1; t<=tests; t++){
			solve(t, sc);
        }
	}
	
	public static void main(String[] args){
		new Solution();
	}
}