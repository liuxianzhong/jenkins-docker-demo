package com.excel;

import com.constant.ExcelConstants;
import com.utils.FileUtils;
import com.utils.TemplateUtils;
import com.utils.ZipUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *Liuliux
 * @outhor Calebit
 * @create 2020-09-24 14:34
 */
public class TestExcelTemplate {

    public static void main(String[] args) throws Exception {
        TestExcelTemplate testExcelTemplate = new TestExcelTemplate();
        long nowMillis = System.currentTimeMillis();

        //1.组织数据
        Map<String, String> data = assembleDataFromDb();

        //2、模板文件 ———> zip
        String zipFile = copyTemplate(ExcelConstants.TEMPLATE_EXCEL_PATH, ExcelConstants.TEMP_PATH + nowMillis + ".zip");

        //3、解压 zip
        String descDir = ExcelConstants.TEMP_PATH + nowMillis;
        unzipFile(zipFile, descDir);

        String templateDataPath = descDir + ExcelConstants.ZIP_DATA_FILE_PATH;
        //4、读取并且替换数据
        String templateString = FileUtils.readFile(templateDataPath);

        //5、替换文件内容
        String lastData = TemplateUtils.renderString(templateString, data);
        FileUtils.fileLinesWrite(templateDataPath, lastData, false);

        String lastZip = ExcelConstants.TEMP_PATH + ExcelConstants.LAST_ZIP_FILE_NAME;
        //6、再次压缩文件
        ZipUtil.zip(descDir, lastZip);

        //7、生成新的excel
        String lastExcelPath = ExcelConstants.TEMP_PATH + ExcelConstants.LAST_EXCEL_FILE_NAME;
        File lastExcel = new File(lastExcelPath);
        if (!lastExcel.exists()) {
            lastExcel.createNewFile();
        }
        FileUtils.copy(new File(lastZip), lastExcel);

        //8、TODO 删除临时目录数据

    }



    /**
     * 解压zip文件
     *
     * @param zipFile
     */
    private static void unzipFile(String zipFile, String descDirStr) throws Exception {
        File file = new File(descDirStr);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipUtil.unZip(zipFile, descDirStr);
    }

    /**
     * copy文件
     *
     * @param templateExcelPath
     * @param dest
     * @return
     */
    private static String copyTemplate(String templateExcelPath, String dest) {

        try {
            File templateFile = new File(templateExcelPath);
            File destFile = new File(dest);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileUtils.copy(templateFile, destFile);

            return dest;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }


    public static Map<String, String> assembleDataFromDb() {
        Map<String, String> dataMap = new HashMap<>(20);
        dataMap.put("userName", "西施");
        dataMap.put("sex", "女");
        dataMap.put("birthDay", "1700-01-08");
        dataMap.put("height", "190CM");
        dataMap.put("weight", "47KG");
        dataMap.put("nation", "藏族");
        dataMap.put("subject", "美女大学");
        dataMap.put("telPhone", "18899992222");
        dataMap.put("eduExperience1", "美女大学一班");
        dataMap.put("eduExperience2", "美女大学二班");
        dataMap.put("workExperience1", "美女公司1");
        dataMap.put("workExperience2", "美女公司2");

        return dataMap;
    }
}
