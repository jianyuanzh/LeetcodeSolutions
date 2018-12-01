import java.util.*;

public class CircleRadium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);

        List<Case> cases = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            int m = Integer.parseInt(line);
            Case cs = new Case(m);
            for (int j = 0; j < m - 1; j++) {
                line = sc.nextLine();
                String[] part = line.split(" ");
                if (part.length != 2) {
                    throw new IllegalArgumentException("Invalid input pair " + line);
                }
                int first = Integer.parseInt(part[0]);
                int second = Integer.parseInt(part[1]);
                cs.relationMap.computeIfAbsent(first, k -> new ArrayList<>()).add(second);
                cs.relationMap.computeIfAbsent(second, k -> new ArrayList<>()).add(first);
            }
            cases.add(cs);
        }

        for (Case cs : cases) {
            System.out.println(cs.findMax());
        }

    }


    private static class Case {
        private final int nodeCount;
        private final Map<Integer, List<Integer>> relationMap;

        private Case(int nodeCount) {
            this.nodeCount = nodeCount;
            relationMap = new HashMap<>();
        }

        public int findMax() {
            int[][]distances = new int[nodeCount][nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    distances[i][j] = 0;
                }
            }
            for (int i = 1; i <= this.nodeCount; i++) {
                List<Integer> edges = relationMap.get(i);
//                Collections.sort(edges);
                for (int edge : edges) {
                    if (edge < i) {
                        continue;
                    }
                    distances[i-1][edge-1] = 1;
                    distances[edge-1][i-1] = 1;

                }
            }
            return 0; // todo
        }

        private void dfs(int i) {

        }
    }
}
