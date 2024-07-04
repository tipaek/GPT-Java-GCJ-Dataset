import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tests=sc.nextInt();
        for(int t=1;t<=tests;t++){
            int n=sc.nextInt();
            String arr[]=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.next();
            }
            Arrays.sort(arr,new Comparator<String>(){
               public int compare(String a,String b){
                   return a.length()-b.length();
               } 
            });
            String ans="";
            for(int i=1;i<n;i++){
                if(checkString(arr[i],arr[i-1])==false){
                   ans="*";
                   break;
                }else{
                    ans=arr[i].substring(1);
                }
            }
            System.out.println("Case #"+t+": "+ans);
        }
    }
    public static boolean checkString(String a,String b){
        int len1=a.length();
        int len2=b.length();
        len2--;
        return a.substring(len1-len2).equals(b.substring(1));
    }
}