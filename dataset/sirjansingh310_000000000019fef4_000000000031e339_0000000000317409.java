import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = 1;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pX = Integer.parseInt(st.nextToken());
            int pY = Integer.parseInt(st.nextToken());
            char path[] = st.nextToken().toCharArray();

            int xMoves[] = {0, 1, -1, 0}; // N E W S
            int yMoves[] = {1, 0, 0, -1};
            HashMap<Integer, String> pPosition = new HashMap<>();
            pPosition.put(0, pX + " " + pY);
            for(int i = 0; i < path.length; i++){
                if(path[i] == 'S'){
                    pY--;
                }
                else if(path[i] == 'N'){
                    pY++;
                }
                else if(path[i] == 'E'){
                    pX++;
                }
                else if(path[i] == 'W'){
                    pX--;
                }
                pPosition.put(i + 1, pX + " "+pY);
            }

            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(0);
            queue.add(0);
            queue.add(0);
          //  HashMap<String, Boolean> visited = new HashMap<>();
           // visited.put("0 0", true);
            int count = 0;
            boolean intersection = false;
            while(queue.size() > 0){
                int parentX = queue.poll();
                int parentY = queue.poll();
                int level = queue.poll();
                if(level > path.length){
                    break;
                }
                String str = pPosition.get(level);
                int currentPX = Integer.parseInt(str.split(" ")[0]);
                int currentPY = Integer.parseInt(str.split(" ")[1]);
                if(parentX == currentPX && parentY == currentPY){
                    count = level;
                    intersection = true;
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int childX = parentX + xMoves[i];
                    int childY = parentY + yMoves[i];
                  //  String key = childX + " " + childY;
                    // if(visited.containsKey(key)){
                    //     continue;
                    // }
                    queue.add(childX);
                    queue.add(childY);
                    queue.add(level + 1);
                    //visited.put(key, true);
                }
                queue.add(parentX);
                queue.add(parentY);
                queue.add(level + 1);
            }
            if(intersection){
                System.out.println("Case #" + caseNumber + ": " + count);
            }
            else{
                System.out.println("Case #" + caseNumber + ": " + "IMPOSSIBLE");
            }
            caseNumber++;
        }
    }
}
