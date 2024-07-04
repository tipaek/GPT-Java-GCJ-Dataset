import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		for (int q = 0; q < num; q++) {
			int n=sca.nextInt();
			int[][]unit=new int[n][2];
			for(int i=0;i<n;i++) {
				unit[i][0]=sca.nextInt();
				unit[i][1]=sca.nextInt();
			}
			
			ArrayList<Integer>c=new ArrayList<Integer>();
			ArrayList<Integer>j=new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				if(!j.contains(i)) {
					c.add(i);
					for(int k=i+1;k<n;k++) {
						if(!j.contains(k)) {
							if(!(unit[i][0]>=unit[k][1]||unit[i][1]<=unit[k][0])) {
								j.add(k);
							}
						}
					}
				}
			}
	
			boolean isImpossible =false;
			for(int i=0;i<j.size()-1;i++) {
				for(int k=i+1;k<j.size();k++) {

					if(!(unit[j.get(i)][0]>=unit[j.get(k)][1]||unit[j.get(i)][1]<=unit[j.get(k)][0])) {
						isImpossible=true;
						
					}
				}

			}

			if(isImpossible) {
				System.out.println("Case #"+(q+1)+": IMPOSSIBLE");
			}else {
				System.out.print("Case #"+(q+1)+": ");
				for(int i=0;i<n;i++) {
					if(c.contains(i)) {
						System.out.print("C");
					}else {
						System.out.print("J");
					}
				}
				System.out.println();
			}
		}
	}
}