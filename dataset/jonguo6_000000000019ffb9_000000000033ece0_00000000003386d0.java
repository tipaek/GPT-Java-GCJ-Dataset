import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			String answer = "";
			int n = Integer.parseInt(in.nextLine());
			hole[] holes = new hole[n];
			for(int i=0;i<n;i++) {
				String[] input = in.nextLine().split(" ");
				int xx = Integer.parseInt(input[0]);
				int yy = Integer.parseInt(input[1]);
				holes[i] = new hole(xx,yy);
			}
			if(n <= 4) {
				System.out.println("Case #"+(test+1)+": "+n);
				continue;
			}
			ArrayList<line> lines = new ArrayList<line>();
			int bound = (int)Math.pow(2, n);
			for(int i=0;i<bound;i++) {
				String bob = Integer.toBinaryString(i);
				while(bob.length() < n) {
					bob = "0"+ bob;
				}
				int sum = 0;
				for(int j=0;j<n;j++) {
					sum += (bob.charAt(j)-'0');
				}
				hole[] linetest = new hole[sum];
				if(sum < 2) continue;
				int index = 0;
				for(int j=0;j<n;j++) {
					if(bob.charAt(j)=='1') {
						linetest[index] = holes[j];
						index++;
					}
				}
				boolean init = false;
				int dx = 0;
				int dy = 0;
				//System.out.println(bob);
				boolean good = true;
				o:
				for(int j=0;j<sum;j++) {
					for(int k=j+1;k<sum;k++) {
						int diffx = linetest[j].x - linetest[k].x;
						int diffy = linetest[j].y - linetest[k].y;
						if(!init) {
							dx = diffx;
							dy = diffy; 
							init = true;
						} else {
							//System.out.println("uh oh "+dx+" "+dy+" "+diffx+" "+diffy);
							if(dy*diffx != dx*diffy) {
								good = false;
								break o;
							}
						}
					}
				}
				if(!good) continue;
				line next = new line(dx,dy,bob);
				lines.add(next);
			}
			while(true) {
				boolean removed = false;
				p:
				for(int i=0;i<lines.size();i++) {
					for(int j=i+1;j<lines.size();j++) {
						line c = lines.get(i);
						line d = lines.get(j);
						if(c.dx*d.dy != c.dy*d.dx) continue;
						String boba = c.bob;
						String bobb = d.bob;
						boolean together = false;
						for(int k=0;k<n;k++) {
							if(boba.charAt(k)=='1' && bobb.charAt(k)=='1') {
								together = true;
								break;
							}
						}
						if(!together) continue;
						String nbob = "";
						for(int k=0;k<n;k++) {
							if(boba.charAt(k) == '1' || bobb.charAt(k) == '1') {
								nbob = nbob + "1";
							} else {
								nbob = nbob + "0";
							}
						}
						line nl = new line(c.dx,c.dy,nbob);
						lines.remove(c);
						lines.remove(d);
						lines.add(nl);
						removed = true;
						break p;
					}
				}
				if(!removed) break;
			}
			while(true) {
				boolean removed = false;
				o:
				for(int i=0;i<lines.size();i++) {
					line c = lines.get(i);
					if(c.sum > 2) continue;
					boolean unique = true;
					p:
					for(int j=0;j<lines.size();j++) {
						if(i==j) continue;
						line d = lines.get(j);
						if(c.dx*d.dy == c.dy*d.dx) { 
							unique = false;
							break p;
						}
					}
					if(unique) {
						lines.remove(c);
						removed = true;
					}
				}
				if(!removed) break;
			}
			//System.out.println("lines: ");
//			for(line c: lines) {
//				System.out.println(c);
//			}
			if(lines.size() == 0) {
				System.out.println("Case #"+(test+1)+": "+4);
				continue;
			}
			if(lines.size() == 1) {
				line only = lines.get(0);
				int length = only.sum;
				int ans = 0;
				if(length % 2 == 1) {
					ans = Math.min(length+1, n);
				} else {
					ans = Math.min(length+2, n);
				}
				System.out.println("Case #"+(test+1)+": "+ans);
				continue;
			}
			if(lines.size() == 2) {
				line c = lines.get(0);
				line d = lines.get(1);
				if(c.dx * d.dy == c.dy * d.dx) {
					int lc = c.sum;
					int ld = d.sum;
					if(lc%2==1 && ld%2==1) {
						int ans = Math.min(lc+ld+2, n);
						System.out.println("Case #"+(test+1)+": "+ans);
					} else if(lc%2==0 && ld%2==0) {
						int ans = Math.min(lc+ld+2, n);
						System.out.println("Case #"+(test+1)+": "+ans);
					} else {
						int ans = Math.min(lc+ld+2, n);
						System.out.println("Case #"+(test+1)+": "+ans);
					}
				} else {
					int length = Math.max(c.sum, d.sum);
					int ans = 0;
					if(length % 2 == 1) {
						ans = Math.min(length+1, n);
					} else {
						ans = Math.min(length+2, n);
					}
					System.out.println("Case #"+(test+1)+": "+ans);
				}
				continue;
			}
			if(lines.size() >= 3) {
				line[] testttt = new line[lines.size()];
				testttt = lines.toArray(testttt);
				Arrays.sort(testttt);
				line c = testttt[0];
				line d = testttt[1];
				line e = testttt[2];
				if(c.dx*d.dy == c.dy*d.dx) {
					if(c.dx*e.dy == c.dy*e.dx) {
						int ans = Math.min(c.sum+d.sum+e.sum+2, n);
						System.out.println("Case #"+(test+1)+": "+ans);
					} else {
						int lc = c.sum;
						int ld = d.sum;
						if(lc%2==1 && ld%2==1) {
							int ans = Math.min(lc+ld+2, n);
							System.out.println("Case #"+(test+1)+": "+ans);
						} else if(lc%2==0 && ld%2==0) {
							int ans = Math.min(lc+ld+2, n);
							System.out.println("Case #"+(test+1)+": "+ans);
						} else {
							int ans = Math.min(lc+ld+2, n);
							System.out.println("Case #"+(test+1)+": "+ans);
						}
					}
				} else {
					int ans = 0;
					if(c.sum%2==0) {
						ans = Math.min(c.sum+2,n);
					} else {
						ans = Math.min(c.sum+1,n);
					}
					System.out.println("Case #"+(test+1)+": "+ans);
				}
				continue;
			}
			System.out.println("Case #"+(test+1)+": "+answer);
			
		}
		in.close();

	}
	public static int gcd(int a, int b) {
		if(a==0) return b;
		if(b==0) return a;
		if(a==1) return 1;
		if(b==1) return 1;
		if(a>b) return gcd(b,a%b);
		return gcd(a,b%a);
	}
	static class line implements Comparable<line> {
		String bob = "";
		int dx = 0;
		int dy = 0;
		int sum = 0;
		public line(int a, int b, String c) {
			dx = a;
			dy = b;
			bob = c;
			for(int i=0;i<c.length();i++) {
				sum += (c.charAt(i)-'0');
			}
		}
		public String toString() {
			return dx+" "+dy+" "+bob;
		}
		@Override
		public int compareTo(line o) {
			return -1*Integer.compare(this.sum, o.sum);
		}
	}
	static class hole {
		int x,y;
		public hole(int a, int b) {
			x = a;
			y = b;
		}
	}
}
