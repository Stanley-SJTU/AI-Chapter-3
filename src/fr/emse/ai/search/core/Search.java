package fr.emse.ai.search.core;

import java.util.Collection;
import java.util.Hashtable;

public interface Search {
    public Node solve(Problem problem);
    public Collection<Node> expand(Node node, Problem problem, Hashtable<Node, Object> ex_set); //Hashtable<Node, Object> added
}
