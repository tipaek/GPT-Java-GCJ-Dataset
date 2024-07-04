//
//				rem = n;
//			}
//			int prev = 0;
//			int i = 0;
//			boolean l  = false;
//			System.out.println("Case #"+j+":");
//			j++;
//			while (i < ar.size()) {
//				int el = ar.get(i);
//				if (i % 2 == 0) {
//					while(prev  < el -1 ) {
//						prev++;
//						System.out.println(prev+" "+1);
//					}
//					
//					for (int k = 1; k <= el; k++) {
//						System.out.println(el+" "+k);
//					}
//					l = false;
//					prev = el ; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//
//				rem = n;
//			}
//			int prev = 0;
//			int i = 0;
//			boolean l  = false;
//			System.out.println("Case #"+j+":");
//			j++;
//			while (i < ar.size()) {
//				int el = ar.get(i);
//				if (i % 2 == 0) {
//					while(prev  < el -1 ) {
//						prev++;
//						System.out.println(prev+" "+1);
//					}
//					



//					for (int k = 1; k <= el; k++) {
//						System.out.println(el+" "+k);
//					}
//					l = false;
//					prev = el ; 

public class Solution{
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = s.nextLong();
        //
//				rem = n;
//			}
//			int prev = 0;
//			int i = 0;
//			boolean l  = false;
//			System.out.println("Case #"+j+":");
//			j++;
//			while (i < ar.size()) {
//				int el = ar.get(i);




//				if (i % 2 == 0) {
//					while(prev  < el -1 ) {
//						prev++;
//						System.out.println(prev+" "+1);
//					}
//					
//					for (int k = 1; k <= el; k++) {
//						System.out.println(el+" "+k);
//					}
//					l = false;
//					prev = el ; 
		int j = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			ArrayList<Integer> ar = new ArrayList<Integer>();


			int d = (int) (Math.log10(n) / Math.log10(2));
			int rem = 0;
			if (Math.pow(2, d) + (d) > n) {
				for (int i = 0; i < d; i++) {


					ar.add(i + 1);
				}
				rem = (int) (n - Math.pow(2, d) + 1);




			} else {
				ar.add(d + 1);
				n = (int) (n - (Math.pow(2, d) + (d)));


				for (int i = d - 1; i >= 1; i--) {


					int temp = (int) (Math.pow(2, i) - 1);
					if (temp <= n) {


						n -= temp;
						ar.add(0, i + 1);
					}
                    //
//				rem = n;
//			}
//			int prev = 0;
//			int i = 0;
//			boolean l  = false;




//			System.out.println("Case #"+j+":");
//			j++;
//			while (i < ar.size()) {
//				int el = ar.get(i);
//				if (i % 2 == 0) {
//					while(prev  < el -1 ) {
//						prev++;
//						System.out.println(prev+" "+1);
//					}
//					
//					for (int k = 1; k <= el; k++) {
//						System.out.println(el+" "+k);
//					}
//					l = false;
//					prev = el ; 
				}

				rem = n;
			}
			int prev = 0;


			int i = 0;
			boolean l  = false;
			System.out.println("Case #"+j+":");
			j++;
			while (i < ar.size()) {
				int el = ar.get(i);
				if (i % 2 == 0) {
					while(prev  < el -1 ) {
						prev++;
						System.out.println(prev+" "+1);

                        
					}
                    //
//				rem = n;
//			}
//			int prev = 0;
//			int i = 0;
//			boolean l  = false;
//			System.out.println("Case #"+j+":");
//			j++;
//			while (i < ar.size()) {
//				int el = ar.get(i);
//				if (i % 2 == 0) {
//					while(prev  < el -1 ) {
//						prev++;
//						System.out.println(prev+" "+1);
//					}
//					
//					for (int k = 1; k <= el; k++) {
//						System.out.println(el+" "+k);
//					}
//					l = false;
//					prev = el ; 
					
					for (int k = 1; k <= el; k++) {
						System.out.println(el+" "+k);
					}
					l = false;
					prev = el ; 
				} else {
					while(prev  < el -1 ) {
						prev++;
						System.out.println(prev+" "+prev);
					}
					
					for (int k = el; k >=1 ; k--) {
						System.out.println(el+" "+k);
					}
					prev = el ; 
					l = true;

				}
				i++;
			}
			
         while(rem>0) {
        	 if(l) {
        		 prev++;
        		 System.out.println(prev + " "+1);
        	 }else {
        		 prev++;
        		 System.out.println(prev + " "+prev);        		 
        	 }
        	 rem--;
         }
			
		}
	}

}
