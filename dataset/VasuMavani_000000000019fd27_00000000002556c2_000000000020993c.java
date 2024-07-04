import java.util.*;

public class Vestigium
{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		int c=1;
		while(test-->0){
			int sum=0;
			int c1=0,c2=0;
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
                 int cn=a[i][j];
                 if(!s.add(cn)){
					 c1++;
                     break;
                 }
              }
			  s.clear();
           }
		   
		   	for (int i=0;i<n;i++){
              for (int j=0;j<n;j++){
                 int cn=a[j][i];
                 if(!s.add(cn)){
					 c2++;
                     break;
                 }
              }
			  s.clear();
           }
		   
		   System.out.println("Case #"+c+": "+sum+" "+c1+" "+c2);
			c++;
			
		}
	}
} 