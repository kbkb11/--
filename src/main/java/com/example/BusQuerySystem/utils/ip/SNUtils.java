package com.example.BusQuerySystem.utils.ip;

import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class SNUtils {

    /**
     * 计算SN签名
     *
     * @param paramsMap 请求参数的Map
     * @param AK Access Key
     * @param SK Secret Key
     * @return SN签名
     * @throws UnsupportedEncodingException 如果编码过程中出现错误
     * @throws NoSuchAlgorithmException 如果指定的算法不可用
     */
    public static String calculateSn(Map<String, String> paramsMap, String AK, String SK, String UrlType) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // 将参数Map转换为查询字符串
        String paramsStr = toQueryString(paramsMap);

        // 构建完整的请求字符串：请求路径 + 查询字符串 + Secret Key
        String wholeStr = UrlType + paramsStr + SK;
        System.out.println(wholeStr);

        // 对请求字符串进行URL编码
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");

        // 计算并返回SN签名（MD5哈希值）
        String sn = MD5(tempStr);
        System.out.println(sn);
        return sn;
    }

    /**
     * 将Map中的参数转换为URL查询字符串
     *
     * @param data 参数的Map
     * @return 查询字符串
     * @throws UnsupportedEncodingException 如果编码过程中出现错误
     */
    public static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();
        // 遍历Map中的每个键值对
        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey()).append("=");
            // 对每个参数值进行URL编码
            queryString.append(UriUtils.encode((String) pair.getValue(), "UTF-8")).append("&");
        }
        // 删除查询字符串末尾多余的"&"字符
        if (!queryString.isEmpty()) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    /**
     * 计算MD5哈希值
     *
     * @param md5 输入字符串
     * @return MD5哈希值
     */
    public static String MD5(String md5) {
        try {
            // 获取MD5哈希实例
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            // 计算哈希值
            byte[] array = md.digest(md5.getBytes());
            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            // 返回null以指示算法不可用
            return null;
        }
    }


}
