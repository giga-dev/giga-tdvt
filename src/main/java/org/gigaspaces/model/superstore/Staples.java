package org.gigaspaces.model.superstore;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.sql.Timestamp;

@SpaceClass
public class Staples {

    private String id;
    private Integer Item_count;
    private Integer Ship_priority;
    private String Order_priority;
    private String Order_status;
    private Integer Order_quantity;
    private Double Sales_total;
    private Double Discount;
    private Double Tax_rate;
    private String Ship_mode;
    private Integer Fill_time;
    private Double Gross_profit;
    private Double Price;
    private Double Ship_handle_cost;
    private String Employee_name;
    private Integer Employee_dept;
    private String Manager_name;
    private Integer Employee_yrs_exp;
    private Double Employee_salary;
    private String Customer_name;
    private String Customer_state;
    private String Call_center_region;
    private Integer Customer_balance;
    private String Customer_segment;
    private String Prod_type1;
    private String Prod_type2;
    private String Prod_type3;
    private String Prod_type4;
    private String Product_name;
    private String Product_container;
    private String Ship_promo;
    private String Supplier_name;
    private Integer Supplier_balance;
    private String Supplier_region;
    private String Supplier_state;
    private Integer Order_id;
    private Integer Order_year;
    private Integer Order_month;
    private Integer Order_day;
    private Timestamp Order_date;
    private String Order_quarter;
    private Double Product_base_margin;
    private Integer Product_id;
    private Integer Receive_time;
    private Timestamp Received_date;
    private Timestamp Ship_date;
    private Double Ship_charge;
    private Integer Total_cycle_time;
    private String Product_in_stock;
    private Integer Pid;
    private String Market_segment;




    public Integer getItem_count() {
        return Item_count;
    }

    public void setItem_count(Integer item_count) {
        Item_count = item_count;
    }

    public Integer getShip_priority() {
        return Ship_priority;
    }

    public void setShip_priority(Integer ship_priority) {
        Ship_priority = ship_priority;
    }

    public String getOrder_priority() {
        return Order_priority;
    }

    public void setOrder_priority(String order_priority) {
        Order_priority = order_priority;
    }

    public String getOrder_status() {
        return Order_status;
    }

    public void setOrder_status(String order_status) {
        Order_status = order_status;
    }

    public Integer getOrder_quantity() {
        return Order_quantity;
    }

    public void setOrder_quantity(Integer order_quantity) {
        Order_quantity = order_quantity;
    }

    public Double getSales_total() {
        return Sales_total;
    }

