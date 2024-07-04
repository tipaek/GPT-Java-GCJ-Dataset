import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				final int R = sc.nextInt();
				final int C = sc.nextInt();
				
				long[][] board = new long[R][C];
				long[][] next_board = new long[R][C];
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						board[i][j] = sc.nextLong();
					}
				}
				
				long answer = 0;
				while(true) {
					for(int i = 0; i < R; i++) {
						for(int j = 0; j < C; j++) {
							answer += board[i][j];
							//System.out.print(board[i][j]);
						}
						//System.out.println();
					}
					//System.out.println("---");
					
					boolean no_eliminate = true;
					
					for(int i = 0; i < R; i++) {
						for(int j = 0; j < C; j++) {
							if(board[i][j] <= 0) { 
								next_board[i][j] = board[i][j];
								continue; 
							}

							int count = 0;
							long value = 0;
							
							for(int dx = -1; dx <= 1; dx++) {
								if(dx == 0) { continue; }
								
								for(int k = 1; ; k++) {
									final int nx = j + k * dx;
									if(nx < 0 || C <= nx) { break; }

									if(board[i][nx] <= 0) { continue; }
									
									count++;
									value += board[i][nx];
									break;
								}
							}
							
							for(int dy = -1; dy <= 1; dy++) {
								if(dy == 0) { continue; }
								
								for(int k = 1; ; k++) {
									final int ny = i + k * dy;
									if(ny < 0 || R <= ny) { break; }

									if(board[ny][j] <= 0) { continue; }
									
									count++;
									value += board[ny][j];
									break;
								}
							}
														
							if(count == 0) {
								next_board[i][j] = 0;
							}else if(count * board[i][j] < value) {
								next_board[i][j] = 0;
								no_eliminate = false;
							}else {
								next_board[i][j] = board[i][j];
							}
						}
					}
					
					if(no_eliminate){
						break;
					}
					
					{
						long[][] tmp = board;
						board = next_board;
						next_board = tmp;
					}
				}
				
				System.out.printf("Case #%d: %d\n", tt + 1, answer);				
			}
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;
		
		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}
 
		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}
 
		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}
 
		public String next() {
			getLine();
			return tok.nextToken();
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
