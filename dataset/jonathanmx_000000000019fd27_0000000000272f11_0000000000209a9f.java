import java.util.*;
class Main {
  public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int T = 3;
		String b;
		for(int i = 0; i < a; i++) {
			b = reader.next();
			System.out.println("Case #" + (i + 1) + ": " + solution(b));
		}
  }

	public static String solution(String a) {
        String b = "";
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < Character.getNumericValue(a.charAt(i));j++) {
              b += "(";  
            }
            b += a.charAt(i);
            for(int j = 0; j < Character.getNumericValue(a.charAt(i));j++) {
              b += ")";  
            }
        }
        return b;
    }
}