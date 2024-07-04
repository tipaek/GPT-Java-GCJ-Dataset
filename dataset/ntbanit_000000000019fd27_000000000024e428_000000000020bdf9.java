import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        int tc = 1;
        
        class A {
        	A(int s, int e) {
        		this.s = s;
        		this.e = e;
        	}
        	int s, e;
        }
        
        while (T-- > 0) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int tempOfC = -1, tempOfJ = -1;
            boolean isOk = true;
            
            List<A> items = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                items.add(new A(start, end));
            }
            
            items.sort(new Comparator<A>() {
				@Override
				public int compare(A o1, A o2) {
					if (o1.e != o2.e) return o1.s - o2.s;
					return o1.e - o2.e;
				}
			});
            
            for(A a: items) {
                if (!isOk) continue;
                if (a.s >= tempOfC) {
                    sb.append('C');
                    tempOfC = a.e;
                } else if(a.s >= tempOfJ) {
                    sb.append('J');
                    tempOfJ = a.e;
                } else {
                    isOk = false;
                    break;
                }
            }
            
            System.out.printf("Case #%d: %s\n", tc++, !isOk ? "IMPOSSIBLE" : sb.toString());
        }
    }
}