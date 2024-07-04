import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                String[] words = new String[n];
                int[] currentPosition = new int[n];
                int[] asteriskFromFront = new int[n];
                int[] asteriskFromBack = new int[n];
                for(int j = 0; j<n; j++){
                    st = new StringTokenizer(br.readLine());
                    words[j] = st.nextToken();
                    currentPosition[j]=0;
                    asteriskFromFront[j]=0;
                    asteriskFromBack[j]=0;
                }
                for(int j = 0; j<n; j++){
                    int currPos = 0;
                    while(currPos < words[j].length() && words[j].charAt(currPos)!='*'){
                        currPos++;
                    }
                    asteriskFromFront[j]=currPos;
                }
                for(int j = 0; j<n; j++){
                    int currPos = words[j].length()-1;
                    while(currPos >= 0 && words[j].charAt(currPos)!='*'){
                        currPos--;
                    }
                    asteriskFromBack[j]=currPos;
                }
                int maxFrontIndex = 0;
                int maxBackIndex = 0;
                for(int j = 0; j<n; j++){
                    if(asteriskFromFront[j]>asteriskFromFront[maxFrontIndex]){
                        maxFrontIndex = j;
                    }
                    if(words[j].length()-asteriskFromBack[j]>words[maxBackIndex].length()-asteriskFromBack[maxBackIndex]){
                        maxBackIndex = j;
                    }
                }
                boolean impossible = false;
                for(int j = 0; j<n; j++){
                    if(!words[j].substring(0, asteriskFromFront[j]).equals(words[maxFrontIndex].substring(0, asteriskFromFront[j]))){
                        impossible = true;
                    }
                    if(!words[j].substring(asteriskFromBack[j]+1, words[j].length()).equals(words[maxBackIndex].substring(words[maxBackIndex].length()-words[j].length()+asteriskFromBack[j]+1, words[maxBackIndex].length()))){
                        impossible = true;
                    }
                }
                if(impossible){
                    System.out.println("Case #"+i+": *");
                }else{
                    String currentWord = words[maxFrontIndex].substring(0, asteriskFromFront[maxFrontIndex]);
                    String back = words[maxBackIndex].substring(asteriskFromBack[maxBackIndex]+1, words[maxBackIndex].length());
                    for(int j = 0; j<n; j++){
                        words[j]=words[j].substring(asteriskFromFront[j]+1, asteriskFromBack[j]+1);
                        words[j] = words[j].replace("*", "");
                        currentWord += words[j];
                    }
                    currentWord += back;
                    System.out.println("Case #"+i+": "+currentWord);
                    
                    
                }
            }
        }catch(IOException e){
            return;
        }
    }
}