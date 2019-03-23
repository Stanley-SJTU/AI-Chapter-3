package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class SimpleTest {

    public static void main(String[] args) {
        CanProblem p1 = new CanProblem();
        System.out.println("Solution to problem : ");
        System.out.println(new BreadthFirstGraphSearch().solve(p1).pathToString());
    }
}
