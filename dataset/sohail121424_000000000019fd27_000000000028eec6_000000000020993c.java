import java.util.Scanner;
import java.util.HashSet;
class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();
         int t1=1;
         while(t!=0)
         {
        	 int n=sc.nextInt();
        	 int a[][]=new int[n][n];
        	 for(int i=0;i<n;i++)
        	 {
        		 for(int j=0;j<n;j++)
        		 {
        		  a[i][j]=sc.nextInt();	 
        		 }
        	 }
        	 int trace=0;
        	 for(int i=0;i<n;i++)
        	 {
        		 trace+=a[i][i];
        	 }
        	 int cl=0;
        	 int ro=0;
        	 for(int i=0;i<n;i++)
        	 {
                 HashSet<Integer> h=new HashSet<>();
        		 for(int j=0;j<n;j++)
        		 {
        			 if(h.contains(a[i][j]))
        			 {
        				 ro++;
        				 break;
        			 }
        			 h.add(a[i][j]);
        		 }
        	 }
        	 for(int i=0;i<n;i++)
        	 {
                 HashSet<Integer> h=new HashSet<>();
        		 for(int j=0;j<n;j++)
        		 {
        			 if(h.contains(a[j][i]))
        			 {
        				 cl++;
        				 break;
        			 }
        			 h.add(a[j][i]);
        		 }
        	 }
        	 --t;
        	 System.out.println("Case #"+t1+": "+trace+" "+ro+" "+cl);
        	 t1++;
         }
	}

}