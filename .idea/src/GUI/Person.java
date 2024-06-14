package GUI;



import java.io.Serializable; //importing Serializable interface which is used to serialize objects in Java.
// Serialize means to convert an object into a byte stream so that it can be saved into a file or sent over the network.
// The byte stream can be saved as a file or sent over a network and reconstructed later into an object.
// The object can be reconstructed later from the byte stream.

public class Person implements Serializable {
    private String name;
    private String lastName;
    private String height;
    private String location;

    public Person(String name, String lastName, String height, String location) {
        this.name = name;
        this.lastName = lastName;
        this.height = height;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHeight() {
        return height;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Last Name: " + lastName + ", Height: " + height + ", Location: " + location;
    }
}
