import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for (int t = 0; t < numberOfTestCases; t++) {
            PersonalCalendar cameron = new PersonalCalendar();
            PersonalCalendar jamie = new PersonalCalendar();
            StringBuilder eventAssigned = new StringBuilder();
            boolean possible = true;

            int numberOfActivities = in.nextInt();
            for (int a = 0; a < numberOfActivities; a++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                if (possible) {
                    if (cameron.addEvent(startTime, endTime)) {
                        eventAssigned.append("C");
                    } else if (jamie.addEvent(startTime, endTime)) {
                        eventAssigned.append("J");
                    } else {
                        possible = false;
                    }
                }
            }
            if (!possible) eventAssigned = new StringBuilder("IMPOSSIBLE");

            System.out.println("Case #" + (t + 1) + ": " + eventAssigned);
        }
    }
}

class PersonalCalendar {
    TreeNode root;

    public PersonalCalendar() {
        root = null;
    }

    public boolean addEvent(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }

        TreeNode tempNode = root;
        while (tempNode != null) {
            if (tempNode.startTime >= end) {
                if (tempNode.left != null) {
                    tempNode = tempNode.left;
                } else {
                    tempNode.left = new TreeNode(start, end);
                    tempNode = null;
                }
            } else if (tempNode.endTime <= start) {
                if (tempNode.right != null) {
                    tempNode = tempNode.right;
                } else {
                    tempNode.right = new TreeNode(start, end);
                    tempNode = null;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

class TreeNode {
    int startTime;
    int endTime;
    TreeNode left;
    TreeNode right;

    TreeNode(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}