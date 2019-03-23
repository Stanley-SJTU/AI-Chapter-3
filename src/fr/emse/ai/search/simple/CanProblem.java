package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

import static fr.emse.ai.search.simple.CanState.canCapacityA;
import static fr.emse.ai.search.simple.CanState.canCapacityB;

public class CanProblem implements Problem {

    CanState initialState = new CanState(12,3);
    CanState finalState = new CanState(0,5);


    @Override
    public Object getInitialState() {
        return initialState;
    }

    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    public boolean isValid(Object state) {
        CanState currentState = (CanState) state;
        int canA = currentState.getCanA();
        int canB = currentState.getCanB();

        return canA >= 0 && canB >= 0 && canA <= canCapacityA && canB <= canCapacityB;
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        int canA = ((CanState) state).getCanA();
        int canB = ((CanState) state).getCanB();

            actions.add("Fill B until full");
            actions.add("Fill B with A");
            actions.add("Empty B");

            actions.add("Empty A");
            actions.add("Fill A until full");
            actions.add("Fill A with B");

        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {

        CanState currentState = (CanState) state;
        int canA = currentState.getCanA();
        int canB = currentState.getCanB();
        int remainCanA = canCapacityA - currentState.getCanA();
        int remainCanB = canCapacityB - currentState.getCanB();

        if (action.equals("Fill B until full"))
            return new CanState(canA - remainCanB, canCapacityB);
        if (action.equals("Fill B with A"))
            return new CanState(0, canB + canA);
        if (action.equals("Empty B"))
            return new CanState(canA, 0);
        if (action.equals("Empty A"))
            return new CanState(0, canB);
        if (action.equals("Fill A until full"))
            return new CanState(canCapacityA, canB - remainCanA);
        if (action.equals("Fill A with B"))
            return new CanState(canA + canB, 0);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
