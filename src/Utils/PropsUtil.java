package Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName PropsUtil
 * @Description 属性文件工具类
 * @Author Administrator
 * @Date 2019/12/18 14:16
 * @Version 1.0
 **/
public class PropsUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(PropsUtil.class);
    /**
    * @Description: 加载属性文件
    * @MethodName: loadProps
    * @Param: [fileName] filename一定要在class下面及java根目录或者resource根目录下
    * @return: java.util.Properties
    * @Date: 2019/12/18
    **/
    public static Properties loadProps(String fileName){
        Properties props=new Properties();
        InputStream is=null;
        try {
            //将资源文件加载为流
            is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            props.load(is);
            if (is==null){
                throw new FileNotFoundException(fileName+"file is not Found");
            }
        }catch (FileNotFoundException e){
            LOGGER.error("load properties file failure",e);
        }catch (IOException e){
            LOGGER.error("load input stream failure",e);
        }
        finally {
            if (is!=null){
                try {
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }

    /**
    * @Description: 获取字符型属性(默认值为空字符串)
    * @MethodName: getString
    * @Param: [props, key]
    * @return: java.lang.String
    * @Date: 2019/12/18
    **/
    public static String getString(Properties props,String key){
        return getString(props, key,"");
    }
    
    /**
    * @Description: 获取字符型属性(可指定默认值)
    * @MethodName: getString
    * @Param: [props, key, defaultValue] 当文件中无此key对应的值则返回defaultValue
    * @return: java.lang.String 
    * @Date: 2019/12/18
    **/
    public static String getString(Properties props,String key,String defaultValue){
        String value=defaultValue;
        if (props.containsKey(key)){
            value=props.getProperty(key);
        }
        return value;
    }
    
    /**
    * @Description: 获取数值型属性(可指定默认值)
    * @MethodName: getInt
    * @Param: [props, key, defaultValue]
    * @return: int
    * @Date: 2019/12/18
    **/
    public static int getInt(Properties props,String key,int defaultValue){
        int value=defaultValue;
        if (props.containsKey(key)){
            value=CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }
    
    /**
    * @Description: 获取数值型属性(默认值为0)
    * @MethodName: getInt
    * @Param: [props, key]
    * @return: int
    * @Date: 2019/12/18
    **/
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }
    
    /**
    * @Description: 获取布尔型属性(默认值为false)
    * @MethodName: getBoolean
    * @Param: [props, key, defaultValue]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean getBoolean(Properties props,String key,Boolean defaultValue){
        boolean value=defaultValue;
        if (props.containsKey(key)){
            value=CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }

    /**
    * @Description: 获取布尔值属性(默认为false)
    * @MethodName: getBoolean
    * @Param: [props, key]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }
    
    
    
}
