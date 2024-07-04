import java.util.*;
import java.lang.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int numTest=s.nextInt();
        String ans[]=new String[numTest];
        for(int i=0;i<numTest;i++){
            String temp=s.next();
            //System.out.println("Input test"+(i+1)+":"+temp);
            if(!temp.contains("1")){
                //when the number is just a string of 0s
                ans[i]=temp;
                //System.out.println("No 1, temp:"+temp);
                continue;
            }
            //if even one 1:
            int k=0;
            String temp1="";
            while(k<temp.length()){
                while(k<temp.length() && temp.charAt(k)=='0'){
                    temp1=temp1+"0";
                    k++;
                }
                if(k<temp.length() && temp.charAt(k)=='1'){
                    //first 1 encountered:
                    temp1=temp1+"(";
                    while(k<temp.length() &&  temp.charAt(k)=='1'){
                        temp1=temp1+"1";
                        k++;
                    }
                    //either 0 encountered or end of string
                    temp1=temp1+")";
                }

            }
            ans[i]=temp1;
        }
        for(int i=0;i<numTest;i++){
            System.out.println("Case #"+(i+1)+":"+ans[i]);
        }
    }
}