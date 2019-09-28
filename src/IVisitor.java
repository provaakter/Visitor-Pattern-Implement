
public interface IVisitor {
	public void visit(LeafSum leafSum);
	public void visit(Tree tree);
	public void visit(NodeSum nodeSum);
}
