import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {//Rename to Solution
    static Scanner scan;
    public static void main(String[] args) throws FileNotFoundException {//you're an idiot
        scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 0; t < T; t++){
            int n = scan.nextInt();
            scan.nextLine();
            String[] patterns = new String[n];
            String[] begins = new String[n];
            String[] ends = new String[n];
            String[] mids = new String[n];
            for(int i = 0; i < n; i++){
                patterns[i] = scan.nextLine();
                begins[i] = patterns[i].substring(0,patterns[i].indexOf("*"));
                ends[i] = patterns[i].substring(patterns[i].lastIndexOf("*")+1);
                StringBuilder s = new StringBuilder();
                for(char c: ends[i].toCharArray())
                    s.append(c);
                ends[i] = s.reverse().toString();
                mids[i] = patterns[i].substring(patterns[i].indexOf("*")+1, patterns[i].lastIndexOf("*"));
                mids[i] = mids[i].replace("*","");
            }
            boolean fail = false;
            ArrayList<Character> beg = new ArrayList<>();
            for(String s : begins){
                if (fail)
                    break;
                char[] arr = s.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    if(i >= beg.size())
                        beg.add(arr[i]);
                    else if(beg.get(i)!=arr[i]) {
                        fail = true;
                        break;
                    }
                }
            }
            String beginning = "";
            for(char c: beg)
                beginning+=c;

            ArrayList<Character> eds = new ArrayList<>();
            for(String s : ends){
                if (fail)
                    break;
                char[] arr = s.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    if(i >= eds.size())
                        eds.add(arr[i]);
                    else if(eds.get(i)!=arr[i]) {
                        fail = true;
                        break;
                    }
                }
            }
            String ending = "";
            for(int i = eds.size()-1; i>=0; i--)
                ending+=eds.get(i);


            String out = beginning;
            for(String s : mids)
                out+=s;
            out+=ending;
            if(fail || out.length()>10000)
                System.out.println("Case #" + (t+1) + ": *");
            else
                System.out.println("Case #" + (t+1) + ": " + out);

        }
        scan.close();
    }
}