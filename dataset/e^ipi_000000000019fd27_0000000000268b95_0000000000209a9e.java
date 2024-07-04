import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		int B = sc.nextInt();
        int T = t;
        while (t-- > 0) {
			int queries = 0;
			String prefix = "";
			String postfix = "";
			
			if (queries == 0) {
				for (int i = 0; i < 5; i++) {
					System.out.println(i + 1);
					queries++;
					prefix += sc.nextInt();
				}
				
				for (int i = 0; i < 5; i++) {
					System.out.println(B - i);
					queries++;
					postfix = sc.nextInt() + postfix;
				}
			}
			
			System.out.println(prefix + postfix);
			sc.nextLine();
			sc.nextLine();
        }

    }


}
