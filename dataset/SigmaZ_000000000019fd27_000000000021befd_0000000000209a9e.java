import java.util.*;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tc = in.nextInt(), b = in.nextInt();
		for(int ts = 0; ts < tc; ts++) {
			int rpos = -1, cpos = -1, ct = 0;
			int bits[] = new int[b], rin = -1, cin = -1;
			boolean r = false, c = false;
			if(b % 2 == 1) {
				cpos = b / 2;
				bits[b / 2] = ask(cpos);
				cin = ask(cpos);
				ct = 2;
			}
			for(int i = 0; i < b / 2; i++) {
				if(ct > 0 && ct % 10 == 0) {
					if(cpos != -1)
						c = ask(cpos) != cin;
					else {
						c = false;
						ask(0);
					}
					if(rpos != -1)
						r = c ^ ask(rpos) != rin;
					else {
						r = false;
						ask(0);
					}
					ct += 2;
				}
				int inv = b - 1 - i, ipos = r ? inv : i, invpos = b - 1 - ipos;
				bits[i] = c ? 1 - ask(ipos) : ask(ipos);
				bits[inv] = c ? 1 - ask(invpos) : ask(invpos);
				ct += 2;
				if(rpos == -1 && bits[i] != bits[inv]) {
					rpos = i;
					rin = bits[i];
				}
				if(cpos == -1 && bits[i] == bits[inv]) {
					cpos = i;
					cin = bits[i];
				}
			}
			for(int i = 0; i < b; i++) {
				int p = r ? b - i - 1 : i;
				System.out.print(c ? 1 - bits[p] : bits[p]);
			}
			System.out.println();
			in.next();
		}
		in.close();

	}
	
	public static int ask(int i) {
		System.out.println(i + 1);
		return in.nextInt();
	}

}
