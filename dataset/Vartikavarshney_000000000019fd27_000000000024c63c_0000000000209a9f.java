import java.util.*;
public class Solution{
  public static void main(String args[]){
      Scanner sc= new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=1;t<=T;t++){
        String s= sc.next();
        char[] MyArrList = s.toCharArray();
        String n_s ="";
        
    
        for(int v=0;v<Character.getNumericValue(MyArrList[0]);v++){
            n_s+=("(");
        }
        n_s+=(MyArrList[0]+"");
        for(int i=1;i<s.length();i++){
            if(MyArrList[i]>MyArrList[i-1]){
                for(int k=0;k<MyArrList[i]-MyArrList[i-1];k++){
                    n_s+=("(");
                }
                n_s+=(MyArrList[i]+"");
            }
            if(MyArrList[i]<MyArrList[i-1]){
                for(int k=0;k<MyArrList[i-1]-MyArrList[i];k++){
                    n_s+=(")");
                }
                n_s+=(MyArrList[i]+"");
            }
            if(MyArrList[i]==MyArrList[i-1]){
                n_s+=(MyArrList[i]+"");
            }
        }
        for(int z=0;z<Character.getNumericValue(MyArrList[s.length()-1]);z++){
            n_s+=(")");
        }
       
        System.out.println("Case #"+t+": "+n_s);
    }
        
        
    }
}