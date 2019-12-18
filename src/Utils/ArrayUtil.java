package Utils;

/**
 * @ClassName ArrayUtil
 * @Description 数组工具类
 * @Author Administrator
 * @Date 2019/12/18 14:14
 * @Version 1.0
 **/
public class ArrayUtil {
    
    /**
    * @Description: 判断数组是否非空
    * @MethodName: isNotEmpty
    * @Param: [array]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean isNotEmpty(Object[]array){
        return !isEmpty(array);
    }
    
    /**
    * @Description: 判断数组是否为空
    * @MethodName: isEmpty
    * @Param: [array]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean isEmpty(Object[]array){
        return array==null || array.length==0;
    }
    
    
}
