package au.com.seasoft.ham;

import com.syncleus.dann.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericGraph implements Graph {

    private Set<InteropNode> nodes = new HashSet<InteropNode>();
    private Set<InteropEdge> edges = new HashSet<InteropEdge>();

    private GenericGraph() {
    }

    /**
     * Intended to be used from Clojure. Need to return a GenericGraph rather than a Graph, b/c will need to addNode
     * and addEdge.
     */
    public static GenericGraph create() {
        return new GenericGraph();
    }

    public void addNode(InteropNode node) {
        nodes.add( node);
    }

    public void addEdge(InteropEdge edge) {
        edges.add( edge);
    }

    @Override
    public Set getNodes() {
        return nodes;
    }

    @Override
    public Set getEdges() {
        return edges;
    }

    /*
     * The other end of all the edges associated with the given node
     */
    @Override
    public List getAdjacentNodes(Object obj) {
        List<InteropNode> result = new ArrayList<InteropNode>();
        InteropNode node = (InteropNode)obj;
        for(final InteropEdge edge : edges){
            if(edge.getSourceNode().getId() == node.getId()) {
                result.add( edge.getTargetNode());
            }
            if(edge.getTargetNode().getId() == node.getId()) {
                result.add( edge.getSourceNode());
            }
        }
        return result;
    }

    /*
     * Edge where given is either the source or the target
     */
    @Override
    public Set getAdjacentEdges(Object obj) {
        Set<InteropEdge> result = new HashSet<InteropEdge>();
        InteropNode node = (InteropNode)obj;
        for(final InteropEdge edge : edges){
            if(edge.getSourceNode().getId() == node.getId()) {
                result.add( edge);
            }
            if(edge.getTargetNode().getId() == node.getId()) {
                result.add( edge);
            }
        }
        return result;
    }

    /*
     * Go thru all the edges where the given node is the source node, and grab the target node.
     * Can traverse to the target node.
     * Not used by anything other than tests.
     */
    @Override
    public List getTraversableNodes(Object obj)
    {
        List<InteropNode> result = new ArrayList<InteropNode>();
        InteropNode node = (InteropNode)obj;
        for(final InteropEdge edge : edges){
            if(edge.getSourceNode().getId() == node.getId()) {
                result.add( edge.getTargetNode());
            }
        }
        return result;
    }

    /*
     * All the edges that the given node leads in.
     * Not used so not worth having, and there are no tests.
     */
    @Override
    public Set getTraversableEdges(Object obj) {
        Set<InteropEdge> result = new HashSet<InteropEdge>();
        InteropNode node = (InteropNode)obj;
        for(final InteropEdge edge : edges){
            if(edge.getSourceNode().getId() == node.getId()) {
                result.add( edge);
            }
        }
        return result;
    }
}
