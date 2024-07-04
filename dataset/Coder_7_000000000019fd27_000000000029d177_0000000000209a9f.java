import java.util.*;
class Solution{
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int cases=Integer.parseInt(in.nextLine());
    int count=1;
    for(int i=0; i<cases; i++){
        String next=in.nextLine();
        String result="";
        int previous=Integer.parseInt(""+next.charAt(0));
        result=get(previous,0,0);
        for(int j=1; j<next.length(); j++){
            int num=Integer.parseInt(""+next.charAt(j));
            if(previous<num){
               String s=get(num,previous,0);
               result=join(result,s,0,previous);
               previous=num;
            }
            else if(previous > num){
                String s=get(num,0,0);
                result=join(result,s,num,0);
                previous=num;
            }
            else if(previous ==num){
                String s=get(num,num,0);
                result=join(result,s,num,0);
            }
        }
        
        
        
        System.out.println("Case #"+count+": "+result);
        count++;
    }
    
  }
 public static String join(String result,String next,int f, int s){
      return result.substring(0,result.length()-f)+next.substring(s,next.length());
  }
  
  public static String get(int num, int l, int r){
    String result="";
    for(int i=0; i<num-l; i++){
        result+="(";
    }
     result+=""+num;
     for(int j=0; j<num-r; j++){
         result+=")";
     } 
    return result;
  }
    
}
