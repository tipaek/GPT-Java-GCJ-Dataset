import java.util.*;
class Solution {
	public static void main(String asdf[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		if(t>=1 && t<=100) {
			x:for(int z=1;z<=t;z++) {
					int n = in.nextInt();
					if(n>=2 && n<=1000) {
						set a[] = new set[n];
						for(int i=0;i<n;i++) {
							int st = in.nextInt();
							int e = in.nextInt();
							if(st<0 || st>24*60 || e<0 || e>24*60) continue x;
							a[i] = new set(st,e);
						}
						a[0].setSlot('C');
						int st = a[0].getEnd();
						for(int i=1;i<a.length;i++) {
							if(a[i].getStart()>=st) {
								a[i].setSlot('C');n--;
								st = a[i].getEnd();
							}
						}
						st = 0;
						for(int i=1;i<a.length;i++) {
							if(a[i].isEmpty() && a[i].getStart() >= st) {
								a[i].setSlot('J');n--;
								st = a[i].getEnd();
							}
						}			
						System.out.printf("Case #%d: ",z);
						if(n==0) {
							for(int i=0;i<a.length;i++) System.out.print(a[i].getSlot());
							System.out.println();
						}
						else {
							label:{
								for(int i=0;i<a.length;i++) {
									if(a[i].isEmpty()) {
										for(int j=0;j<a.length;j++) {
											if(a[i].getStart() >= a[j].getStart()) {
												if(a[j].getSlot()=='J') a[i].setSlot('C');
												else a[i].setSlot('J');
												for(int k=0;k<a.length;k++) {
													if(a[k].getStart()<Math.min(a[i].getEnd(),a[j].getEnd()) && a[k].getStart() >= a[i].getStart() && k!=i && k!=j) {
														System.out.println("IMPOSSIBLE");
														break label;
													}
												}
											}
										}
									}
								
								}
								for(int i=0;i<a.length;i++) System.out.print(a[i].getSlot());
								System.out.println();
							}
						}
					}						
				}
			}
		}
	}
class set {
	private int start;
	private int end;
	private char slot='@';
	public set(int s,int e) {
		start = s;
		end  = e;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public void setSlot(char c) {
		slot = c;
	}
	public boolean isEmpty() {
		if(slot=='@') return true;
		return false;
	}
	public char getSlot() {
		return slot;
	}
}
	