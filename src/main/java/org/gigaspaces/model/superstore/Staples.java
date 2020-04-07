package org.gigaspaces.model.superstore;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceSequenceNumber;
import org.mockito.internal.verification.Times;

import java.sql.Timestamp;
import java.util.Date;

@SpaceClass
public class Staples {

    private String id;
    private Integer Item_Count;
    private Integer Ship_Priority;
    private String Order_Priority;
    private String Order_Status;
    private Integer Order_Quantity;
    private Double Sales_Total;
    private Double Discount;
    private Double Tax_Rate;
    private String Ship_Mode;
    private Integer Fill_Time;
    private Double Gross_Profit;
    private Double Price;
    private Double Ship_Handle_Cost;
    private String Employee_Name;
    private Integer Employee_Dept;
    private String Manager_Name;
    private Integer Employee_Yrs_Exp;
    private Double Employee_Salary;
    private String Customer_Name;
    private String Customer_State;
    private String Call_Center_Region;
    private Integer Customer_Balance;
    private String Customer_Segment;
    private String Prod_Type1;
    private String Prod_Type2;
    private String Prod_Type3;
    private String Prod_Type4;
    private String Product_Name;
    private String Product_Container;
    private String Ship_Promo;
    private String Supplier_Name;
    private Integer Supplier_Balance;
    private String Supplier_Region;
    private String Supplier_State;
    private Integer Order_ID;
    private Integer Order_Year;
    private Integer Order_Month;
    private Integer Order_Day;
    private Timestamp Order_Date;
    private String Order_Quarter;
    private Double Product_Base_Margin;
    private Integer Product_ID;
    private Integer Receive_Time;
    private Timestamp Received_Date;
    private Timestamp Ship_Date;
    private Double Ship_Charge;
    private Integer Total_Cycle_Time;
    private String Product_In_Stock;
    private Integer PID;
    private String Market_Segment;




    public Integer getItem_Count() {
        return Item_Count;
    }

    public void setItem_Count(Integer item_Count) {
        Item_Count = item_Count;
    }

    public Integer getShip_Priority() {
        return Ship_Priority;
    }

    public void setShip_Priority(Integer ship_Priority) {
        Ship_Priority = ship_Priority;
    }

    public String getOrder_Priority() {
        return Order_Priority;
    }

    public void setOrder_Priority(String order_Priority) {
        Order_Priority = order_Priority;
    }

    public String getOrder_Status() {
        return Order_Status;
    }

    public void setOrder_Status(String order_Status) {
        Order_Status = order_Status;
    }

    public Integer getOrder_Quantity() {
        return Order_Quantity;
    }

    public void setOrder_Quantity(Integer order_Quantity) {
        Order_Quantity = order_Quantity;
    }

    public Double getSales_Total() {
        return Sales_Total;
    }

