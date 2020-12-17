package example;

import com.syncleus.dann.graph.TraversableCloud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyEdge implements TraversableCloud {
    public MyNode sourceNode;
    public MyNode targetNode;

    public MyEdge(MyNode sourceNode, MyNode targetNode) {
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
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

    @Override
    public Collection getNodes() {
        return packNodes( sourceNode, targetNode);
    }
}
