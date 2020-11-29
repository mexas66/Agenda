package fr.greta.java.event.persistance;

import fr.greta.java.event.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventRepository {
    private static final String INSERT_REQUEST = "INSERT INTO event (_begin_date, _end_date, _title, _description) VALUES (?, ?, ?, ?)";
    private static final String SELECT_REQUEST= "SELECT id, _begin_date, _end_date, _title, _description FROM event";
    private static final String DELETE_REQUEST= "DELETE FROM event WHERE id = ?";

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public EventEntity create(EventEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement = conn.prepareStatement(INSERT_REQUEST, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, new Timestamp(entity.getBeginDate().getTime()));
            statement.setTimestamp(2, new Timestamp(entity.getEndDate().getTime()));
            statement.setString(3, entity.getTitle());
            statement.setString(4, entity.getDescription());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
            }
            return entity;
        }catch(SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_REQUEST, e);
        }finally{
            JdbcTool.close(resultSet,statement,conn);
        }
    }

    public List<EventEntity> findAllEvent() throws RepositoryException {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<EventEntity> entities = new ArrayList();

        try{
            conn = connectionFactory.create();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(SELECT_REQUEST);

            while(resultSet.next()){
                EventEntity entity = toEntity(resultSet);
                entities.add(entity);
            }

            return entities;

        }catch(SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_REQUEST, e);
        }
    }

    private EventEntity toEntity(ResultSet resultSet) throws SQLException {
        EventEntity entity = new EventEntity();

        entity.setBeginDate(new Date(resultSet.getTimestamp("_begin_date").getTime()));
        entity.setEndDate(new Date(resultSet.getTimestamp("_end_date").getTime()));
        entity.setId(resultSet.getInt("id"));
        entity.setTitle(resultSet.getString("_title"));
        entity.setDescription(resultSet.getString("_description"));

        return entity;

    }

    public void removeById(int id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement= conn.prepareStatement(DELETE_REQUEST);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requete: ",e);
        }finally{
            JdbcTool.close(resultSet,statement,conn);
        }
    }
}
