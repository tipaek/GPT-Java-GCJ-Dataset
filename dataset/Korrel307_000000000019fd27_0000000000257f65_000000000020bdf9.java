  
  
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
		//System.out.println("Case #" + i + ": " +Concatvector(svec));
		//System.out.println();
		//System.out.println("Case #" + i + ": " +Concatvector(Concat(out)));
		//System.out.println();
		System.out.println("Case #" + i + ": " +ConcatSet2(svec));
		
		}
		
      }
		
	public static String[] Concat(String[] input) {
			String[] out = new String[input.length];
			for (int p = 0; p<input.length;p++) {
				if (!input[p].substring(0,1).equals("0")) {
					out[p] =   "(" + input[p] +  ")";
					//for (int r = 2; r<=Integer.parseInt(input[p].substring(0,1));r++) {
					//out[p] =   "(" + out[p] +  ")";}
				} else {out[p] =    "" + input[p] +  "";}
			}
			
			//if (input[p].substring(0,1).compareTo(input[p+1])==1) {
			//			out =  out +  "(" + input[p] +  "";
			//		} else if (input[p-1].substring(0,1).compareTo(input[p])==-1) {
			//			out =  out +  "" + input[p] +  "))";
					
			
			return out;
		}	
		
		public static String ConcatSet2(String[] input) {
			String out = "";
			int openpar = 0;
			
			for (int p = 0; p<input.length;p++) {
			int num = Integer.parseInt(input[p]);
			
				if (num>openpar) {
					int diff = num-openpar;
					for (int e=0; e<diff;e++) {
						out = out + "(";
						openpar=openpar+1;
					}
				} 
				else if (num<openpar) {
					int diff = openpar-num;
					for (int e=0; e<diff;e++) {
						out = out + ")";
						openpar=openpar-1;
					}
				}
				out += num;
			
			}
			
			for (int u=0; u<openpar;u++)
				out = out + ")";
			return out;
		}
		
		
		
	
	public static String ConcatSet3(String[] input) {
			String out = "";
			int openpar = 0;
			int sum = 0;
			String par = "";
			for (int p = 0; p<input.length-1;p++) {
				//sum = 0;
				//openpar = 0;
				//out = out + input[p];
				System.out.println("p : "+p);
				if (!input[p].equals(input[p+1])) {
					System.out.println("Different values");
					sum = sum + Integer.parseInt(input[p]);
				}
				System.out.println("openpar : "+openpar);
				System.out.println("sum : "+sum);
				par = "";
				
				while (openpar<sum) {
					par =  par +"(";
					openpar = openpar + 1;
				}
				
				out = out + par + input[p];
				System.out.println("out : "+out);
				
				if (!input[p].equals(input[p+1])) {
					System.out.println("Different values");
					sum = sum + Integer.parseInt(input[p+1]);
				}
				
				System.out.println("openpar : "+openpar);
				System.out.println("sum : "+sum);
				par = "";
				while (openpar>=sum) {
					
					par =  par +")";
					openpar = openpar - 1;
					System.out.println("par : "+par);
					System.out.println("openpar -1 : "+openpar);
					//sum = sum -Integer.parseInt(input[p]);
				}
				
				out = out + par;
				System.out.println("out : "+out);
				par = "";		
				
			System.out.println();
			System.out.println();			
			}
			
			//if (input[p].substring(0,1).compareTo(input[p+1])==1) {
			//			out =  out +  "(" + input[p] +  "";
			//		} else if (input[p-1].substring(0,1).compareTo(input[p])==-1) {
			//			out =  out +  "" + input[p] +  "))";
					
			
			return out;
		}	
	
	
	
	public static String Concatvector(String[] input) {
			String out = "";
			for (int p = 0; p<input.length;p++) {
				out =  out +(input[p]) +  "";
			}
			return out;
		}
	
	
}