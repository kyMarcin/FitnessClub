package sample.database;

/**
 * Created by Marcin on 17.02.2018.
 */
public class QueryProvider {

    private QueryProvider() {

    }

    public static String getInsertQuery(String tableName, int noParameters) {
        StringBuilder resultQuery = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
        for (int i = 0; i < noParameters - 1; ++i) {
            resultQuery.append("?,");
        }
        resultQuery.append("?)");
        return resultQuery.toString();
    }

    public static String getSelectByQuery(String tableName, String columnName) {
        String resultQuery = "SELECT * FROM " + tableName + " WHERE "+ columnName + "= ?";
        return resultQuery;
    }

    public static String getSelectAllQuery(String tableName) {
        String resultQuery = "SELECT * FROM " + tableName;
        return resultQuery;
    }

    public static String getDeleteAllQuery(String tableName) {
        String resultQuery = "DELETE FROM " + tableName;
        return resultQuery;
    }

}
