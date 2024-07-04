import java.util.*;
class Solution{
  public static void main(String args[]){
      Scanner sc= new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=1;t<=T;t++){
        String s= sc.next();
        char[] My_array = s.toCharArray();
        String new_S ="";
        
    
        for(int u=0;u<Character.getNumericValue(My_array[0]);u++){
            //System.out.println(arr[0]);
            new_S+=("(");
        }
        new_S+=(My_array[0]+"");
        for(int i=1;i<s.length();i++){
            if(My_array[i]>My_array[i-1]){
                for(int u=0;u<My_array[i]-My_array[i-1];u++){
                    new_S+=("(");
                }
                new_S+=(My_array[i]+"");
            }
            if(My_array[i]<My_array[i-1]){
                for(int u=0;u<My_array[i-1]-My_array[i];u++){
                    new_S+=(")");
                }
                new_S+=(My_array[i]+"");
            }
            if(My_array[i]==My_array[i-1]){
                new_S+=(My_array[i]+"");
            }
        }
        for(int x=0;x<Character.getNumericValue(My_array[s.length()-1]);x++){
            new_S+=(")");
        }
       
        System.out.println("Case #"+t+": "+new_S);
    }
        
        
    }
}