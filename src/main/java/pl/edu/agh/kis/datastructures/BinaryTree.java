package pl.edu.agh.kis.datastructures;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class BinaryTree implements Iterable<Object> {

	private Node root;

	public static class Node {
		private Object value;
		private Node left;
		private Node right;

		public static Node leaf(Object value) {
			Node n = new Node();
			n.value = value;
			n.left = null;
			n.right = null;
			return n;
		}

		public void replaceLeftTree(Node n) {
			this.left = n;
		}

		public void replaceRightTree(Node n) {
			this.right = n;
		}

		public Optional<Node> getLeft() {
			return Optional.ofNullable(left);
		}

		public Optional<Node> getRight() {
			return Optional.ofNullable(right);
		}

		public Object getValue() {
			return value;
		}
	}

	private static class NodeProcessing {
		public enum LVR {
			L, V, R;
		}

		public Node n;
		public LVR branchProcessing;

		public NodeProcessing(Node n) {
			this.n = checkNotNull(n);
			branchProcessing = LVR.L;
		}
	}

	public static BinaryTree fromList(List<Object> elements) {
		BinaryTree t = new BinaryTree();
		Deque<NodeProcessing> nodes = new ArrayDeque<>();

		for (Object e : elements) {
			boolean goingToLeft = nodes.size() > 0 ? nodes.peek().branchProcessing == NodeProcessing.LVR.L : true;
			if (e == null) {
				if (goingToLeft) {
					nodes.peek().branchProcessing = NodeProcessing.LVR.R;
				} else {
					nodes.pop();
				}
			} else {
				Node n = Node.leaf(e);
				if (nodes.size() == 0) {
					t.root = n;
				} else if (goingToLeft) {
					nodes.peek().n.replaceLeftTree(n);
					nodes.peek().branchProcessing = NodeProcessing.LVR.R;
				} else {
					nodes.peek().n.replaceRightTree(n);
					nodes.pop();
				}
				nodes.push(new NodeProcessing(n));
			}
		}
		return t;
	}

	public static BinaryTree fromList(Object... elements) {
		return fromList(Arrays.asList(elements));
	}

	@Override
	public Iterator<Object> iterator() {
		return inOrder().iterator();
	}

	public Iterable<Object> preOrder() {
		return new PreOrderIterable();
	}

	public Iterable<Object> inOrder() {
		return new InOrderIterable();
	}

	public Iterable<Object> postOrder() {
		return new PostOrderIterable();
	}

}
