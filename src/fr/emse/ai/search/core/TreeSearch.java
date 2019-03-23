package fr.emse.ai.search.core;

import java.util.Collection;


public interface TreeSearch {
    public Node solve(Problem problem);
    public Collection<Node> expand(Node node, Problem problem);
}
