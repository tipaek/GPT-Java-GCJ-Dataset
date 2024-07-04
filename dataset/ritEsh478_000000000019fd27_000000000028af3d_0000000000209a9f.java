import java.util.*;

class Solution{
	public static void main(String []args){
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  int l=1;
	  while(l<=t){
	  String x=sc.next();
	  int c=0;
	  String res="";
	  Stack<String> stack=new Stack<String>();
	  for(int i=0;i<x.length();i++){
	  	int num=(int)(x.charAt(i)-'0');
	  	if(num==0){
			while(c!=0 && stack.empty()==false){
				c--;
				res+=(stack.pop());
				}
	  	res=res+"0";
	  	}
	  	else{
	  		if(c<num){
	  		for(int j=0;j<num-c;j++){
	  			res+="(";
	  			stack.push(")");
	  		}

	  		c=num;
	  		}
	  		else if(c>num){
	  		while(c!=num){
	  			c--;
	  			res+=(stack.pop());
	  			}

	  		}
	  		res+=(""+x.charAt(i));

	  	}

	  }
	  while(stack.empty()==false){
	  	res+=(stack.pop());
	 	}
	  System.out.println("Case #"+l+": "+res);
		l++;
	  }
	}
}