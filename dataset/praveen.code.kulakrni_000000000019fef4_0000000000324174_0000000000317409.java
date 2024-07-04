import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++){
			int X = sc.nextInt();
			int Y = sc.nextInt();
			String M = sc.next();
			int myPosx = 0;
			int myPosy = 0;
			int steps = 0;
			System.out.print("Case #" + t + ": ");
			boolean f = false;
			for(int i = 0 ; i < M.length() ; i++){
				char c = M.charAt(i);
				
				if(c == 'N')		{Y += 1;}
				else if(c == 'S')	{Y -= 1;}
				else if(c == 'E')	{X += 1;}
				else if(c == 'W')	{X -= 1;}
				
				if(X > myPosx)		myPosx += 1;
				else if(X < myPosx)	myPosx -= 1;
				else if(Y > myPosy)	myPosy += 1;
				else if(Y < myPosy)	myPosy -= 1;
				steps += 1;
				
				// System.out.println("i = " + i + " c = " + c + " myPosx = " + myPosx + " myPosy = " + myPosy + " X = "  + X + " Y = " + Y);
				
				if(myPosx == X && myPosy == Y){
					if(M.indexOf('E') != -1 || M.indexOf('W') != -1)
						System.out.println(steps-1);
					else
						System.out.println(steps);
					f = true;
					break;
				}
			}
			if(!f){
				System.out.println("IMPOSSIBLE");
			}
		}

	}

}