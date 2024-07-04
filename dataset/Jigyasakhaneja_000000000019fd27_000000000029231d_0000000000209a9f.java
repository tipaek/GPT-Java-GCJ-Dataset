
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] answer = new String[t];
		for (int i = 0; i < t; i++) {
			String str = s.next();
			String ans = "";
			int balanced=0;
			int prev = -1;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				int val = c - '0';
				if (balanced==0) {
					prev = val;
					for (int k = 1; k <= val; k++)
						ans += '(';
					ans += c;
					balanced+=val;
				} else {
					if (val > prev) {
						int count = val - prev;
						for (int k = 1; k <= count; k++)
							ans += '(';
                        balanced+=count;
                        prev=val;
					} else if (val < prev) {
						int count = prev - val;
						for (int k = 1; k <= count; k++)
							ans += ')';
						balanced-=count;
						prev=val;
					}
					else {
						prev=val;
					}
					ans += c;
				}

			}
			if(balanced!=0)
			{
				for(int j=1;j<=Math.abs(balanced);j++) {
					ans+=')';
				}
			}
			answer[i]=ans;

		}
		for(int i=0;i<t;i++) {
			System.out.println("Case #"+(i+1)+": "+answer[i]);
		}


	}

}
