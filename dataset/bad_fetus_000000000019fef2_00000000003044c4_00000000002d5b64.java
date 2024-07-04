import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            String[] split = sc.nextLine().split("\\s+");
            int rankCount = Integer.parseInt(split[0]);
            int suitCount = Integer.parseInt(split[1]);
            Node firstNode = new Node(1);
            Node currNode = firstNode;
            Node watchNode = firstNode;
            currNode.id = 1;
            int id = 2;
            for(int suit = 0; suit < suitCount; suit++){
                for(int rank = 1; rank <= rankCount; rank++){
                    if(!(rank == 1 && suit == 0)){
                        currNode.setNextNode(new Node(rank));
                        currNode = currNode.nextNode;
                        currNode.id = id;
                        if(id==5){
                            watchNode = currNode;
                        }
                        id++;
                    }
                }
            }

            int solved = 0;
            List<String> solution = new ArrayList<>();

            while(solved<rankCount * suitCount - 1){
                int requiredRank = rankCount - (solved / suitCount);
                if(currNode.rank == requiredRank){
                    solved ++;
                    currNode = currNode.previousNode;
                }else{
                    Node correctNode = currNode.previousNode;
                    int offBy = 1;
                    while(correctNode.rank != requiredRank){
                        correctNode = correctNode.previousNode;
                        offBy++;
                    }
                    int bDepth = rankCount * suitCount - solved;
                    int aDepth = bDepth - offBy;
                    solution.add(aDepth + " " + (bDepth - aDepth));

                    Node tempNode = correctNode.nextNode;
                    correctNode.nextNode.previousNode = null;
                    correctNode.setNextNode(currNode.nextNode);
                    firstNode.setPreviousNode(currNode);
                    firstNode = tempNode;
                    currNode = correctNode;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + solution.size());
            for(String string: solution){
                System.out.println(string);
            }
        }
        sc.close();
    }

    static class Node{
        Node previousNode = null;
        Node nextNode = null;
        int rank;
        int id;
        public Node(int rank){
            this.rank = rank;
        }

        public void setNextNode(Node node){
            this.nextNode = node;
            node.previousNode = this;
        }

        public void setPreviousNode(Node node){
            this.previousNode = node;
            node.nextNode = this;
        }
    }
}
