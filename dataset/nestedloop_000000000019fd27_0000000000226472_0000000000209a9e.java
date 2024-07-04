import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] inpLine = line.split(" ");
        int test = Integer.parseInt(inpLine[0]);
        int n = Integer.parseInt(inpLine[1]);
        for (int t = 1; t <= test; ++t) {
            int isFlipped = -1;
            int isReversed = -1;
            int progress = 0;
            int questions = 0;
            int indF = -1;
            char testF = '0';
            int indR = -1;
            char testR = '0';
            char[] answer = new char[n];
            while (progress < n / 2) {
                if (questions % 10 == 0) {
                    if (isFlipped != -1) {
                        System.out.println((indF + 1));
                        char a = (in.next()).charAt(0);
                        if (a == 'N') {
                            return;
                        }
                        if (a != testF) {
                            isFlipped = 1;
                        } else {
                            isFlipped = 0;
                        }
                        questions++;
                    }
                    if (isReversed != -1) {
                        System.out.println((indR + 1));
                        char a = (in.next()).charAt(0);
                        if (a == 'N') {
                            return;
                        }
                        if (a != testR) {
                            isReversed = 1;
                        } else {
                            isReversed = 0;
                        }
                        questions++;
                    }
                    if (questions % 2 == 1) {
                        System.out.println(1);
                        char a = (in.next()).charAt(0);
                        questions++;
                    }
                }
                char a;
                int ind; 
                progress++;
                System.out.println(progress);
                a = (in.next()).charAt(0);
                if (a == 'N') {
                    return;
                }
                ind = progress-1;
                if (isFlipped==1){
                    ind = n-1-ind;
                }
                if (isReversed==1){
                    if (a == '0'){
                      a = '1';   
                    }
                    else{
                      a = '0';
                    }
                }
                answer[ind] = a;
                
                ind = n-progress;
                System.out.println(ind+1);
                a = (in.next()).charAt(0);
                if (a == 'N') {
                    return;
                }
                if (isFlipped==1){
                    ind = n-1-ind;
                }
                if (isReversed==1){
                    if (a == '0'){
                      a = '1';   
                    }
                    else{
                      a = '0';
                    }
                }
                answer[ind] = a;
                
                if ((isFlipped == -1) && (answer[ind] != answer[n-1-ind])){
                    isFlipped = 0;
                    indF = ind;
                    testF = answer[ind];
                }
                
                if((isReversed == -1) && (answer[ind] == answer[n-1-ind])){
                    isReversed = 0;
                    indR = ind;
                    testR = answer[ind];
                }
                questions+=2;
            }
            
            if (isReversed==1){
                for (int i=0; i<n/2; i++){
                    char a = answer[i];
                    answer[i] = answer[n-1-i];
                    answer[n-1-i] = a;
                }
            }
            if (isFlipped == 1){
                for (int i=0; i<n; i++){
                    if (answer[i] == '0'){
                      answer[i] = '1';   
                    }
                    else{
                      answer[i] = '0';
                    }
                }
            }
            
            
            String result = new String(answer);
            System.out.println(result);
            char a =  (in.next()).charAt(0);
            if (a == 'N'){
                return;
            }
        }
    }
}