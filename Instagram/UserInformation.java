package javaFx.FXML.Instagram;

public class UserInformation {
    private String name;
    private String lastName;
    private long phNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) throws IGException {
        if(name == null || name.isEmpty()){
            throw new IGException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IGException {
        if(lastName == null || lastName.isEmpty()){
            throw new IGException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    public long getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(long phNumber) throws IGException {
        String numberToString = Long.toString(phNumber);
        if(phNumber < 0){
            throw new IGException("Phone Number cannot be negative");
        }
        if(numberToString.length() > 10){
            throw new IGException("Phone Number cannot exceed 10 characters");
        }
        this.phNumber = phNumber;
    }
}
