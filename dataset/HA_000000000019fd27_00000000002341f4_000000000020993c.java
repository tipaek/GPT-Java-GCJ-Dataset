import java.util.*;
class Ves
     {
     public static void main(String[]args)
     {
     int t,n,i,j,c=0,r=0,x=0,tr=0;
     Scanner sc= new Scanner(System.in);
     t=sc.nextInt();
     while(t!=0)
     {
     n=sc.nextInt();
     int a[][]=new int[n][n];
     for(i=0;i<n;++i)
     for(j=0;j<n;++j)
     {
     a[i][j]=sc.nextInt();
     if(i==j) tr=tr+a[i][j];
     }
     int a1[]=new int[n];
     i=0;j=0;
     while (i<n)
     {
     for (j=0;j<n;++j)
     a1[j]=a[i][j];
     Arrays.sort(a1);
     for(j=0;j<n;++j)
     if (a1[j]==a1[j+1])
     {
     r++;
     continue;
     }
     ++i;
     }
     i=0;j=0;
     while(i<n)
     {
     for(j=0;j<n;++j)
     a1[j]=a[j][i];
     Arrays.sort(a1);
     for(j=0;j<n;++j)
     if(a[j]==a[j+1])
     {
     ++c;
     continue;
     }
     ++i;
     }
     System.out.println("Case #"+(x++)+":"+" "+tr+" "+r+" "+c);
     ++t;
     }
     }
     }
     