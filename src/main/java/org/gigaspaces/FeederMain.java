package main.java.org.gigaspaces;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.apache.commons.io.IOUtils;
import  main.java.org.gigaspaces.model.superstore.*;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Function;


/**
 * Created by Vitalii Zinchenko
 */
public class FeederMain {

    private static final String Calcs_file = "/Calcs_headers.csv";
    private static final String Staples_file = "/Staples_utf8_headers.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-DD");
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm:ss");

//    @Parameter(names={"--userName"}, required = true)
//    private String userName;
//
//    @Parameter(names={"--passWord"}, required = true)
//    private String passWord;

    @Parameter(names={"--space-url"}, required = true)
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

 //  public static void main(String ... argv){

//      // LocalDate S = new LocalDate.parse("2004-04-01");
//       CharSequence S = "2004-04-01";
//        Orders o = new Orders();
//       o.setDate0(LocalDate.parse(S));
//       // o.setTime1(Time.valueOf(S));
//        System.out.println(o.getDate0());
//   }

    public void run() throws IOException, URISyntaxException {
        GigaSpace space = createSpace();
     //   GigaSpace space = null;
        loadCsv(space, Staples_file, this::convertStaples);
        loadCsv(space, Calcs_file, this::convertOrders);
       // int thecount = space.count(null);
       // System.out.println("the count:" + thecount);
    }

    private void loadCsv(GigaSpace space, String fileName, Function<String[], Object> converter) throws URISyntaxException, IOException {
        IOUtils.readLines(FeederMain.class.getResourceAsStream(fileName), "UTF-8").stream()
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
           // System.out.println(e.getMessage());
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
        calcs.setInt0(parseMyInt(line[i++]));
        calcs.setInt1(parseMyInt(line[i++]));
        calcs.setInt2(Integer.parseInt(line[i++]));
        calcs.setInt3(Integer.parseInt(line[i++]));
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
        calcs.setDatetime1(parseDateTime(line[i++]));
        calcs.setZzz(parseString(line[i++])); // ???




        return calcs;
    }

    private Staples convertStaples(String[] line) {
        Staples staples = new Staples();

        int i = 0;
        staples.setItem_Count(Integer.parseInt(line[i++]));
        staples.setShip_Priority(Integer.parseInt(line[i++]));
        staples.setOrder_Priority(line[i++]);
        staples.setOrder_Status(line[i++]);
        staples.setOrder_Quantity(Integer.parseInt(line[i++]));
        staples.setSales_Total(Double.parseDouble(line[i++]));
        staples.setDiscount(Double.parseDouble(line[i++]));
        staples.setTax_Rate(Double.parseDouble(line[i++]));
        staples.setShip_Mode(line[i++]);
        staples.setFill_Time(Integer.parseInt(line[i++]));
        staples.setGross_Profit(Double.parseDouble(line[i++]));
        staples.setPrice(Double.parseDouble(line[i++]));
        staples.setShip_Handle_Cost(Double.parseDouble(line[i++]));
        staples.setEmployee_Name(parseString(line[i++]));
        staples.setEmployee_Dept(Integer.parseInt(line[i++]));
        staples.setManager_Name(parseString(line[i++]));
        staples.setEmployee_Yrs_Exp(Integer.parseInt(line[i++]));
        staples.setEmployee_Salary(Double.parseDouble(line[i++]));
        staples.setCustomer_Name(line[i++]);
        staples.setCustomer_State(line[i++]);
        staples.setCall_Center_Region(line[i++]);
        staples.setCustomer_Balance(Integer.parseInt(line[i++]));
        staples.setCustomer_Segment(line[i++]);
        staples.setProd_Type1(line[i++]);
        staples.setProd_Type2(line[i++]);
        staples.setProd_Type3(line[i++]);
        staples.setProd_Type4(line[i++]);
 //       staples.setProduct_Name(line[i++]);// Max
        staples.setProduct_Name(parseProductName(line[i++]));
        staples.setProduct_Container(line[i++]);
        staples.setShip_Promo(line[i++]);
        staples.setSupplier_Name(line[i++]);
        staples.setSupplier_Balance(Integer.parseInt(line[i++]));
        staples.setSupplier_Region(line[i++]);
        staples.setSupplier_State(line[i++]);
        staples.setOrder_ID(Integer.parseInt(line[i++]));
        staples.setOrder_Year(Integer.parseInt(line[i++]));
        staples.setOrder_Month(Integer.parseInt(line[i++]));
        staples.setOrder_Day(Integer.parseInt(line[i++]));
        staples.setOrder_Date(Timestamp.valueOf(line[i++]));
        staples.setOrder_Quarter(line[i++]);
        staples.setProduct_Base_Margin(Double.parseDouble(line[i++]));
        staples.setProduct_ID(Integer.parseInt(line[i++]));
        staples.setReceive_Time(Integer.parseInt(line[i++]));
        staples.setReceived_Date(Timestamp.valueOf(line[i++]));
        staples.setShip_Date(Timestamp.valueOf(line[i++]));
        staples.setShip_Charge(Double.parseDouble(line[i++]));
        staples.setTotal_Cycle_Time(Integer.parseInt(line[i++]));
        staples.setProduct_In_Stock(line[i++]);
        staples.setPID(Integer.parseInt(line[i++]));
        staples.setMarket_Segment(line[i++]);

        return staples;
    }

    private Double parseDouble(String S){
        if(S.isEmpty()) return null;
        return Double.parseDouble(S);
    }

    private Integer parseMyInt(String S){
        if (S.isEmpty()) return null;
        return Integer.parseInt(S);
    }


    private Timestamp parseTime(String S){
        if (S.isEmpty()) return null;
        try {return new Timestamp(TIME_FORMAT.parse(unquote(S)).getTime());}
        catch (ParseException e){
            throw new RuntimeException("could not parse time " +S,e);
        }

    }

    private Boolean parseBoolean(String s){
        return s != null ? Boolean.parseBoolean(s) : null;
    }

    private String parseProductName(String S){
   //     if (S.isEmpty()) return null;
        if (S.isEmpty()) return "";
        return unquote(S);

        }


    private Timestamp parseDateTime(String S) {
        String S1 = S.replace("\"","");
        if (S1.isEmpty()) return null;
        try { return new Timestamp(DATE_TIME_FORMAT.parse(unquote(S)).getTime());}
        catch (ParseException e) {
            throw new RuntimeException("could not parse date and time :" +S,e );
        }

    }

    private Date parseDate(String S) {
        if (S.isEmpty()) return null;
      try {  return new Date(DATE_FORMAT.parse(unquote(S)).getTime());}
      catch (ParseException e){
          throw new RuntimeException("failed to parse dates " + S,e);
      }

    }

    private String parseString(String S) {
        String S1 = S.replace("\"","");
        return S1.length() == 0 ? null : S1;
    }


    private String unquote (String S) {
        S = S.substring(1,S.length()-1);
        return S;
    }

    private GigaSpace createSpace() {
        UrlSpaceConfigurer configurer = new UrlSpaceConfigurer(spaceUrl);
        if(lookupGroup != null) {
            configurer.lookupGroups(lookupGroup);
        }
        return new GigaSpaceConfigurer(configurer).gigaSpace();
        //return new GigaSpaceConfigurer(configurer.credentials(userName, passWord)).gigaSpace();
    }
}
