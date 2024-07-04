import java.util.*;
                 
public class Solution{
     public static void main(String[] args) {		 
     Scanner in = new Scanner(System.in);
	 String data = in.nextLine();
	 int T = 0, b = 0;
	 StringBuilder tb = new StringBuilder();
	 for(char ch: data.toCharArray()){
		 if(ch-'0' >= 0 && ch-'0' < 10)
			 tb.append(ch);
		 else if(tb.length() > 0){
			 if(T == 0){
				 T = Integer.parseInt(tb.toString());     //System.out.println(T+"  #"+ch+"& ... "+tb.toString());
				 tb.setLength(0);
			 }
			 else{
				 b = Integer.parseInt(tb.toString());    //System.out.println(b+"  |"+ch+"| ... "+tb.toString());
				 break;
			 }
		 }
	 }
	 if(b == 0)
		 b = Integer.parseInt(tb.toString());

     for(int cas = 1; cas <= T; cas++){
		int[] arr = new int[b+1];
		Arrays.fill(arr, -5);
		int cnt = 0;
		String str = " ";
		int reponse = -1,  feedback = -1;
		int mark1 = -1,  mark2 = -1;
		
		for(int i = 1; i <= b/2; i++){
			if(cnt > 0 && cnt % 10 == 0){
				reponse = -1;  feedback = -1;
				if(mark1 != -1){
				    System.out.println(mark1);
					str = in.next();
					if(str.charAt(0) != 'N')
				        reponse = str.charAt(0) - '0';
					cnt++;
				}
				if(mark2 != -1){					
				    System.out.println(mark2);
					str = in.next();
					if(str.charAt(0) != 'N')
				        feedback = str.charAt(0) - '0';
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
			str = in.next();
			if(str.charAt(0) != 'N')
			    reponse = str.charAt(0) - '0';
			arr[i] = reponse;
			System.out.println(b-i+1);
			str = in.next();
			if(str.charAt(0) != 'N')
			    reponse = str.charAt(0) - '0';
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
		String res = in.next();
		if(res.charAt(0) == 'N')
			System.exit(0);
	 }
	 }
	 
	 static void reverse(int[] arr){
		 int n = arr.length,  temp = -1;
		 for(int i = 1; i <= n/2; i++){
			 if(arr[i] == -5)
				 return;
			 temp = arr[i];
			 arr[i] = arr[n-i];
			 arr[n-i] = temp;
		 }
	 }
	 static void compliment(int[] arr){
		 int n = arr.length;
		 for(int i = 1; i <= n/2; i++){
			 if(arr[i] == -5)
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
			 
			
			