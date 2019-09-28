
/**
 * Name             : Sirajus Salekin Prodhan
 * Enrollment number: 557731
 * Name				: Prova Akter
 * Enrollment number: 557913
 * Name				: Shazad Ul Alam
 * Enrollment number: 558077
 */

public class Main {

	public static void main(String[] args) {
		int arr[] = { 5, 7, 8, 15, 20, 21, 13, 18, 11, 42 };
		ExecuteTreeOperation(arr);	 
	} 
	
	public static void ExecuteTreeOperation(int[] arr) {
		
		IVisitor visitor = new TreeInitiator(arr);
		
		IVisitableData visitableData = new Tree(0);
		visitableData.accept(visitor);
		
		IVisitableData visitableData1 = new NodeSum();
		visitableData1.accept(visitor);
		
		IVisitableData visitableData2 = new LeafSum();
		visitableData2.accept(visitor);
		
	}
}
