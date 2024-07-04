import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                int currentStep = 0;
                int previousSame = 0;
                int previousDifferent = 1;
                int same = -1;
                int different = -1;
                int currentPair = 0;
                int[] bits = new int[b];
                while(currentPair*2<b){
                    if(currentStep%10==0 && currentStep != 0){
                        if(different == -1){
                            if(same != -1){
                                System.out.println(same+1);
                                System.out.flush();
                                st = new StringTokenizer(br.readLine());
                                int newSame = Integer.parseInt(st.nextToken());
                                System.out.println(same+1);
                                System.out.flush();
                                st = new StringTokenizer(br.readLine());
                                newSame = Integer.parseInt(st.nextToken());
                                if(previousSame != newSame){
                                    for(int j = 0; j<currentPair; j++){
                                        bits[j]=1-bits[j];
                                        bits[b-j-1]=1-bits[b-j-1];
                                    }
                                }
                            }
                        }else{
                            if(same == -1){
                                System.out.println(different+1);
                                System.out.flush();
                                st = new StringTokenizer(br.readLine());
                                int newDifferent = Integer.parseInt(st.nextToken());
                                System.out.println(different+1);
                                System.out.flush();
                                st = new StringTokenizer(br.readLine());
                                newDifferent = Integer.parseInt(st.nextToken());
                                if(previousDifferent != newDifferent){
                                    for(int j = 0; j<currentPair; j++){
                                        bits[j]=1-bits[j];
                                        bits[b-j-1]=1-bits[b-j-1];
                                    }
                                }
                            }else{
                                System.out.println(different+1);
                                System.out.flush();
                                st = new StringTokenizer(br.readLine());
                                int newDifferent = Integer.parseInt(st.nextToken());
                                System.out.println(same+1);
                                System.out.flush();
                                st = new StringTokenizer(br.readLine());
                                int newSame = Integer.parseInt(st.nextToken());
                                if(newDifferent == previousDifferent){
                                    if(newSame != previousSame){
                                       for(int j = 0; j<currentPair; j++){
                                            int temp = 1-bits[j];
                                            bits[j]=1-bits[b-j-1];
                                            bits[b-j-1]=temp;
                                        }
                                        System.out.println("ri");
                                    }
                                }else{
                                    if(newSame == previousSame){
                                        for(int j = 0; j<currentPair; j++){
                                            int temp = bits[j];
                                            bits[j]=bits[b-j-1];
                                            bits[b-j-1]=temp;
                                        }
                                        System.out.println("r");
                                    }else{
                                        for(int j = 0; j<currentPair; j++){
                                            bits[j]=1-bits[j];
                                            bits[b-j-1]=1-bits[b-j-1];
                                        }
                                        System.out.println("i");
                                    }
                                }
                                previousSame = newSame;
                                previousDifferent = newDifferent;
                            }
                        }
                    }else{
                        System.out.println(currentPair+1);
                        System.out.flush();
                        st = new StringTokenizer(br.readLine());
                        int beginning = Integer.parseInt(st.nextToken());
                        System.out.println(b-currentPair);
                        System.out.flush();
                        st = new StringTokenizer(br.readLine());
                        int end = Integer.parseInt(st.nextToken());
                        bits[currentPair]=beginning;
                        bits[b-currentPair-1]=end;
                        if (beginning == end){
                            same = currentPair;
                            previousSame = beginning;
                        }else{
                            different = currentPair;
                            previousDifferent = beginning;
                        }
                        currentPair++;
                    }
                    currentStep+=2;
                }
                String finalString = "";
                for(int j = 0; j<b; j++){
                    finalString = finalString + bits[j];
                }
                System.out.println(finalString);
                System.out.flush();
                st = new StringTokenizer(br.readLine());
                String verdict = st.nextToken();
                if(verdict == "N"){
                    return;
                }
            }
        }catch(Exception e){
            return;
        }
    }
}