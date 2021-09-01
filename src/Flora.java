public class Flora {

    protected String latinName;
    protected String latvianName;
    protected String type;
    protected int floraID;

    public Flora() {
    }

    public Flora(String latinName, String latvianName, String type, int floraID) {
        this.latinName = latinName;
        this.latvianName = latvianName;
        this.type = type;
        this.floraID = floraID;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getLatvianName() {
        return latvianName;
    }

    public void setLatvianName(String latvianName) {
        this.latvianName = latvianName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloraID() {
        return floraID;
    }

    public void setFloraID(int floraID) {
        this.floraID = floraID;
    }

    @Override
    public String toString() {
        return "Flora{" +
                "latinName='" + latinName + '\'' +
                ", latvianName='" + latvianName + '\'' +
                ", type='" + type + '\'' +
                ", floraID=" + floraID +
                '}';
    }
}
