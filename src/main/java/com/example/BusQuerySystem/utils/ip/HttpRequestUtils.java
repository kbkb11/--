package com.example.BusQuerySystem.utils.ip;

import org.springframework.web.util.UriUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpRequestUtils {

    /**
     * 发送HTTP GET请求并返回响应内容
     *
     * @param strUrl 请求的URL
     * @param param 请求的参数，键值对形式的Map
     * @return 响应内容，类型为String
     * @throws Exception 当请求过程中发生任何异常时
     */
    public static String requestGetSN(String strUrl, Map<String, String> param) throws Exception {
        // 验证输入参数是否为空或无效
        if (strUrl == null || strUrl.length() <= 0 || param == null || param.isEmpty()) {
            return null;
        }

        // 创建一个StringBuilder用于构建最终的请求URL
        StringBuilder queryString = new StringBuilder();
        queryString.append(strUrl);

        // 遍历参数Map，将每个键值对添加到URL查询字符串中
        for (Map.Entry<String, String> pair : param.entrySet()) {
            queryString.append(pair.getKey()).append("=");
            // 对参数值进行URL编码，避免特殊字符影响请求
            queryString.append(UriUtils.encode(pair.getValue(), "UTF-8")).append("&");
        }

        // 删除查询字符串末尾多余的"&"字符
        if (!queryString.isEmpty()) {
            queryString.deleteCharAt(queryString.length() - 1);
        }

        // 创建URL对象，并打开HTTP连接
        URL url = new URL(queryString.toString());
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();

        // 读取HTTP响应
        InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder buffer = new StringBuilder();
        String line;

        // 逐行读取响应内容，并将其添加到StringBuilder中
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        // 关闭输入流和BufferedReader
        reader.close();
        isr.close();

        // 返回响应内容作为字符串
        return buffer.toString();
    }
}
