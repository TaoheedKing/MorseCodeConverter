 
/**
 * The external Tree Node for Linked Trees 
 * @author Taoheed King
 *
 * @param <T>
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode 
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 * used for making deep copies 
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}

	/* ******* getters and setters ********** */
	/**
	 * @return the data within this TreeNode 
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the leftChild
	 */
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	

	

}
