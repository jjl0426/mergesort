package Utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @ClassName ZipUtil
 * @Description 解压Zip文件
 * @Author Administrator
 * @Date 2019/12/18 15:21
 * @Version 1.0
 **/
public class ZipUtil {
    
    private static final int buffer=2048;
    
    /**
    * @Description: 解压Zip文件
    * @MethodName: unZip
    * @Param: [path]
    * @return: void
    * @Date: 2019/12/18
    **/
    public static void unZip(String path) {
        int count = -1;
        String savepath = "";

        File file = null;
        InputStream is = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        //保存解压文件目录
        savepath = path.substring(0, path.lastIndexOf(".")) + File.separator;
        //创建保存目录
        new File(savepath).mkdir();
        ZipFile zipFile = null;
        try {
            //解决中文乱码问题
            zipFile = new ZipFile(path, Charset.forName("GBK"));
            //枚举ZIP中的所有文件
            Enumeration<?> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                byte buf[] = new byte[buffer];

                ZipEntry entry = (ZipEntry) entries.nextElement();
                //获取文件名
                String filename = entry.getName();
                filename = savepath + filename;
                boolean ismkdir = false;
                //检查此文件是否带有文件夹
                if (filename.lastIndexOf("/") != -1) {
                    ismkdir = true;
                }
                //如果此枚举文件是文件夹则创建,并且遍历下一个
                if (entry.isDirectory()) {
                    file = new File(filename);
                    file.mkdirs();
                    continue;
                }
                //此枚举文件不是目录
                file = new File(filename);
                //如果文件不存在并且文件带有目录
                if (!file.exists()) {
                    if (ismkdir) {
                        //先创建目录
                        new File(filename.substring(0, filename
                                .lastIndexOf("/"))).mkdirs();
                    }
                }
                //再创建文件
                file.createNewFile();

                is = zipFile.getInputStream(entry);
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos, buffer);

                while ((count = is.read(buf)) > -1) {
                    bos.write(buf, 0, count);
                }
                bos.flush();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
