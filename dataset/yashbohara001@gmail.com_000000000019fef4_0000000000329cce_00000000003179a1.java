import java.util.*;
    import java.io.*;
    import java.util.regex.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=in.nextInt();
		ArrayList<String> arr=new ArrayList<String>();
		for(int i=1;i<=t;i++)
      {
         arr.add("");
         arr.add("");arr.add("");arr.add("");arr.add("");arr.add("");arr.add("");arr.add("");arr.add("");arr.add("");
              int u=in.nextInt();
              for(int k=0;k<10000;k++)
              {
               int a=in.nextInt();
               String s=in.next();
               String s1=a+"";
               if(s1.length()!=s.length())
               continue;
               else{
                   for(int h=0;h<s1.length();h++){
                       int temp=Integer.parseInt(String.valueOf(s1.charAt(h)));
                       String ff=arr.get(temp)+String.valueOf(s.charAt(h));
                arr.set(temp,ff);   }
               }
              }
              
              
             
              }
              String res="";
              for(int y=0;y<10;y++){
                  res=String.valueOf(getMaxOccuringChar(arr.get(y)));
                  if(y!=9){
                  String rr=arr.get(y+1);
                      rr=rr.replaceAll(res,"");
                     // System.out.println(res);
                      //System.out.println(rr+"----");
                      arr.set(y+1,rr);
                      
                  }
                  
              }
              System.out.println(res);
              }
              public static char getMaxOccuringChar(String str) 
    { 
        int count[] = new int[256]; 
        int len = str.length(); 
        for (int i=0; i<len; i++) 
            count[str.charAt(i)]++; 
       
        int max = -1;  
        char result = ' '; 
       
        for (int i = 0; i < len; i++) { 
            if (max < count[str.charAt(i)]) { 
                max = count[str.charAt(i)]; 
                result = str.charAt(i); 
            } 
        } 
       
        return result; 
    } 
              }