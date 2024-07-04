
import java.util.Scanner;
public class Solution{
public static void main(String[]args) {
	Scanner in=new Scanner(System.in);
	int testcases=in.nextInt();
	String p="";
	String output []=new String[testcases];
	for(int t=0;t<testcases;t++) {
		p="";
     int brackets=0;
	  String input=in.next();
	  int size=input.length();
	  int size1=size+2;
	  int digits[]=new int [size1];
	   int x=Integer.parseInt(input);
	   digits[0]=0;
	   digits[size1-1]=0;
	   for(int i=size1-2;i>0;i--) {
		   digits[i]=x%10;
		   x=x/10;
	   }
	for(int i=0;i<size1-1;i++){
		brackets=digits[i+1]-digits[i];
		if(brackets>0){
		for(int y=0;y<brackets;y++){
		    p=p+("(");
		}
		}
		if(brackets<0){
		for(int y=brackets;y<0;y++){
		    p=p+(")");
		}
		}
		if(i!=size1-2)
		p=p+Integer.toString((digits[i+1]));
	}
	output[t]=p;
	}
	for(int i=0;i<testcases;i++) {
		System.out.print("Case #"+(i+1)+": ");
		System.out.println(output[i]);
	}

	
}
}