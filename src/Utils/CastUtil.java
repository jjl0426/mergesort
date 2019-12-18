package Utils;

/**
 * @ClassName CastUtil
 * @Description 数据类型工具类
 * @Author Administrator
 * @Date 2019/12/18 11:24
 * @Version 1.0
 **/
public class CastUtil {

    /**
    * @Description: 转为String类型
    * @MethodName: castString
    * @Param: [obj]
    * @return: java.lang.String 如果参数为null则转为空字符串
    * @Date: 2019/12/18
    **/
    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    /**
    * @Description: 转为String类型(提供默认值)
    * @MethodName: castString
    * @Param: [obj, defaultValue] 将obj转为String，如果obj为null则返回default
    * @return: java.lang.String
    * @Date: 2019/12/18
    **/
    public static String castString(Object obj,String defaultValue){
        return obj!=null?String.valueOf(obj):defaultValue;
    }

    /**
    * @Description: 转为double类型，如果为null或者空字符串或者格式不对返回0
    * @MethodName: castDouble
    * @Param: [obj]
    * @return: double
    * @Date: 2019/12/18
    **/
    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj,0);
    }

    /**
    * @Description: 转为double类型，如果obj为null或者空字符串或者格式不对返回defaultValue
    * @MethodName: castDouble
    * @Param: [obj, defaultValue]
    * @return: double
    * @Date: 2019/12/18
    **/
    public static double castDouble(Object obj,double defaultValue){
        //声明结果，把默认值赋给结果
        double value=defaultValue;
        //判断是否为null
        if (obj!=null){
            //转换为String
            String strValue=castString(obj);
            //判断字符串是否为空(是否为空只能判断字符串，不能判断Object)
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    //不为空则把值赋给value
                    value=Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    //格式不对把默认值赋给value
                    value=defaultValue;
                }
            }
        }
        return value;
    }

    /**
    * @Description: 转为long型，如果obj为null或者空字符串或者格式不对返回0
    * @MethodName: castLong
    * @Param: [obj]
    * @return: long
    * @Date: 2019/12/18
    **/
    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    /**
    * @Description: 转为long型（提供默认数值），如果obj为null或者空字符串或者格式不对则返回defaultValue
    * @MethodName: castLong
    * @Param: [obj, defaultValue]
    * @return: long
    * @Date: 2019/12/18
    **/
    public static long castLong(Object obj,long defaultValue){
        //声明结果，把默认值赋给结果
        long value = defaultValue;
        //判断是否为null
        if (obj!=null){
            //转换为String
            String strValue = castString(obj);
            //判断字符串是否为空（是否为空只能判断字符串，不能判断Object）
            if (StringUtil.isNotEmpty(strValue)){
                try{
                    //不为空则把值赋给value
                    value = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    //格式不对把默认值赋给value
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
    * @Description: 转为int型
    * @MethodName: castInt
    * @Param: [obj]
    * @return: int 如果obj为null或者空字符串或者格式不对则返回0
    * @Date: 2019/12/18
    **/
    public static int castInt(Object obj){
        return CastUtil.castInt(obj,0);
    }

    /**
    * @Description: 转为int型(提供默认值)
    * @MethodName: castInt
    * @Param: [obj, defaultValue]
    * @return: int 如果obj为null或者空字符串或者格式不对则返回defaultValue
    * @Date: 2019/12/18
    **/
    public static int castInt(Object obj,int defaultValue){
        //声明结果，把默认值赋给结果
        int value = defaultValue;
        //判断是否为null
        if (obj!=null){
            //转换为String
            String strValue = castString(obj);
            //判断字符串是否为空（是否为空只能判断字符串，不能判断Object）
            if (StringUtil.isNotEmpty(strValue)){
                try{
                    //不为空则把值赋给value
                    value = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    //格式不对把默认值赋给value
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
    * @Description: 转为boolean型，不是true的返回为false
    * @MethodName: castBoolean
    * @Param: [obj]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj,false);
    }


    /**
    * @Description: 转为boolean型（提供默认值）
    * @MethodName: castBoolean
    * @Param: [obj, defaultValue]
    * @return: boolean
    * @Date: 2019/12/18
    **/
    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean value = defaultValue;
        //obj为null则返回默认值
        if (obj!=null){
            //底层会把字符串和true对比，所以不用判断是否为空字符串
            value = Boolean.parseBoolean(castString(obj));
        }
        return value;
    }




}
