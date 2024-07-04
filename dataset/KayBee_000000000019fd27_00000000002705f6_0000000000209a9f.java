import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=0;i<t;i++){
      String s = sc.next();
      String s1="";
      char[] str=s.toCharArray();
      for(int j=0;j<str.length;j++){
        int num= Integer.parseInt(String.valueOf(str[j]));
        if(str.length==1){
          int k=num;
          while(k!=0){
            s1+="(";
            k--;
          }
          s1+=num;
          k=num;
          while(k!=0){
            s1+=")";
            k--;
          }
          break;
        }

        if(j==0 && str.length!=1){
          int k=num;
          while(k!=0){
            s1+="(";
            k--;
          }
          s1+=num;
          int nxt= Integer.parseInt(String.valueOf(str[j+1]));
          int diff = num - nxt;
          k=diff;
          if(diff>0){
            while(k!=0){
              s1+=")";
              k--;
            }
          }else if(k<0){
            while(k!=0){
              s1+="(";
              k++;
            }
          }else{
            continue;
          }
        }
        else if(j>0 && j<(str.length-1)){
         s1+=""+num;
          int nxt= Integer.parseInt(String.valueOf(str[j+1]));
          int diff = num - nxt;
          int k=diff;
          if(diff>0){
            while(k!=0){
              s1+=")";
              k--;
            }
          }else if(k<0){
            while(k!=0){
              s1+="(";
              k++;
            }
          }else{
            continue;
          }
        }
        else if(j==(str.length-1)) {
         s1+=""+num;
          int k=num;
          while(k!=0){
            s1+=")";
            k--;
          }
        }
      }
      System.out.println("Case #"+(i+1)+": "+s1);
    }
  }
}