import java.util.*;

public class Solution {
    static class Node {
        public int x,y;
        public String first, second;
        public Node(int x, int y, String first, String second){
            this.x = x;
            this.y = y;
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            results[i] = "Case #" + (i+1) + ": " + direction(x,y);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String direction(int x, int y){
        String result = "";
        int len = 2*Math.max(Math.abs(x),Math.abs(y));
        Queue<Node> findNode = new LinkedList<Node>();
        Node a1 = new Node(x,y,"0","0");
        Node a2 = new Node(x,y,"0","1");
        Node a3 = new Node(x,y,"1","0");
        Node a4 = new Node(x,y,"1","1");
        findNode.add(a1);
        findNode.add(a2);
        findNode.add(a3);
        findNode.add(a4);
        while (!findNode.isEmpty()){
            Node node = findNode.poll();
            int lenNode = node.first.length();
            if (lenNode > len) return "IMPOSSIBLE";
            char c1 = node.first.charAt(lenNode - 1);
            char c2 = node.second.charAt(lenNode - 1);
            int x1 = node.x;
            int y1 = node.y;
            if (c1 == '0' && c2 == '0'){
                x1 += (int) Math.pow(2,lenNode-1);
            } else if (c1 == '1' && c2 == '0'){
                x1 -= (int) Math.pow(2,lenNode-1);
            } else if (c1 == '0' && c2 == '1'){
                y1 += (int) Math.pow(2,lenNode-1);
            }
            else {
                y1 -= (int) Math.pow(2,lenNode-1);
            }
            if (x1 == 0 && y1 == 0) {
                for (int i = 0; i < lenNode; i++){
                    char m = node.first.charAt(i);
                    char n = node.second.charAt(i);
                    if (m == '0' && n == '0'){
                        result += "W";
                    } else if (m == '1' && n == '0'){
                        result += "E";
                    } else if (m == '0' && n == '1'){
                        result += "S";
                    }
                    else {
                        result += "N";
                    }
                }
                return result;
            }
            if (lenNode < 2*len){
                Node a11 = new Node(x1,y1,node.first+"0",node.second + "0");
                Node a22 = new Node(x1,y1,node.first+"0",node.second +"1");
                Node a33 = new Node(x1,y1,node.first+"1",node.second +"0");
                Node a44 = new Node(x1,y1,node.first+"1",node.second +"1");
                findNode.add(a11);
                findNode.add(a22);
                findNode.add(a33);
                findNode.add(a44);
            }
        }
        return result;
    }
    
}