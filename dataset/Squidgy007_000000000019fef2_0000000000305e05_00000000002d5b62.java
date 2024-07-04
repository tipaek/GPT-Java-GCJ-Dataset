
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);
        int T=scn.nextInt();
        String str="", str1="";
        for(int t=1;t<=T;t++){
            long X, Y;
            X=scn.nextInt();
            Y=scn.nextInt();
            if((X+Y)%2==0){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }
            if(X%2!=0){


                str=checkPossible(X-1, Y);
                if(str!=null){
                    str = "E" +str;
                }
                str1=checkPossible(X+1, Y);
                if(str1!=null){
                    str1 = "W" + str1;
                }
//                if(str !=null){
//                    System.out.println("Case #" + t + ": " +  str);
//                    continue;
//                }

//                if(str1 !=null){
//                    System.out.println("Case #" + t + ": " +  str1);
//                    continue;
//                }

                if(str!=null&&str1!=null){
                    if(str.length()<str1.length()){
                        System.out.println("Case #" + t + ": " +  str);
                    }
                    else{
                        System.out.println("Case #" + t + ": " +  str1);
                    }
                    continue;
                }
                if(str==null&&str1==null){
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    continue;
                }
                if(str!=null){
                    System.out.println("Case #" + t + ": " +  str);
                    continue;
                }
                else{
                    System.out.println("Case #" + t + ": " +  str1);
                    continue;
                }
            }
            else{

                str=checkPossible(X, Y-1);
                if(str!=null){
                    str = "N" +str;
                }
                str1=checkPossible(X, Y+1);
                if(str1!=null){
                    str1 = "S" + str1;
                }
                
//                if(str !=null){
//                    System.out.println("Case #" + t + ": " +  str);
//                    continue;
//                }
//                str1 = "S" + checkPossible(X, Y+1);
//                if(str1 !=null){
//                    System.out.println("Case #" + t + ": " + str1);
//                    continue;
//                }
//                System.out.println("Case #" + t + ": IMPOSSIBLE");
//                continue;
                if(str!=null&&str1!=null){
                    if(str.length()<str1.length()){
                        System.out.println("Case #" + t + ": " +  str);
                    }
                    else{
                        System.out.println("Case #" + t + ": " +  str1);
                    }
                    continue;
                }
                if(str==null&&str1==null){
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    continue;
                }
                if(str!=null){
                    System.out.println("Case #" + t + ": " +  str);
                    continue;
                }
                else{
                    System.out.println("Case #" + t + ": " +  str1);
                    continue;
                }
            }
        }
    }

    private static String checkPossible(long X, long Y) {
        String str="";
        long z=(Math.abs(X)+Math.abs(Y))/2+1;
        boolean flag= (int)(Math.ceil((Math.log(z) / Math.log(2)))) ==
                (int)(Math.floor(((Math.log(z) / Math.log(2)))));
        if(!flag){
            return null;
        }
        else{
            int bitCount= (int) Math.ceil((Math.log(z) / Math.log(2)));
            if(Math.abs(Y)>Math.abs(X)){
                int[] binaryNum = new int[bitCount+1];

                // counter for binary array
                int i = 0;
                long temp=Math.abs(Y);
                while (temp > 0)
                {
                    // storing remainder in binary array
                    binaryNum[i] = (int) (temp % 2);
                    temp = temp / 2;
                    i++;
                }

                for (int j = 1; j <= i-1; j++){
                    if(binaryNum[j]==0){
                        if(X>0){
                            str=str+"E";
                        }
                        else{
                            str=str+"W";
                        }
                    }
                    else{
                        if(Y>0){
                            str=str+"N";
                        }
                        else{
                            str=str+"S";
                        }
                    }
                }
            }
            else{
                int[] binaryNum = new int[bitCount+1];

                // counter for binary array
                int i = 0;
                long temp=Math.abs(X);
                while (temp > 0)
                {
                    // storing remainder in binary array
                    binaryNum[i] = (int) (temp % 2);
                    temp = temp / 2;
                    i++;
                }

                for (int j = 1; j <= i-1; j++){
                    if(binaryNum[j]==0){
                        if(Y>0){
                            str=str+"N";
                        }
                        else{
                            str=str+"S";
                        }
                    }
                    else{
                        if(X>0){
                            str=str+"E";
                        }
                        else{
                            str=str+"W";
                        }
                    }
                }

            }

            return str;
        }

    }
}
