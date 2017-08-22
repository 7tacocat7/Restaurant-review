package dao;
import dao.Sql2oRestaurantDao;
import enums.DiningStyle;
import models.Restaurant;
import models.Foodtype;
import models.Review;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;




import static enums.DiningStyle.CASUAL;
import static org.junit.Assert.*;

/**
 * Created by Guest on 8/22/17.
 */
public class sql2ORestaurantDaoTest {

    private Connection conn;
    private Sql2oRestaurantDao restaurantDao;
    private Sql2oFoodtypeDao foodtypeDao;
    private Sql2oReviewDao reviewDao;





    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
            conn.close();
    }

    @Test
    public void addingFoodSetsId() throws Exception {
            Restaurant testRestaurant = setupRestaurant();
            int testRestaurantId = testRestaurant.getId();
            restaurantDao.add(testRestaurant);
            assertNotEquals(testRestaurantId, testRestaurant.getId());
     }
    @Test
    public void addedRestaurantsAreReturnedFromGetAll() throws Exception {
        Restaurant restaurant = setupRestaurant();
        restaurantDao.add(restaurant);
        assertEquals(1,restaurantDao.getAll().size());
    }
    @Test
    public void noRestaurantsReturnsEmptyList() throws Exception {
        assertEquals(0, restaurantDao.getAll().size());
    }
    @Test
    public void deleteByIdDeletesCorrectRestaurant() throws Exception {
        Restaurant restaurant = setupRestaurant();
        restaurantDao.add(restaurant);
        restaurantDao.deleteById(restaurant.getId());
        assertEquals(0,restaurantDao.getAll().size());



    }
//
//    @Test
//    public void getAllFoodtypesForARestaurantReturnsFoodtypesCorrectly() throws Exception {
//    }

    //Helper class
public Restaurant setupRestaurant() {
    return new Restaurant("Robotaco", "639 se Morrision", "97232", "503-909-5647", "http://Robotaco.com", "robotaco@robotaco.com", "robotaco.jpg", DiningStyle.CASUAL);
}

    public Restaurant setupAltRestaurant(){
        return new Restaurant("Robotaco","639 se Morrision","97232","503-909-5647", DiningStyle.CASUAL);
    }
}