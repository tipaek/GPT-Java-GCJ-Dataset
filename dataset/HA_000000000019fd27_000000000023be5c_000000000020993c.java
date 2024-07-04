import java.util.*;
public class Ves
     {
     public static void main(String[]args)
     {
     int t,n,i,j,c=0,r=0,x=1,tr=0;
     Scanner sc= new Scanner(System.in);
     t=sc.nextInt();
     while(t>0)
     {
     n=sc.nextInt();
     int a[][]=new int[n][n];
     for(i=0;i<n;++i)
     for(j=0;j<n;++j)
     {
     a[i][j]=sc.nextInt();
     }
     for(i=0;i<n;++i)
     tr=tr+a[i][i];
     int a1[]=new int[n];
     int a2[]=new int[n];
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
     break;
     }
     ++i;
     }
     i=0;j=0;
     while(i<n)
     {
     for(j=0;j<n;++j)
     a2[j]=a[j][i];
     Arrays.sort(a2);
     for(j=0;j<n;++j)
     if(a2[j]==a2[j+1])
     {
     ++c;
     break;
     }
     ++i;
     }
     System.out.println("Case #"+(x++)+":"+" "+tr+" "+r+" "+c);
     --t;
     }
     }
     }
     