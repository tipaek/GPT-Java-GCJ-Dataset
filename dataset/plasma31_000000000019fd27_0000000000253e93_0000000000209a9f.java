import java.util.*;

public class Solution{
	static Scanner s=new Scanner(System.in);
    public static void main(String[] args) {
	    int nofarr;
	    String n;
		nofarr=s.nextInt();
		for(int i=0;i<nofarr;i++) {
			n=s.next();
			takeInput(n,i);
		}
	}
	static void takeInput(String n,int caseno){
		int i;
		boolean check=true;
		String output="";
		for(i=0;i<n.length();i++){
			if(check==true) {
				if(n.charAt(i)=='1') {
					check=false;
					output=output.concat("("+n.charAt(i));
				}else if(n.charAt(i)=='0') {
					output=output.concat("0");
				}
			}else{
				if(n.charAt(i)=='0') {
					check=true;
					output=output.concat(")"+n.charAt(i));
				}else if(n.charAt(i)=='1') {
					output=output.concat("1");
				}
			}

		}
		if(n.charAt(n.length()-1)=='1') {
			output=output.concat(")");
		}
		printCase(caseno+1,output);
	}
	
	static void printCase(int n,String seq){
        System.out.println("Case #"+n+": "+seq);
	}
}
