package cz.kct.exam.db.favorites;

import cz.kct.exam.db.AppDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoritesFacade extends AppDataSource {

    private PreparedStatement pstm = null;
    private CallableStatement cstm = null;
    private Connection conn = null;
    private ResultSet resultSet = null;

    public final List<FavoriteEntity> getFavorites() throws SQLException, Exception  {
        List<FavoriteEntity> entities = new ArrayList<FavoriteEntity>();
        try {
            pstm = null;
            conn = pool.getConnection();
            pstm = conn.prepareStatement(sqlSelect());
            setResultSet(pstm.executeQuery());

            while (getResultSet().next()) {
                entities.add(parseResultSet(getResultSet()));
            }
            if (pstm != null) {
                pstm.close();
            }

        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            throw e;
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            throw e;
        } finally {
            freeConnection(conn);
        }

        return entities;
    }

    public final FavoriteEntity getFavorite(String favoriteId) throws SQLException, Exception  {
        FavoriteEntity favorite = null;
        try {
            pstm = null;
            conn = pool.getConnection();
            pstm = conn.prepareStatement(sqlSelectById());
            int i = 1;
            pstm.setString(i++, favoriteId);
            
            setResultSet(pstm.executeQuery());

            if (getResultSet().next()) {
                favorite = parseResultSet(getResultSet());
            }
            if (pstm != null) {
                pstm.close();
            }

        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            throw e;
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            throw e;
        } finally {
            freeConnection(conn);
        }

        return favorite;
    }
    
    public final void addFavorite(FavoriteEntity favorite) throws SQLException, Exception {
        try {
            cstm = null;
            conn = pool.getConnection();
            cstm = conn.prepareCall(sqlPut());
            int i = 1;
            cstm.setString(i++, favorite.getFavoriteId());
            cstm.setString(i++, favorite.getName());
            cstm.setString(i++, favorite.getDescription());
            cstm.setString(i++, favorite.getOrigin());
            cstm.setInt(i++, favorite.getImageWidth());
            cstm.setInt(i++, favorite.getImageHeight());
            cstm.setString(i++, favorite.getImageUrl());
            cstm.execute();
            if (cstm != null) {
                cstm.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        } finally {
            freeConnection(conn);
        }
    }
    
    public final void deleteFavorite(String favoriteId) throws SQLException, Exception {
        try {
            cstm = null;
            conn = pool.getConnection();
            cstm = conn.prepareCall(sqlDelete());
            int i = 1;
            cstm.setString(i++, favoriteId);
            cstm.execute();
            if (cstm != null) {
                cstm.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        } finally {
            freeConnection(conn);
        }
    }
    
    /**
     * Parsuje result set na entitu
     * 
     * @param rs ResultSet
     * 
     * @return FavoriteEntity
     * @throws SQLException
     */
    private final FavoriteEntity parseResultSet(ResultSet rs) throws SQLException {
        FavoriteEntity ent = new FavoriteEntity();
        ent.setFavoriteId(parseRsString(rs, "id"));
        ent.setName(parseRsString(rs, "name"));
        ent.setDescription(parseRsString(rs, "description"));
        ent.setOrigin(parseRsString(rs, "origin"));
        ent.setImageWidth(rs.getInt("width"));
        ent.setImageHeight(rs.getInt("height"));
        ent.setImageUrl(parseRsString(rs, "url"));

        return ent;
    }

    private final String sqlSelect() {
        StringBuilder sql = new StringBuilder();
        sql.append("select id, name, description, origin, width, height, url ");
        sql.append("from tFavorites");
        
        return sql.toString();
    }
    
    private final String sqlSelectById() {
        StringBuilder sql = new StringBuilder();
        sql.append(sqlSelect());
        sql.append(" where id=?");
        
        return sql.toString();
    }
    
    private final String sqlPut() {
        StringBuilder sql = new StringBuilder();
        sql.append("call pFavorites.setFavorite(?,?,?,?,?,?,?)");
        
        return sql.toString();
    }
    
    private final String sqlDelete() {
        StringBuilder sql = new StringBuilder();
        sql.append("call pFavorites.delFavorite(?)");
        
        return sql.toString();
    }

    /**
     * Zkontroluje jestli String, ktery vraci ResultSet neni null
     * 
     * @param rs    ResultSet s daty
     * @param field element
     * @return "" kdyz ResultSet vrati null, nebo String z ResultSetu
     * 
     * @throws SQLException
     */
    private String parseRsString(ResultSet rs, String field) throws SQLException {
        if (rs.getString(field) != null) {
            return rs.getString(field);
        } else {
            return "";
        }
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
