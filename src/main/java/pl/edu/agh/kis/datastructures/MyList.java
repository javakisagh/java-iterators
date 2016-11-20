package pl.edu.agh.kis.datastructures;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import static com.google.common.base.Preconditions.*;

public class MyList {
    private Node head;

    public static class Node {
        private Object value;
        private Node next;

        public static Node lastNode(Object value) {
            Node n = new Node();
            n.value = checkNotNull(value);
            n.next = null;
            return n; 
        }

        public static Node middleNode(Object value, Node tail) {
            Node n = new Node();
            n.value = checkNotNull(value);
            n.next = checkNotNull(tail);
            return n;
        }

        public Object getValue() {
            return value;
        }

        public Optional<Node> getNext() {
            return Optional.ofNullable(next);
        }

        public void replaceTail(Node tail) {
            next = checkNotNull(tail);
        }
    }

    public static MyList fromList(List<Object> elements) {
        MyList l = new MyList();
        Node currentNode = null;
        for (Object e : elements) {
            Node n = Node.lastNode(e);
            if (currentNode != null) {
                currentNode.replaceTail(n);
                currentNode = n;
            } else {
                l.head = n;
                currentNode = n;
            }
        }
        return l;
    }

    public static MyList fromList(Object... elements) {
        return fromList(Arrays.asList(elements));
    }
}