
public class Tree implements IVisitableData {
	public int data; 
	Tree left, right, root; 
	Tree leftMostNode;
	Tree fetchedData;
	
 	public Tree(int data) 
	{ 
		this.data = data; 
		this.left = null; 
		this.right = null; 
	}

	public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
	
	public Tree insertLevelOrder(int[] arr, Tree proot, int i) 
	{ 
		if (i < arr.length) { 
			Tree temp = new Tree(arr[i]); 
			proot = temp; 

			// insert left child 
			proot.left = insertLevelOrder(arr, proot.left, 2 * i + 1); 

			// insert right child 
			proot.right = insertLevelOrder(arr, proot.right, 2 * i + 2); 
		} 
		root = proot;
		//printLevelOrder(root);
		return proot; 
	} 
	public Tree getTree()
    {
        return root;    
    }
	
	void findDeepestLeftMostleaf(Tree tree, int lvl, Level level, boolean isLeft) 
	{
		// Base case 
		if (root == null) 
			return; 

		// Update result if this node ||  is left leaf and its level || is more than the maxl level || of the current result 
		if (isLeft != false && root.left == null &&	root.right == null && lvl > Level.maxLevel) 
		{ 
			leftMostNode = root; 
			Level.maxLevel = lvl; 
		} 

		// Recur for left and right subtrees 
		findDeepestLeftMostleaf(root.left, lvl + 1, level, true); 
		findDeepestLeftMostleaf(root.right, lvl + 1, level, false); 
	}
	public void deepestLeftMostleaf(Tree tree) 
	{ 
		Level level = new Level();
		findDeepestLeftMostleaf(root, 0, level, false); 
		if (leftMostNode != null) 
			System.out.println("The deepest left leaf is " + leftMostNode.data); 
		else
			System.out.println("There is no left leaf in the given tree");
	}
	
	static class Level {
		static int maxLevel = 0;
	}
	
	static int height(Tree tree) 
    { 
        if (tree == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(tree.left); 
            int rheight = height(tree.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    }
	/* Function to line by line print level order traversal a tree*/
	static void printLevelOrder(Tree tree) 
	{ 
	    int h = height(tree); 
	    int i; 
	    for (i=1; i<=h; i++) 
	    { 
	        printGivenLevel(tree, i); 
	        System.out.println(); 
	    } 
	} 
	/* Print nodes at a given level */
	static void printGivenLevel(Tree tree, int level) 
	{ 
	    if (tree == null) 
	        return; 
	    if (level == 1) 
	        System.out.print(tree.data + " "); 
	    else if (level > 1) 
	    { 
	        printGivenLevel(tree.left, level-1); 
	        printGivenLevel(tree.right, level-1); 
	    } 
	} 
}

//test