import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {
            int n = in.nextInt();
            in.nextLine();
            String result = "";
            String suffix = "";
            String prefix = "";
            String[] temp = new String[n];
            boolean possible = true;
            boolean empty = false;
            for (int i = 0; i < n; i++) {
                temp[i] = in.nextLine();

            }
            boolean q = true;
            
            while (q) {
                char start = '*';
                for (int i = 0; i<n; i++){
                    if ((start=='*')&&(temp[i].charAt(0)!='*')){
                        start = temp[i].charAt(0);
                    }
                    if ((start!='*')&&(temp[i].charAt(0)!='*')&&(temp[i].charAt(0)!=start)){
                        possible = false;
                        q = false;
                        break;
                    }
                }
                if (start == '*'){
                    q = false;
                }
                else if (possible){
                    boolean check = false;
                    for (int i = 0; i<n; i++){
                        if (temp[i].charAt(0)!='*'){
                            temp[i] = temp[i].substring(1);
                            if (temp[i].length() == 0){
                                check = true;
                                break;
                            }
                        }
                        
                    }
                    if (check){
                        for (int j = 0; j<n; j++){
                            for (int m=0; m< temp[j].length(); m++){
                                if (temp[j].charAt(m)!='*'){
                                    possible = false;
                                    break;
                                }
                            }
                            if (!possible){
                                break;
                            }
                        }    
                    }
                    if (possible){
                        char[] start_ar = new char[1];
                        start_ar[0] = start;
                        prefix = prefix.concat(new String(start_ar));
                    }
                }
                if (!possible){
                    q = false;
                }
            }
            
            q = true;
            if (!possible){
                q = false;
            }
            
            while (q) {
                char finish = '*';
                for (int i = 0; i<n; i++){
                    int ind = temp[i].length()-1;
                    if ((finish=='*')&&(temp[i].charAt(ind)!='*')){
                        finish = temp[i].charAt(ind);
                    }
                    if ((finish!='*')&&(temp[i].charAt(ind)!='*')&&(temp[i].charAt(ind)!=finish)){
                        possible = false;
                        q = false;
                        break;
                    }
                }
                if (finish == '*'){
                    q = false;
                }
                else if (possible){
                    boolean check = false;
                    for (int i = 0; i<n; i++){
                        int ind = temp[i].length()-1;
                        if (temp[i].charAt(ind)!='*'){
                            temp[i] = temp[i].substring(0, ind);
                            if (temp[i].length() == 0){
                                check = true;
                                break;
                            }
                        }
                        
                    }
                    if (check){
                        for (int j = 0; j<n; j++){
                            for (int m=0; m< temp[j].length(); m++){
                                if (temp[j].charAt(m)!='*'){
                                    possible = false;
                                    break;
                                }
                            }
                            if (!possible){
                                break;
                            }
                        }    
                    }
                    if (possible){
                        char[] finish_ar = new char[1];
                        finish_ar[0] = finish;
                        suffix = (new String(finish_ar)).concat(suffix);
                    }
                }
                if (!possible){
                    q = false;
                }
            }
            
            
            if (!possible){
                result = "*";
            }
            else{
                String middle;
                if (empty){
                    result = prefix.concat(suffix);
                }
                else{
                    result = prefix;
                    for (int i= 0; i<n; i++){
                        temp[i] = temp[i].replace('*', '8');
                        temp[i] = temp[i].replaceAll("8", "");
                        result = result.concat(temp[i]);                        
                    }
                    result = result.concat(suffix);
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }

}
