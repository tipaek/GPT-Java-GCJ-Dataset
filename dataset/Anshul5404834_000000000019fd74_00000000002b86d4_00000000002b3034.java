import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=1;test<=testcase;test++){
            int n=sc.nextInt();
            String[] arr=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.next();
            }
            System.out.println("Case #"+test+": "+fn(arr));
        }
    }
    public static String fn(String[] arr){
        String left="";
        String right="";
        for(int i=0;i<arr.length;i++){
            if(left=="*"){
                return left;
            }
            if(right=="*"){
                return right;
            }
            for(int j=0;j<arr[i].length();j++){
                if(arr[i].charAt(j)=='*'){
                    if(right.length()<arr[i].length()-j-1){
                        if(arr[i].substring(j+1,arr[i].length()).contains(right)){
                            right=arr[i].substring(j+1,arr[i].length());
                        }else{
                            right="*";
                            break;
                        }
                    }else{
                        if(right.contains(arr[i].substring(j+1,arr[i].length()))){
                            continue;
                        }else{
                            right="*";
                            break;
                        }
                        
                    }
                    if(left.length()<j){
                        if(arr[i].substring(0,j).contains(left)){
                            left=arr[i].substring(0,j);
                        }else{
                            left="*";
                            break;
                        }
                    }else{
                        if(left.contains(arr[i].substring(0,j))){
                            continue;
                        }else{
                            left="*";
                            break;
                        }
                        
                    }
                }
            }
        }
        return left+right;
    }
}
        