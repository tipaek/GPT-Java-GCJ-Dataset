import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int slices = in.nextInt();
			int diners = in.nextInt();
			long [] sizes=new long [slices];
			for (int j=0; j<slices; j++) {
				String temp=in.next();
				sizes[j]=Long.parseLong(temp);
			}
			int ans=find (slices, diners, sizes);
			System.out.println("Case #" + i + ": "+ans);
		}
	}
	public static int find (int slices, int num, long [] sizes) {
		ArrayList <Long> divisible=new ArrayList <Long> ();
		long divisor=findGCD (sizes,slices);
		int diners=num;
		for (int i=0; i<slices; i++) {
			if (divisor==sizes[i]) diners--;
			else if (sizes[i]%divisor==0) {
				divisible.add(sizes[i]/divisor);
			}
		}
		Collections.sort (divisible);
		int index=0;
		int cuts=0;
		while (index<divisible.size()&&(diners-divisible.get(index)>=0)){
			diners-=divisible.get(index);
			cuts+=divisible.get(index)-1;
			index++;
		}
		cuts+=diners;
		int ans=cuts;
		divisible=new ArrayList <Long> ();
		for (int i=0; i<slices; i++) {
			cuts=0;
			diners=num;
			for (int j=0; j<slices; j++) {
				if (sizes[i]==sizes[j]) diners--;
				else if (sizes[j]%sizes[i]==0) {
					long mag=sizes[j]/sizes[i];
					divisible.add(mag);
				}
			}
			Collections.sort (divisible);
			index=0;
			while (index<divisible.size()&&(diners-divisible.get(index)>=0)){
				Long div=divisible.get(index);
				diners-=div;
				cuts+=div-1;
				index++;
			}
			cuts+=diners;
			if (cuts<ans) ans=cuts;
		}
		return ans;
	}
	public static long gcd(long a, long b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b % a, a); 
	} 

	public static long findGCD(long arr[], int n) 
	{ 
		long result = arr[0]; 
		for (int i = 1; i < n; i++){ 
			result = gcd(arr[i], result); 

			if(result == 1) 
			{ 
				return 1; 
			} 
		} 
		return result; 
	}
}
