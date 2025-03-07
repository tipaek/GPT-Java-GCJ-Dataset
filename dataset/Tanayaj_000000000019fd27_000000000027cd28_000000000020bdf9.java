import java.util.*;
class Solution{
    
    public static String Allocate(int s[],int e[]){
    Hashtable<Integer,String> ht = new Hashtable<>();
    ht.put(0,"J");
    ht.put(1,"C");
    for(int i=2;i<s.length;i++)
    {
        for(int j=0;j<i;j++){
            
            if( (e[i]<=s[j] || s[i]>=e[j]))
            {
            ht.put(i,ht.get(j));
            break;
            }
            }
            
        }
        
        
    
    String st="";
    for(int i=0;i<s.length;i++){
        if(ht.get(i)==null)
        continue;
        st+=ht.get(i);
    }
   if(st.length()!=s.length)
   return "IMPOSSIBLE";
   else
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