import java.util.*;
class Solution{
  public static void main(String args[]){
      Scanner sc= new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=1;t<=T;t++){
        String s= sc.next();
        char[] MyArray = s.toCharArray();
        String new_s ="";
        
    
        for(int k=0;k<Character.getNumericValue(MyArray[0]);k++){
            //System.out.println(arr[0]);
            new_s+=("(");
        }
        new_s+=(MyArray[0]+"");
        for(int i=1;i<s.length();i++){
            if(MyArray[i]>MyArray[i-1]){
                for(int k=0;k<MyArray[i]-MyArray[i-1];k++){
                    new_s+=("(");
                }
                new_s+=(MyArray[i]+"");
            }
            if(MyArray[i]<MyArray[i-1]){
                for(int k=0;k<MyArray[i-1]-MyArray[i];k++){
                    new_s+=(")");
                }
                new_s+=(MyArray[i]+"");
            }
            if(MyArray[i]==MyArray[i-1]){
                new_s+=(MyArray[i]+"");
            }
        }
        for(int z=0;z<Character.getNumericValue(MyArray[s.length()-1]);z++){
            new_s+=(")");
        }
       
        System.out.println("Case #"+t+": "+new_s);
    }
        
        
    }
}