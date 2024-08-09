/**
 * 选择AK使用SN校验：
 */

package com.example.BusQuerySystem;

import com.example.BusQuerySystem.service.serviceImpl.BaiduConfigService;
import com.example.BusQuerySystem.utils.gson.LocationIpResponse;
import com.example.BusQuerySystem.utils.gson.LocationNameResponse;
import com.example.BusQuerySystem.utils.ip.HttpRequestUtils;
import com.example.BusQuerySystem.utils.ip.SNUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.Map;

public class temp {

//    @Autowired
    private final BaiduConfigService baiduConfigService;

    @Autowired
    public temp(BaiduConfigService baiduConfigService) {
        this.baiduConfigService = baiduConfigService;
    }

    public static String AK = "Cuf5RfkxkA5bQTAhpczBkplGHvNqJgVz";

    public static String SK = "xkmpgAM2NR1abPPWWsS5DXBUb2KYuWUY";



    // 地图
//    public static void main(String[] args) throws Exception {
//
//        Map<String, String> params = new LinkedHashMap<>();
//        params.put("width", "280");
//        params.put("height", "140");
//        params.put("zoom", "10");
//        params.put("ak", AK);
//
//        String sn = SNUtils.calculateSn(params, AK, SK, "/staticimage/v2?");
//        params.put("sn", sn);
//
//        // 发送HTTP GET请求并获取响应
//        String response = HttpRequestUtils.requestGetSN("https://api.map.baidu.com/staticimage/v2?", params);
//        System.out.println(response);
//
//        // 使用 Gson 解析 JSON 数据
//        Gson gson = new Gson();
//        LocationResponse locationResponse = gson.fromJson(response, LocationResponse.class);
//
//        // 输出解析后的数据
//        System.out.println("Address: " + locationResponse.getContent().getAddress());
//        System.out.println("City: " + locationResponse.getContent().getAddressDetail().getCity());
//        System.out.println("Province: " + locationResponse.getContent().getAddressDetail().getProvince());
//        System.out.println("Longitude (x): " + locationResponse.getContent().getPoint().getX());
//        System.out.println("Latitude (y): " + locationResponse.getContent().getPoint().getY());
//    }


        // IP定位
    public static void main(String[] args) throws Exception {

        // 设置API请求的参数
        Map<String, String> params = new LinkedHashMap<>();
        params.put("address", "萍乡市风扬茶楼");
        params.put("output", "json");
        params.put("ak", AK);

        // 计算SN签名
        String sn = SNUtils.calculateSn(params, AK, SK, "/geocoding/v3?");
        params.put("sn", sn);

        // 发送HTTP GET请求并获取响应
        String response = HttpRequestUtils.requestGetSN("http://api.map.baidu.com/geocoding/v3?", params);

        // 使用 Gson 解析 JSON 数据
        Gson gson = new Gson();
        LocationNameResponse locationIpResponse = gson.fromJson(response, LocationNameResponse.class);

        System.out.println(locationIpResponse.getResult().getLocation().getLat());
        System.out.println(locationIpResponse.getResult().getLocation().getLng());

    }

//    /**
//     * 选择了ak，使用SN校验：
//     * 根据您选择的AK已为您生成调用代码
//     * 检测您当前的AK设置了sn检验，本示例中已为您生成sn计算代码
//     * @param strUrl
//     * @param param
//     * @throws Exception
//     */
//    public String requestGetSN(String strUrl, Map<String, String> param) throws Exception {
//        if (strUrl == null || strUrl.length() <= 0 || param == null || param.size() <= 0) {
//            return null;
//        }
//
//        StringBuilder queryString = new StringBuilder();
//        queryString.append(strUrl);
//        for (Map.Entry<String, String> pair : param.entrySet()) {
//            queryString.append(pair.getKey()).append("=");
//            queryString.append(UriUtils.encode(pair.getValue(), "UTF-8")).append("&");
//        }
//
//        if (queryString.length() > 0) {
//            queryString.deleteCharAt(queryString.length() - 1);
//        }
//
//        URL url = new URL(queryString.toString());
//        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
//        httpConnection.connect();
//
//        InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
//        BufferedReader reader = new BufferedReader(isr);
//        StringBuilder buffer = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            buffer.append(line);
//        }
//        reader.close();
//        isr.close();
//        return buffer.toString();
//    }
//
//    public String caculateSn() throws UnsupportedEncodingException,
//            NoSuchAlgorithmException {
//        temp snCal = new temp();
//
//        // 计算sn跟参数对出现顺序有关，get请求请使用LinkedHashMap保存<key,value>，该方法根据key的插入顺序排序；post请使用TreeMap保存<key,value>，该方法会自动将key按照字母a-z顺序排序。
//        // 所以get请求可自定义参数顺序（sn参数必须在最后）发送请求，但是post请求必须按照字母a-z顺序填充body（sn参数必须在最后）。
//        // 以get请求为例：http://api.map.baidu.com/geocoder/v2/?address=百度大厦&output=json&ak=yourak，paramsMap中先放入address，再放output，然后放ak，放入顺序必须跟get请求中对应参数的出现顺序保持一致。
//        Map paramsMap = new LinkedHashMap<String, String>();
//        paramsMap.put("ip", "111.206.214.37");
//        paramsMap.put("coor", "bd09ll");
//        paramsMap.put("ak", AK);
//
//
//        // 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
//        String paramsStr = snCal.toQueryString(paramsMap);
//
//        // 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
//        String wholeStr = new String("/location/ip?" + paramsStr + SK);
//
//        System.out.println(wholeStr);
//        // 对上面wholeStr再作utf8编码
//        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
//
//        // 调用下面的MD5方法得到最后的sn签名
//        String sn = snCal.MD5(tempStr);
//        System.out.println(sn);
//        return sn;
//    }
//
//    // 对Map内所有value作utf8编码，拼接返回结果
//    public String toQueryString(Map<?, ?> data)
//            throws UnsupportedEncodingException {
//        StringBuffer queryString = new StringBuffer();
//        for (Map.Entry<?, ?> pair : data.entrySet()) {
//            queryString.append(pair.getKey() + "=");
//            //    第一种方式使用的 jdk 自带的转码方式  第二种方式使用的 spring 的转码方法 两种均可
//            //    queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8").replace("+", "%20") + "&");
//            queryString.append(UriUtils.encode((String) pair.getValue(), "UTF-8") + "&");
//        }
//        if (queryString.length() > 0) {
//            queryString.deleteCharAt(queryString.length() - 1);
//        }
//        return queryString.toString();
//    }
//
//    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
//    public String MD5(String md5) {
//        try {
//            java.security.MessageDigest md = java.security.MessageDigest
//                    .getInstance("MD5");
//            byte[] array = md.digest(md5.getBytes());
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < array.length; ++i) {
//                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
//                        .substring(1, 3));
//            }
//            return sb.toString();
//        } catch (java.security.NoSuchAlgorithmException e) {
//        }
//        return null;
//    }
}