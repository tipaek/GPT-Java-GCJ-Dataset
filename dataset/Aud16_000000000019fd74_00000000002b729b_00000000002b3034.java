/* Use the slash-star style comments or the system won't see your
	identification information */
/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

class Solution {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int total = in.nextInt();
	in.nextLine();
	
	for(int i = 1; i <= total; i++) {
		int twords = in.nextInt();
		in.nextLine();
		String[] words = new String[twords];
		int[] count = new int[twords];
		String ans = "*";
		for(int x = 0; x < twords; x++) {
			words[x] = new StringBuilder(in.nextLine()).reverse().toString();
		}
		
		int longest = 0;
		int l = 0;
		for(int x = 1; x < twords; x++) {
			if(words[x].length() > longest) {
				longest = words[x].length();
				l = x;
			}
		}
						
		for(int x = 0; x < longest; x++) {
			char test = 'a';
			boolean wrong = false;
			boolean add = false;
			if(words[l].charAt(x)=='*') {
				if(x+1==words[l].length()) break;
				test = words[l].charAt(x+1);
				count[l] = x+1;
				add = true;
			} else {
				test = words[l].charAt(x);
				count[l] = x;
			}

			for(int w = 0; w < twords; w++) {
				boolean ast = false;
				if(words[w].charAt(count[w]) == '*') {
					ast = true;
				}
				char compare = 'a';
				if(ast) { 
					compare = test;
				}
				else {
					compare = words[w].charAt(count[w]);
				}
				if(compare!=test) {
					count[w] = -1;
					wrong = true;
					
				} else if (compare == test && !ast) {
					count[w] = count[w] + 1;
				}
			}
			if(!wrong) {
				ans+=test;
			} else {
				ans = "*";
				break;
			}
			if (add) x++;
		}
		
		if(!ans.equals("*")) {
			ans = new StringBuilder(ans.substring(1)).reverse().toString();
		}
		System.out.println("Case #" + i + ": " + ans);
	}
  }
}
