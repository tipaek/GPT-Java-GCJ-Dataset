
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        int B = scanner.nextInt();//bytes cases

        for(int i=0;i<T;i++){
            if(! findWhole(B,scanner)){
                break;
            }
        }
    }


    private static boolean findWhole(int b,Scanner in) {
        int[] result = new int[b];
        for(int i=0;i<result.length;i++){
            result[i]=-1;
        }
        int count =0;
        boolean reverse = false;
        boolean invert = false;
        for(int i=0;i<b;i++){

            if(count%10>=0&&count>=10){
                count=count%10;
                int indexSame=-1,indexDiff=-1;

                for(int k=0;result[k]!=-1&&k<b&&result[result.length-1-k]!=-1;k++){
                    if(result[k]!=result[result.length-1-k]){
                        indexDiff=k;
                    }
                    if(result[k]==result[result.length-1-k]){
                        indexSame=k;
                    }
                    if(indexDiff!=-1&&indexSame!=-1)
                        break;

                }
                boolean stillDiff=false, stillSame=true;
                if(indexDiff!=-1) {
                    System.out.println(indexDiff+1);
                    int diff1 = in.nextInt();
                    count++;
                    int compareVal;

                    if(reverse) {
                        if (invert)
                            compareVal = Math.abs(result[result.length - 1 - indexDiff] - 1);
                        else
                            compareVal = result[result.length - 1 - indexDiff];
                    }
                    else {
                        if (invert)
                            compareVal = Math.abs(result[indexDiff] - 1);
                        else
                            compareVal = result[indexDiff];
                    }
                    stillDiff = compareVal == diff1;
                }
                if(indexSame!=-1) {
                    System.out.println(indexSame+1);
                    int same1 = in.nextInt();
                    count++;
                    int compareVal;
                    if(reverse) {
                        if (invert)
                            compareVal = Math.abs(result[result.length - 1 - indexSame] - 1);
                        else
                            compareVal = result[result.length - 1 - indexSame];
                    }
                    else {
                        if (invert)
                            compareVal = Math.abs(result[indexSame] - 1);
                        else
                            compareVal = result[indexSame];
                    }

                    stillSame =  compareVal == same1;
                }

                if(indexSame==-1&&!stillDiff){
                    invert = !invert;
                }
                else if(indexDiff==-1&&!stillSame){
                    invert = !invert;

                }
                else if(indexDiff!=-1&&indexSame!=-1&&!stillDiff&&!stillSame){
                    invert = !invert;

                }
                else if(indexDiff!=-1&&indexSame!=-1&&stillDiff&&!stillSame){
                    invert = !invert;
                    reverse = !reverse;

                }
                else if(indexDiff!=-1&&indexSame!=-1&&stillSame&&!stillDiff){
                    reverse = !reverse;

                }


            }
//            try{
//                throw new Error("count: "+count +" i: "+i+ " rev: "+reverse+" inv: "+invert);
//            }catch (Error e){
//                e.printStackTrace();
//            }
            if(i%2==0) {
                System.out.println((i/2 + 1));
                int val = in.nextInt();
                int index = i/2;
                if(reverse)
                    index = b-i/2-1;
                if(invert)
                    val = Math.abs(val-1);
                result[index] = val;
            } else{
                System.out.println((b-i/2-1+1));
                int val = in.nextInt();
                int index = b-i/2-1;
                if(reverse)
                    index = i/2;
                if(invert)
                    val = Math.abs(val-1);
                result[index] = val;

            }
            count++;
        }


        for(int i=0;i<result.length;i++){
            if(result[i]<0){
                if(reverse)
                System.out.println(b-i);
                else
                    System.out.println(i+1);
            if(!invert)
                result[i]=in.nextInt();
            else
                result[i]=Math.abs(in.nextInt()-1);
            }
        }
        if(count%10>=0&&count>=10){
            count=count%10;
            int indexSame=-1,indexDiff=-1;

            for(int k=0;result[k]!=-1&&k<b&&result[result.length-1-k]!=-1;k++){
                if(result[k]!=result[result.length-1-k]){
                    indexDiff=k;
                }
                if(result[k]==result[result.length-1-k]){
                    indexSame=k;
                }
                if(indexDiff!=-1&&indexSame!=-1)
                    break;

            }
            boolean stillDiff=false, stillSame=true;
            if(indexDiff!=-1) {
                System.out.println(indexDiff+1);
                int diff1 = in.nextInt();
                count++;
                int compareVal;

                if(reverse) {
                    if (invert)
                        compareVal = Math.abs(result[result.length - 1 - indexDiff] - 1);
                    else
                        compareVal = result[result.length - 1 - indexDiff];
                }
                else {
                    if (invert)
                        compareVal = Math.abs(result[indexDiff] - 1);
                    else
                        compareVal = result[indexDiff];
                }
                stillDiff = compareVal == diff1;
            }
            if(indexSame!=-1) {
                System.out.println(indexSame+1);
                int same1 = in.nextInt();
                count++;
                int compareVal;
                if(reverse) {
                    if (invert)
                        compareVal = Math.abs(result[result.length - 1 - indexSame] - 1);
                    else
                        compareVal = result[result.length - 1 - indexSame];
                }
                else {
                    if (invert)
                        compareVal = Math.abs(result[indexSame] - 1);
                    else
                        compareVal = result[indexSame];
                }

                stillSame =  compareVal == same1;
            }

            if(indexSame==-1&&!stillDiff){
                invert = !invert;
            }
            else if(indexDiff==-1&&!stillSame){
                invert = !invert;

            }
            else if(indexDiff!=-1&&indexSame!=-1&&!stillDiff&&!stillSame){
                invert = !invert;

            }
            else if(indexDiff!=-1&&indexSame!=-1&&stillDiff&&!stillSame){
                invert = !invert;
                reverse = !reverse;

            }
            else if(indexDiff!=-1&&indexSame!=-1&&stillSame&&!stillDiff){
                reverse = !reverse;

            }


        }
        String s="";
        if(reverse){
            if(invert) {
                for (int i = 0; i < result.length; i++)
                    s += Math.abs(result[result.length - 1 - i] - 1);
            }
            else {
                for (int i = 0; i < result.length; i++)
                    s += (result[result.length - 1 - i]);
            }
        }
        else{
            if(invert) {
                for (int i = 0; i < result.length; i++)
                    s += (Math.abs(result[i] - 1));
            }
            else {
                for (int i = 0; i < result.length; i++)
                    s += (result[i]);
            }
        }

        System.out.println(s);
        s= in.next();
        if(s=="N")
            return false;
        if(s=="Y")
            return true;
        return true;

    }
    //    public isReverse(){
////        if(result[i]!=result[result.length-1-i]) - position1
////        if(result[i]==result[result.length-1-i]) - position2
////        if position1 is opposite - sth happend (rev or inv) and  if(position2 the same - reverse, else inv)
////        if position1 the same and positon2 opposite - both, if position 2 the same - nothing
////
////
////    }

    public static int[] reverse(int[] array){
        int[] result=new int[array.length];

        for(int i=0;i<array.length;i++){
            result[i]=array[array.length-i-1];
        }
        return result;

    }
    public static int[] reverseInvert(int[] array){
        int[] result=new int[array.length];
        result = invert(array);
        result = reverse(result);
        return result;


    }
    public static int[] invert(int[] array){
        int[] result=new int[array.length];
        for(int i=0;i<result.length;i++){
            result[i]=-1;
        }
        for(int i=0;i<array.length;i++){
            if(array[i]!=-1)
                result[i]=Math.abs(array[i]-1);
        }
        return result;

    }
}
