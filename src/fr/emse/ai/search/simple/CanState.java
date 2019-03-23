package fr.emse.ai.search.simple;

public class CanState {

    private int canA;
    private int canB;

    public final static int canCapacityA = 15;
    public final static int canCapacityB = 5;

    public CanState(int canA, int canB) {
        this.canA = canA;
        this.canB = canB;
    }

    public int getCanA() {
        return canA;
    }

    public int getCanB() {
        return canB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CanState canState = (CanState) o;

        if (canA != canState.canA) return false;
        return canB == canState.canB;
    }

    @Override
    public String toString() {
        return "CanState{" +
                "canA=" + canA +
                ", canB=" + canB +
                '}';
    }
}
