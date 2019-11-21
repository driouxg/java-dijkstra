import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DijkstraTest {

  @Test
  void get_shortest_path_from_A_to_E() {
    Graph graph = buildDefaultGraph();
    Map<String, Node> graphMap = buildGraphMap(graph);
    Node a = graphMap.get("A");
    Node b = graphMap.get("B");
    Node d = graphMap.get("D");
    Node e = graphMap.get("E");
    Dijkstra dijkstra = new Dijkstra();
    List<Node> shortestPathExpected = new ArrayList<>(Arrays.asList(a, b, d, e));

    List<Node> shortestPathResult = dijkstra.calcShortestPath(graph, a, e);

    assertThat(shortestPathResult).isEqualTo(shortestPathExpected);
  }

  @Test
  void get_shortest_path_from_A_to_F() {
    Graph graph = buildDefaultGraph();
    Map<String, Node> graphMap = buildGraphMap(graph);
    Node a = graphMap.get("A");
    Node b = graphMap.get("B");
    Node d = graphMap.get("D");
    Node f = graphMap.get("F");
    Dijkstra dijkstra = new Dijkstra();
    List<Node> shortestPathExpected = new ArrayList<>(Arrays.asList(a, b, d, f));

    List<Node> shortestPathResult = dijkstra.calcShortestPath(graph, a, f);

    assertThat(shortestPathResult).isEqualTo(shortestPathExpected);
  }

  private Map<String, Node> buildGraphMap(Graph graph) {
    Map<String, Node> map = new HashMap<>();
    for (Node n : graph.vertices) {
      map.put(n.name, n);
    }
    return map;
  }

  // The example graph used is found via: https://www.baeldung.com/java-dijkstra
  private Graph buildDefaultGraph() {
    final Node a = new Node("A");
    final Node b = new Node("B");
    final Node c = new Node("C");
    final Node d = new Node("D");
    final Node e = new Node("E");
    final Node f = new Node("F");

    a.addEdge(b, 10);
    a.addEdge(c, 15);

    b.addEdge(f, 15);
    b.addEdge(d, 12);

    c.addEdge(e, 10);

    d.addEdge(f, 1);
    d.addEdge(e, 2);

//    e.addEdge();  No directed edges out of E exist.

    f.addEdge(e, 5);

    Graph graph = new Graph();
    graph.addVertices(new ArrayList<Node>() {{
      add(a);
      add(b);
      add(c);
      add(d);
      add(e);
      add(f);
    }});

    return graph;
  }
}