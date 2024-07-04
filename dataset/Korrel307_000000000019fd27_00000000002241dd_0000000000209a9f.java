  
  
  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Number of cases
        for (int i = 1; i <= t; ++i) {
					
		String s_in = in.nextLine();
		String[] svec = s_in.split("");
		
		String[] out = new String[1];
		int p = 0;
		out[p] = svec[0];
		
		
		//out = Arrays.copyOf(out, out.length + 1);
		String sout = "("+svec[0];
		for (int k = 1;k<svec.length;k++) {
			if(svec[k-1].equals(svec[k])){
				out[p] = out[p] + svec[k];
			} else {
				p=p+1;
				out = Arrays.copyOf(out, out.length + 1);
				out[p] = svec[k];
			}
			}
		
		

		//System.out.println();
		//System.out.println("Case #" + i + ": " +s_in);
		//System.out.println();
		//System.out.println("Case #" + i + ": " +Concat(svec));
		//System.out.println();
		System.out.println("Case #" + i + ": " +Concat(out));
		}
		
      }
		
	public static String Concat(String[] input) {
			String out = "";
			for (int p = 0; p<input.length;p++) {
				if (!input[p].substring(0,1).equals("0")) {
					out =  out +  "(" + input[p] +  ")";
				} else {out =  out +  "" + input[p] +  "";}
			}
			return out;
		}	
	
	
}