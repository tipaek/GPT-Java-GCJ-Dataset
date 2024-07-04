import java.util.*;
class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int cn = 1;
		while(T > 0) {
			T--;

			int N = sc.nextInt();

            int[][] schedule = new int[N][3];
            boolean[] C = new boolean[1441];
            boolean[] J = new boolean[1441];
            
            for (int i = 0; i < N; i++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                schedule[i][0] = n;
                schedule[i][1] = m;
                schedule[i][2] = i;
            }    
            
            Arrays.sort(schedule, Comparator.comparingInt(o -> o[1]));

			int bp = 0;
			int point = schedule[0][1];
			char[] temp = new char[N];
			temp[schedule[0][2]] = 'C';
			char ch = 'C';

			boolean find = true;
			for (int i = 1; i < N; i++) {
				if (point <= schedule[i][0]) {
					temp[schedule[i][2]] = ch;
				} else {
					if (bp <= schedule[i][0]) {
						ch = ch == 'C' ? 'J' : 'C';
						bp = point;
//						point = schedule[i][1];
						temp[schedule[i][2]] = ch;
					} else {
						find = false;
					}
				}

				point = schedule[i][1];
			}

			if (find) {
				System.out.printf("Case #%d: %s%n",cn, new String(temp));
			} else {
				System.out.printf("Case #%d: IMPOSSIBLE%n", cn);
			}

			cn++;

		}
	}
	
	public void find(int schedule[][], int index, int N, boolean[] C, boolean[] J, char[] res) {
	    if (index == N - 1) {
	        return;
	    }
	    
	    int x = schedule[index][0];
	    int y = schedule[index][1];
	    
	   
	    
	    
	    
	    
	    return;
	    
	}
}