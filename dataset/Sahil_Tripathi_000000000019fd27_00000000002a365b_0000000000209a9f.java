

import java.util.Scanner;

public class Solution {
	static int mastercount=0;
	public static void main(String[] args) {
		String s;
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		for(int i=0;i<a;i++) {
			s=sc.next();
			Calculate(s);
		}
	}
		public static void Calculate(String ss) {mastercount++;
		System.out.print("Case #"+mastercount+":"+" ");
			int e=0;
			String array2[]=new String[10000];
			int range=ss.length()+2;
			String output="";
			char[] array=new char[range];
			int[] array1=new int[range];
			for(int i=0;i<range;i++)
				if(i==0 || i==range-1)
					array[i]='0';
				else array[i]=ss.charAt(i-1);
			for(int i=0;i<range;i++) 
				 array1[i]=(char) Character.getNumericValue(array[i]);
			
				 
					for(int m=0;m<array1.length-1;m++) {
						int z=m+1;
						if(array1[z]>array1[m]){
					int loca =array1[z]-array1[m]; 
					for(int n=0;n<loca;n++)
						System.out.print("(");
					if(Integer.toString(array1[z])=="0");
					else output=Integer.toString(array1[z]);
					z++;
					}
					else if (array1[z]<array1[m]) {
						int loca =array1[m]-array1[z]; 
						for(int n=0;n<loca;n++)
							System.out.print(")");
						if(Integer.toString(array1[z])=="0");
						else output=Integer.toString(array1[z]);
						z++;
					}
					else if (array1[z]==array1[m]) {
						if(Integer.toString(array1[z])=="0");
						else output=Integer.toString(array1[z]);
						z++;
						}
						array2[m]=output;
						//for(int i=0;i<array2.length;i++)
						if(m==array1.length-2);
						else System.out.print(array2[m]);
					}
					
					
		}
}
