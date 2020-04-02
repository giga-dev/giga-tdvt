package main.java.org.gigaspaces;

import com.gigaspaces.metadata.SpaceTypeDescriptor;
import com.gigaspaces.utils.CsvReader;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;


public class TableauMain {

    private final static String SPACE_NAME = "demo";
    private final static String CALCS_CSV_FILE = "/Calcs_headers.csv";
    private final static String STAPLES_CSV_FILE = "/Staples_utf8_headers.csv";

    public static void main(String[] args) {
        String spaceName = SPACE_NAME;

        String url = "jini://*/*/" + spaceName + "?groups=alon_group";

        GigaSpace gigaSpace = new GigaSpaceConfigurer(new UrlSpaceConfigurer(url)).create();
        try {
            Path calcPath = Paths.get(CALCS_CSV_FILE);
            Path staplesPath = Paths.get(STAPLES_CSV_FILE);
//            SpaceTypeDescriptorBuilder typeDescriptorBuilder = new CsvReader().readSchema(calcPath, "calc");
//            gigaSpace.getTypeManager().registerTypeDescriptor(typeDescriptorBuilder.create());
//            typeDescriptorBuilder = new CsvReader().readSchema(staplesPath, "staple");
//            gigaSpace.getTypeManager().registerTypeDescriptor(typeDescriptorBuilder.create());
            Class.forName("com.j_spaces.jdbc.driver.GDriver");
            Connection conn = DriverManager.getConnection("jdbc:gigaspaces:url:" + url);
//            conn.createStatement().execute("drop TABLE Staples");
//            conn.createStatement().execute("drop TABLE Calcs");
            conn.createStatement().execute("CREATE TABLE Staples\n" +
                    "(\n" +
                    "    Item_Count INTEGER,\n" +
                    "    Ship_Priority VARCHAR(14),\n" +
                    "    Order_Priority VARCHAR(15),\n" +
                    "    Order_Status VARCHAR(13),\n" +
                    "    Order_Quantity DOUBLE,\n" +
                    "    Sales_Total DOUBLE,\n" +
                    "    Discount DOUBLE,\n" +
                    "    Tax_Rate DOUBLE,\n" +
                    "    Ship_Mode VARCHAR(25),\n" +
                    "    Fill_Time DOUBLE,\n" +
                    "    Gross_Profit DOUBLE,\n" +
                    "    Price NUMERIC,\n" +
                    "    Ship_Handle_Cost NUMERIC,\n" +
                    "    Employee_Name VARCHAR(50),\n" +
                    "    Employee_Dept VARCHAR(4),\n" +
                    "    Manager_Name VARCHAR(255),\n" +
                    "    Employee_Yrs_Exp DOUBLE,\n" +
                    "    Employee_Salary NUMERIC,\n" +
                    "    Customer_Name VARCHAR(50),\n" +
                    "    Customer_State VARCHAR(50),\n" +
                    "    Call_Center_Region VARCHAR(25),\n" +
                    "    Customer_Balance DOUBLE,\n" +
                    "    Customer_Segment VARCHAR(25),\n" +
                    "    Prod_Type1 VARCHAR(50),\n" +
                    "    Prod_Type2 VARCHAR(50),\n" +
                    "    Prod_Type3 VARCHAR(50),\n" +
                    "    Prod_Type4 VARCHAR(50),\n" +
                    "    Product_Name VARCHAR(100),\n" +
                    "    Product_Container VARCHAR(25),\n" +
                    "    Ship_Promo VARCHAR(25),\n" +
                    "    Supplier_Name VARCHAR(25),\n" +
                    "    Supplier_Balance DOUBLE,\n" +
                    "    Supplier_Region VARCHAR(25),\n" +
                    "    Supplier_State VARCHAR(50),\n" +
                    "    Order_ID VARCHAR(10),\n" +
                    "    Order_Year INTEGER,\n" +
                    "    Order_Month INTEGER,\n" +
                    "    Order_Day INTEGER,\n" +
                    "    Order_Date TIMESTAMP,\n" +
                    "    Order_Quarter VARCHAR(2),\n" +
                    "    Product_Base_Margin DOUBLE,\n" +
                    "    Product_ID VARCHAR(5),\n" +
                    "    Receive_Time DOUBLE,\n" +
                    "    Received_Date TIMESTAMP,\n" +
                    "    Ship_Date TIMESTAMP,\n" +
                    "    Ship_Charge NUMERIC,\n" +
                    "    Total_Cycle_Time DOUBLE,\n" +
                    "    Product_In_Stock VARCHAR(3),\n" +
                    "    PID INTEGER,\n" +
                    "    Market_Segment VARCHAR(25)\n" +
                    ")");
            conn.createStatement().execute("CREATE TABLE Calcs\n" +
                    "(\n" +
                    "    key VARCHAR(255),\n" +
                    "    num0 DOUBLE,\n" +
                    "    num1 DOUBLE,\n" +
                    "    num2 DOUBLE,\n" +
                    "    num3 DOUBLE,\n" +
                    "    num4 DOUBLE,\n" +
                    "    str0 VARCHAR(255),\n" +
                    "    str1 VARCHAR(255),\n" +
                    "    str2 VARCHAR(255),\n" +
                    "    str3 VARCHAR(255),\n" +
                    "    int0 INTEGER,\n" +
                    "    int1 INTEGER,\n" +
                    "    int2 INTEGER,\n" +
                    "    int3 INTEGER,\n" +
                    "    bool0 BOOLEAN,\n" +
                    "    bool1 BOOLEAN,\n" +
                    "    bool2 BOOLEAN,\n" +
                    "    bool3 BOOLEAN,\n" +
                    "    date0 DATE,\n" +
                    "    date1 DATE,\n" +
                    "    date2 DATE,\n" +
                    "    date3 DATE,\n" +
                    "    time0 TIMESTAMP,\n" +
                    "    time1 TIME,\n" +
                    "    datetime0 TIMESTAMP,\n" +
                    "    datetime1 VARCHAR(255),\n" +
                    "    zzz VARCHAR(255)\n" +
                    ")");
            SpaceTypeDescriptor typeDescriptor = gigaSpace.getTypeManager().getTypeDescriptor("Calcs");
            new CsvReader().read(
                    calcPath, typeDescriptor).forEach(gigaSpace::write);
            typeDescriptor = gigaSpace.getTypeManager().getTypeDescriptor("Staples");
            new CsvReader().read(
                   staplesPath, typeDescriptor).forEach(gigaSpace::write);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
