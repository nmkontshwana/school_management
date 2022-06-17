/**
 * CityRepository.java
 * class for CityRepository
 * Author: Zintle Zothe(216130565)
 * Date: 14 June 2022
 */
package za.ac.cput.school_management.repository;

import za.ac.cput.school_management.domain.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository implements ICityRepository {

    private static CityRepository repository = null;
    private List<City> cityDB = null;

    private CityRepository() {
        cityDB = new ArrayList<>();
    }

    public static CityRepository getRepository() {
        if (repository == null) {
            repository = new CityRepository();
        }
        return repository;
    }


    @Override
    public City save(City city) {
        Optional<City> read = read(city.getId());
        if(read.isPresent()){
            delete(read.get());
        }
        this.cityDB.add(city);
        return city;
    }


    @Override
    public Optional<City> read(String id){
        return this.cityDB.stream()
                .filter(c-> c.getId().equalsIgnoreCase(id))
                .findFirst();
    }

   @Override
   public void delete(City city){
       this.cityDB.remove(city);
   }


    @Override
    public List<City> getAll () {
        return this.cityDB;
    }
}