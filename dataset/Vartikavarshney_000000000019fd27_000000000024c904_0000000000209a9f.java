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
                for(int j=0;j<MyArrList[i]-MyArrList[i-1];j++){
                    n_s+=("(");
                }
                n_s+=(MyArrList[i]+"");
            }
            if(MyArrList[i]<MyArrList[i-1]){
                for(int j=0;j<MyArrList[i-1]-MyArrList[i];j++){
                    n_s+=(")");
                }
                n_s+=(MyArrList[i]+"");
            }
            if(MyArrList[i]==MyArrList[i-1]){
                n_s+=(MyArrList[i]+"");
            }
        }
        for(int p=0;p<Character.getNumericValue(MyArrList[s.length()-1]);p++){
            n_s+=(")");
        }
       
        System.out.println("Case #"+t+": "+n_s);
    }
        
        
    }
}