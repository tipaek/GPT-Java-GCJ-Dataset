import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		for(int k = 1; k <= t; k++){

			int n = scan.nextInt();
			int r = scan.nextInt();
			

			System.out.print("Case #" + k + ": ");
			
			if(n == 2){
				if(r == 2){

					System.out.println("POSSIBLE");
					System.out.println("1 2");
					System.out.println("2 1");

				}else if(r == 4){

					System.out.println("POSSIBLE");
					System.out.println("2 1");
					System.out.println("1 2");

				}else{

					System.out.println("IMPOSSIBLE");

				}
			}else if(n == 3){
				
				if(r == 3){

					System.out.println("POSSIBLE");
					System.out.println("1 3 2");
					System.out.println("2 1 3");
					System.out.println("3 2 1");

				}else if(r == 6){

					System.out.println("POSSIBLE");
					System.out.println("3 1 2");
					System.out.println("1 2 3");
					System.out.println("2 3 1");

				}else if(r == 9){

					System.out.println("POSSIBLE");
					System.out.println("3 2 1");
					System.out.println("1 3 2");
					System.out.println("2 1 3");

				}else{

					System.out.println("IMPOSSIBLE");

				}
			}else if(n == 4){

				if(r == 4){
					
					System.out.println("POSSIBLE");
					System.out.println("1 2 3 4");
					System.out.println("2 1 4 3");
					System.out.println("3 4 1 2");
					System.out.println("4 3 2 1");
				
				}else if(r == 6){

					System.out.println("POSSIBLE");
					System.out.println("1 2 3 4");
					System.out.println("2 1 4 3");
					System.out.println("3 4 2 1");
					System.out.println("4 3 1 2");

				}else if(r == 7){

					System.out.println("POSSIBLE");
					System.out.println("1 3 2 4");
					System.out.println("4 2 3 1");
					System.out.println("3 4 1 2");
					System.out.println("2 1 4 3");

				}else if(r == 8){

					System.out.println("POSSIBLE");
					System.out.println("2 1 3 4");
					System.out.println("1 2 4 3");
					System.out.println("3 4 2 1");
					System.out.println("4 3 1 2");
				
				}else if(r == 9){

					System.out.println("POSSIBLE");
					System.out.println("3 1 2 4");
					System.out.println("4 2 1 3");
					System.out.println("1 4 3 2");
					System.out.println("2 3 4 1");

				}else if(r == 10){

					System.out.println("POSSIBLE");
					System.out.println("1 2 4 3");
					System.out.println("2 4 3 1");
					System.out.println("4 3 1 2");
					System.out.println("3 1 2 4");
				
				}else if(r == 11){

					System.out.println("POSSIBLE");
					System.out.println("4 1 2 3");
					System.out.println("3 2 1 4");
					System.out.println("1 3 4 2");
					System.out.println("2 4 3 1");

				}else if(r == 12){

					System.out.println("POSSIBLE");
					System.out.println("3 1 2 4");
					System.out.println("1 3 4 2");
					System.out.println("2 4 3 1");
					System.out.println("4 2 1 3");

				}else if(r == 13){

					System.out.println("POSSIBLE");
					System.out.println("4 3 2 1");
					System.out.println("1 2 3 4");
					System.out.println("3 1 4 2");
					System.out.println("2 4 1 3");

				}else if(r == 14){

					System.out.println("POSSIBLE");
					System.out.println("3 4 2 1");
					System.out.println("4 3 1 2");
					System.out.println("2 1 4 3");
					System.out.println("1 2 3 4");

				}else if(r == 16){

					System.out.println("POSSIBLE");
					System.out.println("4 1 2 3");
					System.out.println("1 4 3 2");
					System.out.println("2 3 4 1");
					System.out.println("3 2 1 4");

				}else{

					System.out.println("IMPOSSIBLE");

				}

			}else if(n == 5){

				if(r == 5){

					System.out.println("POSSIBLE");
					System.out.println("1 2 5 4 3");
					System.out.println("3 1 2 5 4");
					System.out.println("4 3 1 2 5");
					System.out.println("5 4 3 1 2");
					System.out.println("2 5 4 3 1");

				}else if(r == 7){

					System.out.println("POSSIBLE");
					System.out.println("1 2 3 5 4");
					System.out.println("5 1 2 4 3");
					System.out.println("2 4 1 3 5");
					System.out.println("4 3 5 2 1");
					System.out.println("3 5 4 1 2");

				}else if(r == 8){

					System.out.println("POSSIBLE");
					System.out.println("2 1 3 5 4");
					System.out.println("5 2 1 4 3");
					System.out.println("1 4 2 3 5");
					System.out.println("4 3 5 1 2");
					System.out.println("3 5 4 2 1");

				}else if(r == 9){

					System.out.println("POSSIBLE");
					System.out.println("1 3 2 5 4");
					System.out.println("5 1 3 4 2");
					System.out.println("3 4 1 2 5");
					System.out.println("4 2 5 3 1");
					System.out.println("2 5 4 1 3");

				}else if(r == 10){

					System.out.println("POSSIBLE");
					System.out.println("2 1 5 4 3");
					System.out.println("3 2 1 5 4");
					System.out.println("4 3 2 1 5");
					System.out.println("5 4 3 2 1");
					System.out.println("1 5 4 3 2");

				}else if(r == 11){

					System.out.println("POSSIBLE");
					System.out.println("3 1 2 5 4");
					System.out.println("5 3 1 4 2");
					System.out.println("1 4 3 2 5");
					System.out.println("4 2 5 1 3");
					System.out.println("2 5 4 3 1");

				}else if(r == 12){

					System.out.println("POSSIBLE");
					System.out.println("2 3 1 5 4");
					System.out.println("5 2 3 4 1");
					System.out.println("3 4 2 1 5");
					System.out.println("4 1 5 3 2");
					System.out.println("1 5 4 2 3");

				}else if(r == 13){

					System.out.println("POSSIBLE");
					System.out.println("3 2 1 5 4");
					System.out.println("5 3 2 4 1");
					System.out.println("2 4 3 1 5");
					System.out.println("4 1 5 2 3");
					System.out.println("1 5 4 3 2");

				}else if(r == 14){

					System.out.println("POSSIBLE");
					System.out.println("2 4 1 5 3");
					System.out.println("5 2 4 3 1");
					System.out.println("4 3 2 1 5");
					System.out.println("3 1 5 4 2");
					System.out.println("1 5 3 2 4");

				}else if(r == 15){

					System.out.println("POSSIBLE");
					System.out.println("3 2 5 4 1");
					System.out.println("1 3 2 5 4");
					System.out.println("4 1 3 2 5");
					System.out.println("5 4 1 3 2");
					System.out.println("2 5 4 1 3");

				}else if(r == 16){

					System.out.println("POSSIBLE");
					System.out.println("4 2 1 5 3");
					System.out.println("5 4 2 3 1");
					System.out.println("2 3 4 1 5");
					System.out.println("3 1 5 2 4");
					System.out.println("1 5 3 4 2");

				}else if(r == 17){

					System.out.println("POSSIBLE");
					System.out.println("3 4 1 5 2");
					System.out.println("5 3 4 2 1");
					System.out.println("4 2 3 1 5");
					System.out.println("2 1 5 4 3");
					System.out.println("1 5 2 3 4");

				}else if(r == 18){

					System.out.println("POSSIBLE");
					System.out.println("4 3 1 5 2");
					System.out.println("5 4 3 2 1");
					System.out.println("3 2 4 1 5");
					System.out.println("2 1 5 3 4");
					System.out.println("1 5 2 4 3");

				}else if(r == 19){

					System.out.println("POSSIBLE");
					System.out.println("3 5 1 4 2");
					System.out.println("4 3 5 2 1");
					System.out.println("5 2 3 1 4");
					System.out.println("2 1 4 5 3");
					System.out.println("1 4 2 3 5");

				}else if(r == 20){

					System.out.println("POSSIBLE");
					System.out.println("4 2 5 1 3");
					System.out.println("3 4 2 5 1");
					System.out.println("1 3 4 2 5");
					System.out.println("5 1 3 4 2");
					System.out.println("2 5 1 3 4");	

				}else if(r == 21){

					System.out.println("POSSIBLE");
					System.out.println("5 3 1 4 2");
					System.out.println("4 5 3 2 1");
					System.out.println("3 2 5 1 4");
					System.out.println("2 1 4 3 5");
					System.out.println("1 4 2 5 3");

				}else if(r == 22){

					System.out.println("POSSIBLE");
					System.out.println("4 5 1 3 2");
					System.out.println("3 4 5 2 1");
					System.out.println("5 2 4 1 3");
					System.out.println("2 1 3 5 4");
					System.out.println("1 3 2 4 5");

				}else if(r == 23){
				
					System.out.println("POSSIBLE");
					System.out.println("5 4 1 3 2");
					System.out.println("3 5 4 2 1");
					System.out.println("4 2 5 1 3");
					System.out.println("2 1 3 4 5");
					System.out.println("1 3 2 5 4");

				}else if(r == 25){

					System.out.println("POSSIBLE");
					System.out.println("5 2 1 4 3");
					System.out.println("3 5 2 1 4");
					System.out.println("4 3 5 2 1");
					System.out.println("1 4 3 5 2");
					System.out.println("2 1 4 3 5");

				}else{
					System.out.println("IMPOSSIBLE");
				}

			}

		}

	}
}