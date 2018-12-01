import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeftViewOfTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (line.isEmpty()) {
            System.out.println("[]");
            return;
        }

        String[] parts = line.split(" ");
        if (parts.length < 1) {
            System.out.println("[]");
            return;
        }

        // build tree
        // 1. find header
        int headerIndex = -1;
        for (int i = 0; i < parts.length; i++) {
            if ("#".equals(args[i])) {
                continue;
            }
            headerIndex = i;
            break;
        }

        if (headerIndex < 0) {
            System.err.println("No tree header found");
            return;
        }

        // build tree
        Node header = buildTree(headerIndex, parts);
        // left view of tree
        List<Integer> result = leftViewOfTree(header);
        StringBuilder sb = new StringBuilder();
        for (Integer rt : result) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(rt);
        }
        System.out.println(String.format("[%s]", sb.toString()));
    }

    private static List<Integer> leftViewOfTree(Node header) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        list.add(header);
        while (!list.isEmpty()) {
            result.add(list.getFirst().value);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node tmp = list.removeFirst();
                if (tmp.left != null) list.add(tmp.left);
                if (tmp.right != null) list.add(tmp.right);
            }
        }
        return result;
    }

    private static Node buildTree(int headerIndex, String[] parts) {
        Node header = new Node(Integer.valueOf(parts[headerIndex++]));
        LinkedList<Node> prevNodes = new LinkedList<>();
        prevNodes.add(header);
        Node tmp;
        while (!prevNodes.isEmpty() && headerIndex < parts.length) {
            // left node
            tmp = prevNodes.removeFirst();
            if (headerIndex < parts.length) {
                Node left = createNode(parts[headerIndex]);
                headerIndex++;
                if (left != Node.DUMMY) {
                    tmp.left = left;
                }
                prevNodes.add(left);
            }

            if (headerIndex < parts.length) {
                Node right = createNode(parts[headerIndex]);
                headerIndex++;
                if (right != Node.DUMMY) {
                    tmp.right = right;
                }
                prevNodes.add(right);
            }

        }

        return header;
    }


    private static Node createNode(String input) {
        if ("#".equals(input)) {
            return Node.DUMMY;
        }
        return new Node(Integer.valueOf(input));
    }

    static class Node {

        private final static Node DUMMY = new Node(null);
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
