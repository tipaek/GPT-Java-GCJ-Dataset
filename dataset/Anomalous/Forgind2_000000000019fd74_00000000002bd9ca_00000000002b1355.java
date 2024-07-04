import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        in.nextLine();
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String[] dimensions = in.nextLine().trim().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            DancerList dancerList = new DancerList();
            int totalSkill = 0;
            Dancer[] lastRow = new Dancer[cols];
            
            for (int i = 0; i < rows; i++) {
                String[] skills = in.nextLine().trim().split(" ");
                Dancer previousDancer = null;
                
                for (int j = 0; j < cols; j++) {
                    Dancer currentDancer = new Dancer(Integer.parseInt(skills[j]));
                    currentDancer.east = previousDancer;
                    if (previousDancer != null) previousDancer.west = currentDancer;
                    previousDancer = currentDancer;
                    
                    currentDancer.north = lastRow[j];
                    if (lastRow[j] != null) lastRow[j].south = currentDancer;
                    lastRow[j] = currentDancer;
                    
                    dancerList.add(currentDancer);
                    totalSkill += currentDancer.skill;
                }
            }
            
            int totalInterest = totalSkill;
            int skillChange = dancerList.performDance();
            
            while (skillChange > 0) {
                totalSkill -= skillChange;
                totalInterest += totalSkill;
                skillChange = dancerList.performDance();
            }
            
            System.out.println("Case #" + caseNum + ": " + totalInterest);
        }
        
        in.close();
    }
    
    private static class Dancer {
        int skill;
        Dancer north, south, east, west;
        boolean eliminated;
        
        Dancer(int skill) {
            this.skill = skill;
            this.eliminated = false;
        }
        
        void dance() {
            int neighborCount = 0;
            int totalNeighborSkill = 0;
            
            if (north != null) {
                neighborCount++;
                totalNeighborSkill += north.skill;
            }
            if (south != null) {
                neighborCount++;
                totalNeighborSkill += south.skill;
            }
            if (east != null) {
                neighborCount++;
                totalNeighborSkill += east.skill;
            }
            if (west != null) {
                neighborCount++;
                totalNeighborSkill += west.skill;
            }
            
            if (skill * neighborCount < totalNeighborSkill) {
                eliminated = true;
            }
        }
    }
    
    private static class DancerNode {
        Dancer dancer;
        DancerNode prev, next;
        
        DancerNode(Dancer dancer) {
            this.dancer = dancer;
        }
    }
    
    private static class DancerList {
        DancerNode head;
        
        void add(Dancer dancer) {
            DancerNode newNode = new DancerNode(dancer);
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
        }
        
        int performDance() {
            int skillLoss = 0;
            
            for (DancerNode node = head; node != null; node = node.next) {
                node.dancer.dance();
            }
            
            for (DancerNode node = head; node != null; node = node.next) {
                if (node.dancer.eliminated) {
                    if (node.prev != null) node.prev.next = node.next;
                    else head = node.next;
                    
                    if (node.next != null) node.next.prev = node.prev;
                    
                    skillLoss += node.dancer.skill;
                } else {
                    Dancer dancer = node.dancer;
                    while (dancer.north != null && dancer.north.eliminated) dancer.north = dancer.north.north;
                    while (dancer.south != null && dancer.south.eliminated) dancer.south = dancer.south.south;
                    while (dancer.east != null && dancer.east.eliminated) dancer.east = dancer.east.east;
                    while (dancer.west != null && dancer.west.eliminated) dancer.west = dancer.west.west;
                }
            }
            
            return skillLoss;
        }
    }
}