import java.util.ArrayList;

public class NodeSum implements IVisitableData {
	ArrayList<Integer> listOfNodes = new ArrayList<Integer>();
	
	public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
	
	ArrayList<Integer> getAllNodes(Tree root) 
	{ 
	    if (root == null) 
	        return null; 
	    
	    listOfNodes.add(root.data); 
	  
	    // if left child exists, check for parent  
	    // recursively 
	    if (root.left != null) 
	    	getAllNodes(root.left); 
	          
	    // if right child exists, check for parent  
	    // recursively 
	    if (root.right != null) 
	    	getAllNodes(root.right); 
	    
	    return listOfNodes;
	}  

	/* Calculate sum of the values of parent nodes */
	int calculateTotalValuesOfNodes(Tree root)
	{
		int sumOfValuesOfNodes = 0; 
		for(int parentNodes : getAllNodes(root)) {
			sumOfValuesOfNodes += parentNodes;
		}
		System.out.println("The sum of the values of all nodes = " + sumOfValuesOfNodes);
		return sumOfValuesOfNodes;
	}
}
