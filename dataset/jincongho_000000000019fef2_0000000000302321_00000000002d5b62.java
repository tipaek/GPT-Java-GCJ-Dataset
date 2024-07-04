import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static int log2(int x)
	{
		return (int) Math.ceil(Math.log(x) / Math.log(2));
	}
	
	public static class Candidate
	{
		int power;
		char[] solution;
		int x;
		int y;
		
		public Candidate(int power, int x, int y, char[] solution)
		{
			this.power = power;
			this.x = x;
			this.y = y;
			this.solution = solution;
		}
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for(int t=1;t<=T;t++) {
			System.out.print("Case #"+t+": ");
			int X = input.nextInt(), Y = input.nextInt();
			
			// iterative deepening search
			LinkedList<Candidate> queue = new LinkedList<Candidate>();
			char[] options = new char[] {'N', 'S', 'E', 'W'};
			int largest = log2(Math.max(Math.abs(X), Math.abs(Y)));
			queue.add(new Candidate(0, 0, 0, new char[32]));
			boolean success = false;
			while(!queue.isEmpty()) {
				Candidate top = queue.poll();
				int power = top.power;
				for(int o=0;o<4;o++) {
					char[] solution = top.solution.clone();
					solution[power] = options[o];
					int x = top.x, y = top.y;
					switch(options[o])
					{
						case 'N':
							y += Math.pow(2, power);
							break;
						case 'S':
							y -= Math.pow(2, power);
							break;
						case 'E':
							x += Math.pow(2, power);
							break;
						case 'W':
							x -= Math.pow(2, power);
							break;
					}
					if(x==X && y==Y) {
						success = true;
						for(int i=0;i<=power;i++) {
							System.out.print(solution[i]);
						}
						System.out.println();
						break;
					}else if(power+1<=largest){
						queue.add(new Candidate(power+1,x,y,solution));
					}
				}
				if(success)
					break;
			}
			if(!success) {
				System.out.println("IMPOSSIBLE");
			}
		}
		
	}

}
