package org.gigaspaces;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.gigaspaces.model.superstore.Calcs;
import org.gigaspaces.model.superstore.Staples;
import org.apache.commons.io.IOUtils;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.CannotFindSpaceException;
import org.openspaces.core.space.SpaceProxyConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;


/**
 * Created by Vitalii Zinchenko
 */
public class FeederMain {

    private static final String Calcs_file = "/Calcs_headers.csv";
    private static final String Staples_file = "/Staples_utf8_headers.csv";

//    private static final String Calcs_file = "C:\\Users\\intreviews\\IdeaProjects\\giga-tdvt\\src\\main\\resources\\Calcs_headers.csv";
//    private static final String Staples_file = "C:\\Users\\intreviews\\IdeaProjects\\giga-tdvt\\src\\main\\resources\\Staples_utf8_headers.csv";

    @Parameter(names={"--userName"})
    private String userName;

    @Parameter(names={"--passWord"})
    private String passWord;

    @Parameter(names={"--space-url"})
    private String spaceUrl;

    @Parameter(names={"--lookup-group"})
    private String lookupGroup;

    public static void main(String ... argv) throws IOException, URISyntaxException {
        FeederMain main = new FeederMain();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(argv);
        main.run();
        System.out.println("Completed!");
    }

    public void run() throws IOException, URISyntaxException {
        GigaSpace space = createSpace();
        loadCsv(space, Staples_file, this::convertStaples);
        loadCsv(space, Calcs_file, this::convertOrders);
    }

