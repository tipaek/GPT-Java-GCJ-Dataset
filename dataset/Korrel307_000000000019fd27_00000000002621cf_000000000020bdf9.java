  
  
  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Number of cases
        for (int i = 1; i <= t; ++i) {
					
		String n_str = in.nextLine();
		int n = Integer.parseInt(n_str);
		
		int[][] matrix = new int[n][4];
				
		for (int a = 1;a<=n;a++) {
			String[] mat_in = in.nextLine().split(" ");
			//insRow(matrix,mat_in,a);
			matrix[a-1][0] = Integer.parseInt(mat_in[0]);
			matrix[a-1][1] = Integer.parseInt(mat_in[1]);
			matrix[a-1][2] = a-1;
		}
		
		//String[] svec = s_in.split("");
		
		int[] array_c = new int[(24*60)+1];
		int[] array_j = new int[(24*60)+1];
		
		
		
		/*for (int b = 0;b<array_c.length;b++) {
			if (b>=matrix[0][0]&&b<=matrix[0][1]) {
				array_c[b] = 1;
			} 
		}*/
		
		
		
		//print2dArray(matrix);
		//System.out.println();
		
		
		
		//System.out.println("array C: " +ConcatvectorInt(array_c));
		//System.out.println("array J: " +ConcatvectorInt(array_j));
		sortbyColumn(matrix,1);
		//print2dArray(matrixstd);
		//System.out.println();
		
		String[] array_sched = new String[n];
		//array_sched[0] = "";
		String check = "";
			
		System.out.println("Case #" + i + ": "+solve(matrix));
		
		/*for (int c = 0;c<n;c++) {
			//System.out.println();
			//System.out.println("C: "+c);
			//System.out.println("C Check: " +(checkschedule(array_c,matrix[c][0],matrix[c][1])));
			//System.out.println();
			//System.out.println("J Check: " +(checkschedule(array_j,matrix[c][0],matrix[c][1])));
			//System.out.println();
			if (checkschedule(array_j,matrix[c][0],matrix[c][1])) {
					//System.out.println("J selected: "+c);	
					fillschedule(array_j,matrix[c][0],matrix[c][1]);
					array_sched[c] = "J";
				} else
			if (checkschedule(array_c,matrix[c][0],matrix[c][1])) {
					//System.out.println("C selected: "+c);	
					fillschedule(array_c,matrix[c][0],matrix[c][1]);
					array_sched[c] = "C";
				} else
				 {
						//System.out.println("ERROR selected: ");
						check = "error";
					}
				//System.out.println("array Sched: " +ConcatvectorStr(array_sched));	
				//System.out.println();
				//System.out.println("array C: " +ConcatvectorInt(array_c));
				//System.out.println("array J: " +ConcatvectorInt(array_j));
		}
*/
			
		
		//System.out.println();
		//System.out.println("array C: " +ConcatvectorInt(array_c));
		//System.out.println("array J: " +ConcatvectorInt(array_j));
		
		String check2 = "";
		
		/*if (check.equals("error")){
			for (int b = 0;b<array_c.length;b++) {
			if (b>=matrixstd[0][0]&&b<=matrixstd[0][1]) {
				array_j[b] = 1;
			} else {array_j[b] = 0;}
			array_c[b] = 0;
		}
		
		array_sched = new String[n];
		//array_sched[0] = "J";
		

		for (int c = 0;c<n;c++) {
			//System.out.println("C Check: " +(checkschedule(array_c,matrix[c][0],matrix[c][1])));
			//System.out.println("J Check: " +(checkschedule(array_j,matrix[c][0],matrix[c][1])));
			if (checkschedule(array_c,matrix[c][0],matrix[c][1])) {
					//System.out.println("C selected: "+c);	
					fillschedule(array_c,matrix[c][0],matrix[c][1]);
					array_sched[c] = "C";
				} else
				if (checkschedule(array_j,matrix[c][0],matrix[c][1])) {
					//System.out.println("J selected: "+c);	
					fillschedule(array_j,matrix[c][0],matrix[c][1]);
					array_sched[c] = "J";
					} else {
						//System.out.println("ERROR selected: ");
						check2 = "error";
					}
				//System.out.println("array Sched: " +ConcatvectorStr(array_sched));	
				//System.out.println();
		}
		}*/
		
		/*String[] answer = new String[array_sched.length];
		String[] order = fetchColumn(matrixstd,3);
		
		
		System.out.println("Order#" + i + ": "+ConcatvectorStr(array_sched));
		System.out.println("Order#" + i + ": "+ConcatvectorStr(order));
		*/
		/*for (int g = 0;g<answer.length ;g++) {*
			answer[g]=array_sched[Arrays.asList(order).indexOf(g)];
			
			
		}*/
		
		//System.out.println("Case Test#" + i + ": "+ConcatvectorStr(answer));
		
		
		//System.out.println("Case #" + i + ": "+ConcatvectorStr(array_sched));
		/*if (check.equals("error")&&check2.equals("error")){
			System.out.println("Case #" + i + ": "+"IMPOSSIBLE");
		} else {
			System.out.println("Case #" + i + ": "+ConcatvectorStr(array_sched));
		}
		//System.out.println("array Sched: " +check);
		//System.out.println();
		//System.out.println("Case #" + i + ": " +n);
*/
		}
		
      }
		public static String solve(int[][] matrix) {
		
		int[] cx = {-1,-1};
		int[] jx = {-1,-1};
		int n = matrix.length;
		for (int c = 0;c<n;c++) {
				if (cx[1]<=matrix[c][0]&&jx[1]<=matrix[c][0]) {
					if (cx[1]>jx[1]){
						cx[0] = matrix[c][0];
						cx[1] = matrix[c][1];
						matrix[c][3]=0;
					} else {
						jx[0] = matrix[c][0];
						jx[1] = matrix[c][1];
						matrix[c][3]=1;
						
					}
				} else if (cx[1]<=matrix[c][0]) {
					cx[0] = matrix[c][0];
						cx[1] = matrix[c][1];
						matrix[c][3]=0;
				} else if (jx[1]<=matrix[c][0]) {
					jx[0] = matrix[c][0];
						jx[1] = matrix[c][1];
						matrix[c][3]=1;
				} else {return "IMPOSSIBLE";}
			}
		String answer = "";
		for (int m = 0; m<n;m++ ) {
			for ( int v = 0 ; v<n; v++) {
				if (matrix[v][2]==m) {
					if (matrix[v][3]==0){
						answer += "C";
					} else {answer += "J";}
				}
			}
		} return answer;
		}
		
		
		
		
		
		public static boolean checkschedule(int[] arr,int start,int end){
		boolean out = true;
		//System.out.println("Start Index: "+start + " end Index: " + end);
		//System.out.println("First: "+arr[start] + " Last: " + arr[end]);
		if (start==end && arr[start]==0){
			//System.out.println("Same start and end check");
			for (int a = start;a<=end;a++) {
					if (arr[a] == 1) {
						out = false;
						break;
					} 
				}
			out = true;
			
		} else
		if (arr[start] == 0) {
			//System.out.println("Pass start is zero check");
			for (int b = start;b<=end;b++) {
					if (arr[b] == 1) {
						out = false;
						break;
					} 
				}
		} else 			
		/*if (arr[start] == 1 && arr[start+1]==0){
			//System.out.println("Pass start is 1 next is zero check");
			for (int c = start+1;c<=end;c++) {
				if (arr[c] == 1) {
					out = false;
					break;
				} 
			}
		} else */{out = false;}
				
		return out;
		}
		
		public static void fillschedule(int[] arr,int start,int end){
		for (int b = 0;b<arr.length;b++) {
			if (b>=start&&b<end) {
				arr[b] = 1;
			} 
		}
		}
		
		public static String ConcatvectorInt(int[] input) {
		String out = "";
		for (int p = 0; p<input.length;p++) {
		out =  out +(Integer.toString(input[p])) +  "";
		}
		return out;
		}
	
		public static String ConcatvectorStr(String[] input) {
		String out = "";
		for (int p = 0; p<input.length;p++) {
		out =  out +((input[p])) +  "";
		}
		return out;
		}
	
	
		
		private static void insRow(int[][] matrix,String ins,int row) {
		String[] out = ins.split(" ");
		for (int c = 0; c < out.length; c++) {
		matrix[row-1][c] = Integer.parseInt(out[c]);
		matrix[row-1][2] = row-1;
		}
		}
		
		private static void print2dArray(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
		for (int c = 0; c < matrix[0].length; c++) {
		System.out.print(matrix[r][c] + " ");
		}
		System.out.println();
		}
		}
		
		public static void sortbyColumn(int arr[][], int col) 
		{ 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          //@Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        }
		
		);  // End of function call sort(). 
		//return arr;
		}
		
		public static String[] fetchColumn(int[][] matrix,int col) {
		String[] out = new String[matrix[0].length];
		for (int c = 0; c < matrix[0].length; c++) {
			out[c] = Integer.toString(matrix[c][col-1]);
			
			//System.out.print(matrix[row-1][c] + "\t");
		}
			
		return out;
		}
		
    } 
		
		
	
