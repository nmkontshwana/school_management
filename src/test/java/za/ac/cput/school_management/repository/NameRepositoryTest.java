/**
 * NameRepositoryTest.java
 * Test class for NameRepository.java
 * Author: Sonwabile Gxoyiya (219267189)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.factory.NameFactory;
import za.ac.cput.school_management.repository.NameRepository;

import static org.junit.jupiter.api.Assertions.*;

class NameRepositoryTest {

    public static NameRepository repository = NameRepository.getRepository();
    public static Name name = NameFactory.build("Sonwabile","OK","Gxoyiya");
    public static Name name1 = NameFactory.build("Siyabulela","","Gxoyiya");
    public static Name name2 = NameFactory.build("Sonwabile","","Lolo");

    @Test
    void create() {
        Name createdName = repository.save(name);
        assertNotNull(createdName);
        System.out.println(createdName.toString());
        System.out.println("In the Repository: " + repository.getAll());
    }

    @Test
    void read() {
        Name createdName = repository.save(name);
        Name createdName1 = repository.save(name1);
        Name createdName2 = repository.save(name2);
        Name readName = repository.read(new Name.NameId(createdName2.getFistName(),createdName2.getLastName()));
        assertNotNull(readName);
        System.out.println("In Repository: " + repository.getAll());
        System.out.println("Read value: " + readName);
    }



    @Test
    void delete() {
        Name createdName = repository.save(name);
        Name createdName1 = repository.save(name1);
        System.out.println("In repository: " + repository.getAll());
        Name deleteName = repository.delete(name1);
        System.out.println("In the Repository: " + repository.getAll());
    }


}