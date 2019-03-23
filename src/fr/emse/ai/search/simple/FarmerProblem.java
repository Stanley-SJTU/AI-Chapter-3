package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Problem;
import java.util.ArrayList;
import java.util.Collection;

public class FarmerProblem implements Problem {
    
    FarmerState initialState = new FarmerState(1,1,1,1,0,0,0,0);

    @Override
    public Object getInitialState() { return initialState; }

    public boolean isGoal(Object state) {
        FarmerState currentState = (FarmerState) state;

        return currentState.getFarmerLeft() == 0 && currentState.getGoatLeft() == 0
                && currentState.getCabbageLeft() == 0 && currentState.getWolfLeft() == 0;
    }

    public boolean isValid(Object state) {
        FarmerState currentState = (FarmerState) state;
        int farmerLeft = currentState.getFarmerLeft();
        int cabbageLeft = currentState.getCabbageLeft();
        int goatLeft = currentState.getGoatLeft();
        int wolfLeft = currentState.getWolfLeft();
        int farmerRight = currentState.getFarmerRight();
        int cabbageRight = currentState.getCabbageRight();
        int goatRight = currentState.getGoatRight();
        int wolfRight = currentState.getWolfRight();

        return farmerLeft >= 0 && cabbageLeft >= 0 && goatLeft >= 0 && wolfLeft >= 0
                && farmerRight >= 0 && cabbageRight >= 0 && goatRight >= 0 && wolfRight >= 0
                && (!(farmerLeft == 0 && goatLeft == 1 && cabbageLeft == 1)) && (!(farmerLeft == 0 && goatLeft == 1 && wolfLeft == 1))
                && (!(farmerRight == 0 && goatRight == 1 && cabbageRight == 1)) && (!(farmerRight == 0 && goatRight == 1 && wolfRight == 1));
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        int farmer = ((FarmerState) state).getFarmerLeft();

        if (farmer == 1) {
            actions.add("Cabbage and Farmer left to right");
            actions.add("Goat and Farmer left to right");
            actions.add("Wolf and Farmer left to right");
        } else {
            actions.add("Farmer right to left");
            actions.add("Cabbage and Farmer right to left");
            actions.add("Goat and Farmer right to left");
            actions.add("Wolf and Farmer right to left");
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {

        FarmerState currentState = (FarmerState) state;
        int farmerLeft = currentState.getFarmerLeft();
        int cabbageLeft = currentState.getCabbageLeft();
        int goatLeft = currentState.getGoatLeft();
        int wolfLeft = currentState.getWolfLeft();
        int farmerRight = currentState.getFarmerRight();
        int cabbageRight = currentState.getCabbageRight();
        int goatRight = currentState.getGoatRight();
        int wolfRight = currentState.getWolfRight();
        if (action.equals("Cabbage and Farmer left to right"))
            return new FarmerState(farmerLeft - 1, cabbageLeft - 1, wolfLeft, goatLeft,
                    farmerRight + 1, cabbageRight + 1, wolfRight, goatRight);
        if (action.equals("Goat and Farmer left to right"))
            return new FarmerState(farmerLeft - 1, cabbageLeft, wolfLeft, goatLeft - 1,
                    farmerRight + 1, cabbageRight, wolfRight, goatRight + 1);
        if (action.equals("Wolf and Farmer left to right"))
            return new FarmerState(farmerLeft - 1, cabbageLeft , wolfLeft - 1, goatLeft,
                    farmerRight + 1, cabbageRight, wolfRight + 1, goatRight);
        if (action.equals("Farmer right to left"))
            return new FarmerState(farmerLeft + 1, cabbageLeft, wolfLeft, goatLeft,
                    farmerRight - 1, cabbageRight, wolfRight, goatRight);
        if (action.equals("Cabbage and Farmer right to left"))
            return new FarmerState(farmerLeft + 1, cabbageLeft + 1, wolfLeft, goatLeft,
                    farmerRight - 1, cabbageRight - 1, wolfRight, goatRight);
        if (action.equals("Goat and Farmer right to left"))
            return new FarmerState(farmerLeft + 1, cabbageLeft, wolfLeft, goatLeft + 1,
                    farmerRight - 1, cabbageRight, wolfRight, goatRight - 1);
        if (action.equals("Wolf and Farmer right to left"))
            return new FarmerState(farmerLeft + 1, cabbageLeft, wolfLeft + 1, goatLeft,
                    farmerRight - 1, cabbageRight, wolfRight - 1, goatRight);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
