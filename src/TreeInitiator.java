//import java.util.ArrayList;

public class TreeInitiator implements IVisitor  {
	Tree root;
	int arr[];
	
	public TreeInitiator(int[] arr) {
		this.arr = arr;
	}
	
	@Override
	public void visit(Tree data)  
    {        	
		data.insertLevelOrder(arr, root, 0); 
        root = data.getTree(); //returning tree   
        System.out.println("The value of the root node = " + root.data);
    }
	
	@Override
	public void visit(LeafSum leafSum) {
		leafSum.calculateTotalValuesOfLeafs(root);
	}

	@Override
	public void visit(NodeSum nodeSum) {
		nodeSum.calculateTotalValuesOfNodes(root);
	}	
}
