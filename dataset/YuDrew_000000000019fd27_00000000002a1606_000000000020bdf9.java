/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competitionscratchpaper;

/**
 *
 * @author yudrew
 */
import java.io.*;
import java.util.*;
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //take in input
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t;
        t = parseInt(f.readLine());
        for(int i = 0; i < t; i++){
            //System.out.println(vestigium(f, out, i + 1));
            //System.out.println(nestingDepth(f,i+1)); 
            System.out.println(parentingPartnering(f, out, i + 1));
        }
    }
    
    public static String nestingDepth(BufferedReader f, int caseNumber) throws IOException{
        String inp = f.readLine();
        String returnString = "";
        int currDepth = 0;
        for(int i = 0; i < inp.length(); i++){
            int num = parseInt(inp.substring(i,i+1));
            if(currDepth < num){
                for(int j = currDepth; j < num; j++){
                    returnString += "(";
                    currDepth++;
                }
                returnString += num;
            }else if(currDepth > num){
                for(int j = currDepth; j > num; j--){
                    returnString += ")";
                    currDepth--;
                }
                returnString += num;
            }else{
                returnString += num;
            }
        }
        for(int i = 0; i < currDepth; i++){
            returnString += ")";
        }
        return "Case #" + caseNumber + ": " + returnString;
    }
    
    public static String vestigium(BufferedReader f, PrintWriter out, int caseNumber) throws IOException{
        int N = parseInt(f.readLine());
        int[][] matrix = new int[N][N];
        int k = 0, r = 0, c = 0;
        boolean rLocked = false, cLocked = false;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for(int i = 0; i < N; i++){
            StringTokenizer tok = new StringTokenizer(f.readLine());
            rLocked = false;
            rowMap.clear();
            for(int j = 0; j < N; j++){
                matrix[i][j] = parseInt(tok.nextToken());
                if(i == j){
                    k += matrix[i][j];
                }
                if(!rLocked && rowMap.containsKey(matrix[i][j])){
                    r++;
                    rLocked = true;
                }
                rowMap.put(matrix[i][j], 1);
            }
        }
        for(int i = 0; i < N; i++){
            colMap.clear();
            cLocked = false;
            for(int j = 0; j < N; j++){
                if(!cLocked && colMap.containsKey(matrix[j][i])){
                    c++;
                    cLocked = true;
                }
                colMap.put(matrix[j][i], 1);
            }
        }
        return "Case #" + caseNumber + ": " + k + " " + r + " " + c;
    }//vestigium
    
    public static String parentingPartnering(BufferedReader f, PrintWriter out, int caseNumber) throws IOException{
        //input
        int N = parseInt(f.readLine());
        List<TaskTime> tasks = new LinkedList<>();
        StringTokenizer tok;
        for(int i = 0; i < N; i++){
            tok = new StringTokenizer(f.readLine());
            tasks.add(new TaskTime(parseInt(tok.nextToken()), true, i));
            tasks.add(new TaskTime(parseInt(tok.nextToken()), false, i));
        }
        Collections.sort(tasks);
        //System.out.println(tasks.toString());
        
        int activeCounter = 0;
        String assignmentString = "";
        boolean cAssigned = false;
        boolean jAssigned = false;
        int cAssignment = -1;
        int jAssignment = -1;
        for(int i = 0; i < tasks.size(); i++){
            //iterate through tasks and keep track of how many active tasks there are at a time;
            TaskTime time = tasks.get(i);
            if(time.isStart){
                activeCounter++;
                if(activeCounter > 2){
                    return "Case #" + caseNumber + ": " + "IMPOSSIBLE";
                }else{
                    if(!cAssigned){
                        cAssigned = true;
                        assignmentString += "C";
                        cAssignment = time.identifier;
                    }else if(!jAssigned){
                        jAssigned = true;
                        assignmentString += "J";
                        jAssignment = time.identifier;
                    }
                }
            }else{
                activeCounter--;
                if(time.identifier == cAssignment){
                    cAssignment = -1;
                    cAssigned = false;
                } else if(time.identifier == jAssignment){
                    jAssignment = -1;
                    jAssigned = false;
                }
            }
        }//true compute
        return "Case #" + caseNumber + ": " + assignmentString;
    }//computeTestCase
    public static int parseInt(String s){
        return Integer.parseInt(s);
    }//parseInt
}

class TaskTime implements Comparable{
    int time;
    boolean isStart;
    int identifier;
    public TaskTime(int t, boolean s, int i){
        time = t;
        isStart = s;
        identifier = i;
    }
    
    @Override
    public int compareTo(Object o) {
        int value = this.time - ((TaskTime) o).time;
        if(value == 0){
            if(!((TaskTime) o).isStart && this.isStart){
                return 1;
            }
            if(((TaskTime) o).isStart && !this.isStart){
                return -1;
            }
        }
        return value;
    }
    
    @Override
    public String toString(){
        String startString = "";
        if(isStart){
            startString = "S";
        }else{
            startString = "E";
        }
        return "T#" + identifier + startString + ": " + time;
    }
}//TaskTime
