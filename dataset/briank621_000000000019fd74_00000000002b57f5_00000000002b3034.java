import java.util.*;
import java.io.*;

class Solution{

	public static boolean equalOrStart(String s, String add){
		// System.out.println("s.startsWith(add): " + s.startsWith(add));
		// System.out.println("add.star: " + add.star);
		// System.out.println("checking here");
		return add.length() == 0 || s.length() == 0 || s.startsWith(add) || add.startsWith(s);
	}

	public static boolean equalOrEnd(String s, String add){
		return add.length() == 0 || s.length() == 0 || s.endsWith(add) || add.endsWith(s);
	}

	public static String attach(String s, String add){
		return s.length() > add.length() ? s : add;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			String begin = new String();
			StringBuilder mid = new StringBuilder();
			String end = new String();
			int n = Integer.parseInt(br.readLine());
			boolean valid = true;
			for(int i = 0; i < n; i++){
				String s = br.readLine();
				// System.out.println("s: " + s);
				String[] l = s.split("\\*");
					// System.out.println(Arrays.toString(l));
					// System.out.println("begin: " + begin);
					// System.out.println("end: " + end);
				int start = 0;
				int endi = l.length;
				if(s.charAt(0) != '*')
					start++;
				if(s.charAt(s.length() - 1) != '*')
					endi--;
				StringBuilder sb = new StringBuilder();
				for(int j = start; j < endi; j++)
					sb.append(l[j]);
				mid.append(sb);
				if(start == 1){
					String ss = l[0];
					// System.out.println("ss: " + ss);
					// System.out.println("begin: " + begin);
					if(equalOrStart(begin, ss)){
						// System.out.println("made it");
						begin = attach(begin, ss);
					}
					else{
							// System.out.println("Bad #3");
						valid = false;
					}
				}
				if(endi == l.length - 1){
					String es = l[l.length - 1];
						// System.out.println("end: " + end);
						// System.out.println("es: " + es);
					if(equalOrEnd(end, es)){
						end = attach(end, es);
					}
					else{
							// System.out.println("Bad #4");
						valid = false;
					}
				}

			}

			if(!valid){
				System.out.printf("Case #%d: *\n", numCases);
			}
			else{
				if(begin.length() == 0 && mid.length() == 0 && end.length() == 0)
					begin = "a";
				System.out.printf("Case #%d: %s%s%s\n", numCases, begin, mid.toString(), end);
			}

		}

		
		br.close();
	}

}