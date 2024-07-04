import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for(int i = 1; i <= T; i++) {
            String s;
            int[] array = new int[B];
            int counter = 0;
            while(counter != B) {
                if(counter == 0) {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(j+1);
                        s = input.next();
                        array[j] = Integer.parseInt(s);
                        counter++;
                    }
                    for (int j = B-1; j >= B-5; j--) {
                        System.out.println(j+1);
                        s = input.next();
                        array[j] = Integer.parseInt(s);
                        counter++;
                    }
                }
                else {
                    int temp = counter/2;
                    int equal = -1;
                    int notEqual = -1;
                    for(int j = 0; j < temp; j++) {
                        if(array[j] == array[B-j-1]){
                            equal = j;
                            break;
                        }
                    }
                    for(int j = 0; j < temp; j++) {
                        if(array[j] != array[B-j-1]){
                            notEqual = j;
                            break;
                        }
                    }
                    boolean changeEqual = false;
                    boolean changeNotEqual = false;
                    if(equal != -1) {
                        System.out.println(equal + 1);
                        s = input.next();
                        if (Integer.parseInt(s) != array[equal]) {
                            changeEqual = true;
                        }
                    }
                    if(notEqual != -1) {
                        System.out.println(notEqual + 1);
                        s = input.next();
                        if (Integer.parseInt(s) != array[notEqual]) {
                            changeNotEqual = true;
                        }
                    }
                    if(equal == -1 || notEqual == -1) {
                        System.out.println(1);
                        s = input.next();
                    }
                    for(int j = 0; j < temp; j++) {
                        if(array[j] == array[B-j-1] && changeEqual)
                            array[j] = array[B-j-1] = 1-array[j];
                        if(array[j] != array[B-j-1] && changeNotEqual)
                            array[j] = array[B-j-1] = 1-array[j];
                    }
                    for (int j = temp; j < temp+4; j++) {
                        System.out.println(j+1);
                        s = input.next();
                        array[j] = Integer.parseInt(s);
                        counter++;
                    }
                    for (int j = B-1-temp; j > B-1-temp-4; j--) {
                        System.out.println(j+1);
                        s = input.next();
                        array[j] = Integer.parseInt(s);
                        counter++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < B; k++) {
                sb.append(array[k]);
            }
            System.out.println(sb.toString());
            s = input.next();
            if(s.equals("N")) {
                break;
            }
        }
    }
}
