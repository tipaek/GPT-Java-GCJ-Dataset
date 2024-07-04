import java .util.Scanner;
class codejamqualify {
public static void main(String args[]) {
	Scanner s=new Scanner(System.in);
	String str,str2;
	int row=0,col=0,sum=0;
	
	int mat[][] =new int[4][4];
	int test=s.nextInt();
	String ans[]=new String[test];
	for(int k=0;k<test;k++) {
		int size=s.nextInt();
		 row=0;
		 col=0;
		 sum=0;
		 s.nextLine();
		for(int i=-0;i<size;i++) {
		str=s.nextLine();
		
		String split[]=str.split(" ");
		for(int j=0;j<split.length;j++) {
			mat[i][j]=Integer.parseInt(split[j]);	
		}
	}
		for(int i=0;i<size;i++) {
			str="";
			 str2="";
			 sum=sum+mat[i][i];
			for(int j=0;j<size;j++) {
				
				if(str.contains(" "+mat[i][j]+" ")) {
			    	row++;
			    	break;
			     }	
			    else
			    	str=str+" "+mat[i][j]+" ";
				
				}
			for(int j=0;j<size;j++) {
				if(str2.contains(" "+mat[j][i]+" ")) {
			    	col++;
			    	break;
			     }	
			    else
			    	str2=str2+" "+mat[j][i]+" ";
				}
			
			
		}
		ans[k]="Case #"+(k+1)+":"+" "+sum+ " "+row+" "+col;
	
	
	}
	for(int i=0;i<test;i++) {
		
		System.out.println(ans[i]);
	}
	
	
	
		
}
}