    public void setSales_total(Double sales_total) {
        Sales_total = sales_total;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public Double getTax_rate() {
        return Tax_rate;
    }

    public void setTax_rate(Double tax_rate) {
        Tax_rate = tax_rate;
    }

    public String getShip_mode() {
        return Ship_mode;
    }

    public void setShip_mode(String ship_mode) {
        Ship_mode = ship_mode;
    }

    public Integer getFill_time() {
        return Fill_time;
    }

    public void setFill_time(Integer fill_time) {
        Fill_time = fill_time;
    }

    public Double getGross_profit() {
        return Gross_profit;
    }

    public void setGross_profit(Double gross_profit) {
        Gross_profit = gross_profit;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getShip_handle_cost() {
        return Ship_handle_cost;
    }

    public void setShip_handle_cost(Double ship_handle_cost) {
        Ship_handle_cost = ship_handle_cost;
    }

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }

    public Integer getEmployee_dept() {
        return Employee_dept;
    }

    public void setEmployee_dept(Integer employee_dept) {
        Employee_dept = employee_dept;
    }

    public String getManager_name() {
        return Manager_name;
    }

    public void setManager_name(String manager_name) {
        Manager_name = manager_name;
    }

    public Integer getEmployee_yrs_exp() {
        return Employee_yrs_exp;
    }

    public void setEmployee_yrs_exp(Integer employee_yrs_exp) {
        Employee_yrs_exp = employee_yrs_exp;
    }

    public Double getEmployee_salary() {
        return Employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        Employee_salary = employee_salary;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getCustomer_state() {
        return Customer_state;
    }

    public void setCustomer_state(String customer_state) {
        Customer_state = customer_state;
    }

    public String getCall_center_region() {
        return Call_center_region;
    }

    public void setCall_center_region(String call_center_region) {
        Call_center_region = call_center_region;
    }

    public Integer getCustomer_balance() {
        return Customer_balance;
    }

    public void setCustomer_balance(Integer customer_balance) {
        Customer_balance = customer_balance;
    }

    public String getCustomer_segment() {
        return Customer_segment;
    }

    public void setCustomer_segment(String customer_segment) {
        Customer_segment = customer_segment;
    }

    public String getProd_type1() {
        return Prod_type1;
    }

    public void setProd_type1(String prod_type1) {
        Prod_type1 = prod_type1;
    }

    public String getProd_type2() {
        return Prod_type2;
    }

    public void setProd_type2(String prod_type2) {
        Prod_type2 = prod_type2;
    }

    public String getProd_type3() {
        return Prod_type3;
    }

    public void setProd_type3(String prod_type3) {
        Prod_type3 = prod_type3;
    }

    public String getProd_type4() {
        return Prod_type4;
    }

    public void setProd_type4(String prod_type4) {
        Prod_type4 = prod_type4;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_container() {
        return Product_container;
    }

    public void setProduct_container(String product_container) {
        Product_container = product_container;
    }

    public String getShip_promo() {
        return Ship_promo;
    }

    public void setShip_promo(String ship_promo) {
        Ship_promo = ship_promo;
    }

    public String getSupplier_name() {
        return Supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        Supplier_name = supplier_name;
    }

    public Integer getSupplier_balance() {
        return Supplier_balance;
    }

    public void setSupplier_balance(Integer supplier_balance) {
        Supplier_balance = supplier_balance;
    }

    public String getSupplier_region() {
        return Supplier_region;
    }

    public void setSupplier_region(String supplier_region) {
        Supplier_region = supplier_region;
    }

    public String getSupplier_state() {
        return Supplier_state;
    }

    public void setSupplier_state(String supplier_state) {
        Supplier_state = supplier_state;
    }

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }

    public Integer getOrder_year() {
        return Order_year;
    }

    public void setOrder_year(Integer order_year) {
        Order_year = order_year;
    }

    public Integer getOrder_month() {
        return Order_month;
    }

    public void setOrder_month(Integer order_month) {
        Order_month = order_month;
    }

    public Integer getOrder_day() {
        return Order_day;
    }

    public void setOrder_day(Integer order_day) {
        Order_day = order_day;
    }

    public Timestamp getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        Order_date = order_date;
    }

    public String getOrder_quarter() {
        return Order_quarter;
    }

    public void setOrder_quarter(String order_quarter) {
        Order_quarter = order_quarter;
    }

    public Double getProduct_base_margin() {
        return Product_base_margin;
    }

    public void setProduct_base_margin(Double product_base_margin) {
        Product_base_margin = product_base_margin;
    }

    public Integer getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(Integer product_id) {
        Product_id = product_id;
    }

    public Integer getReceive_time() {
        return Receive_time;
    }

    public void setReceive_time(Integer receive_time) {
        Receive_time = receive_time;
    }

    public Timestamp getReceived_date() {
        return Received_date;
    }

    public void setReceived_date(Timestamp received_date) {
        Received_date = received_date;
    }

    public Timestamp getShip_date() {
        return Ship_date;
    }

    public void setShip_date(Timestamp ship_date) {
        Ship_date = ship_date;
    }

    public Double getShip_charge() {
        return Ship_charge;
    }

    public void setShip_charge(Double ship_charge) {
        Ship_charge = ship_charge;
    }

    public Integer getTotal_cycle_time() {
        return Total_cycle_time;
    }

    public void setTotal_cycle_time(Integer total_cycle_time) {
        Total_cycle_time = total_cycle_time;
    }

    public String getProduct_in_stock() {
        return Product_in_stock;
    }

    public void setProduct_in_stock(String product_in_stock) {
        Product_in_stock = product_in_stock;
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        this.Pid = pid;
    }

    public String getMarket_segment() {
        return Market_segment;
    }

    public void setMarket_segment(String market_segment) {
        Market_segment = market_segment;
    }

    @SpaceId(autoGenerate = true)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
