
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        int B = scanner.nextInt();//bytes cases

        for(int i=0;i<T;i++){
            indexSame=-1;indexDiff=-1;
            if(! findWhole(B,scanner)){
                break;
            }
        }
    }
    static int indexSame=-1,indexDiff=-1;

    private static boolean findWhole(int b,Scanner in) {
        int[] result = new int[b];
        for(int i=0;i<result.length;i++){
            result[i]=-1;
        }
        int count =0;
        for(int i=0;i<b;i++){

            if(count%10==0&&count!=0){
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

                    stillDiff = result[indexDiff] == diff1;
                }
                if(indexSame!=-1) {
                    System.out.println(indexSame+1);
                    int same1 = in.nextInt();
                    count++;


                    stillSame =  result[indexSame] == same1;
                }

                if(indexSame==-1&&!stillDiff){
                    result=invert(result);
                }
                else if(indexDiff==-1&&!stillSame){
                    result=invert(result);
                }
                else if(indexDiff!=-1&&indexSame!=-1&&!stillDiff&&!stillSame){
                    result=invert(result);
                }
                else if(indexDiff!=-1&&indexSame!=-1&&stillDiff&&!stillSame){
                    result=reverseInvert(result);
                }
                else if(indexDiff!=-1&&indexSame!=-1&&stillSame&&!stillDiff){
                    result=reverse(result);
                }


            }
            if(i%2==0) {
                System.out.println((i/2 + 1));
                result[i/2] = in.nextInt();
            } else{
                System.out.println((b-i/2-1+1));
                result[b-i/2-1] = in.nextInt();

            }
            count++;
        }
        for(int i=0;i<result.length;i++){
            if(result[i]<0){
                System.out.println(i+1);
                result[i]=in.nextInt();
            }
        }
        String s="";
        for(Integer integer:result){
            s+=integer+"";
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
