import java.lang.*;
import java.util.*;
import java.io.*;

class Solution{

	//final string
	static String fin;

	public static int A(int count, int no, String temp){
		
		//no of open brackets to be added
		int op=0;

		//no of closing brackets to be added
		int clo=0;

		int p=no;
		int j=0;
		if(count<p){

			op=p-count;
			for(j=0;j<op;j++){
				fin=fin+"(";
				//fin=fin.concat("(");
				count++;
			}
								
			fin=fin+temp;
			//fin=fin.concat(temp);
			//System.out.println("---"+fin);
		}
		else if(count>p){

			clo=count-p;
			for(j=0;j<clo;j++){
				fin=fin+")";
				//fin=fin.concat(")");
				count--;
			}
			fin=fin+temp;
			//fin=fin.concat(temp);
			//System.out.println("---"+fin);
		}
		else if(count==p){

			fin=fin+temp;
			//fin=fin.concat(temp);
			//System.out.println("---"+fin);
		}
		return count;
	}


	public static void main(String args[]){

		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream ps= new PrintStream(System.out);

		fin="";

		int test=0;
		//test=scan.nextInt();
		if(test>=1 && test<=100){

			int x=0;
			for(x=1;x<=test;x++){
				//System.out.println("Test Case:- "+x);

				String n;
				n=scan.nextLine();
				int len=n.length();

				if(len<=100 && len>=1){

					//current index we are at of the String n
					int ind=0;
					
					//character at the current index of string
					String temp="";
					//count of parenthesis
					int count=0;

					//no of opening parenthesis to be added
					int op=0;

					// no of closing parenthesis to be added
					int clo=0;

					int i=0, j=0;
					for(;i<len;i++){
						temp=n.substring(ind,ind+1);
						System.out.println("Substring is "+temp);

						if(temp=="0"){
							count=A(count,0,temp);
						}
						else if(temp=="1"){
							count=A(count,1,temp);
						}	
						else if(temp=="2"){
							count=A(count,3,temp);
						}	
						else if(temp=="3"){
							count=A(count,4,temp);

						}	
						else if(temp=="4"){
							count=A(count,4,temp);
						}
						else if(temp=="5"){
							count=A(count,5,temp);
						}	
						else if(temp=="6"){
							count=A(count,6,temp);
						}	
						else if(temp=="7"){
							count=A(count,7,temp);
						}
						else if(temp=="8"){
							count=A(count,8,temp);
						}
						else if(temp=="9"){
							count=A(count,9,temp);
						}

						ind++;
					}	

					for(j=0;j<count;j++){
						//fin=fin.concat(")");
						fin=fin+")";
						count--;
					}
					

				}
				//System.out.println("Hello");
				System.out.print("Case #"+x+": ");
				ps.print(fin);
				System.out.println("");
					
			}	

		}
	}
}