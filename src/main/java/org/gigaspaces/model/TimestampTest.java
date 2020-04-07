package main.java.org.gigaspaces.model;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class TimestampTest {
    protected static GigaSpace space;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        System.out.println("Setup started");

        space = new GigaSpaceConfigurer(new SpaceProxyConfigurer("demo")).create();

        Class.forName("com.gigaspaces.jdbc.Driver");

        List<Map<String, Object>> allResults = new LinkedList<>();
        Set<String> timeTypes = new HashSet<>();
        timeTypes.add("TIMESTAMP");
        timeTypes.add("TIME");
        timeTypes.add("DATE");

        try (Connection connection = createConnection(space)) {
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT TIMESTAMPADD(SQL_TSI_DAY,1,datetime0)\n" +
                        "FROM \"demo\".\"Calcs\" \"Calcs\" ";
//                        "SELECT \"Calcs\".\"str2\" AS \"str2\",\n" +
//                        "SUM(\"Calcs\".\"num3\") AS \"sum:num3:ok\"\n" +
//                        "FROM \"demo\".\"Calcs\" \"Calcs\"\n" +
//                        "WHERE (\"Calcs\".\"str2\" IS NULL)\n" +
//                        "GROUP BY \"str2\"";

//                        "SELECT TIMESTAMPADD(SQL_TSI_DAY,1,datetime0) AS \"TEMP(Test)(3060670302)(0)\"\n" +
//                        "FROM \"demo\".\"Calcs\" \"Calcs\" ";
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Map resultRow = new HashMap<>();
                        int cols = resultSet.getMetaData().getColumnCount();
                        for (int i=0 ; i < cols ; i++) {
                            if(timeTypes.contains(resultSet.getMetaData().getColumnTypeName(i+1))){
                                resultRow.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getTimestamp(i + 1,Calendar.getInstance(TimeZone.getTimeZone("UTC"))));
                            }else if (resultSet.getMetaData().getColumnClassName(i+1).contains("Long")){
                                resultRow.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getLong(i + 1));
                            }else if (resultSet.getMetaData().getColumnClassName(i+1).contains("Integer")){
                                resultRow.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getInt(i + 1));
                            }else{
                                resultRow.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getObject(i + 1));
                            }
                            System.out.println("Type: "+resultSet.getMetaData().getColumnTypeName(i+1));
                        }
                        allResults.add(resultRow);
                    }
                    System.out.println("*** results: "+ allResults.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static Connection createConnection(GigaSpace space) throws SQLException {
        return DriverManager.getConnection(toConnectionString(space.getName()));
    }


    private static String toConnectionString(String spaceName) {
        return "jdbc:insightedge:spaceName=" + spaceName;
    }

}
