public class Conifers extends Flora {

    private String soil;
    private String light;
    private int height;

    public Conifers() {
    }

    public Conifers(int floraID, String latinName, String latvianName, String type, String soil, String light, int height) {
        super(floraID, latinName, latvianName, type);
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
        return "Conifers{" +
                "soil='" + soil + '\'' +
                ", light='" + light + '\'' +
                ", height=" + height +
                ", floraID=" + floraID +
                ", latinName='" + latinName + '\'' +
                ", latvianName='" + latvianName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
