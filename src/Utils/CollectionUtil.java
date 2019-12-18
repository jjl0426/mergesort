package Utils;

import javafx.beans.binding.MapBinding;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName CollectionUtil
 * @Description 集合工具类
 * @Author Administrator
 * @Date 2019/12/18 14:07
 * @Version 1.0
 **/
public class CollectionUtil {
    
    /**
    * @Description: 判断Collection是否为空
    * @MethodName: isEmpty
    * @Param: [collection]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean isEmpty(Collection<?>collection){
        //return CollectionUtil.isEmpty(collection);
        return collection==null || collection.isEmpty();
    }
    
    /**
    * @Description: 判断Collection是否非空
    * @MethodName: isNotEmpty
    * @Param: [collection]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean isNotEmpty(Collection<?>collection){
        return !isEmpty(collection);
    }
    
    /**
    * @Description: 判断map是否为空
    * @MethodName: isEmpty
    * @Param: [map]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean isEmpty(Map<?,?>map){
        //return CollectionUtil.isEmpty(map);
        return map==null || map.isEmpty();
    }
    
    /**
    * @Description: 判断map是否非空
    * @MethodName: isNotEmpty
    * @Param: [map]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean isNotEmpty(Map<?,?>map){
        return !isEmpty(map);
    }
    
}
