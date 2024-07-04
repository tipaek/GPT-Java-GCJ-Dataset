import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c =0;
		while(t>0) {
			t--;
			c++;
			int n= sc.nextInt();
			int d = sc.nextInt();
			long [] a=  new long[n];

			for(int i=0;i<n;i++) {
				a[i] = sc.nextLong();
			}
			Arrays.sort(a);
			int numCuts = d;
			for(int i=0;i<n;i++) {
				for(int j=0;j<d;j++) {
					//break a[i] into (j+1) pieces by making j cuts....
					//size of each is a[i]/(j+1)? for people to be happy^
					int numCutsMade = 0;
					int numHappy = 0;
					for(int k=0;k<n;k++) {

						long x = (long) a[k]*(j+1);
						if((x%a[i])==0) {
							long cut = x/a[i]-1;
							long extrahappy = x/a[i];
							if((extrahappy+numHappy)<=d) {
								numCutsMade+=cut;
								numHappy+=extrahappy;
							}
							else {
								numCutsMade+=(d-numHappy);
								numHappy = d;
								//break?
							}
						}
					}
					for(int k=0;k<n;k++) {
						long x = (long) a[k]*(j+1);
						if((x%a[i])!=0) {
							long cut = x/a[i];
							long extrahappy = x/a[i];
							if((extrahappy+numHappy)<=d) {
								numCutsMade+=cut;
								numHappy+=extrahappy;
							}
							else {
								numCutsMade+=(d-numHappy);
								numHappy = d;
								//break?
							}
						}
					}
					if(numHappy<d)
						continue;
					else {
						numCuts = Math.min(numCuts,numCutsMade);

					}

				}
			}
			numCuts = Math.min(numCuts,d-1);
			System.out.println("Case #"+c+": "+numCuts);
		}
	}

}
