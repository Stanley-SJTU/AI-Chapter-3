package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractGraphSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.LinkedList;


public class BreadthFirstGraphSearch extends AbstractGraphSearch {
    public Collection<Node> initFrontier() {
        return new LinkedList<Node>();  //now it is a queue instead of a stack
    }
    // FIFO
    public Node chooseLeafNode (Collection<Node> frontier, Problem problem) {
        return ((LinkedList<Node>) frontier).poll();
    }
}
