package com.springboot.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 省市区处理工具类
 */
public class AddressResolutionUtil {

    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String TOWN = "town";
    public static final String VILLAGE = "village";


    public static final String PROVINCE_REGX = "(?<province>.*?自治区|.*?省|.*?行政区)?";
    public static final String CITY_REGX = "(?<city>.*?自治州|.*?地区|.*?行政单位|.*?盟|.*?市辖区|.*?市|.*?县)?";
    public static final String COUNTRY_REGX = "(?<county>.*?县|.+区|.+市|.+旗|.+海域|.+岛)?";
    public static final String TOWN_REGX = "(?<town>[^区]+区|.+镇)?";
    public static final String VILLAGE_REGX = "(?<village>.*)";

    /**
     * 解析地址
     *
     * @param address
     * @return
     * @author lin
     */
    public static Map<String, String> addressResolution(String address) {
        StringBuffer buffer = new StringBuffer();

        //省市区匹配
        String regex = buffer.append(PROVINCE_REGX).append(CITY_REGX).append(COUNTRY_REGX).append(TOWN_REGX).append(VILLAGE_REGX).toString();

        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        Map<String, String> row = null;
        row = new LinkedHashMap<String, String>();
        if (m.find()) {
            province = m.group("province");
            row.put(PROVINCE, province == null ? "" : province.trim());
            city = m.group("city");
            row.put(CITY, city == null ? "" : city.trim());
            county = m.group("county");
            row.put(COUNTRY, county == null ? "" : county.trim());
            town = m.group("town");
            row.put(TOWN, town == null ? "" : town.trim());
            village = m.group("village");
            row.put(VILLAGE, village == null ? "" : village.trim());
            return row;
        } else {
            return null;
        }
    }
}