    private void loadCsv(GigaSpace space, String fileName, Function<String[], Object> converter) throws URISyntaxException, IOException {
        IOUtils.readLines(new FileInputStream(fileName), "UTF-8").stream()
                .skip(1)
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1))
                .forEach(line -> write(space, line, converter));
    }

    private void write(GigaSpace space, String[] line, Function<String[], Object> converter) {
        try {
            Object o = converter.apply(line);

            space.write(o);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Calcs convertOrders(String[] line) {
        Calcs calcs = new Calcs();

        int i = 0;
        calcs.setKey(parseString(line[i++]));
        calcs.setNum0(parseDouble(line[i++]));
        calcs.setNum1(parseDouble(line[i++]));
        calcs.setNum2(parseDouble(line[i++]));
        calcs.setNum3(parseDouble(line[i++]));
        calcs.setNum4(parseDouble(line[i++]));
        calcs.setStr0(parseString(line[i++]));
        calcs.setStr1(parseString(line[i++]));
        calcs.setStr2(parseString(line[i++]));
        calcs.setStr3(parseString(line[i++]));
        calcs.setInt0(parseInteger(line[i++]));
        calcs.setInt1(parseInteger(line[i++]));
        calcs.setInt2(parseInteger(line[i++]));
        calcs.setInt3(parseInteger(line[i++]));
        calcs.setBool0(parseBoolean(parseString(line[i++])));
        calcs.setBool1(parseBoolean(parseString(line[i++])));
        calcs.setBool2(parseBoolean(parseString(line[i++])));
        calcs.setBool3(parseBoolean(parseString(line[i++])));
        calcs.setDate0(parseDate(line[i++]));
        calcs.setDate1(parseDate(line[i++]));
        calcs.setDate2(parseDate(line[i++]));
        calcs.setDate3(parseDate(line[i++]));
        calcs.setTime0(parseDateTime(line[i++])); //???
        calcs.setTime1(parseTime(line[i++])); //???
        calcs.setDatetime0(parseDateTime(line[i++]));
        calcs.setDatetime1(parseString(line[i++]));
        calcs.setZzz(parseString(line[i++])); // ???




        return calcs;
    }

    private Staples convertStaples(String[] line) {
        Staples staples = new Staples();

        int i = 0;
        staples.setItem_count(Integer.parseInt(line[i++]));
        staples.setShip_priority(Integer.parseInt(line[i++]));
        staples.setOrder_priority(line[i++]);
        staples.setOrder_status(line[i++]);
        staples.setOrder_quantity(Integer.parseInt(line[i++]));
        staples.setSales_total(Double.parseDouble(line[i++]));
        staples.setDiscount(Double.parseDouble(line[i++]));
        staples.setTax_rate(Double.parseDouble(line[i++]));
        staples.setShip_mode(line[i++]);
        staples.setFill_time(Integer.parseInt(line[i++]));
        staples.setGross_profit(Double.parseDouble(line[i++]));
        staples.setPrice(Double.parseDouble(line[i++]));
        staples.setShip_handle_cost(Double.parseDouble(line[i++]));
        staples.setEmployee_name(parseString(line[i++]));
        staples.setEmployee_dept(Integer.parseInt(line[i++]));
        staples.setManager_name(parseString(line[i++]));
        staples.setEmployee_yrs_exp(Integer.parseInt(line[i++]));
        staples.setEmployee_salary(Double.parseDouble(line[i++]));
        staples.setCustomer_name(line[i++]);
        staples.setCustomer_state(line[i++]);
        staples.setCall_center_region(line[i++]);
        staples.setCustomer_balance(Integer.parseInt(line[i++]));
        staples.setCustomer_segment(line[i++]);
        staples.setProd_type1(line[i++]);
        staples.setProd_type2(line[i++]);
        staples.setProd_type3(line[i++]);
        staples.setProd_type4(line[i++]);
        //       staples.setProduct_Name(line[i++]);// Max
        staples.setProduct_name(parseProductName(line[i++]));
        staples.setProduct_container(line[i++]);
        staples.setShip_promo(line[i++]);
        staples.setSupplier_name(line[i++]);
        staples.setSupplier_balance(Integer.parseInt(line[i++]));
        staples.setSupplier_region(line[i++]);
        staples.setSupplier_state(line[i++]);
        staples.setOrder_id(Integer.parseInt(line[i++]));
        staples.setOrder_year(Integer.parseInt(line[i++]));
        staples.setOrder_month(Integer.parseInt(line[i++]));
        staples.setOrder_day(Integer.parseInt(line[i++]));
        staples.setOrder_date(Timestamp.valueOf(line[i++]));
        staples.setOrder_quarter(line[i++]);
        staples.setProduct_base_margin(Double.parseDouble(line[i++]));
        staples.setProduct_id(Integer.parseInt(line[i++]));
        staples.setReceive_time(Integer.parseInt(line[i++]));
        staples.setReceived_date(parseDateTime(line[i++]));
        staples.setShip_date(parseDateTime(line[i++]));
        staples.setShip_charge(Double.parseDouble(line[i++]));
        staples.setTotal_cycle_time(Integer.parseInt(line[i++]));
        staples.setProduct_in_stock(line[i++]);
        staples.setPid(Integer.parseInt(line[i++]));
        staples.setMarket_segment(line[i++]);

        return staples;
    }

    private Double parseDouble(String S){
        if(!validateString(S))
            return null;
        return Double.parseDouble(S);
    }

    private Integer parseInteger(String S){
        if(!validateString(S))
            return null;
        return Integer.parseInt(S);
    }

    private Time parseTime(String S){
        if(!validateString(S))
            return null;
        return Time.valueOf(unquote(S));
    }

    private Boolean parseBoolean(String s){
        if(!validateString(s))
            return null;
        if(s.equals("1"))
            return true;
        if(s.equals("0"))
            return false;
        return Boolean.parseBoolean(s);
    }

    private String parseProductName(String S){
        if(!validateString(S))
            return null;
        return unquote(S);

    }

    private Timestamp parseDateTime(String S) {
        if(!validateString(S))
            return null;
        return Timestamp.valueOf(unquote(S));
    }

    private Date parseDate(String S) {
        if(!validateString(S))
            return null;
        return Date.valueOf(unquote(S));
    }

    private String parseString(String S) {
        if(!validateString(S))
            return null;
        String S1 = unquote(S);
        return S1.length() == 0 ? null : S1;
    }

    private String unquote (String S) {
        return S.replace("\"","");
    }

    private boolean validateString(String s){
        if (s == null || s.isEmpty())
            return false;
        return true;
    }

    private GigaSpace createSpace() {

        if(spaceUrl == null)
            spaceUrl = "jini://*/*/demo?groups=xap-15.5.0";
        UrlSpaceConfigurer configurer = new UrlSpaceConfigurer(spaceUrl);
        if(lookupGroup != null) {
            configurer.lookupGroups(lookupGroup);
        }
        if(userName != null && passWord != null)
            configurer.credentials(userName, passWord);
        return new GigaSpaceConfigurer(configurer).gigaSpace();

//        {
//            System.out.printf("Connecting to space demo");
//            try {
//                SpaceProxyConfigurer demo = new SpaceProxyConfigurer("demo");
////                demo.lookupGroups("a");
//                return new GigaSpaceConfigurer(demo).create();
//            } catch (CannotFindSpaceException e) {
//                System.err.println("Failed to find space: " + e.getMessage());
//                throw e;
//            }
//        }
    }
}
