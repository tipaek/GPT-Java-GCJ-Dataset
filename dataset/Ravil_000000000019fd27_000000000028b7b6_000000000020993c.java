import java.util.*;
 class codejam {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();
         int t1=1;
         while(t1<=t)
         {
        	 int n=sc.nextInt();
        	 long a[][]=new long[n][n];
        	 for(int i=0;i<n;i++)
        	 {
        		 for(int j=0;j<n;j++)
        		 {
        		  a[i][j]=sc.nextLong();	 
        		 }
        	 }
        	 long trace=0;
        	 for(int i=0;i<n;i++)
        	 {
        		 trace+=a[i][i];
        	 }
        	 int cl=0;
        	 int ro=0;
        	 for(int i=0;i<n;i++)
        	 {
                 HashSet<Long> h=new HashSet<>();
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
                 HashSet<Long> h=new HashSet<>();
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
        	 System.out.println("Case #"+t1+": "+trace+" "+ro+" "+cl);
        	 t1++;
         }
	}
}
