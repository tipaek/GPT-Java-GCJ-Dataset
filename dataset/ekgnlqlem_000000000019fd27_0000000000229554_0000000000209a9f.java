import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int c = 1; c <= T; c++){
            String S = input.next();
            int[] arr = new int[S.length()];
			for(int i = 0; i < S.length(); i++){
				arr[i] = S.charAt(i)-'0';
			}
            StringBuilder sb = new StringBuilder();
			
            for(int i = 0; i < arr.length; i++){
				if(arr.length == 1){
					int par = arr[i];
					while(par-- > 0) sb.append("(");
					sb.append(arr[i]);
					par = arr[i];
					while(par-- > 0) sb.append(")");
				}
				else if(i == 0){
					int open = arr[i];
					while(open-- > 0) sb.append("(");
					sb.append(arr[i]);
					if(arr[i] > arr[i+1]){
						int diff = arr[i] - arr[i+1];
						while(diff-- > 0) sb.append(")");
					}
				}
				else if(i == arr.length-1){
					if(arr[i] > arr[i-1]){
						int diff = arr[i] - arr[i-1];
						while(diff-- > 0) sb.append("(");
					}
					sb.append(arr[i]);
					int close = arr[i];
					while(close-- > 0) sb.append(")");
					
				}
				else{
					if(arr[i] > arr[i-1]){
						int diff = arr[i] - arr[i-1];
						while(diff-- > 0) sb.append("(");
					}
					sb.append(arr[i]);
					if(arr[i] > arr[i+1]){
						int diff = arr[i] - arr[i+1];
						while(diff-- > 0) sb.append(")");
					}
				}
			}
			
            System.out.println("Case #"+c+": "+sb.toString());
        }
    }
}