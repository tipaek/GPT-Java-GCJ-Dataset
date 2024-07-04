	import java.util.Scanner;
	
	public class Solution {
	
		public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
			int N=input.nextInt();
			input.nextLine();
			int n=0;
			String []strArr=new String[N];
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<=N;i++){
				sb=new StringBuilder();
				String T = input.nextLine();
				char arr1[]=T.toCharArray();
				int arr2[]=new int[arr1.length];
				for(int j=0;j<arr1.length;j++) {
					arr2[j]=Integer.parseInt(String.valueOf(arr1[j]));
				}
				for(int j=0;j<arr2.length;j++) {
					if((j==0)||(j!=0&&(arr2[j]!=arr2[j-1]))){
						for(int k=0;k<arr2[j];k++) {
							sb.append("(");
						}
					}
					
					sb.append(arr2[j]);
					if((j==((arr2.length)-1))||(arr2[j+1]!=arr2[j])) {
						for(int k=0;k<arr2[j];k++) {
							sb.append(")");
						}	
					}
					
				}					strArr[n]=sb.toString(); n++;
			} 
			for(int i=0;i<strArr.length;i++) {
				System.out.printf("Case #%d: %s\n",i+1,strArr[i]);
			}
		}
	
		}
