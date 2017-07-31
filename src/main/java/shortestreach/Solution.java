package shortestreach;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int[] solution;

    public static class Edge {
        final int idA;
        final int idB;

        private Edge(int idA, int idB) {
            this.idA = idA;
            this.idB = idB;
        }

        public static Edge of(int idA, int idB) {
            return new Edge(idA, idB);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (idA != edge.idA) return false;
            return idB == edge.idB;
        }

        @Override
        public int hashCode() {
            int result = Math.min(idA, idB);
            result = 31 * result + Math.max(idA, idB);
            return result;
        }
    }

    public static class Graph {

        private final int size;
        private final Set<Edge> edges = new HashSet<>();
        private int EDGE_LENGTH = 6;

        public Graph(int size) {
            this.size = size;
        }

        public void addEdge(int first, int second) {
            edges.add(Edge.of(first, second));
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Set<Integer> visited = new HashSet<>();
            int[] minPaths = new int[size];
            Queue<Path> queue = new LinkedList<>();
            queue.add(Path.from(startId).withLength(0));
            findShortestReach(queue, visited, minPaths);
            int[] result = new int[size-1];
            System.arraycopy(minPaths, 0, result, 0, startId);
            System.arraycopy(minPaths, startId+1, result, startId, size-startId-1);
            return Arrays.stream(result)
                    .map((i) -> i == 0 ? -1 : i)
                    .toArray();
        }

        private void findShortestReach(Queue<Path> queue, Set<Integer> visited, int[] minPaths) {
            if (!queue.isEmpty()) {
                Path path = queue.poll();
                int length = path.getLength();
                Integer nodeId = path.getNode();
                if (!visited.contains(nodeId)) {
                    visited.add(nodeId);
                    if (minPaths[nodeId] > length * EDGE_LENGTH || minPaths[nodeId] == 0) {
                        minPaths[nodeId] = length * EDGE_LENGTH;
                    }
                    for (int i = 0; i < size; i++) {
                        if (edges.contains(Edge.of(nodeId, i))) {
                            queue.add(Path.from(i).withLength(length + 1));
                        }
                    }
                }
                findShortestReach(queue, visited, minPaths);
            }
        }

        private static class Path {
            private int node;
            private int length;

            private Path(int node) {
                this.node = node;
            }

            public static Path from(int node) {
                return new Path(node);
            }


            public Path withLength(int length) {
                this.length = length;
                return this;
            }

            public int getLength() {
                return length;
            }

            public int getNode() {
                return node;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(String.join(" ", args));

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            solution = distances;
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
