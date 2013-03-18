/*
	Eric Frank
	TreeNode data structure
	Holds information about each node on the tree.
*/
import java.util.ArrayList;
public class TreeNode
{
//Coordinates of the node on the grid, the node's children, it's depth and number of children.
	int x,y;
	TreeNode[] children = new TreeNode[3];
	int depth;
	int numChildren = 0;
	
	public TreeNode(int x, int y, int depth)
	{
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
	
	public TreeNode[] getChildren()
	{return children;}
//Is this the top right node? Included to speed up the program a bit by knocking out possibilities.
	public boolean isTR(int width)
	{
		if((x == width) && (y==0))
			return true;
		return false;
	}
	
//I would have used an arraylist, but it increased the space compexity (which is about 2*n, where n is num elements).
	public void addChildren(TreeNode child)
	{
		children[numChildren] = child;
		numChildren++;
	}
	
	public int getNumChildren()
	{return numChildren;}
	
	public int getDepth()
	{return depth;}
	
	public int getX()
	{return x;}
	
	public int getY()
	{return y;}
}