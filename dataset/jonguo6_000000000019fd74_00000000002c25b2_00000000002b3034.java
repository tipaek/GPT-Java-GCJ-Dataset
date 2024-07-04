import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			int n = Integer.parseInt(in.nextLine());
			String[] regex = new String[n];
			for(int i=0;i<n;i++) {
				String curr = in.nextLine();
				regex[i] = curr;
			}
			String ansf = "";
			String ansl = "";
			String ansm = "";
			o:
			while(true) {
				boolean starfirst = true;
				boolean starlast = true;
				for(int i=0;i<n;i++) {
					String curr = regex[i];
					if(!curr.substring(0,1).equals("*")) {
						starfirst = false;
					}
					if(!curr.substring(curr.length()-1,curr.length()).equals("*")) {
						starlast = false;
					}
				}
				if(!starfirst) {
					String first = "";
					boolean hasfirst = false;
					for(int i=0;i<n;i++) {
						String curr = regex[i];
						String firstl = curr.substring(0,1);
						if(firstl.equals("*")) continue;
						if(!hasfirst) {
							hasfirst = true;
							first = firstl;
							continue;
						}
						if(!first.equals(firstl)) {
							ansf = "*";
							break o;
						}
					}
					ansf = ansf + first;
					for(int i=0;i<n;i++) {
						String curr = regex[i];
						if(curr.substring(0,1).equals("*")) continue;
						curr = curr.substring(1);
						regex[i] = curr;
					}
				} else if(!starlast) {
					String last = "";
					boolean haslast = false;
					for(int i=0;i<n;i++) {
						String curr = regex[i];
						String lastl = curr.substring(curr.length()-1,curr.length());
						if(lastl.equals("*")) continue;
						if(!haslast) {
							haslast = true;
							last = lastl;
							continue;
						}
						if(!last.equals(lastl)) {
							ansl = "*";
							break o;
						}
					}
					ansl = last + ansl;
					for(int i=0;i<n;i++) {
						String curr = regex[i];
						if(curr.substring(curr.length()-1,curr.length()).equals("*")) continue;
						curr = curr.substring(0,curr.length()-1);
						regex[i] = curr;
					}
				} else {
					for(int i=0;i<n;i++) {
						String curr = regex[i];
						for(int j=0;j<curr.length();j++) {
							if(curr.substring(j,j+1).equals("*")) continue;
							ansm = ansm + curr.substring(j,j+1);
						}
					}
					break o;
				}
//				System.out.println(starfirst+" | "+starlast);
//				System.out.println(ansf+" | "+ansm+" | "+ansl);
//				in.nextLine();
			}
			String answer = "*";
			if(ansf.equals("*")) answer = "*";
			else if(ansl.equals("*")) answer = "*";
			else answer = ansf+ansm+ansl;
			System.out.println("Case #"+(test+1)+": "+answer);
		}
		in.close();
	}
}