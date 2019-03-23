package fr.emse.ai.search.simple;

import static fr.emse.ai.search.simple.Position.LEFT;

enum Position {RIGHT, LEFT}

public class MissionariesCannibalsState {

    private int cannibalLeft;
    private int missionaryLeft;
    private int cannibalRight;
    private int missionaryRight;
    private Position boat;

    public MissionariesCannibalsState(int cannibalLeft, int missionaryLeft, Position boat,
                                 int cannibalRight, int missionaryRight) {
        this.cannibalLeft = cannibalLeft;
        this.missionaryLeft = missionaryLeft;
        this.boat = boat;
        this.cannibalRight = cannibalRight;
        this.missionaryRight = missionaryRight;
    }

    public int getCannibalLeft() {
        return cannibalLeft;
    }

    public void setCannibalLeft(int cannibalLeft) {
        this.cannibalLeft = cannibalLeft;
    }

    public int getMissionaryLeft() {
        return missionaryLeft;
    }

    public void setMissionaryLeft(int missionaryLeft) {
        this.missionaryLeft = missionaryLeft;
    }

    public int getCannibalRight() {
        return cannibalRight;
    }

    public void setCannibalRight(int cannibalRight) {
        this.cannibalRight = cannibalRight;
    }

    public int getMissionaryRight() {
        return missionaryRight;
    }

    public void setMissionaryRight(int missionaryRight) {
        this.missionaryRight = missionaryRight;
    }

    public Position getBoat() {
        return boat;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MissionariesCannibalsState)) {
            return false;
        }
        MissionariesCannibalsState s = (MissionariesCannibalsState) obj;
        return (s.cannibalLeft == cannibalLeft && s.missionaryLeft == missionaryLeft
                && s.boat == boat && s.cannibalRight == cannibalRight
                && s.missionaryRight == missionaryRight);
    }

    public String toString() {
        if (boat == LEFT) {
            return "(" + cannibalLeft + "," + missionaryLeft + ",L,"
                    + cannibalRight + "," + missionaryRight + ")";
        } else {
            return "(" + cannibalLeft + "," + missionaryLeft + ",R,"
                    + cannibalRight + "," + missionaryRight + ")";
        }
    }
}
