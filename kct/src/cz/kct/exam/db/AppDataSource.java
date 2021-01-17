package cz.kct.exam.db;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AppDataSource {

    /** Connection pool WebSphere serveru */
    protected static javax.sql.DataSource pool;

    /** Odkaz do resources ve web.xml, kde je to namapováno na JNDI z WebSphere serveru */
    private final String DS_NAME = "java:comp/env/jdbc/KCTE_DS";

    /** KOnstruktor */
    public AppDataSource() {
        if (pool == null) {
            inicialize();
        }
    }

    /** Inicializace db poolu */
    private synchronized void inicialize() {
        Context ctx = getNamingContext();
        pool = lookupPoolFromServer(ctx, DS_NAME);
    }

    /**Z9skání poolu z kontextu ap serveru */
    private DataSource lookupPoolFromServer(Context ctx, String dsName) {
        DataSource dsPool = null;
        if (ctx != null) {
            try {
                dsPool = (DataSource) ctx.lookup(dsName);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return dsPool;
    }

    /**
     * Vrácení connection do poolu
     * 
     * @param conn vracená connection
     */
    public void freeConnection(java.sql.Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    /**
     * Získání connecion z poolu
     * 
     * @return connection z poolu
     */
    public java.sql.Connection getConnection() {
        try {
            return pool.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Vrací NamingContext App serveru pro získání DataSource
     * 
     * @return Context
     */
    private final Context getNamingContext() {
        final String CONTEXT_FACTORY_IBM = "com.ibm.websphere.naming.WsnInitialContextFactory";
        java.util.Properties parms = new java.util.Properties();
        parms.setProperty(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_FACTORY_IBM);

        /** Create the Initial Naming Context */
        try {
            return new InitialContext(parms);
        } catch (NamingException e) {
            System.err.println(e);
        }

        return null;
    }

}
