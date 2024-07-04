import java.util.*;
class Solution{
    
    public static String Allocate(int s[],int e[]){
        String st="";
        for(int i=0;i<s.length;i++)
        {
         boolean j=true;
         boolean c=true;
         for(int k=0;k<i;k++)
         {
             if((s[i]>s[k]&&s[i]<e[k])||(e[i]>s[k]&&e[i]<e[k])||(s[i]<s[k]&&e[i]>e[k]))
             {
                 if(st.charAt(k)=='J')
                 j=false;
                 else
                 c=false;
             }
             
         }
         
        if(j==true)
        {
        st+="J";
        }
        else if(c==true)
        {
         st+="C";
        }
         else{
         return "IMPOSSIBLE";
         }
        
        
        }
        
        
        return st;
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        for(int i=1;i<=t;i++){
            int n =sc.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            for(int j=0;j<n;j++){
                s[j]=sc.nextInt();
                e[j]=sc.nextInt();
            }
            String st= Allocate(s,e);
            System.out.println("Case #"+i+": "+st);
        }
    }
}