import java.io.*;

import java.util.*;

public class Solution {
   
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           int t=Integer.parseInt(br.readLine());
          for(int l=1;l<=t;l++){
              int n=Integer.parseInt(br.readLine());
              int max=Integer.MIN_VALUE;
              String[][] str=new String[n][n];
              String s="";
              for(int i=0;i<n;i++){
                  str[i]=br.readLine().split("[*]");
                if(max<str[i][str[i].length-1].length()){
                    max=str[i][str[i].length-1].length();
                    s=str[i][str[i].length-1];
                }
              }
              
              
              for(int i=0;i<n;i++){
                  //System.out.println(str[i][1]+"");
                  //System.out.println(s.substring(s.length()-str[i][str[i].length-1].length(),s.length()-1));
                  if(!s.substring(s.length()-str[i][str[i].length-1].length(),s.length()).equals(str[i][str[i].length-1])){
                      System.out.println("Case #"+l+": *");
                      return;
                  }
              }
               System.out.println("Case #"+l+": "+s);
           }
        }

}