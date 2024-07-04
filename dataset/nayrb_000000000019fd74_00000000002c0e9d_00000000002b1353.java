import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		int keis = Integer.valueOf(br.readLine().trim());
		for(int kei = 0; kei < keis; kei++){
		
			int N = Integer.valueOf(br.readLine().trim());
			
			
			int r = 1;
			int c = 2;
			
			int runSum = 1;
			LinkedList<Cell> list = new LinkedList<Cell>();
			list.add(new Cell(1,1));
			
			while(true){
				if(runSum + r > N){
					break;
				}
				else{
					runSum += r;
					list.add(new Cell(r+1, 2));
					r++;
				}
				if(runSum >= N) break;
			}
			for(int i = 0; i < (N - runSum); i++){
				list.add(new Cell(r, 1));
				r--;
			}	
			
			// out.println(list);
			out.println("Case #"+(kei+1)+":");
			for(Cell cc : list){
				out.println(cc);
			}
		}
		
	}
		public static class Cell{
			int y, x;
			public Cell(int a, int b){
				y = a;
				x = b;
			}
			public String toString(){
				return y+" "+x;
			}
		}
}