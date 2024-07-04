import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    final Scanner in;

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
		scanner.close();
	}
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
	
	public Solution(Scanner in) {
	    this.in = in;
	}
	
	private void runCase(int cs) {
	    int n = in.nextInt();
	    List<String> strs = new ArrayList<>();
	    for (int i = 0; i < n; i++) {
	        strs.add(in.next());
	    }
	    String pre = "";
	    String post = "";
	    StringBuilder middle = new StringBuilder();
	    boolean possible = true;
	    for (String s : strs) {
	        int first = s.indexOf("*");
	        String p1 = s.substring(0, first);
	        if (p1.length() < pre.length()) {
	            if (!pre.startsWith(p1)) {
	                possible = false;
	                break;
	            }
	        } else {
	            if (p1.startsWith(pre)) {
	                pre = p1;
	            } else {
	                possible = false;
                    break;
	            }
	        }
            int last = s.lastIndexOf("*");
            String p2 = s.substring(last+1, s.length());
            if (p2.length() < post.length()) {
                if (!post.endsWith(p2)) {
                    possible = false;
                    break;
                }
            } else {
                if (p2.endsWith(post)) {
                    post = p2;
                } else {
                    possible = false;
                    break;
                }
            }
            if (first != last) {
                for(char c : s.substring(first+1, last).toCharArray()) {
                    if (c != '*') {
                        middle.append(c);
                    }
                }
            }
	    }
	    String ans = possible ? pre + middle + post : "*";
	    println(String.format("Case #%s: %s", cs, ans));
	}
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}