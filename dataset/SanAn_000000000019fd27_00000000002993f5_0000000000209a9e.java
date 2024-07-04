import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int b = sc.nextInt();
            int[] number = new int[b];
            int[] operation = new int[150];
            int front=0;
            int back = b-1;
            int opcount = 1;
            int bitNum = front;
            boolean frontpart = true;
            while(opcount <= 150 && front <= back){
                if(opcount % 10 == 1 && opcount > 1){
                        //findOpandApply(operation, number);
                        //find complementary pair
                        System.out.println(1);
                        int bit = sc.nextInt();
                        opcount++;
                        if(number[0] == number[b-1] ){
                            if(number[0] != bit){
                                //Complement or complement + reverse
                                int j =0;
                                for( j=1; j<front; j++){
                                    if(number[j] != number[b-j-1] )
                                        break;
                                }
                                if(j<front){
                                    System.out.println(j+1);
                                    int bit1 = sc.nextInt();
                                    opcount++;
                                    if(bit1 != number[j]){
                                        //complement
                                        complement(number, b, front);
                                    } else {
                                        //complment and reverse
                                        complement(number,b,front);
                                        reverse(number,b, front);

                                    }
                                } else {
                                    //complement and compl-rev will give same result
                                    complement(number,b,front);
                                }
                            } else {
                                //same or reversal
                                int j =0;
                                for( j=1; j<front; j++){
                                    if(number[j] != number[b-j-1] )
                                        break;
                                }
                                if(j<front){
                                    System.out.println(j+1);
                                    int bit1 = sc.nextInt();
                                    opcount++;
                                    if(bit1 != number[j]){
                                        //reversal
                                        reverse(number, b, front);
                                    } else {
                                        //no-op

                                    }
                                } else {
                                    //no-op and rev will give same result
                                    //no-op
                                }

                            }
                        } else {
                            if(number[0] != bit){
                                //Complement or  reverse
                                int j =0;
                                for( j=1; j<front; j++){
                                    if(number[j] == number[b-j-1] )
                                        break;
                                }
                                if(j<front){
                                    System.out.println(j+1);
                                    int bit1 = sc.nextInt();
                                    opcount++;
                                    if(bit1 != number[j]){
                                        //complement
                                        complement(number, b, front);
                                    } else {
                                        //reverse
                                        reverse(number,b, front);
                                    }
                                } else {
                                    //complement and rev will give same result
                                    complement(number,b,front);
                                }
                            } else {
                                //same or comp-reversal
                                int j =0;
                                for( j=1; j<front; j++){
                                    if(number[j] == number[b-j-1] )
                                        break;
                                }
                                if(j<front){
                                    System.out.println(j+1);
                                    int bit1 = sc.nextInt();
                                    opcount++;
                                    if(bit1 != number[j]){
                                        //comp-reversal
                                        complement(number,b,front);
                                        reverse(number, b, front);
                                    } else {
                                        //no-op

                                    }
                                } else {
                                    //no-op and comp-rev will give same result
                                    //no-op
                                }

                            }
                        }

                } else {
                    if (frontpart) {
                        System.out.println(front+1);
                        number[front] = sc.nextInt();
                        front++;
                        frontpart = false;

                    } else {
                        System.out.println(back+1);
                        number[back] = sc.nextInt();
                        back--;
                        frontpart = true;
                    }

                    opcount++;
                }


            }

            //System.out.println(Arrays.toString(number));
            StringBuilder num = new StringBuilder("");
            for(int j=0; j<b; j++){
                num.append(number[j]);
            }
            System.out.println(num);
            String result = sc.next();
            if(result.equals("N"))
                break;

               // System.out.println("Case #"+ (i+1) + ": " + new String(order) );

        }
    }

    private static void reverse(int[] number, int b, int front) {
        int i = 0;
        int j = b-1;
        while (i < j && i< front){
            int t = number[i];
            number[i] = number[j];
            number[j] = t;
            i++;
            j--;
        }
    }

    private static void complement(int[] number, int b, int front) {
        int i = 0;
        int j = b-1;
        while (i < j && i< front){
            number[i] = 1 - number[i];
            number[j] = 1 - number[j];
            i++;
            j--;
        }
    }


}


