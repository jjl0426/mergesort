package Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/**
* @Description: 编码工具类
* @MethodName: 
* @Param: 
* @return: 
* @Date: 2019/12/18
**/
public class CodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeUtil.class);

    /**
    * @Description: 将URL编码
    * @MethodName: encodeURL
    * @Param: [source]
    * @return: java.lang.String
    * @Date: 2019/12/18
    **/
    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure",e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return target;
    }

    /**
    * @Description: 将URL解码
    * @MethodName: dencodeURL
    * @Param: [source]
    * @return: java.lang.String
    * @Date: 2019/12/18
    **/
    public static String dencodeURL(String source){
        String target;
        try {
            target = URLDecoder.decode(source,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure",e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return target;
    }
}