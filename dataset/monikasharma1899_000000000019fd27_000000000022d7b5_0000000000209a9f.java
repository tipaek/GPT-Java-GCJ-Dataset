import java.util.*;
class Solution{
  public static void main(String args[]){
      Scanner sc= new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=0;t<T;t++){
        String s= sc.next();
        char[] arr = s.toCharArray();
        List<Character> stack = new ArrayList<>();
        
    
        for(int k=0;k<Character.getNumericValue(arr[0]);k++){
            //System.out.println(arr[0]);
            stack.add('(');
        }
        stack.add(arr[0]);
        for(int i=1;i<s.length();i++){
            if(arr[i]>arr[i-1]){
                for(int k=0;k<arr[i]-arr[i-1];k++){
                    stack.add('(');
                }
                stack.add(arr[i]);
            }
            if(arr[i]<arr[i-1]){
                for(int k=0;k<arr[i-1]-arr[i];k++){
                    stack.add(')');
                }
                stack.add(arr[i]);
            }
            if(arr[i]==arr[i-1]){
                stack.add(arr[i]);
            }
        }
        for(int k=0;k<Character.getNumericValue(arr[s.length()-1]);k++){
            stack.add(')');
        }
         
        StringBuilder sb = new StringBuilder(); 
  
        for (Character ch : stack) { 
            sb.append(ch); 
        } 
        String string = sb.toString();
        System.out.println(string);
    }
        
        
    }
}