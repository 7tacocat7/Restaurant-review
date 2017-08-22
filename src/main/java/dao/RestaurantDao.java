package dao;

import models.Foodtype;
import models.Restaurant;

import java.util.List;

/**
 * Created by Guest on 8/22/17.
 */
public interface RestaurantDao {
    //create
    void add(Restaurant restaurant);
//    void addRestaurantToFoodtype(Restaurant restaurant, Foodtype foodtype);

//    //read
    List<Restaurant> getAll();
//    List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId); //D - we will implement this soon.
    Restaurant findById(int id);

//    //update
//    void update(int id, String name, String address, String zipcode, String phone, String website, String email, String image);
//    //delete
    void deleteById(int id);
}
