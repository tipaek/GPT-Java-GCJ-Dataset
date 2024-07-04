import java.util.*;



public class Solution {

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);



int t=sc.nextInt();
int T=t;
while(t-->0){

int n=sc.nextInt();
int a[][]=new int[n][4];
for (int i=0;i<n;i++)
{
a[i][0]=sc.nextInt();
a[i][1]=sc.nextInt();
a[i][2]=i;
}
Arrays.sort(a, new Comparator<int[]>() {
           
         @Override              
         
         public int compare(final int[] entry1,  
                            final int[] entry2) {
 
           
           if (entry1[0] > entry2[0])
               return 1;
           else
               return -1;
         }
       });
int c=0,j=0;
boolean f=false;
for(int i=0;i<n;i++)
{
if(c<=a[i][0])
{
a[i][3]=0;
c=a[i][1];
}
else if(j<=a[i][0])
{
a[i][3]=1;
j=a[i][1];
}
else
{
f=true;
break;
}

}
System.out.print("Case #"+(T-t)+": ");
if (f==true)
System.out.println("IMPOSSIBLE");
else
{
Arrays.sort(a, new Comparator<int[]>() {
           
         @Override              
         
         public int compare(final int[] entry1,  
                            final int[] entry2) {
 
           
           if (entry1[2] > entry2[2])
               return 1;
           else
               return -1;
         }
       });
for(int i=0;i<n;i++)
{
if(a[i][3]==0)
System.out.print("C");
else
System.out.print("J");
}
System.out.println();
}
//System.out.println(dig+" "+r+" "+c);
}
}
}