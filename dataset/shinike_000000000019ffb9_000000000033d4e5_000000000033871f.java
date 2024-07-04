import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i=1;i<=t;i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			ArrayList<Computer> firstKind = new ArrayList<>(); 
			ArrayList<Computer> secondKind = new ArrayList<>();
			int[] left = new int[d];
			int[] right = new int[d];
			int[] len = new int[d];
			int[] dist = new int[c+1];
			for (int j=2;j<=c;j++) {
				dist[j]=-1;
			}
			for (int j=2;j<=c;j++) {
				int tmp = sc.nextInt();
				if (tmp>0) {
					firstKind.add(new Computer(j,tmp));
				} else {
					secondKind.add(new Computer(j, -tmp));
				}
			}
			for (int j=0;j<d;j++) {
				left[j]=sc.nextInt();
				right[j]=sc.nextInt();
			}
			
			firstKind.sort(Comparator.comparing((Computer com) -> com.value));
			secondKind.sort(Comparator.comparing((Computer com) -> com.value));
			
			int counter1 = 0;
			int counter2 = 0;
			int count = 1;
			int nextTime = 0;
			while (counter1 < firstKind.size() || counter2 < secondKind.size()) {
				ArrayList<Integer> nextUpdate = new ArrayList<>();
				nextTime++;
				
					while(counter1 < firstKind.size() && firstKind.get(counter1).value==nextTime) {
						nextUpdate.add(firstKind.get(counter1).num);
						counter1++;
					}
				

					while(counter2 < secondKind.size() && secondKind.get(counter2).value==count) {
						nextUpdate.add(secondKind.get(counter2).num);
						counter2++;
					}
				
				if (nextUpdate.isEmpty()) {
					nextTime = firstKind.get(counter1).value;
					while(firstKind.get(counter1).value == nextTime) {
						nextUpdate.add(firstKind.get(counter1).num);
						counter1++;
					}
				}
				
				for (Integer intg : nextUpdate) {
					for (int j=0;j<d;j++) {
						if (left[j]==intg && dist[right[j]] >= 0) {
							len[j] = nextTime - dist[right[j]];
						}
						if (right[j]==intg && dist[left[j]] >= 0) {
							len[j] = nextTime - dist[left[j]];
						}
					}
				}
				
				for (Integer intg : nextUpdate) {
					dist[intg]=nextTime;
					count++;
				}
				
			}
			StringBuilder str = new StringBuilder("Case #"+i+":");
			for (int j=0;j<d;j++) {
				str.append(" "+(len[j]==0 ? 1000000 : len[j]));
			}
			
			System.out.println(str);
		}	
	}
	
	
}

class Computer {
	int num;
	int value;
	Computer(int num, int value) {
		this.num=num;
		this.value=value;
	}
}

