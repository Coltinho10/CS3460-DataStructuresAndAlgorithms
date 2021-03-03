
public class DepthPrint {
	
    public static void main(String [] args) {
        // Create an instance of MyTree.		
        MyTree T = new MyTree();

        // Get the root node of my tree.
		TreeNode root = T.getRoot();

		// TODO: Code for printing the tree from depth 500 through 510 in sorted order.
		// Feel free to define recursive methods to traverse the tree and print.
		// Please print each key separated by spaces.
        print(root, 0);
		// Printing a new line in the end.
		System.out.println();
	}
    
    public static void print(TreeNode root, int depth)
    {
        if (root == null) return;
        if (depth >= 500 && depth <= 510)
        {
            print(root.left, depth + 1);
            System.out.print(root.key + " ");
            print(root.right, depth + 1);
        }
        else
        {
            print(root.left, (depth + 1));
            print(root.right, (depth + 1));
        }

    }
}
