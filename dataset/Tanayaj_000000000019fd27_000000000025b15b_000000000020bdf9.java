import java.util.*;
class Solution{
    
    public static String Allocate(int s[],int e[]){
    Hashtable<Integer,String> ht = new Hashtable<>();
    ht.put(0,"J");
    for(int i=1;i<s.length;i++)
    {
        for(int j=0;j<i;j++){
            if(s[i]<=s[j] && e[i]<=s[j])
            {
            ht.put(i,"J");
            break;
            }
            else if(s[i]>=e[j]&& e[i]>=e[j] )
            {
            ht.put(i,"J");
            break;
            }
            else
            {
            if(ht.get(j)!="C")
            {
            ht.put(i,"C");}
            else 
            {
            return "IMPOSSIBLE";}
            }
        }
        
        
    }
    String st="";
    for(int i=0;i<s.length;i++){
        st+=ht.get(i);
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