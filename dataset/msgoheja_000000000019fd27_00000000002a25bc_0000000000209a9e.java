import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	int MAX_QUERY = 150;
	int[] compl, reverse, cr, original;
	int N, blank, read;
	
	void init() {
		compl = new int[N+1];
		reverse = new int[N+1];
		cr = new int[N+1];
		original = new int[N+1];
		Arrays.fill(original, -1);
		blank = N;
	}
	
	void updateComplement() {
		for(int i = 1; i <= N; i++) {
			if(original[i] != -1) {
				compl[i] = (original[i] == 1) ? 0 : 1;
			} else {
				compl[i] = original[i];
			}
		}
	}
	
	void updateReverse() {
		for(int i = 1, j = N; i <= N && j > 0; i++, j--) {
			reverse[i] = original[j];
		}
	}
	
	void updateCR() {
		for(int i = 1, j = N; i <= N && j > 0; i++, j--) {
			cr[i] = compl[j];
		}
	}
	
	void calculateValues() {
		updateComplement();
		updateReverse();
		updateCR();
	}
	
	int[][] fetchArrayWithMatchValues(int index, int value) {
		int[] a1 = null, a2 = null;
		
		if(compl[index] == value) {
			a1 = compl;
		}
		
		if(reverse[index] == value) {
			if(a1 == null) a1 = reverse;
			else a2 = reverse;
		}
		
		if(cr[index] == value) {
			if(a1 == null) a1 = cr;
			else a2 = cr;
		}
		
		if(original[index] == value) {
			a2 = original;
		}
		
		int[][] output = {a1, a2};
		return output;
	}
	
	int nextMismatchPos(int[] a1, int[] a2) {
		int pos = -1;
		
		for(int i = 2; i <= N; i++) {
			if(a1[i] != -1 && a2[i] != -1 && a1[i] != a2[i]) {
				pos = i;
				break;
			}
		}
		return pos;
	}
	
	String getStringBits(int[] bits) {
		String output = "";
		
		for(int i = 1; i < bits.length; i++) {
			output += ("" + bits[i]);
		}
		return output;
	}
	
	void solve() {
		try {
			Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			
			int T = in.nextInt();
			N = in.nextInt();
			
			for(int tc = 1; tc <= T; tc++) {
				init();
				
				System.out.println(1);
				read = in.nextInt();
				
				// Query 1 to 13
				for(int query = 2, startIndex = 1, lastIndex = N; query < 10; query +=2) {
					System.out.println(startIndex);
					read = in.nextInt();
					original[startIndex++] = read;
					blank--;
					
					System.out.println(lastIndex);
					read = in.nextInt();
					original[lastIndex--] = read;
					blank--;
				}
				
				System.out.println(5);
				read = in.nextInt();
				original[5] = read;
				blank--;
				
				int[] a1 = null, a2 = null;
				for(int query = 11; query <= MAX_QUERY; query++) {
					
					if(query%10 == 1) {
						System.out.println(1);
						read = in.nextInt();
					} else if(query%10 == 2) {
						calculateValues();
						
						System.out.println(1);
						read = in.nextInt();
						int[][] output = fetchArrayWithMatchValues(1, read);
						
						a1 = output[0];
						a2 = output[1];
						
						if(a1 == null && a2 != null) {
							a1 = a2;
						} else if(a2 == null && a1 != null) {
							a2 = a1;
						}
					} else if(query%10 == 3) {
						int pos = nextMismatchPos(a1, a2);
						
						if(pos > -1) {
							System.out.println(pos);
						} else {
							System.out.println(1);
						}
						read = in.nextInt();
						
						if(pos > -1) {
							if(a1[pos] == read) {
								original = a1;
							} else if(a2[pos] == read) {
								original = a2;
							}
						} else {
							original = a1;
						}
					} else {
						int nextBlankPos = -1;
						for(int i = 1; i <= N; i++) {
							if(original[i] == -1) {
								nextBlankPos = i;
								break;
							}
						}
						
						if(nextBlankPos > -1) {
							System.out.println(nextBlankPos);
							read = in.nextInt();
							original[nextBlankPos] = read;
							blank--;
						}
						
						if((query + 1) % 10 != 1 && blank == 0) {
							break;
						}
					}
				}
				
				System.out.println(getStringBits(original));
				String result = in.next();
				if(!result.equals("Y")) break;
			}
			in.close();	
		} catch(Exception e) {}
	}
	
	
	public static void main(String[] args) throws Exception{
		Solution obj = new Solution();
		obj.solve();
	}
}
