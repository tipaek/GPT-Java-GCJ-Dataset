import java.util.HashSet;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
//        try {
//            sc = new Scanner(new File("bin/i.txt"));
//        } catch(Exception e) {
//            e.printStackTrace();
//            return;
//        }
        
        int numTestCases = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < numTestCases; i++) {
        	int N = sc.nextInt(); sc.nextLine();
        	
        	int[] matrix = new int[N*N];
        	
        	for(int j = 0; j < N; j++) {
        		for(int k = 0; k < N; k++) {
        			matrix[j * N + k] = sc.nextInt();
        		}
        		sc.nextLine();
        	}
        	
        	System.out.println("Case #" + (i + 1) + ": " + solve(N, matrix));
        }
	}

	private static String solve(int N, int[] matrix) {
		int k = 0;
		int r = 0;
		int c = 0;
		
		for(int i = 0; i < N; i++) {
			k += matrix[i * N + i];
		}
		
		//rows
		for(int i = 0; i < N; i++) {
			HashSet<Integer> seen = new HashSet<Integer>();
			boolean repeated = false;
			
			for(int j = 0; !repeated && j < N; j++) {
				int v = matrix[i * N + j];
				if(seen.contains(v)) {
					repeated = true;
				} else {
					seen.add(v);
				}
			}
			
			if(repeated) r++;
		}
		
		//columns
		for(int i = 0; i < N; i++) {
			HashSet<Integer> seen = new HashSet<Integer>();
			boolean repeated = false;
			
			for(int j = 0; !repeated && j < N; j++) {
				int v = matrix[i + j * N];
				if(seen.contains(v)) {
					repeated = true;
				} else {
					seen.add(v);
				}
			}
			
			if(repeated) c++;
		}
		
		return k + " " + r + " " + c;
	}
}