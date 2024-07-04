import java.util.*;
 class Solution{
    public static void main(String[] args)
    {
        int T,i,j,k,l,a,b,t=0,countOpen,countClose;
        Scanner scan = new Scanner(System.in);
        T=scan.nextInt();
        while((T--)>0)
        {
            t++;
            countOpen=0;
            countClose=0;
            System.out.print("Case #"+t+": ");
            String str,str1="";
            str=scan.next();
            char c;
            
            for(i=0;i<str.length();i++)
           {
               c=str.charAt(i);
               l=Integer.parseInt(c+"");
               if(i==0){
                    countOpen=l;
                    for(j=0;j<l;j++)
                        str1+="(";
               }
               else{
                   if(l>countOpen)
                   {
                       l=l-countOpen;
                       countOpen+=l;
                       for(j=0;j<l;j++)
                         str1+="(";
                       
                   }
                   else if(l<countOpen)
                   {
                       k=countOpen-l;
                       countOpen-=k;
                       countClose+=k;
                       for(j=0;j<k;j++)
                         str1+=")";
                   }
               }
                str1+=c;
                
           }
           for(j=0;j<countOpen;j++)
                str1+=")";
            System.out.println(str1);
        }
    }
}