import java.util.HashMap;
import java.util.Map;

public class Node {

  public String name;
  public Integer distance;
  public Map<Node, Integer> edges = new HashMap<>();

  public Node(String name) {
    this.name = name;
  }

  public void addEdge(Node edge, Integer weight) {
    edges.put(edge, weight);
  }

  @Override
  public String toString() {
    return String.format("{ name: %s   distance: %d }", name, distance);
  }
}
