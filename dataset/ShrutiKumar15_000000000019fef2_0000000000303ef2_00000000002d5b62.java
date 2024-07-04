//package competitive;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc =  new Scanner(System.in);
		if(sc.hasNext()) {
			int t = sc.nextInt();
			for(int tt=0; tt<t; tt++) {
				int x =sc.nextInt();
				int y= sc.nextInt();
				int odd=0;
				int even=0;
				int sum=0;
				if( (x%2!=0 && y%2==0) ||(x%2==0 && y%2!=0)){
					if(x%2!=0) {
						odd = x;
						even=y;
					}
					else if(y%2!=0){
						odd=y;
						even=x;
					}
					sum=Math.abs(odd+even);
					int pow=1;
					while(pow<sum) {
						pow=2*pow;
					}
					int n= (int)(Math.log(pow) / Math.log(2));
					List<Integer> l = new ArrayList<>();
					for(int i=1; i<=n; i++) {
						
						l.add((int) Math.pow(2, i));
					}
					for(int i=0; i<l.size()/2; i++) {
						int n1=i+1;
						int n2=l.size()-n1;
						for(int j=0; j<l.size(); j++) {
							
						}
						
					}
					
				}
				else {
					System.out.println("IMPOSSIBLE");
				}
				System.out.println("Case #"+(tt+1)+": ");
			}
				
        }
    }
   
   
 }		

