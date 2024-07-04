import java.util.*;
import java.io.*;

class Solution{

	public static boolean equalOrStart(String s, String add){
		return s.length() == 0 || s.startsWith(add) || add.startsWith(add);
	}

	public static boolean equalOrEnd(String s, String add){
		return s.length() == 0 || s.endsWith(add) || add.endsWith(s);
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
			boolean noMid = false;
			boolean valid = true;
			for(int i = 0; i < n; i++){
				String s = br.readLine();
				// System.out.println("s: " + s);
				if(! s.contains("*")){
					noMid = true;
					if(equalOrStart(begin, s) && equalOrEnd(end, s)){
						begin = attach(begin, s);
						end = attach(end, s);
					}
					else{
						// System.out.println("Bad #1");
						valid = false;
					}
				}
				else{
					if(noMid){
						// System.out.println("Bad #2");
						valid = false;
					}
					else{
						String[] l = s.split("\\*");
						// System.out.println(Arrays.toString(l));
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
							if(equalOrStart(begin, ss)){
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
				}
			}

			if(!valid){
				System.out.printf("Case #%d: *\n", numCases);
			}
			else{
				System.out.printf("Case #%d: %s%s%s\n", numCases, begin, mid.toString(), end);
			}

		}

		
		br.close();
	}

}