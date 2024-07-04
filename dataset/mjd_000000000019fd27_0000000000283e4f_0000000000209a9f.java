import java.util.Scanner;

 class Solution {

	public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int T = scan.nextInt();
            for (int i=1; i<=T ;i++) {
            	String inp = scan.next();
            	String ans = parenthesis(inp);
            	System.out.println("Case #"+i+": "+ans);
        }
	}

static String parenthesis(String str) {

	StringBuffer s = new StringBuffer();
	char[] ch = str.toCharArray();
        int[] array = new int[ch.length];
        for (int i = 0; i < ch.length; ++i) {
            array[i] = ch[i] - '0';
        }
        int d = 0;

      
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 0) {
                s.append("0");
            } else {
                if (i == 0 || array[i-1] == 0) {
                    s.append("(");
                }
                s.append("1");
                if (i == array.length-1 || array[i+1] == 0) {
                    s.append(")");
                }
            }
        }
    return s.toString();    
	}
}