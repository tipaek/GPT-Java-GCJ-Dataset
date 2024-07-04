import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) { //each test case
            String nestedString = "";
            String inputStr = in.next(); //N
            char[] valuesArr = inputStr.toCharArray();
            Node headNode = new Node(null,null, parseInt(""+valuesArr[0]));
            Node prevNode = headNode;
            for(int k=1; k< valuesArr.length; k++){
                Node n = new Node(prevNode, null, Integer.parseInt(""+valuesArr[k]));
                prevNode.nextNode = n;
                prevNode = n;
            }
            Node currentNode = headNode;
            int totalOpenParanthesis = currentNode.openParanthesis;
            while(currentNode !=null){

                if(currentNode.prevNode!=null && currentNode.value!=0) {
                    if (totalOpenParanthesis > currentNode.closingParanthesis) {
                        currentNode.prevNode.closingParanthesis = (totalOpenParanthesis - currentNode.closingParanthesis);
                        totalOpenParanthesis = totalOpenParanthesis - currentNode.prevNode.closingParanthesis;
                        currentNode.openParanthesis = 0;

                    }
                    else if (totalOpenParanthesis < currentNode.closingParanthesis) {
                        currentNode.openParanthesis = (currentNode.closingParanthesis - totalOpenParanthesis);
                        totalOpenParanthesis = totalOpenParanthesis+currentNode.openParanthesis;
                        currentNode.prevNode.closingParanthesis = 0;
                    }
                    else{
                        currentNode.prevNode.closingParanthesis = 0;
                    }
                }
                while(currentNode.nextNode!=null && currentNode.nextNode.value ==currentNode.value){
                    //skip the node
                    currentNode = currentNode.nextNode;
                }
                currentNode = currentNode.nextNode;
            }
            currentNode = headNode;
            while(currentNode !=null){
                String openParanthesis = "";
                for(int op=0; op <currentNode.openParanthesis;op++){
                    openParanthesis = "("+openParanthesis;
                }

                nestedString = nestedString+openParanthesis+currentNode.value;
                while(currentNode.nextNode!=null && currentNode.nextNode.value ==currentNode.value){

                    //skip the node
                    currentNode = currentNode.nextNode;
                    nestedString = nestedString+currentNode.value;
                }
                String closingParanthesis = "";
                for(int op=0; op <currentNode.closingParanthesis;op++){
                    closingParanthesis = ")"+closingParanthesis;
                }
                nestedString = nestedString+closingParanthesis;
                currentNode = currentNode.nextNode;
            }
            System.out.println("Case #" + i + ": " + nestedString);
        }
    }

    static class Node{
        public Node prevNode;
        public int value;
        public int openParanthesis;
        public int closingParanthesis;
        public Node nextNode;
        public Node(Node pNode, Node nNode, int val){
            prevNode = pNode;
            nextNode = nNode;
            value= val;
            openParanthesis = val;
            closingParanthesis = val;

        }
    }
}