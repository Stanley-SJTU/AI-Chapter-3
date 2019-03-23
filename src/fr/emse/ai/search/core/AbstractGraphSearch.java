package fr.emse.ai.search.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import static fr.emse.ai.search.simple.SimpleState.A;

public abstract class AbstractGraphSearch implements Search {
    Collection<Node> frontier;

    public Node solve(Problem problem) {
        // initialize fringe
        System.out.println("Solving...");
        Hashtable<Node, Object> explored_set =
                new Hashtable<Node, Object>();
        //Node node_root = new Node(A);
        //explored_set.put(node_root, A); // manually put root node in explored set
        frontier = initFrontier();
        frontier.addAll(expand(new Node(problem.getInitialState()), problem, explored_set));
        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseLeafNode(frontier, problem);
                System.out.println("Inspecting node " + node);
                if (problem.isGoal(node.getState())) {
                    System.out.println("Goal node reached => SUCCESS");
                    solution = node;
                    done = true;
                } else {
                    explored_set.put(node,node.getState());  // put the node in the explored set
                    System.out.println(node.getState());
                    frontier.addAll(expand(node, problem, explored_set));
                    System.out.printf("Expanding node, frontier is " + frontier);
                }
            }
        }
        return solution;
    }

    public Collection<Node> expand(Node node, Problem problem, Hashtable<Node, Object> ex_set) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            Node expand_node = new Node(next, node, action, problem.getStepCost(node.getState(), action, next));
            if (problem.isValid(next) && !ex_set.containsValue(expand_node.getState())) {
                nodes.add(expand_node);  // how to stop it from adding node A ?
            }
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier();

    public abstract Node chooseLeafNode(Collection<Node> frontier, Problem problem);

}
