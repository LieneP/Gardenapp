public class Flora {

    protected String englishName;
    protected String latinName;
    protected String type;
    protected int floraID;

    public Flora() {
    }

    public Flora(String englishName, String latinName, String type, int floraID) {
        this.englishName = englishName;
        this.latinName = latinName;
        this.type = type;
        this.floraID = floraID;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
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
                "englishName='" + englishName + '\'' +
                ", latinName='" + latinName + '\'' +
                ", type='" + type + '\'' +
                ", floraID=" + floraID +
                '}';
    }
}
