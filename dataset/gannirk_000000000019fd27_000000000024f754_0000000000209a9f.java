import java.util.*;
 class Solution{

     public static void main(String []args){
       Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        int i,j,z=1;
        int l,r,k;
        String s;
        String sd;
        while(z<=t){
            sd="";
            s=sc.nextLine();
            l=s.charAt(0)-48;
           for (j=1;j<=l;j++)
                   sd+="(";
            sd+=s.charAt(0);
            for (i=1;i<s.length();i++){
               r=s.charAt(i)-48;
               if (r<l){
                   k=l-r;
                   for (j=1;j<=k;j++)
                   sd+=")";
                   sd+=s.charAt(i);
                   l-=k;
               }
               else if (r>l){
                   k=r-l;
                  for (j=1;j<=k;j++)
                   sd+="(";
                   sd+=s.charAt(i);
                   l+=k;
               }
               else{
                   sd+=s.charAt(i);
               }
            }
            for (j=1;j<=l;j++)
                   sd+=")";
            System.out.println("Case #"+z+": "+sd);
            z++;
        }
       
     }
}
