	import java.util.*;
    import java.io.*;
    import java.util.regex.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=in.nextInt();
		for(int i=1;i<=t;i++)
      {
          boolean ab=false;
          int y=0;
          int t1=in.nextInt();
          ArrayList<String> arr=new ArrayList<String>();
          ArrayList<String> arr2=new ArrayList<String>();
          for(int j=0;j<t1;j++)
          {
              String temp=in.next();
              temp=temp.replace("*",".*");
              arr.add(temp);
    //System.out.println("arr1=>"+arr.get(j));          
          }
          String s2="",s3="";
          for(int j=0;j<t1;j++)
          {
              arr2.add(arr.get(j).replace(".*",""));
              s2=s2+arr2.get(j);
      //        System.out.println("arr2=>"+arr2.get(j));
          }
          boolean temp2=false;
          for(int j=0;j<t1;j++)
          {
int count=0;              
          for(int k=0;k<t1;k++)
          {
              boolean b = Pattern.matches(arr.get(k), arr2.get(j));
if(b)
{
    //System.out.println("s1=>"+arr.get(k));
    //System.out.println("s2=>"+arr2.get(j));
    count++;
}
if(count==t1){
System.out.println("Case #"+i+": "+arr2.get(j));
ab=true;
y++;
break;}
          }
          if(count==1)
          {
      //        System.out.println("Case"+s2+"rr"+s3);   
              temp2=true;
          }
          else{
              temp2=false;
          }
if(count==t1)
break;
          }
          if(temp2)
          {
              int count2=0;
              for(int k=0;k<t1;k++)
          {
      //        System.out.println("p1=>"+s2);
    //System.out.println("p2=>"+arr.get(k));
    
              boolean b = Pattern.matches(arr.get(k),s2);
              if(b)
{
    //System.out.println("s22=>"+arr2.get(k));
    count2++;
}
           //System.out.println("Case #"+t+": "+arr2.get(j));   
          }
          if(count2==t1)
          {System.out.println("Case #"+t+": "+s2);   
          ab=true;
          y++;
          break;}
          else{
              String result="";
              for (int i2 = 0; i2 < arr2.get(0).length() || i2 < arr2.get(1).length(); i2++) { 
  
            if (i2 < arr2.get(0).length()) 
                result+=arr2.get(0).charAt(i2); 
            if (i2 < arr2.get(1).length()) 
                result+=arr2.get(1).charAt(i2); 
                
        }
          int count3=0;
              for(int k=0;k<t1;k++)
          {
      //        System.out.println("pre1=>"+result);
    //System.out.println("pre2=>"+arr.get(k));
    
              boolean b = Pattern.matches(arr.get(k),result);
              if(b)
{
    //System.out.println("s22=>"+arr2.get(k));
    count3++;
}
           //System.out.println("Case #"+t+": "+arr2.get(j));   
          }
          if(count3==t1)
          {System.out.println("Case #"+t+": "+result);   
          ab=true;
          y++;
          break;}
        
     //   System.out.println("rs"+result);
        //System.out.println(y);
          }
          
          
      }
       if(y==0)
       {
           System.out.println("Case #"+t+": *");
       }
      }}
    }