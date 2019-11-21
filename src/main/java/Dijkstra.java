import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

  private PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
  private Map<Node, Node> predecessor = new HashMap<>();

  public List<Node> calcShortestPath(Graph graph, Node start, Node end) {
    initialize(graph, start);

    while (!pq.isEmpty()) {
      Node u = pq.remove();
      for (Node v : u.edges.keySet()) {
        relax(u, v, 0);
      }
    }

    List<Node> shortestPath = new ArrayList<>();

    Node parentPointer = end;
    shortestPath.add(parentPointer);
    while (predecessor.get(parentPointer) != null) {
      shortestPath.add(predecessor.get(parentPointer));
      parentPointer = predecessor.get(parentPointer);
    }

    Collections.reverse(shortestPath);
    return shortestPath;
  }

  private void relax(Node u, Node v, Integer w) {
    if (v.distance > u.distance + u.edges.get(v) && u.distance != Integer.MAX_VALUE) {
      v.distance = u.distance + u.edges.get(v);
      predecessor.put(v, u);
    }
  }

  private void initialize(Graph graph, Node start) {
    predecessor.put(start, null);

    for (Node n : graph.vertices) {
      n.distance = Integer.MAX_VALUE;
      pq.add(n);
    }

    start.distance = 0;
  }
}
