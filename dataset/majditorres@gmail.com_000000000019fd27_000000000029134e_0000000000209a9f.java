import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    String result="";
int open=0;
int close=0;
for (int i=0;i<t;i++){//for each test case
    String S=in.nextLine();
    char[] ch=S.toCharArray();
    for (int j=0;j<ch.length;j++){
        int k=0;
        if(j==0 || (j>0 && Integer.parseInt(ch[j-1])<Integer.parseInt(ch[j])))
        while (k<Integer.parseInt(ch[j])) {
            result+="(";
            open++;
            k++;
        } 
        result+=ch[j];
        int toclose=0;
        if(j<ch.length-1 || Integer.parseInt(ch[j+1])<Integer.parseInt(ch[j])){
         toclose=open-Integer.parseInt(ch[j+1]);   
        }else{
         toclose=Integer.parseInt(ch[j]);
        }
        while (toclose>0){
            result+=")";
            toclose--;
        }
    }
}
  }
}