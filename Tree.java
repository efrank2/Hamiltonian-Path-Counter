/*
	Eric Frank
	Tree.java
	Holds tree data structure and methods to build and explore it.
*/
import java.util.ArrayList;
public class Tree
{
	TreeNode root = new TreeNode(0,0,0);
	int height;
	int width;
	int numPaths = 0;
	boolean[][] visited;
	public Tree(int height, int width)
	{this.height = height; this.width = width; visited = new boolean[width][height]; visited[0][0] = true;}
//Recursively adds leaves to the tree until either goal node is found or no nodes can be added.
	public void addLeaf(TreeNode current)
	{
//Makes sure any path ends with the goal node.
		if(!((current.getX() == 0) && (current.getY() == height-1)) || (current.getDepth() == width*height-2))
		{
//Try adding X+1 (Where X is a coordinate on the x axis)
			if((current.getX() < width-1) && (!isNodeInPath(current.getX()+1,current.getY())) && !((current.isTR(width-1)) && (current.getDepth() < width*height-(width+height))))
			{
				TreeNode newLeaf = new TreeNode(current.getX()+1,current.getY(),current.getDepth()+1);
				visited[newLeaf.getX()][newLeaf.getY()] = true;
				current.addChildren(newLeaf);
				addLeaf(newLeaf);
			}
//Sets visited nodes to false once path has been fully explored.
				TreeNode[] childrens = current.getChildren();
				for(int i=0; i<current.getNumChildren();i++)
				{visited[childrens[i].getX()][childrens[i].getY()] = false;}
//X-1
			if((current.getX() > 0) && (!isNodeInPath(current.getX()-1,current.getY())))
			{
				TreeNode newLeaf = new TreeNode(current.getX()-1,current.getY(),current.getDepth()+1);
				visited[newLeaf.getX()][newLeaf.getY()] = true;
				current.addChildren(newLeaf);
				addLeaf(newLeaf);
			}	
			
				childrens = current.getChildren();
				for(int i=0; i<current.getNumChildren();i++)
				{visited[childrens[i].getX()][childrens[i].getY()] = false;}
//Y+1			
			if((current.getY() < height-1) && (!isNodeInPath(current.getX(),current.getY()+1)))
			{
				TreeNode newLeaf = new TreeNode(current.getX(),current.getY()+1,current.getDepth()+1);
				visited[newLeaf.getX()][newLeaf.getY()] = true;
				current.addChildren(newLeaf);
				addLeaf(newLeaf);
			}
			
				childrens = current.getChildren();
				for(int i=0; i<current.getNumChildren();i++)
				{visited[childrens[i].getX()][childrens[i].getY()] = false;}
//Y-1					
			if((current.getY() > 0) && (!isNodeInPath(current.getX(),current.getY()-1))&& !((current.isTR(width-1)) && (current.getDepth() < width*height-(width+height))))
			{
				TreeNode newLeaf = new TreeNode(current.getX(),current.getY()-1,current.getDepth()+1);
				visited[newLeaf.getX()][newLeaf.getY()] = true;
				current.addChildren(newLeaf);
				addLeaf(newLeaf);
			}
			
				childrens = current.getChildren();
				for(int i=0; i<current.getNumChildren();i++)
				{visited[childrens[i].getX()][childrens[i].getY()] = false;}
				
		}
		else
			if(current.getDepth() == width*height-1)
				numPaths++;
	}
	public int getNumPaths(){return numPaths;}

//Tests if considered node is already in the path leading to its parent.
	public boolean isNodeInPath(int x, int y)
	{return visited[x][y];}
	
	public TreeNode getRoot(){return root;}

/*
//Recursive method for finding if tree is in node (x,y)'s path.
	public boolean isNodeInPath(int x, int y, TreeNode current)
	{
		while(!current.equals(root))
		{
			if((current.getX() == x) && (current.getY() == y))
				return true;
//Checks if the root is repeated.
			if((x==0) && (y==0))
				return true;
			else
				current = current.getParent();
		}
		return false;
	}
	public void printTree(TreeNode in)
	{
		if(in.children.size() == 0)
		{
			System.out.println("Leaf coordinates: " + in.getX() + ", " + in.getY() + " Depth: " + in.getDepth());
			return;
		}
		System.out.println("Tree: " + in.getX() + " " + in.getY() + " Depth: " + in.getDepth());
		for(int i=0; i< in.children.size(); i++)
		{
			printTree(in.children.get(i));
		}
	}
*/}