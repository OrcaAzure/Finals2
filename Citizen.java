import java.util.Objects;

public class Citizen implements Comparable<Citizen> {
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String address;
    private int age;
    private String residencyType;
    private int districtNumber;
    private String gender;

    public Citizen(String lastName, String firstName, String emailAddress, String address, int age,
                   String residencyType, int districtNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.age = age;
        this.residencyType = residencyType;
        this.districtNumber = districtNumber;
        this.gender = gender;
    }

    // Getters
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getResidencyType() {
        return residencyType;
    }

    public int getDistrictNumber() {
        return districtNumber;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setResidencyType(String residencyType) {
        this.residencyType = residencyType;
    }

    public void setDistrictNumber(int districtNumber) {
        this.districtNumber = districtNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Citizen other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return age == citizen.age &&
                districtNumber == citizen.districtNumber &&
                Objects.equals(lastName, citizen.lastName) &&
                Objects.equals(firstName, citizen.firstName) &&
                Objects.equals(emailAddress, citizen.emailAddress) &&
                Objects.equals(address, citizen.address) &&
                Objects.equals(residencyType, citizen.residencyType) &&
                Objects.equals(gender, citizen.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, emailAddress, address, age, residencyType, districtNumber, gender);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", residencyType='" + residencyType + '\'' +
                ", districtNumber=" + districtNumber +
                ", gender='" + gender + '\'' +
                '}';
    }
}
