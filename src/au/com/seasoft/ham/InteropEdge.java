package au.com.seasoft.ham;

import com.syncleus.dann.graph.TraversableCloud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InteropEdge implements TraversableCloud {
    private InteropNode sourceNode;
    private InteropNode targetNode;

    public InteropEdge(InteropNode sourceNode, InteropNode targetNode) {
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
    }

    @Override
    public String toString()
    {
        return "[" + this.sourceNode.getId() + ", " + this.targetNode.getId() + "]";
    }

    @Override
    public boolean equals(final Object compareObj)
    {
        if( !(compareObj instanceof InteropEdge) )
            return false;
        final InteropEdge compareWith = (InteropEdge) compareObj;
        return (compareWith.sourceNode.getId() == this.sourceNode.getId() &&
                compareWith.targetNode.getId() == this.targetNode.getId());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((sourceNode == null) ? 0 : sourceNode.hashCode());
        result = prime * result + ((targetNode == null) ? 0 : targetNode.hashCode());
        return result;
    }

    @Override
    public boolean isTraversable(Object node) {
        throw new Error( "Don't need isTraversable");
    }

    @Override
    public Collection getTraversableNodes(Object node) {
        throw new Error( "Don't need getTraversableNodes");
    }

    @Override
    public TraversableCloud disconnect(Object node) {
        throw new Error( "Don't need disconnect 1");
    }

    @Override
    public TraversableCloud disconnect(List node) {
        throw new Error( "Don't need disconnect 2");
    }

    private static <N> List<N> packNodes(final N leftNode, final N rightNode)
    {
        final List<N> pack = new ArrayList<N>();
        pack.add(leftNode);
        pack.add(rightNode);
        return pack;
    }

    public InteropNode getSourceNode() {
        return sourceNode;
    }

    public InteropNode getTargetNode() {
        return targetNode;
    }

    @Override
    public Collection getNodes() {
        return packNodes( sourceNode, targetNode);
    }
}
