package dao;

import models.Foodtype;
import models.Restaurant;
import org.sql2o.Sql2o;

import java.util.List;

/**
 * Created by Guest on 8/22/17.
 */
public class Sql2oFoodtypeDao implements FoodtypeDao{

    private final Sql2o sql2o  ;

    public Sql2oFoodtypeDao(Sql2o sql2o)    {
        this.sql2o = sql2o;
    }


}
