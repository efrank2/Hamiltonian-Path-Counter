/*	Eric Frank
	AthenaHealth Coding Test Solution
	February 2013
*/
public class Solver
{
	public static void main(String[] args)
	{
		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		Tree daTree = new Tree(width,height);
		daTree.addLeaf(daTree.getRoot());
		System.out.println("Solution: " + daTree.getNumPaths());
	}
}