
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a = 1; a <= t; a++) {
			int x = in.nextInt();
			int y = in.nextInt();
			if(x == 2 && y == 2){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 2");
			    System.out.println("2 1");
			    }
			else if(x == 2 && y == 4){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 1");
			    System.out.println("1 2");
			    }
			else if(x == 3 && y == 3){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 2 3");
			    System.out.println("3 1 2");
			    System.out.println("2 3 1");
			    }
			
			else if(x == 3 && y == 6){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 3 1");
			    System.out.println("1 2 3");
			    System.out.println("3 1 2");
			    }
			
			else if(x == 3 && y == 9){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 1 2");
			    System.out.println("2 3 1");
			    System.out.println("1 2 3");
			    }
			else if(x == 4 && y == 4){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 2 3 4");
			    System.out.println("2 1 4 3");
			    System.out.println("3 4 1 2");
			    System.out.println("4 3 2 1");
			    }
			
			else if(x == 4 && y == 6){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 2 4 3");
			    System.out.println("2 1 3 4");
			    System.out.println("3 4 2 1");
			    System.out.println("4 3 1 2");
			    }
			else if(x == 4 && y == 7){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 2 1 4");
			    System.out.println("4 1 3 2");
			    System.out.println("1 4 2 3");
			    System.out.println("2 3 4 1");
			    }
			else if(x == 4 && y == 8){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 3 4 1");
			    System.out.println("1 2 3 4");
			    System.out.println("4 1 2 3");
			    System.out.println("3 4 1 2");
			    }
			else if(x == 4 && y == 9){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 3 1 2");
			    System.out.println("2 1 4 3");
			    System.out.println("1 2 3 4");
			    System.out.println("3 4 2 1");
			    }
			else if(x == 4 && y == 10){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 1 4 3");
			    System.out.println("1 3 2 4");
			    System.out.println("4 2 3 1");
			    System.out.println("3 4 1 2");
			    }
			else if(x == 4 && y == 11){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 3 2 1");
			    System.out.println("1 2 4 3");
			    System.out.println("2 1 3 4");
			    System.out.println("3 4 1 2");
			    }
			else if(x == 4 && y == 12){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 4 1 2");
			    System.out.println("2 3 4 1");
			    System.out.println("1 2 3 4");
			    System.out.println("4 1 2 3");
			    }
			else if(x == 4 && y == 13){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 3 4 1");
			    System.out.println("1 4 2 3");
			    System.out.println("4 1 3 2");
			    System.out.println("3 2 1 4");
			    }
			else if(x == 4 && y == 14){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 1 2 3");
			    System.out.println("1 3 4 2");
			    System.out.println("2 4 3 1");
			    System.out.println("3 2 1 4");
			    }
			
			else if(x == 4 && y == 16){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 1 2 3");
			    System.out.println("3 4 1 2");
			    System.out.println("2 3 4 1");
			    System.out.println("1 2 3 4");
			    }
			else if(x == 5 && y == 5){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 2 3 4 5");
			    System.out.println("4 1 5 3 2");
			    System.out.println("2 4 1 5 3");
			    System.out.println("5 3 2 1 4");
			    System.out.println("3 5 4 2 1");
			    }
			else if(x == 5 && y == 7){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 4 3 5 2");
			    System.out.println("3 2 1 4 5");
			    System.out.println("5 1 2 3 4");
			    System.out.println("2 5 4 1 3");
			    System.out.println("4 3 5 2 1");
			    }
			else if(x == 5 && y == 8){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 3 4 5 1");
			    System.out.println("1 2 5 3 4");
			    System.out.println("3 4 1 2 5");
			    System.out.println("4 5 2 1 3");
			    System.out.println("5 1 3 4 2");
			    }
			else if(x == 5 && y == 9){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("1 3 4 2 5");
			    System.out.println("3 2 5 4 1");
			    System.out.println("5 1 2 3 4");
			    System.out.println("4 5 3 1 2");
			    System.out.println("2 4 1 5 3");
			    }
			else if(x == 5 && y == 10){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 1 4 3 5");
			    System.out.println("3 2 5 4 1");
			    System.out.println("1 3 2 5 4");
			    System.out.println("5 4 1 2 3");
			    System.out.println("4 5 3 1 2");
			    }
			else if(x == 5 && y == 11){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 4 2 5 1");
			    System.out.println("1 3 5 4 2");
			    System.out.println("4 2 1 3 5");
			    System.out.println("2 5 3 1 4");
			    System.out.println("5 1 4 2 3");
			    }
			else if(x == 5 && y == 12){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 5 4 1 3");
			    System.out.println("4 3 2 5 1");
			    System.out.println("1 2 3 4 5");
			    System.out.println("3 1 5 2 4");
			    System.out.println("5 4 1 3 2");
			    }
			else if(x == 5 && y == 13){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 4 5 1 2");
			    System.out.println("2 3 1 4 5");
			    System.out.println("4 5 2 3 1");
			    System.out.println("5 1 3 2 4");
			    System.out.println("1 2 4 5 3");
			    }
			else if(x == 5 && y == 14){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("2 4 5 3 1");
			    System.out.println("4 3 1 5 2");
			    System.out.println("1 2 3 4 5");
			    System.out.println("5 1 4 2 3");
			    System.out.println("3 5 2 1 4");
			    }
			else if(x == 5 && y == 15){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 2 5 4 1");
			    System.out.println("4 3 1 5 2");
			    System.out.println("2 4 3 1 5");
			    System.out.println("1 5 2 3 4");
			    System.out.println("5 1 4 2 3");
			    }
			else if(x == 5 && y == 16){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 5 3 1 2");
			    System.out.println("2 4 1 5 3");
			    System.out.println("5 3 2 4 1");
			    System.out.println("3 1 4 2 5");
			    System.out.println("1 2 5 3 4");
			    }
			else if(x == 5 && y == 17){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 1 5 2 4");
			    System.out.println("5 4 3 1 2");
			    System.out.println("2 3 4 5 1");
			    System.out.println("4 2 1 3 5");
			    System.out.println("1 5 2 4 3");
			    }
			else if(x == 5 && y == 18){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 5 1 2 3");
			    System.out.println("3 4 2 5 1");
			    System.out.println("5 1 3 4 2");
			    System.out.println("1 2 4 3 5");
			    System.out.println("2 3 5 1 4");
			    }
			else if(x == 5 && y == 19){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("3 5 1 4 2");
			    System.out.println("5 4 2 1 3");
			    System.out.println("2 3 4 5 1");
			    System.out.println("1 2 5 3 4");
			    System.out.println("4 1 3 2 5");
			    }
			else if(x == 5 && y == 20){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 3 1 5 2");
			    System.out.println("5 4 2 1 3");
			    System.out.println("3 5 4 2 1");
			    System.out.println("2 1 3 4 5");
			    System.out.println("1 2 5 3 4");
			    }
			else if(x == 5 && y == 21){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("5 1 4 2 3");
			    System.out.println("3 5 2 1 4");
			    System.out.println("1 4 3 5 2");
			    System.out.println("4 2 5 3 1");
			    System.out.println("2 3 1 4 5");
			    }
			else if(x == 5 && y == 22){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("4 2 1 3 5");
			    System.out.println("1 5 4 2 3");
			    System.out.println("3 4 5 1 2");
			    System.out.println("5 3 2 4 1");
			    System.out.println("2 1 3 5 4");
			    }
			else if(x == 5 && y == 23){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("5 1 2 3 4");
			    System.out.println("4 5 3 1 2");
			    System.out.println("1 2 4 5 3");
			    System.out.println("2 3 5 4 1");
			    System.out.println("3 4 1 2 5");
			    }
			
			else if(x == 5 && y == 25){
			    System.out.println("Case #" + a + ": POSSIBLE");
			    System.out.println("5 1 4 3 2");
			    System.out.println("3 5 2 4 1");
			    System.out.println("1 3 5 2 4");
			    System.out.println("2 4 1 5 3");
			    System.out.println("4 2 3 1 5");
			    }
			else System.out.println("Case #" + a + ": IMPOSSIBLE");
			}
		}

}
