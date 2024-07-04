import java.util.*;
public class Solution{
    public static void main(String args[]){
      //  System.out.println("bhopal");
    int test;
    String str;
		Scanner sc = new Scanner(System.in);
	//	System.out.println("enter : ");
		test = sc.nextInt();
	  for(int z=0;z<test;z++){
		str = sc.next();
		int num = Integer.parseInt(str);
		//System.out.println(num);
		int[] a = new int[str.length()];
		for (int i = (a.length - 1); i >= 0; i--) {
			a[i] = num % 10;
			num = num / 10;
		}
		String sample = "";
		int count = 0, close = 0;
		for (int i = 0; i < a.length; i++) {
			while (count < a[i]) {
				sample = sample + "(";
				count++;
			}
			sample += String.valueOf(a[i]);
			if (i != a.length - 1) {
				if (count - a[i + 1] > 0) {
					close = count - a[i + 1];
					count = count - close;
				}
			} else {
				close = count;
			}
			while (close > 0) {
				sample = sample + ")";
				close--;
			}
		}
        System.out.print("Case #"+(z+1)+": ");
		System.out.print(sample);
		System.out.println();
	  }
	}
}
