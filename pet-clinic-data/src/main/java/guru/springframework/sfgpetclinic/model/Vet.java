package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {
    public Vet() {

    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    private Set<Specialty> specialties;

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
