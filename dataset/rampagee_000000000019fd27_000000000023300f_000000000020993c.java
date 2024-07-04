import java.util.*;
import java.util.HashSet;
public class Solution {
public static void main(String []args) {
	Scanner sc = new Scanner(System.in);
	int x =sc.nextInt();
	for(int b=1;b<=x;b++) {
	int rc=sc.nextInt();
	int M[][]=new int[rc][rc];
	int k=0,r=0,c=0;
	for(int i=0;i<rc;i++) {
		for(int j=0;j<rc;j++) {
			M[i][j]=sc.nextInt();
		}
	}
	for(int i=0;i<rc;i++) {
		k+=M[i][i];
		HashSet<Integer> hr = new HashSet<>();
		HashSet<Integer> hc = new HashSet<>();
		for(int j=0;j<rc;j++) {
			hr.add(M[i][j]);
			hc.add(M[j][i]);
		}
		if(hr.size() < rc )
			r++;
		if(hc.size() < rc)
			c++;
		
	}
	System.out.println("Case #"+b+":"+" "+k+" "+r+" "+c);
}
}
}
