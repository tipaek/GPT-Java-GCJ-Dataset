import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        int b = stdin.nextInt();
        for (int k = 0; k < t; k++) {
            //working code here
            int[] diffPair = {-1,-1};
            int[] samePair = {-1,-1};
            int[] workingArray = new int[b];
         
            for(int i = 0;i<5;i++){
                System.out.println(i+1);
                workingArray[i] = stdin.nextInt();
                System.out.println(b-i);
                workingArray[b-i-1] = stdin.nextInt();
                if(samePair[0] == -1 && workingArray[i] == workingArray[b-i-1]){
                    samePair[0] = i;
                    samePair[1] = b-i-1;
                }
                if(diffPair[0] == -1 && workingArray[i] != workingArray[b-i-1]){
                    diffPair[0] = i;
                    diffPair[1] = b-i-1;
                }
            }
            
            int currentMarker = 5;
            while(currentMarker < b/2){
                if(diffPair[0] != -1 && samePair[0] != -1){
                    //check for quantum flux
                    System.out.println(diffPair[0]+1);
                    int dPair = workingArray[diffPair[0]] ^ stdin.nextInt();
                    System.out.println(samePair[0]+1);
                    int sPair = workingArray[samePair[0]] ^ stdin.nextInt();
                    
                    //if both change, a complement happened
                    if(sPair == 1 && dPair == 1){
                        for(int i = 0;i<b;i++){
                            workingArray[i]^=1;
                        }
                    }
                    
                    //if only diff changed, a reversal happened
                    if(sPair == 0 && dPair == 1){
                        for(int i = 0;i<b/2;i++){
                            int temp = workingArray[i];
                            workingArray[i] = workingArray[b-i-1];
                            workingArray[b-i-1] = temp;
                        }
                    }
                        
                    //if only same changed, a reversal and comp happened
                    if(sPair == 1 && dPair == 0){
                        for(int i = 0;i<b/2;i++){
                            int temp = workingArray[i];
                            workingArray[i] = workingArray[b-i-1];
                            workingArray[b-i-1] = temp;
                        }
                        for(int i = 0;i<b;i++){
                            workingArray[i]^=1;
                        }
                    }
                    //otherwise, no changes were needed.
                    //remaining 8 queries can be used to build array
                    for(int i = 0;i<4;i++){
                     System.out.println(currentMarker+1);
                        workingArray[currentMarker] = stdin.nextInt();
                        System.out.println(b-currentMarker);
                        workingArray[b-currentMarker-1] = stdin.nextInt();
                        currentMarker++;
                    }
                }else if(diffPair[0] != -1){ //We haven't found both a same or diff pair yet. suppose we only found the diffPair
                    System.out.println(diffPair[0]+1);
                    int dPair = workingArray[diffPair[0]] ^ stdin.nextInt();
                    
                    //if diff pair changed, a reversal or complement happened, we don't know and we don't care (equivalent)
                    if(dPair == 1){
                        for(int i = 0;i<b;i++){
                            workingArray[i]^=1;
                        }
                    }
                    
                    //now we have 9 guesses to use up
                    for(int i = 0;i<4;i++){
                     System.out.println(currentMarker+1);
                        workingArray[currentMarker] = stdin.nextInt();
                        System.out.println(b-currentMarker);
                        workingArray[b-currentMarker-1] = stdin.nextInt();
                        //we need to check if we've found a same pair in the past guesses
                        if(samePair[0] == -1 && workingArray[currentMarker] == workingArray[b-currentMarker-1]){
                            samePair[0] = currentMarker;
                            samePair[1] = b-currentMarker-1;
                        }
                        currentMarker++;
                    }
                    //let's throw away our last guess, we can't use it anyway
                    System.out.println(1);
                    int throwaway = stdin.nextInt();
                    
                }else{ // it must have been a same pair then - if change occurred, then it was complement
                    System.out.println(samePair[0]+1);
                    int sPair = workingArray[samePair[0]] ^ stdin.nextInt();
                    if(sPair == 1){
                        for(int i = 0;i<b;i++){
                            workingArray[i]^=1;
                        }
                    }
                    
                    //again 9 guess to use
                    for(int i = 0;i<4;i++){
                     System.out.println(currentMarker+1);
                        workingArray[currentMarker] = stdin.nextInt();
                        System.out.println(b-currentMarker);
                        workingArray[b-currentMarker-1] = stdin.nextInt();
                        //we need to check if we've found a diff pair in the past guesses
                        if(diffPair[0] == -1 && workingArray[currentMarker] != workingArray[b-currentMarker-1]){
                            diffPair[0] = currentMarker;
                            diffPair[1] = b-currentMarker-1;
                        }
                        currentMarker++;
                    }
                    
                    //let's throw away our last guess, we can't use it anyway
                    System.out.println(1);
                    int throwaway = stdin.nextInt();
                }
                
                
                
            }
            
            String guess = "";
            for(int d : workingArray){
                guess+=d;
            }
            System.out.println(guess);
            String response = stdin.next();
            if(response.equals("N")){
                System.exit(1);
            }

        }

    }
    
}
