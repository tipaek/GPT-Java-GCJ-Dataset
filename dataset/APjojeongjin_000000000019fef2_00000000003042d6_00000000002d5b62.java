import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = scan.nextInt();

		class calcul {
			long x;
			long y;
			int power;
			String S;

			public calcul(long x, long y, int power, String S) {
				this.x = x;
				this.y = y;
				this.power = power;
				this.S = S;
			}
		}

		for (int i = 0; i < T; i++) {
			String answer = "";
			long x = scan.nextInt();
			long y = scan.nextInt();
			long power_value = 0;

			Queue<calcul> q = new LinkedList<calcul>();
			q.add( new calcul(x, y, 0, ""));
			
			int error=0;
			while (!q.isEmpty()) {
				if(error==1000) {
					break;
				}
				calcul temp = q.poll();
				power_value = (long) (Math.pow(2, temp.power));
				if(power_value>2000000000) {
					break;
				}
				if(temp.x == 0 && temp.y == 0) {
					answer = temp.S;
					break;
				}
				
				if( Math.pow(temp.x, 2) + Math.pow(temp.y, 2) < power_value) {
					error++;
					continue;
				}
				
				//EWSN
				q.add( new calcul(temp.x-power_value, temp.y, temp.power+1, temp.S+"E"));
				q.add( new calcul(temp.x+power_value, temp.y, temp.power+1, temp.S+"W"));
				q.add( new calcul(temp.x, temp.y+power_value, temp.power+1, temp.S+"S"));
				q.add( new calcul(temp.x, temp.y-power_value, temp.power+1, temp.S+"N"));
			}

			if (!q.isEmpty() && power_value<=2000000000 && error!=1000) {
				System.out.println("Case #" + (i + 1) + ": " + answer);
			} else {
				System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
			}
		}

	}

}