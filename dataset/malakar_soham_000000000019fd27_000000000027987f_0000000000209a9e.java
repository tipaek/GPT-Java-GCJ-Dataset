import java .util.*;
import java.io.*;

class Solution{

  String compl(String a){
    String b = "";
    for(int i=0;i<a.length();i++){
      if(a.charAt(i) == '0')
      b += "1";
      else
      b += "0";
    }
    return b;
  }

  String reverse(String a){
    String b = "";
    for(int i=0;i<a.length();i++){
      b += a.charAt(a.length()-1-i);
    }
    return b;
  }

  String both(String a){
    String b = compl(a);
    b = reverse(b);
    return b;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    Solution obj = new Solution();
    int T = sc.nextInt();
    if(!(T>=1 && T<=100))
    System.exit(0);
    int b = sc.nextInt();
    for(int k=0;k<T;k++){
      String norm = sc.next();
      String com = obj.compl(norm);
      String rev = obj.reverse(norm);
      String bot = obj.both(norm);

      char[] flag = {'2','2','2','2'};
      char[] flagBit = {'0','0','0','0'};
      char ret='0';
      int index = -1, count=0;

      for(int i=0;i<norm.length()-1;i++){
        count=0;
        if(norm.charAt(i)=='0' && norm.charAt(i+1)=='0' && flagBit[0]=='0'){
          for (int j=i; j<=i+1; j++) {
            System.out.println(j+1);
            ret = sc.next().charAt(0);
            if(ret == norm.charAt(j) && flag[0]=='2')
            flag[0]='1';
            else if(ret != norm.charAt(j))
            flag[0]='0';
            if(ret == com.charAt(j) && flag[1]=='2')
            flag[1]='1';
            else if(ret != com.charAt(j))
            flag[1]='0';
            if(ret == rev.charAt(j) && flag[2]=='2')
            flag[2]='1';
            else if(ret != rev.charAt(j))
            flag[2]='0';
            if(ret == bot.charAt(j) && flag[3]=='2')
            flag[3]='1';
            else if(ret != bot.charAt(j))
            flag[3]='0';
          }
          flagBit[0] = '1';
        }
        else if(norm.charAt(i)=='0' && norm.charAt(i+1)=='1' && flagBit[1]=='0'){
          for (int j=i; j<=i+1; j++) {
            System.out.println(j+1);
            ret = sc.next().charAt(0);
            if(ret == norm.charAt(j) && flag[0]=='2')
            flag[0]='1';
            else if(ret != norm.charAt(j))
            flag[0]='0';
            if(ret == com.charAt(j) && flag[1]=='2')
            flag[1]='1';
            else if(ret != com.charAt(j))
            flag[1]='0';
            if(ret == rev.charAt(j) && flag[2]=='2')
            flag[2]='1';
            else if(ret != rev.charAt(j))
            flag[2]='0';
            if(ret == bot.charAt(j) && flag[3]=='2')
            flag[3]='1';
            else if(ret != bot.charAt(j))
            flag[3]='0';
          }
          flagBit[1] ='1';
        }
        else if(norm.charAt(i)=='1' && norm.charAt(i+1)=='0' && flagBit[2]=='0'){
          for (int j=i; j<=i+1; j++) {
            System.out.println(j+1);
            ret = sc.next().charAt(0);
            if(ret == norm.charAt(j) && flag[0]=='2')
            flag[0]='1';
            else if(ret != norm.charAt(j))
            flag[0]='0';
            if(ret == com.charAt(j) && flag[1]=='2')
            flag[1]='1';
            else if(ret != com.charAt(j))
            flag[1]='0';
            if(ret == rev.charAt(j) && flag[2]=='2')
            flag[2]='1';
            else if(ret != rev.charAt(j))
            flag[2]='0';
            if(ret == bot.charAt(j) && flag[3]=='2')
            flag[3]='1';
            else if(ret != bot.charAt(j))
            flag[3]='0';
          }
          flagBit[2] ='1';
        }
        else if(norm.charAt(i)=='1' && norm.charAt(i+1)=='1' && flagBit[3]=='0'){
          for (int j=i; j<=i+1; j++) {
            System.out.println(j+1);
            ret = sc.next().charAt(0);
            if(ret == norm.charAt(j) && flag[0]=='2')
            flag[0]='1';
            else if(ret != norm.charAt(j))
            flag[0]='0';
            if(ret == com.charAt(j) && flag[1]=='2')
            flag[1]='1';
            else if(ret != com.charAt(j))
            flag[1]='0';
            if(ret == rev.charAt(j) && flag[2]=='2')
            flag[2]='1';
            else if(ret != rev.charAt(j))
            flag[2]='0';
            if(ret == bot.charAt(j) && flag[3]=='2')
            flag[3]='1';
            else if(ret != bot.charAt(j))
            flag[3]='0';
          }
          flagBit[3] ='1';
        }

        for(int j=0;j<4;j++)
        if(flag[j]=='1'){
          index = j;
          count++;
        }

        if(count==1)
        break;
      }

      if(index == 0)
      System.out.println(norm);
      else if(index == 1)
      System.out.println(com);
      else if(index == 2)
      System.out.println(rev);
      else
      System.out.println(bot);

      ch = sc.next().charAt(0);
      if(ch!='Y')
      System.exit(0);
    }
  }
}
