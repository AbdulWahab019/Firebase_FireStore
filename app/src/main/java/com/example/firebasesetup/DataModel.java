package com.example.firebasesetup;

@SuppressWarnings("NullableProblems")
class DataModel{
    private String name, fatherName, email, institute;

    DataModel(String name, String fatherName, String email, String institute) {
        this.name = name;
        this.fatherName = fatherName;
        this.email = email;
        this.institute = institute;
    }

    String getName() { return name; }
    String getFatherName() { return fatherName; }
    String getEmail() { return email; }
    String getInstitute() { return institute; }

    @Override
    public String toString(){
        return "Name: "+name+
                "\nFather Name: "+fatherName+
                "\nEmail: "+email+
                "\nInstitute: "+institute;
    }
}
