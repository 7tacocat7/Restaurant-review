package dao;
import models.Review;


import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


public class Sql2oReviewDao implements ReviewDao {
        private final Sql2o sql2o;

        public Sql2oReviewDao(Sql2o sql2o){
            this.sql2o = sql2o;
        }
        @Override
        public void add(Review review){
            String sql = "INSERT INTO reviews (writtenby, rating, createddat, restaurantid) VALUES (:writtenby, :rating, :createddat, :restaurantid)";
            try (org.sql2o.Connection con =sql2o.open()) {
                int id = (int) con.createQuery(sql)
                        .bind(review)
                        .executeUpdate()
                        .getKey();
                review.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }

        }


}
