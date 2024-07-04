import java.util.*;

public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int index = 1;index<=t;index++) {
            int n = sc.nextInt();
            Cameron c = new Cameron();
            Jamie j = new Jamie();
            Pair [] p = new Pair[n];
            for (int i =0;i<n;i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int [] a = new int[] {start, end};
                p[i] = new Pair(a, i);   
            }
            Arrays.sort(p);
            char [] ans = new char[n];
            boolean imp = false;
            for (int i =0;i<n;i++) {
            	int s = p[i].a[0];
            	int e = p[i].a[1];
            	int ind = p[i].b;
            	if (c.isBusy(s) && j.isBusy(s)) {
                    imp = true;
                    break;
                } else if (!c.isBusy(s)){
                    ans[ind]='C';
                    c.setTime(s, e);
                } else {
                    ans[ind]='J';
                    j.setTime(s, e);
                }
            }
            if (imp) {
            	System.out.println("Case #"+index+": "+"IMPOSSIBLE");
            } else {
            	System.out.print("Case #"+index+": ");
            	for (int i =0;i<n;i++) {
            		System.out.print(ans[i]);
            	}
            	System.out.println();
            }
            
        }
        sc.close();
    }
    
    static class Pair implements Comparable<Pair> {
		int [] a;
		int b;

		public Pair(int [] a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair p) {
			return this.a[0] - p.a[0];
		}
	}
}

class Cameron {
    int start, end;
    public Cameron() {
        this.start =0;
        this.end =0;
    }
    
    public void setTime(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public boolean isBusy(int startTime) {
        if (this.end>startTime) {
            return true;
        }
        return false;
    }
}

class Jamie {
    int startJ, endJ;
    public Jamie() {
        this.startJ =0;
        this.endJ =0;
    }
    
    public void setTime(int start, int end) {
        this.startJ = start;
        this.endJ = end;
    }
    
    public boolean isBusy(int startTime) {
        if (this.endJ>startTime) {
            return true;
        }
        return false;
    }
}