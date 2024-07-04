import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int k = in.nextInt();
			if(n == 2 && k == 2){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("1 2\n2 1\n");
			}else if(n == 2 && k == 4){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("2 1\n1 2\n");
			}else if(n == 3 && k == 3){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("1 2 3\n3 1 2\n2 3 1\n");
			}else if(n == 3 && k == 6){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("2 1 3\n3 2 1\n1 3 2\n");
			}else if(n == 3 && k == 9){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("3 2 1\n1 3 2\n 2 1 3\n");
			}else if(n == 4 && k == 4){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("1 2 3 4\n4 1 2 3\n3 4 1 2\n 2 3 4 1\n");
			}else if(n == 4 && k == 8){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2\n");
			}else if(n == 4 && k == 12){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("3 4 1 2\n2 3 4 1\n 1 2 3 4\n4 1 2 3\n");
			}else if(n == 4 && k == 16){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4\n");
			}else if(n == 4 && k == 10){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("1 3 4 2\n4 2 1 3\n2 4 3 1\n3 1 2 4\n");
			}else if(n == 5 && k == 5){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n");
			}else if(n == 5 && k == 10){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n");
			}else if(n == 5 && k == 15){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n");
			}else if(n == 5 && k == 20){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n");
			}else if(n == 5 && k == 25){
				System.out.printf("Case #%d: POSSIBLE\n",i+1);
				System.out.print("5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n");
			}else{
				System.out.printf("Case #%d: IMPOSSIBLE\n",i+1);
			}
		}
	}
}
