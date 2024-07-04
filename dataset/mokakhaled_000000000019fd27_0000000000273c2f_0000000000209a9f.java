
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
	/*for(int i=0;i<size1;i++) {
		System.out.println(digits[i]);
	}
	*/
	
	
	for(int i=0;i<size1-1;i++){
		brackets=digits[i+1]-digits[i];
		//System.out.println(brackets);
	
		switch(brackets) {
		case 1:
			p=p+("(");
			break;
		case 2:
			p=p+("((");
		    break;
		case 3:
			p=p+("(((");
		    break;
		case 4:
			p=p+("((((");
		    break;
		case 5:
			p=p+("(((((");
		   break;
		case 6:
			p=p+("((((((");
		   break;
		case 7:
			p=p+("(((((((");
		   break;
		case 8:
			p=p+("((((((((");
		   break;
		case 9:
			p=p+("(((((((((");
	       break;
		
		case -1:
			p=p+(")");
			break;
		case -2:
			p=p+("))");
	   	    break;
		case -3:
			p=p+(")))");
		    break;
		case -4:
			p=p+("))))");
		    break;
		case -5:
			p=p+(")))))");
		   break;
		case -6:
			p=p+("))))))");
			break;
		case -7:
			p=p+(")))))))");
			break;
		case -8:
			p=p+("))))))))");
			break;
		case -9:
	        p=p+(")))))))))");
			break;
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