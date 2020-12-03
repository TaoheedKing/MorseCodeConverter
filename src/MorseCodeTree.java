import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
/**
 * @author Taoheed King
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> rootNode;
	
	
	/**
	 * Constructor - calls the buildTree method 
	 */
	public MorseCodeTree() {
		rootNode = new TreeNode<>(" ");
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return rootNode;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		rootNode = newNode;
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		
		addNode(rootNode, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
    
		String newCode = "";
		String[] charArray = code.split("");
		Queue<String> sb = new LinkedList<>(Arrays.asList(charArray));
		
		sb.poll(); // remove first character from code string
		for(String temp: sb) { // build a new string with removed character
			newCode += temp.trim();
		}
		
		
		// base case: if code string only has one character set the letter to a child
		if(code.length() == 1) {
			if(code.equals(".")){
				if(root.getLeftChild() == null) {
					root.setLeftChild(new TreeNode<String>(letter));
				}
				else {
					root.getLeftChild().setData(letter);
				}
			} 
			else {
				if(root.getRightChild() == null) {
					root.setRightChild(new TreeNode<String>(letter));
				}
				else {
					root.getRightChild().setData(letter);
				}
			}
		}
		//if first character in string builder is "." keep transversing to the left
		else if(code.charAt(0) == '.') {
			if(root.getLeftChild() == null) {
				root.setLeftChild(new TreeNode<String>(" "));
				addNode(root.getLeftChild(), newCode, letter);
			}
			else{
				addNode(root.getLeftChild(), newCode, letter);
			}
		}
		//if first character in string builder is "-" keep transversing to the right
		else if (code.charAt(0) == '-') {
			if(root.getRightChild() == null) {
				root.setRightChild(new TreeNode<String>(" "));
				addNode(root.getRightChild(), newCode, letter);
			}
			else{
				addNode(root.getRightChild(), newCode, letter);
			}
		}
		
	}

	@Override
	public String fetch(String code) {
		return fetchNode(rootNode, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String newCode = "";
		String[] charArray = code.split("");
		Queue<String> sb = new LinkedList<>(Arrays.asList(charArray));

		sb.poll();// remove first character from code string
		for(String temp: sb) { // build a new string with removed character
			newCode += temp.trim();
		}


		//base case
		if(code.length() == 1) {
			if(code.equals(".")){
				return root.getLeftChild().getData();
			} 
			else {
				return root.getRightChild().getData();
			}
		}
		//if first character  is "." keep transversing to the left
		else if(code.charAt(0) == '.') {
			return fetchNode(root.getLeftChild(), newCode);
		}
		//if first character is "-" keep transversing to the right
		else if (code.charAt(0) == '-') {
			return fetchNode(root.getRightChild(), newCode);
		}
		else {
			System.out.println("Character not supported");
			return null;
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		String alphabet = "a b c d e f g h i j k l m n o p q r t s u v w x y z";
		String[] alphabetArray = alphabet.split(" ");


		for(String temp: alphabetArray) {
			addNode(rootNode, getMorseCode(temp), temp);
		}
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(rootNode, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root == null){
			return;
		}
		
		LNRoutputTraversal(root.getLeftChild(), list); //visit and print left child

		list.add(root.getData()); //visit and print node
		
		LNRoutputTraversal(root.getRightChild(), list); //visit and print right child
		
	}
	
	/**
	 * Converts letters to their corresponding morse code
	 * @param letter - letter to be converted to morse code. Must be a letter in the English alphabet
	 * @return a letter as string morse code
	 */
	private String getMorseCode(String letter){
	
		switch (letter) {
			case "a": return ".-";
			case "b": return "-...";
			case "c": return "-.-.";
			case "d": return "-..";
			case "e": return ".";
			case "f": return "..-.";
			case "g": return "--.";
			case "h": return "....";
			case "i": return "..";
			case "j": return ".---";
			case "k": return "-.-";
			case "l": return ".-..";
			case "m": return "--";
			case "n": return "-.";
			case "o": return "---";
			case "p": return ".--.";
			case "q": return "--.-";
			case "r": return ".-.";
			case "s": return "...";
			case "t": return "-";
			case "u": return "..-";
			case "v": return "...-";
			case "w": return ".--";
			case "x": return "-..-";
			case "y": return "-.--";
			case "z": return "--..";
			default: return "";
		}
	}

}
