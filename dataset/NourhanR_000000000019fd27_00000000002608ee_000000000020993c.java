import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Vestigium {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		while(s1.equals(""))
			s1 = br.readLine();
		int t = new Integer(s1);
		int x = 1;
		while(t-- > 0){
			
			int n = new Integer(br.readLine());
			int[][] m = new int[n][n];
			int r = 0;
			for(int i = 0; i < n; i++){
				StringTokenizer s = new StringTokenizer(br.readLine());
				HashSet<Integer> present = new HashSet<>();
				boolean f = false;
				for(int j = 0; j < n; j++){					
					m[i][j] = new Integer(s.nextToken());
					if(present.contains(m[i][j]))
						f = true;	
					present.add(m[i][j]);
				}
				if(f)
					r++;
			}
			int k = 0;
			int c = 0;
			for(int j = 0; j < n; j++){
				boolean f = false;
				HashSet<Integer> present = new HashSet<>();
				for(int i = 0; i < n; i++){
					if(i == j)
						k += m[i][j];
					if(present.contains(m[i][j]))
						f = true;
					present.add(m[i][j]);
				}
				if(f)
					c++;
			}
			System.out.println("Case #" + (x++) +": " + k + " " + r + " " + c);
			
		}
		
	}
	
}
