public class Flora {

    protected int floraID;
    protected String latinName;
    protected String latvianName;
    protected String type;

    public Flora() {
    }

    public Flora(int floraID, String latinName, String latvianName, String type) {
        this.floraID = floraID;
        this.latinName = latinName;
        this.latvianName = latvianName;
        this.type = type;
    }

    public int getFloraID() {
        return floraID;
    }

    public void setFloraID(int floraID) {
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

    @Override
    public String toString() {
        return "Flora{" +
                "floraID=" + floraID +
                ", latinName='" + latinName + '\'' +
                ", latvianName='" + latvianName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
