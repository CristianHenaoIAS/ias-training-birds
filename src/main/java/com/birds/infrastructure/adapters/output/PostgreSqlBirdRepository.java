package com.birds.infrastructure.adapters.output;

import com.birds.application.domain.Bird;
import com.birds.application.domain.valueObjects.BirdId;
import com.birds.application.ports.output.BirdRepository;
import com.birds.infrastructure.logSystem.Log;
import com.birds.infrastructure.models.BirdDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgreSqlBirdRepository implements BirdRepository {
    private DataSource dataSource;

    public PostgreSqlBirdRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Bird bird) {
        String sql = "insert into tbl_birds (common_name, scientific_name, zone_name, confirmed_quantity) values (? ,? , ?, ?)";
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, bird.getCommonName().getValue());
            preparedStatement.setString(2, bird.getScientificName().getValue());
            preparedStatement.setString(3, bird.getZoneName().getValue());
            preparedStatement.setInt(4, bird.getConfirmedQuantity().getValue());

            preparedStatement.execute();

        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error query in database");
            log.logger();
            throw new RuntimeException("Error query in database", exception);
        }
    }

    @Override
    public Optional<Bird> get(BirdId birdId) {
        String sql = "select * from tbl_birds where id = ?";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, birdId.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                Bird bird = birdDAO.toDomain();

                return Optional.of(bird);
            }else{
                return Optional.empty();
            }

        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error query in database");
            log.logger();
            throw new RuntimeException("Error query in database", exception);
        }
    }

    @Override
    public void update(Bird bird) {
        String sql = "update tbl_birds set common_name = ?, scientific_name = ?, zone_name = ?," +
                    " confirmed_quantity = ? where id = ?";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, bird.getCommonName().getValue());
            preparedStatement.setString(2, bird.getScientificName().getValue());
            preparedStatement.setString(3, bird.getZoneName().getValue());
            preparedStatement.setInt(4, bird.getConfirmedQuantity().getValue());
            preparedStatement.setLong(5, bird.getBirdId().getValue());

            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error query in database");
            log.logger();
            throw new RuntimeException("Error query in database", exception);
        }
    }

    @Override
    public boolean delete(BirdId birdId) {
        String sql = "Delete from tbl_birds Where id = ?";
        try (Connection connection = dataSource.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

             preparedStatement.setLong(1, birdId.getValue());

             Boolean result = preparedStatement.execute();

             return  result;

        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error query in database");
            log.logger();
            throw new RuntimeException("Error query in database", exception);
        }
    }
}
