import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    
    public static boolean isReverse(char[] arr,int n){
        for(int i=0;i<n/2;i++){
            if(arr[i] !=arr[n-1-i])return false;
        }
        
        return true;
    }
    
     public static boolean isComplement(char[] arr,int n,char[] arr1){
        for(int i=0;i<n;i++){
            if(arr[i] !=1-arr1[i])return false;
        }
        
        return true;
    }
    
    public static boolean isReverseAndComplement(char[] arr,int n){
        for(int i=0;i<n/2;i++){
            
            if(arr[i] =='1' && arr[n-1-i]!='0')return false;
            if(arr[i]=='0' && arr[n-1-i]!='1')return false;
        }
        
        return true;
    }
    
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        int b=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++){
            char[] arr=new char[b];
            for(int j=1;j<=b;j++){
                System.out.println(j);
                String str=in.next();
                in.nextLine();
                char ch=str.charAt(0);
                if(ch=='N')break;
                arr[j-1]=ch;
            }
            
            if(b>10 && b<=20){
                boolean isRev=isReverse(arr,b);
                if(isRev){
                    for(int j=1;j<=b/2;j++){
                        System.out.println(j);
                        String str=in.next();
                        in.nextLine();
                        char ch=str.charAt(0);
                        if(ch=='N')break;
                        arr[b-j-1]=ch;
                    }
                }else{
                    char[] arr1=new char[10];
                    for(int j=1;j<=10;j++){
                        System.out.println(j);
                        String str=in.next();
                        in.nextLine();
                        char ch=str.charAt(0);
                        if(ch=='N')break;
                        arr1[j-1]=ch;
                    } 
                    boolean isComplement=isComplement(arr,b,arr1);
                    
                    if(isComplement){
                        for(int j=11;j<b;j++){
                            arr[j]=arr[j]=='0'?'1':'0';
                        }
                    }else{
                        boolean isReverseAndComplement=isReverseAndComplement(arr,b);
                        if(isReverseAndComplement){
                            for(int j=1;j<=b/2;j++){
                                System.out.println(j);
                                String str=in.next();
                                in.nextLine();
                                char ch=str.charAt(0);
                                if(ch=='N')break;
                                arr[b-j-1]=ch;
                            }
                            for(int j=11;j<b;j++){
                                arr[j]=arr[j]=='0'?'1':'0';
                            }
                         
                    }
                    }
                    
                    
                }
            }
            
            System.out.println(new String(arr));
            String str=in.next();
            char ch=str.charAt(0);
            if(ch=='N')break;
            in.nextLine();
        }
    }
}