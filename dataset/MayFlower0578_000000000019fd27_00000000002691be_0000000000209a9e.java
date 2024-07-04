import java.util.*;
                 
public class Solution{
     public static void main(String[] args) {		 
     Scanner in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		int b = in.nextInt();
		int[] arr = new int[b+1];
		Arrays.fill(arr, -1);
		int cnt = 0;
		int reponse = -1,  feedback = -1;
		int mark1 = -1,  mark2 = -1;
		
		for(int i = 1; i <= b/2; i++){
			if(cnt > 0 && cnt % 10 == 0){
				reponse = -1;  feedback = -1;
				if(mark1 != -1){
				    System.out.println(mark1);
				    reponse = in.nextInt();
					cnt++;
				}
				if(mark2 != -1){					
				    System.out.println(mark2);
				    feedback = in.nextInt();
					cnt++;
				}

				if(reponse == arr[mark1]){
					if(mark2 == -1 || feedback == arr[mark2]){
						//do nothing
					}
					else
						reverse(arr);
				}
				else if(reponse != -1 && reponse != arr[mark1]){
					if(mark2 == -1 || feedback != arr[mark2])
						compliment(arr);
					else
						compliment_reverse(arr);
				}
				else{                                //if mark1 = -1, mark2 would have a value
					if(feedback == arr[mark2]){
						//do nothing
					}
					else
						reverse(arr);
				}
			}
	
			System.out.println(i);
			reponse = in.nextInt();
			arr[i] = reponse;
			System.out.println(b-i+1);
			reponse = in.nextInt();
			arr[b-i+1] = reponse;
			if(mark1 == -1 && arr[i] == arr[b-i+1])
				mark1 = i;
			if(mark2 == -1 && arr[i] != arr[b-i+1])
				mark2 = i;
			cnt += 2; 
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= b; i++)
			sb.append(arr[i]);
		System.out.println(sb.toString());
	 }
	 }
	 
	 static void reverse(int[] arr){
		 int n = arr.length,  temp = -1;
		 for(int i = 1; i <= n/2; i++){
			 if(arr[i] == -1)
				 return;
			 temp = arr[i];
			 arr[i] = arr[n-i];
			 arr[n-i] = temp;
		 }
	 }
	 static void compliment(int[] arr){
		 int n = arr.length;
		 for(int i = 1; i <= n/2; i++){
			 if(arr[i] == -1)
				 return;
			 if(arr[i] == 0)
				 arr[i] = 1;
			 else
				 arr[i] = 0;
			 if(arr[n-i] == 0)
				 arr[n-i] = 1;
			 else
				 arr[n-i] = 0;
		 }
	 }
	 static void compliment_reverse(int[] arr){
		 compliment(arr);
		 reverse(arr);
	 }
}