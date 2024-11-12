import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String value;
    List<TreeNode> children;

    // Constructor to initialize the node's value and children list
    public TreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    // Method to add a child node to the current node
    public void addChild(TreeNode child) {
        children.add(child);
    }

    // Recursive method to display the tree structure
    public void displayTree(int level) {
        // Print the current node's value with indentation based on the level
        System.out.println(" ".repeat(level * 2) + value);
        for (TreeNode child : children) {
            child.displayTree(level + 1);  // Recursive call to display each child's subtree
        }
    }
}

public class GeneralTreeExample {
    public static void main(String[] args) {
        // Create the root node
        TreeNode root = new TreeNode("A");

        // Add child nodes to the root
        TreeNode child1 = new TreeNode("B");
        TreeNode child2 = new TreeNode("C");
		TreeNode child3 = new TreeNode("G");

        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        // Add children to "Child 1"
        TreeNode child1_1 = new TreeNode("D");
        TreeNode child1_2 = new TreeNode("E");

        child1.addChild(child1_1);
        child1.addChild(child1_2);

        // Add a child to "Child 2"
        TreeNode child2_1 = new TreeNode("F");
        TreeNode child2_2 = new TreeNode("G");
        child2.addChild(child2_1);
        child2.addChild(child2_2);

        // Add a child to "Child 3"
        TreeNode child3_1 = new TreeNode("H");
        TreeNode child3_2 = new TreeNode("I");
        TreeNode child3_3 = new TreeNode("J");
        child3.addChild(child3_1);
        child3.addChild(child3_2);
        child3.addChild(child3_3);

        // Display the entire tree structure starting from the root
        root.displayTree(0);
    }
}
