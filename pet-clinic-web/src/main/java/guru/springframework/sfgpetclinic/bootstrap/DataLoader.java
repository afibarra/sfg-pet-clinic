package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Armando");
        owner1.setLastName("Flores");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1234567890");
        Pet armandosPet = new Pet();
        armandosPet.setPetType(savedDogPetType);
        armandosPet.setOwner(owner1);
        armandosPet.setBirthDate(LocalDate.of(1976, 3, 7));
        armandosPet.setName("Firulais");
        owner1.getPets().add(armandosPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alan");
        owner2.setLastName("Flores");
        owner2.setAddress("124 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1234567890");
        Pet alansPet = new Pet();
        alansPet.setPetType(savedDogPetType);
        alansPet.setOwner(owner2);
        alansPet.setBirthDate(LocalDate.of(2007, 9, 3));
        alansPet.setName("Firulais");
        owner2.getPets().add(alansPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jeff");
        vet2.setLastName("Knife");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
