import java.util.*;

class Main
{
      public static void main(String[] args)
    {
    Scanner sc=new Scanner(System.in);
   
     int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int count=0;
    String s=sc.next();
    String g=" ";
    int l=s.length();
    if(l==1 && s.charAt(0)!='0'){
        g=g+"(";
        count++;
    }
    for(int i=0;i<l-1;i++)
    {
       int p=Character. getNumericValue(s.charAt(i));
       int m=Character. getNumericValue(s.charAt(i+1));

       if(g.charAt(g.length()-1)!=s.charAt(i)){
       for(int j=0;j<p;j++)
       {
           
           g=g+"(";
           count++;
       }
       }
     g=g+s.charAt(i);
       if(m>p)
       {
           int d=m-p;
           for(int x=0;x<d;x++){
           g=g+"(";
           count++;
           }
        //    g=g+s.charAt(i+1);
        
       }
       if(p>m)
       {
           int d=p-m;
           for(int x=0;x<d;x++){
           g=g+")";
           count--;
           }
          // g=g+s.charAt(i+1);
       }
 
    
    }
  g=g+s.charAt(l-1);
    for(int i=0;i<count;i++)
   g=g+")";
    System.out.println("case #"+k+": "+g.substring(1,g.length()));
    }
    }
    
}