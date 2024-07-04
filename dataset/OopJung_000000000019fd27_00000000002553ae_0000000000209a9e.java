import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] ans; //init
	static int idx; //init
	static int same; //init
	static int diff; //init
	static int B;
	static int qnum; // init
	
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		test:
		for(int t = 1; t<=T; t++) {
			
			ans = new int[B+1];
			Arrays.fill(ans, -1);
			idx = 1;
			same = -1;
			diff = -1;
			qnum = 0;
			
			for(int i = 1; i<=5; i++) {
				int front = idx;
				int back = B+1-front;
				
				bw.write(front+"");
				qnum++;
				bw.flush();
				int frontbit = Integer.parseInt(br.readLine());
				
				bw.write(back+"");
				qnum++;
				bw.flush();
				int backbit = Integer.parseInt(br.readLine());
				
				ans[front] = frontbit;
				ans[back] = backbit;
				
				if(frontbit == backbit) {
					same = front;
				}
				else {
					diff = front;
				}
				
				idx++;
			}
			
			if(B == 10) {
				for(int i = 1; i<=10; i++) {
					bw.write(Integer.toString(ans[i]));
				}
				bw.flush();
				String suc = br.readLine();
				continue test;
			}
			else {
				
				for(int i = 1; i<=14; i++) {
					
					if(same != -1 && diff != -1) {
						checkboth();
					}
					else if(same != -1) {
						checksame();
					}
					else {
						checkdiff();
					}
					
					if(idx >B/2) {
						for(int j = 1; j<=B; j++) {
							bw.write(Integer.toString(ans[j]));
						}
						bw.flush();
						String suc = br.readLine();
						continue test;
					}
					
				}
			}
			
		}
		br.close();
		bw.close();
	}
	
	public static void checkdiff() throws IOException{
		bw.write(diff+"");
		bw.flush();
		qnum++;
		int newdiff = Integer.parseInt(br.readLine());
		
		bw.write(diff+"");
		bw.flush();
		qnum++;
		newdiff = Integer.parseInt(br.readLine());
		
		if(ans[diff] != newdiff) {
			comp();
		}
		
		goon();
	}
	
	public static void checksame() throws IOException{
		bw.write(same+"");
		bw.flush();
		qnum++;
		int newsame = Integer.parseInt(br.readLine());
		
		bw.write(same+"");
		bw.flush();
		qnum++;
		newsame = Integer.parseInt(br.readLine());
		
		if(ans[same] != newsame) {
			comp();
		}
		
		goon();
	}
	
	public static void checkboth() throws IOException{
		
		bw.write(same+"");
		bw.flush();
		qnum++;
		int newsame = Integer.parseInt(br.readLine());
		
		bw.write(diff+"");
		bw.flush();
		qnum++;
		int newdiff = Integer.parseInt(br.readLine());
		
		if(ans[same] != newsame && ans[diff] != newdiff) {
			comp();
		}
		else if(ans[same] != newsame && ans[diff] == newdiff) {
			comprev();
		}
		else if(ans[same] == newsame && ans[diff] != newdiff) {
			rev();
		}
		
		goon();
		
	}
	
	public static void goon() throws IOException {
		
		while(qnum % 10 != 0) {
			int front = idx;
			int back = B+1-front;
			
			bw.write(front+"");
			qnum++;
			bw.flush();
			int frontbit = Integer.parseInt(br.readLine());
			
			bw.write(back+"");
			qnum++;
			bw.flush();
			int backbit = Integer.parseInt(br.readLine());
			
			ans[front] = frontbit;
			ans[back] = backbit;
			
			if(frontbit == backbit) {
				same = front;
			}
			else {
				diff = front;
			}
			
			idx++;
			idx = Math.min(idx, B);
		}
	}
	
	public static void comp() {
		for(int i = 1; i<=B; i++) {
			if(ans[i] == 1) {
				ans[i] = 0;
			}
			else if(ans[i] == 0) {
				ans[i] = 1;
			}
		}
	}
	
	public static void rev() {
		for(int i = 1; i<=B/2; i++) {
			int temp = ans[i];
			ans[i] = ans[B+1-i];
			ans[B+1-i] = temp;
		}
	}
	
	public static void comprev() {
		for(int i = 1; i<=B/2; i++) {
			if(ans[i] != -1) {
				int temp = ans[i] == 0 ? 1 : 0;
				ans[i] = ans[B+1-i] == 0 ? 1 : 0;
				ans[B+1-i] = temp;
			}
		}
	}
	
}


