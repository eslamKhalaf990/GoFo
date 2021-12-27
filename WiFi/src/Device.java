public class Device {
    String name;
    String type;

    Device(String name, String type) {
        this.name = name;
        this.type = type;
    }

    Device() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getName();
    }
}