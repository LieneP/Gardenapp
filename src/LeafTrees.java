public class LeafTrees extends Flora {

    private String soil;
    private String light;
    private int height;

    public LeafTrees() {
    }

    public LeafTrees(String latinName, String latvianName, String type, int floraID, String soil, String light, int height) {
        super(latvianName, latinName, type, floraID);
        this.soil = soil;
        this.light = light;
        this.height = height;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "LeafTrees{" +
                "soil='" + soil + '\'' +
                ", light='" + light + '\'' +
                ", height=" + height +
                '}';
    }
}
