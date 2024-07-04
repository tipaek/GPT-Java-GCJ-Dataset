
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) {
			int t = s.nextInt();
			int jk =1;
//		for(int l = -4 ; l<=4 ; l++) {
//			for(int m = -4 ; m<=4 ; m++) {			
			while(t-->0) {
				long x = s.nextLong();
				long y = s.nextLong();
				boolean xneg = false;
				if(x<0)
					xneg= true;
				boolean yneg = false;
				if(y<0)
					yneg= true;
				 x = Math.abs(x);
				 y = Math.abs(y);
				long temp1 = x;
				 long temp2=y;
				 
			
				 int prev = -1 ;
				 boolean one = true;
				 boolean ans = true;
				 for(int i = 0 ; i < 32 ;i++) {
					if(( ((x>>i)&1)^(1&(y>>i)) ) ==1) {
						prev = i;
						if(((y>>i) &(1)) ==1)
							one = false;
						else 
							one = true;
					}else if(( ((x>>i)&1)&(1&(y>>i)) ) ==1) {
						if(prev!=-1) {
							if(one) {
								 prev++;
								while(prev<=i) {
								x = (int) (x + Math.pow(2, prev));
								prev++;}
							}else {
								 prev++;
								while(prev<=i) {
								y = (int) (y + Math.pow(2, prev));
								prev++;}
							}
								
						}else {
							ans = false;
							break;
						}
					}
					if(((x>>(i+1))==0 && (y>>(i+1))==0)) {
						break;
					}
				 }
				// System.out.println(x+" "+y);
				 String aans ="";
				for(int i = 0 ; i<32 ; i++) {
					if(( 1&(x>>i))==0  && (1&(y>>i))==0) {
						
						ans = false;
						break; 
					}
					if(((x>>i)&1)==1) {
						if(((x>>(i+1))&1)==(1&(temp1>>(i+1))) ){
							aans+="E";
						}else {
							aans+="W";
						}
					}
					
					if(((y>>i)&1)==1) {
						if(((y>>(i+1))&1)==(1&(temp2>>(i+1)))) {
							aans+="N";
						}else {
							aans+="S";
						}
					}
					
					if(((x>>(i+1))==0 && (y>>(i+1))==0)) {
						break;
					}
						
				}
				if(xneg) {
					String new_ans ="";
							for(int i = 0 ; i<aans.length() ; i++) {
								if(aans.charAt(i)=='E') {
									new_ans+='W';
								}else if (aans.charAt(i)=='W') {
									new_ans+='E';
								}else {
									new_ans+=aans.charAt(i);

								}
							}
						aans=	new_ans ;
				}
				if(yneg) {
					String new_ans ="";
							for(int i = 0 ; i<aans.length() ; i++) {
								if(aans.charAt(i)=='N') {
									new_ans+='S';
								}else if (aans.charAt(i)=='S') {
									new_ans+='N';
								}else {
									new_ans+=aans.charAt(i);

								}
							}
						aans=	new_ans ;
				}
			
				if(ans) {
					System.out.println("Case #"+jk+": "+aans);
				}else {
					System.out.println("Case #"+jk+": IMPOSSIBLE");
				}
				jk++;
			}
	}
	static void decToBinary(long n) 
    { 
        // array to store binary number 
        int[] binaryNum = new int[32]; 
  System.out.print(n+" ");
        // counter for binary array 
        int i = 0; 
        while (n > 0) { 
            // storing remainder in binary array 
            binaryNum[i] = (int) (n % 2); 
            n = n / 2; 
            i++; 
        } 
  
        // printing binary array in reverse order 
        for (int j = i - 1; j >= 0; j--) 
            System.out.print(binaryNum[j]);
        System.out.println();
    } 
}