    public void setSales_Total(Double sales_Total) {
        Sales_Total = sales_Total;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public Double getTax_Rate() {
        return Tax_Rate;
    }

    public void setTax_Rate(Double tax_Rate) {
        Tax_Rate = tax_Rate;
    }

    public String getShip_Mode() {
        return Ship_Mode;
    }

    public void setShip_Mode(String ship_Mode) {
        Ship_Mode = ship_Mode;
    }

    public Integer getFill_Time() {
        return Fill_Time;
    }

    public void setFill_Time(Integer fill_Time) {
        Fill_Time = fill_Time;
    }

    public Double getGross_Profit() {
        return Gross_Profit;
    }

    public void setGross_Profit(Double gross_Profit) {
        Gross_Profit = gross_Profit;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getShip_Handle_Cost() {
        return Ship_Handle_Cost;
    }

    public void setShip_Handle_Cost(Double ship_Handle_Cost) {
        Ship_Handle_Cost = ship_Handle_Cost;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public Integer getEmployee_Dept() {
        return Employee_Dept;
    }

    public void setEmployee_Dept(Integer employee_Dept) {
        Employee_Dept = employee_Dept;
    }

    public String getManager_Name() {
        return Manager_Name;
    }

    public void setManager_Name(String manager_Name) {
        Manager_Name = manager_Name;
    }

    public Integer getEmployee_Yrs_Exp() {
        return Employee_Yrs_Exp;
    }

    public void setEmployee_Yrs_Exp(Integer employee_Yrs_Exp) {
        Employee_Yrs_Exp = employee_Yrs_Exp;
    }

    public Double getEmployee_Salary() {
        return Employee_Salary;
    }

    public void setEmployee_Salary(Double employee_Salary) {
        Employee_Salary = employee_Salary;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_State() {
        return Customer_State;
    }

    public void setCustomer_State(String customer_State) {
        Customer_State = customer_State;
    }

    public String getCall_Center_Region() {
        return Call_Center_Region;
    }

    public void setCall_Center_Region(String call_Center_Region) {
        Call_Center_Region = call_Center_Region;
    }

    public Integer getCustomer_Balance() {
        return Customer_Balance;
    }

    public void setCustomer_Balance(Integer customer_Balance) {
        Customer_Balance = customer_Balance;
    }

    public String getCustomer_Segment() {
        return Customer_Segment;
    }

    public void setCustomer_Segment(String customer_Segment) {
        Customer_Segment = customer_Segment;
    }

    public String getProd_Type1() {
        return Prod_Type1;
    }

    public void setProd_Type1(String prod_Type1) {
        Prod_Type1 = prod_Type1;
    }

    public String getProd_Type2() {
        return Prod_Type2;
    }

    public void setProd_Type2(String prod_Type2) {
        Prod_Type2 = prod_Type2;
    }

    public String getProd_Type3() {
        return Prod_Type3;
    }

    public void setProd_Type3(String prod_Type3) {
        Prod_Type3 = prod_Type3;
    }

    public String getProd_Type4() {
        return Prod_Type4;
    }

    public void setProd_Type4(String prod_Type4) {
        Prod_Type4 = prod_Type4;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getProduct_Container() {
        return Product_Container;
    }

    public void setProduct_Container(String product_Container) {
        Product_Container = product_Container;
    }

    public String getShip_Promo() {
        return Ship_Promo;
    }

    public void setShip_Promo(String ship_Promo) {
        Ship_Promo = ship_Promo;
    }

    public String getSupplier_Name() {
        return Supplier_Name;
    }

    public void setSupplier_Name(String supplier_Name) {
        Supplier_Name = supplier_Name;
    }

    public Integer getSupplier_Balance() {
        return Supplier_Balance;
    }

    public void setSupplier_Balance(Integer supplier_Balance) {
        Supplier_Balance = supplier_Balance;
    }

    public String getSupplier_Region() {
        return Supplier_Region;
    }

    public void setSupplier_Region(String supplier_Region) {
        Supplier_Region = supplier_Region;
    }

    public String getSupplier_State() {
        return Supplier_State;
    }

    public void setSupplier_State(String supplier_State) {
        Supplier_State = supplier_State;
    }

    public Integer getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(Integer order_ID) {
        Order_ID = order_ID;
    }

    public Integer getOrder_Year() {
        return Order_Year;
    }

    public void setOrder_Year(Integer order_Year) {
        Order_Year = order_Year;
    }

    public Integer getOrder_Month() {
        return Order_Month;
    }

    public void setOrder_Month(Integer order_Month) {
        Order_Month = order_Month;
    }

    public Integer getOrder_Day() {
        return Order_Day;
    }

    public void setOrder_Day(Integer order_Day) {
        Order_Day = order_Day;
    }

    public Timestamp getOrder_Date() {
        return Order_Date;
    }

    public void setOrder_Date(Timestamp order_Date) {
        Order_Date = order_Date;
    }

    public String getOrder_Quarter() {
        return Order_Quarter;
    }

    public void setOrder_Quarter(String order_Quarter) {
        Order_Quarter = order_Quarter;
    }

    public Double getProduct_Base_Margin() {
        return Product_Base_Margin;
    }

    public void setProduct_Base_Margin(Double product_Base_Margin) {
        Product_Base_Margin = product_Base_Margin;
    }

    public Integer getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        Product_ID = product_ID;
    }

    public Integer getReceive_Time() {
        return Receive_Time;
    }

    public void setReceive_Time(Integer receive_Time) {
        Receive_Time = receive_Time;
    }

    public Timestamp getReceived_Date() {
        return Received_Date;
    }

    public void setReceived_Date(Timestamp received_Date) {
        Received_Date = received_Date;
    }

    public Timestamp getShip_Date() {
        return Ship_Date;
    }

    public void setShip_Date(Timestamp ship_Date) {
        Ship_Date = ship_Date;
    }

    public Double getShip_Charge() {
        return Ship_Charge;
    }

    public void setShip_Charge(Double ship_Charge) {
        Ship_Charge = ship_Charge;
    }

    public Integer getTotal_Cycle_Time() {
        return Total_Cycle_Time;
    }

    public void setTotal_Cycle_Time(Integer total_Cycle_Time) {
        Total_Cycle_Time = total_Cycle_Time;
    }

    public String getProduct_In_Stock() {
        return Product_In_Stock;
    }

    public void setProduct_In_Stock(String product_In_Stock) {
        Product_In_Stock = product_In_Stock;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getMarket_Segment() {
        return Market_Segment;
    }

    public void setMarket_Segment(String market_Segment) {
        Market_Segment = market_Segment;
    }

    @SpaceId(autoGenerate = true)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
