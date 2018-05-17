package cn.sillycode.langrensha.utility;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: langrensha
 * @description: Http utility
 * @author: zsq
 * @create: 2018-05-10 23-11
 */
@Service
public class HttpUtil {

    /**
     * 提供
     * @param url 请求地址
     * @param params 携带参数
     * @return 返回响应数据字符串
     */
    public static String client(String url, String params) {
        String result = "";
        BufferedReader in = null;
        try {
            //拼接完整的URL
            String urlNameString = url + "?" + params;
            URL realUrl = new URL(urlNameString);
            //打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            //设置通用请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0(compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立实际连接
            connection.connect();
            //定义BufferedReader输入流读取返回的数据
            System.out.print(connection.getContent());

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }
        } catch (Exception e){
            System.out.println("发送GET请求异常" + e);
            e.printStackTrace();
        //关闭输入流
        } finally {
            try {
                if (in != null){
                    in.close();
                }
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return result;

        /*
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //提交方式
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //执行http请求
        ResponseEntity<String> responseEntity = client.exchange(url, httpMethod, httpEntity, String.class);
        return responseEntity.getBody();
        */
    }
}
