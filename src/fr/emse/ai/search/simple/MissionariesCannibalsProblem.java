package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Problem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static fr.emse.ai.search.simple.Position.LEFT;
import static fr.emse.ai.search.simple.Position.RIGHT;


public class MissionariesCannibalsProblem implements Problem {

    MissionariesCannibalsState initialState = new MissionariesCannibalsState(3,3,LEFT,0,0);
    MissionariesCannibalsState finalState = new MissionariesCannibalsState(0,0,RIGHT,3,3);

    @Override
    public Object getInitialState() { return initialState; }


    public boolean isGoal(Object state) {
        MissionariesCannibalsState currentState = (MissionariesCannibalsState)state;

        if (currentState.getMissionaryLeft() == 0 && currentState.getCannibalLeft() == 0) {
            return true;
        }
        return false;
    }

    public boolean isValid(Object state) {
        MissionariesCannibalsState currentState = (MissionariesCannibalsState)state;

        if (currentState.getMissionaryLeft() >= 0 && currentState.getMissionaryRight() >= 0
                && currentState.getCannibalLeft() >= 0 && currentState.getCannibalRight() >= 0
                && (currentState.getMissionaryLeft() == 0 || currentState.getMissionaryLeft() >= currentState.getCannibalLeft())
                && (currentState.getMissionaryRight() == 0 || currentState.getMissionaryRight() >= currentState.getCannibalRight())) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        Position p = ((MissionariesCannibalsState) state).getBoat();

        if (p.equals(LEFT)) {
            actions.add("Two missionaries cross left to right");
            actions.add("Two cannibals cross left to right");
            actions.add("One missionary and one cannibal cross left to right");
            actions.add("One missionary crosses left to right");
            actions.add("One cannibal crosses left to right");
        } else {
            actions.add("One missionary crosses right to left");
            actions.add("One cannibal crosses right to left");
            actions.add("One missionary and one cannibal cross right to left");
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {

        int cannibalLeft = ((MissionariesCannibalsState) state).getCannibalLeft();
        int missionaryLeft = ((MissionariesCannibalsState) state).getMissionaryLeft();
        int cannibalRight = ((MissionariesCannibalsState) state).getCannibalRight();
        int missionaryRight = ((MissionariesCannibalsState) state).getMissionaryRight();

        if (action.equals("Two missionaries cross left to right"))
            return new MissionariesCannibalsState(cannibalLeft, missionaryLeft - 2, Position.RIGHT,
                    cannibalRight, missionaryRight + 2);
        if (action.equals("Two cannibals cross left to right"))
            return new MissionariesCannibalsState(cannibalLeft - 2, missionaryLeft, Position.RIGHT,
                cannibalRight + 2, missionaryRight);
        if (action.equals("One missionary and one cannibal cross left to right"))
            return new MissionariesCannibalsState(cannibalLeft - 1, missionaryLeft - 1, Position.RIGHT,
                cannibalRight + 1, missionaryRight + 1);
        if (action.equals("One missionary crosses left to right"))
            return new MissionariesCannibalsState(cannibalLeft, missionaryLeft - 1, Position.RIGHT,
                cannibalRight, missionaryRight + 1);
        if (action.equals("One cannibal crosses left to right"))
            return new MissionariesCannibalsState(cannibalLeft - 1, missionaryLeft, Position.RIGHT,
                cannibalRight + 1, missionaryRight);
        if (action.equals("One missionary crosses right to left"))
            return new MissionariesCannibalsState(cannibalLeft, missionaryLeft + 1, LEFT,
                cannibalRight, missionaryRight - 1);
        if (action.equals("One cannibal crosses right to left"))
            return new MissionariesCannibalsState(cannibalLeft + 1, missionaryLeft, LEFT,
                cannibalRight - 1, missionaryRight);
        if (action.equals("One missionary and one cannibal cross right to left"))
            return new MissionariesCannibalsState(cannibalLeft + 1, missionaryLeft + 1, LEFT,
                    cannibalRight - 1, missionaryRight - 1);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

}
