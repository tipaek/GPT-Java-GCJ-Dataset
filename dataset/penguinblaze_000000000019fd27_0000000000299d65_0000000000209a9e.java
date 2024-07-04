import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        if(B != 10){
		    System.exit(0);
		}
		for(int t = 1; t<=T; t++){
		    String solution = "";
		    
		    for(int i = 1; i <= 10; i++){
		        System.out.println(i);
		        solution += in.nextInt();
		    }
		    System.out.println(solution);
		    char next = in.next().charAt(0);
		    if(next == 'N'){
		        System.exit(0);
		    }
		}
    }
}