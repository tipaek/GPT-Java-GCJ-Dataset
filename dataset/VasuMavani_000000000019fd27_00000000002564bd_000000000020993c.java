import java.util.*;

public class Vest
{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		int c=1;
		while(test-->0){
			int sum=0;
			int count1=0,count2=0;
			int n=in.nextInt();
			int a[][]=new int[n][n];
			Set<Integer> s = new HashSet<Integer>();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					a[i][j]=in.nextInt();
				}
			}
			for(int i=0;i<n;i++){
				sum=sum+a[i][i];
			}
			
			for (int i=0;i<n;i++){
              for (int j=0;j<n;j++){
                 int CheckedNumber=a[i][j];
                 if(!s.add(CheckedNumber)){
					 count1++;
                     break;
                 }
              }
			  s.clear();
           }
		   
		   	for (int i=0;i<n;i++){
              for (int j=0;j<n;j++){
                 int CheckedNumber=a[j][i];
                 if(!s.add(CheckedNumber)){
					 count2++;
                     break;
                 }
              }
			  s.clear();
           }
		   
		   System.out.println("Case #"+c+": "+sum+" "+count1+" "+count2);
			c++;
			
		}
	}
} 