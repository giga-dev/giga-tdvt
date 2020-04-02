package main.java.org.gigaspaces.model.superstore;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

@SpaceClass
public class Calcs {

    private String key;
    private Double num0;
    private Double num1;
    private Double num2;
    private Double num3;
    private String num4;
    private String str0;
    private String str1;
    private String str2;
    private String str3;
    private Integer int0;
    private Integer int1;
    private Integer int2;
    private Integer int3;
    private Boolean bool0;
    private Boolean bool1;
    private Boolean  bool2;
    private Boolean  bool3;
    private Date date0;
    private Date date1;
    private Date date2;
    private Date date3;
    private Timestamp time0;
    private Timestamp time1;
    private Timestamp datetime0;
    private Timestamp datetime1;
   // private Character zzz;
    private String zzz;

     @SpaceId

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getNum0() {
        return num0;
    }

    public void setNum0(Double num0) {
        this.num0 = num0;
    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Double getNum3() {
        return num3;
    }

    public void setNum3(Double num3) {
        this.num3 = num3;
    }

    public String getNum4() {
        return num4;
    }

    public void setNum4(String num4) {
        this.num4 = num4;
    }

    public String getStr0() {
        return str0;
    }

    public void setStr0(String str0) {
        this.str0 = str0;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public Integer getInt0() {
        return int0;
    }

    public void setInt0(Integer int0) {
        this.int0 = int0;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt2() {
        return int2;
    }

    public void setInt2(Integer int2) {
        this.int2 = int2;
    }

    public Integer getInt3() {
        return int3;
    }

    public void setInt3(Integer int3) {
        this.int3 = int3;
    }

    public Boolean getBool0() {
        return bool0;
    }

    public void setBool0(Boolean bool0) {
        this.bool0 = bool0;
    }

    public Boolean getBool1() {
        return bool1;
    }

    public void setBool1(Boolean bool1) {
        this.bool1 = bool1;
    }

    public Boolean getBool2() {
        return bool2;
    }

    public void setBool2(Boolean bool2) {
        this.bool2 = bool2;
    }

    public Boolean getBool3() {
        return bool3;
    }

    public void setBool3(Boolean bool3) {
        this.bool3 = bool3;
    }

    public Date getDate0() {
        return date0;
    }

    public void setDate0(Date date0) {
        this.date0 = date0;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Timestamp getTime0() {
        return time0;
    }

    public void setTime0(Timestamp time0) {
        this.time0 = time0;
    }

    public Timestamp getTime1() {
        return time1;
    }

    public void setTime1(Timestamp time1) {
        this.time1 = time1;
    }

    public Timestamp getDatetime0() {
        return datetime0;
    }

    public void setDatetime0(Timestamp datetime0) {
        this.datetime0 = datetime0;
    }

    public Timestamp getDatetime1() {
        return datetime1;
    }

    public void setDatetime1(Timestamp datetime1) {
        this.datetime1 = datetime1;
    }

    public String getZzz() {
        return zzz;
    }

    public void setZzz(String zzz) {
        this.zzz = zzz;
    }


}
