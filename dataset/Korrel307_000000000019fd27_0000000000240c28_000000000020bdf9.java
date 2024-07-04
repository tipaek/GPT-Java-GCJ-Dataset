  
  
  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Number of cases
        for (int i = 1; i <= t; ++i) {
					
		String n_str = in.nextLine();
		int n = Integer.parseInt(n_str);
		
		int[][] matrix = new int[n][2];
				
		for (int a = 1;a<=n;a++) {
			String mat_in = in.nextLine();
			insRow(matrix,mat_in,a);
		}
		
		//String[] svec = s_in.split("");
		
		int[] array_c = new int[(24*60)+1];
		int[] array_j = new int[(24*60)+1];
		
		
		
		/*for (int b = 0;b<array_c.length;b++) {
			if (b>=matrix[0][0]&&b<=matrix[0][1]) {
				array_c[b] = 1;
			} 
		}*/
		
		
		//System.out.println("array C: " +ConcatvectorInt(array_c));
		//System.out.println("array J: " +ConcatvectorInt(array_j));
		//print2dArray(matrix);
		
		
		String[] array_sched = new String[n];
		//array_sched[0] = "";
		String check = "";

		for (int c = 0;c<n;c++) {
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
		}

		
		
		//System.out.println();
		//System.out.println("array C: " +ConcatvectorInt(array_c));
		//System.out.println("array J: " +ConcatvectorInt(array_j));
		
		String check2 = "";
		
		if (check.equals("error")){
			for (int b = 0;b<array_c.length;b++) {
			if (b>=matrix[0][0]&&b<=matrix[0][1]) {
				array_j[b] = 1;
			} else {array_j[b] = 0;}
			array_c[b] = 0;
		}
		
		array_sched = new String[n];
		array_sched[0] = "J";
		

		for (int c = 1;c<n;c++) {
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
		}
		
		
		//System.out.println("Case #" + i + ": "+ConcatvectorStr(array_sched));
		if (check.equals("error")&&check2.equals("error")){
			System.out.println("Case #" + i + ": "+"IMPOSSIBLE");
		} else {
			System.out.println("Case #" + i + ": "+ConcatvectorStr(array_sched));
		}
		//System.out.println("array Sched: " +check);
		//System.out.println();
		//System.out.println("Case #" + i + ": " +n);

		}
		
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
		if (arr[start] == 1 && arr[start+1]==0){
			//System.out.println("Pass start is 1 next is zero check");
			for (int c = start+1;c<=end;c++) {
				if (arr[c] == 1) {
					out = false;
					break;
				} 
			}
		} else {out = false;}
				
		return out;
		}
		
		public static void fillschedule(int[] arr,int start,int end){
		for (int b = 0;b<arr.length;b++) {
			if (b>=start&&b<=end) {
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
		
		
		
	
}