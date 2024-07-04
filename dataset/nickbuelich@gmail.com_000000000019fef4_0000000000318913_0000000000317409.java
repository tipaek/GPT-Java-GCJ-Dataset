import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			char[] path = sc.next().toCharArray();
			String answer = "IMPOSSIBLE";
			if (X+Y==0){
				answer = "0";
			}
			else{
				for(int moves=1; moves<=path.length;moves++){
					if(path[moves-1]=='S')Y--;
					else if (path[moves-1]=='N')Y++;
					else if (path[moves-1]=='E')X++;
					else if (path[moves-1]=='W')X--;
					//System.out.println(moves+" "+X+" "+Y+" "+(Math.abs(X)+Math.abs(Y)));
					if (Math.abs(X)+Math.abs(Y)<=moves){
						answer = (moves)+"";
						break;
					}
				}				
			}
			
			System.out.printf("Case #%d: %s%n", t, answer);
		}
	}
}
