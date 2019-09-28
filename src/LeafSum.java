import java.util.ArrayList;

public class LeafSum implements IVisitableData {
	ArrayList<Integer> listOfLeafs = new ArrayList<Integer>();
	
	public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
	
	ArrayList<Integer> getAllLeafs(Tree root) 
	{ 
	    if (root == null) 
	        return null; 
	     
	    // if node is leaf node, print its data     
	    if (root.left == null && root.right == null) 
	    { 
	    	listOfLeafs.add(root.data); 
	    } 
	  
	    // if left child exists, check for leaf  
	    // recursively 
	    if (root.left != null) 
	       getAllLeafs(root.left); 
	          
	    // if right child exists, check for leaf  
	    // recursively 
	    if (root.right != null) 
	       getAllLeafs(root.right); 
	    
	    return listOfLeafs;
	}  

	/* Calculate sum of the values of leafs */
	int calculateTotalValuesOfLeafs(Tree root)
	{
		int sumOfValuesOfLeafs = 0; 
		for(int leaf : getAllLeafs(root)) {
			sumOfValuesOfLeafs += leaf;
		}
		System.out.println("The sum of the values of all leafs = " + sumOfValuesOfLeafs);
		return sumOfValuesOfLeafs;
	}
}
