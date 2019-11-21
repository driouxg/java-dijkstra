import java.util.ArrayList;
import java.util.List;

public class Graph {

  public List<Node> vertices = new ArrayList<>();

  public void addVertex(Node vertex) {
    vertices.add(vertex);
  }

  public void addVertices(List<Node> vertices) {
    this.vertices.addAll(vertices);
  }
}
