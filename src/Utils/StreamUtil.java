package Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName StreamUtil
 * @Description 常用流操作工具类
 * @Author Administrator
 * @Date 2019/12/18 14:54
 * @Version 1.0
 **/
public class StreamUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(StreamUtil.class);

    /**
    * @Description: 从输入流获取字符串
    * @MethodName: getString
    * @Param: [is]
    * @return: java.lang.String
    * @Date: 2019/12/18
    **/
    public static String getString(InputStream is){
        StringBuilder sb=new StringBuilder();
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
        }catch (IOException e){
            LOGGER.error("get String failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


}
