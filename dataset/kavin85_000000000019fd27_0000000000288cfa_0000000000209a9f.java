import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
        	String content = input.next();
        	String output="";
        	int already=0;
        	for(int i=0;i<content.length();i++){
        		int t=Character.getNumericValue(content.charAt(i));
        		if(already<t){
	        		for(int k=already;k<t;k++){
	        			output+="(";
	        		}
	        		output+=t;
	        		already+=(t-already);
        		}else if(already>t){
        			for(int k=already-t;k>0;k--){
	        			output+=")";
	        		}
        			output+=t;
	        		already-=(already-t);
        		}else{
        			output+=t;
        		}
        	}
        	for(int i=0;i<already;i++){
        		output+=")";
        	}
        	
        	System.out.printf("Case #%d: "+output, n + 1);
        	System.out.println();
        }
    }
}