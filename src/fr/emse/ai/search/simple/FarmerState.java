package fr.emse.ai.search.simple;

public class FarmerState {
    
    private int farmerLeft;
    private int cabbageLeft;
    private int wolfLeft;
    private int beanLeft;
    private int farmerRight;
    private int cabbageRight;
    private int wolfRight;
    private int beanRight;

    public int getFarmerLeft() { return farmerLeft; }

    public void setFarmerLeft(int farmerLeft) { this.farmerLeft = farmerLeft; }

    public int getCabbageLeft() { return cabbageLeft; }

    public void setCabbageLeft(int cabbageLeft) { this.cabbageLeft = cabbageLeft; }

    public int getWolfLeft() { return wolfLeft; }

    public void setWolfLeft(int wolfLeft) { this.wolfLeft = wolfLeft; }

    public int getBeanLeft() { return beanLeft; }

    public void setBeanLeft(int beanLeft) { this.beanLeft = beanLeft; }

    public int getFarmerRight() { return farmerRight; }

    public void setFarmerRight(int farmerRight) { this.farmerRight = farmerRight; }

    public int getCabbageRight() { return cabbageRight; }

    public void setCabbageRight(int cabbageRight) { this.cabbageRight = cabbageRight; }

    public int getWolfRight() { return wolfRight; }

    public void setWolfRight(int wolfRight) { this.wolfRight = wolfRight; }

    public int getBeanRight() { return beanRight; }

    public void setBeanRight(int beanRight) { this.beanRight = beanRight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // equals() function generated by Intellij default
        if (o == null || getClass() != o.getClass()) return false;

        FarmerState that = (FarmerState) o;

        if (farmerLeft != that.farmerLeft) return false;
        if (cabbageLeft != that.cabbageLeft) return false;
        if (wolfLeft != that.wolfLeft) return false;
        if (beanLeft != that.beanLeft) return false;
        if (farmerRight != that.farmerRight) return false;
        if (cabbageRight != that.cabbageRight) return false;
        if (wolfRight != that.wolfRight) return false;
        return beanRight == that.beanRight;
    }

    @Override
    public String toString() {
        return "FarmerState{" +
                "farmerLeft=" + farmerLeft +
                ", cabbageLeft=" + cabbageLeft +
                ", wolfLeft=" + wolfLeft +
                ", beanLeft=" + beanLeft +
                ", farmerRight=" + farmerRight +
                ", cabbageRight=" + cabbageRight +
                ", wolfRight=" + wolfRight +
                ", beanRight=" + beanRight +
                '}';
    }
}
