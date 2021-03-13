package seatwork.one;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() throws Exception {
        test(Main_5.class);
    }

    public void test(Class solution) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String packageName = solution.getPackage().toString();
        String homeworkNumber = packageName.substring(packageName.lastIndexOf(".")+1);
        String className = solution.getName();
        String questionNumber = className.substring(className.lastIndexOf(".")+1);

        System.out.println("题目"+questionNumber.substring(questionNumber.lastIndexOf("_")+1)+"开始测试=================");


        /*
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(filePath);
            InputStream inputStream = resource.getInputStream();
            File ttfFile = new File(filePath);
            FileUtils.copyInputStreamToFile(inputStream, ttfFile);
            FileReader reader = new FileReader(ttfFile); // 建立一个输入流对象reader

            BufferedReader br = new BufferedReader(reader);
         */

        String basicPath = "seatwork/case/"+homeworkNumber+"/"+questionNumber+"/";
        deleteTemp(basicPath);


        String[][] testFileNames = readFileName(homeworkNumber, questionNumber);

        if(testFileNames == null){
            System.out.println("测试用例未准备");
            return;
        }

        String[] caseNames = testFileNames[0];
        String[] resultNames = testFileNames[1];


        for (int i = 0; i < caseNames.length; i++) {
            FileInputStream in = new FileInputStream(basicPath+caseNames[i]);
            System.setIn(in);
            String outFileName = caseNames[i].replace(".in",".temp");
            PrintStream consoleOut = System.out;
            PrintStream out = new PrintStream(new FileOutputStream(basicPath + outFileName));
            System.setOut(out);
            Method method = solution.getMethod("main",String[].class);
            method.invoke(null, new Object[]{new String[]{"1","2","3"}});
            System.setOut(consoleOut);
            out.close();
            System.out.println("用例"+(i+1)+(compareFiles(basicPath + outFileName,basicPath + resultNames[i])?"成功":"失败"));
        }


    }

    private void deleteTemp(String basicPath) {
        File catalogue = new File(basicPath);
        if (catalogue.exists()){
            String[] fileList = catalogue.list();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].contains(".temp")){
                    new File(basicPath+fileList[i]).delete();
                }
            }
        }

    }

    private boolean compareFiles(String temp, String out) throws IOException {
        BufferedReader inTemp = new BufferedReader(new FileReader(temp));
        BufferedReader inOut = new BufferedReader(new FileReader(out));

        StringBuffer tempStr = new StringBuffer();
        StringBuffer outStr = new StringBuffer();

        String lineStr = null;
        while ((lineStr = inTemp.readLine()) != null){
            tempStr.append(lineStr+"\n");
        }
        lineStr = null;
        while ((lineStr = inOut.readLine()) != null){
            outStr.append(lineStr+"\n");
        }

        inOut.close();
        inTemp.close();
        boolean delete = new File(temp).delete();
        boolean same = outStr.toString().equals(tempStr.toString());
        if(!same){
            String[] outArr = outStr.toString().split("\n");
            String[] tempArr = tempStr.toString().split("\n");
            int len = outArr.length<tempArr.length?outArr.length:tempArr.length;

            int index = 0;
            while (index < len) {
                if(!outArr[index].equals(tempArr[index])){
                    System.out.println("标准："+outArr[index]);
                    System.out.println("我的："+tempArr[index]);
                }
                index++;
            }
            System.out.println("****************************************");
            while (index < outArr.length){
                System.out.println("标准多出的数据："+outArr[index++]);
            }
            while (index < tempArr.length){
                System.out.println("我的多出的数据："+tempArr[index++]);
            }

            System.out.println("测试数据****************************************");
            read(out.replace(".out",".in"));
            System.out.println("标准完整数据****************************************");
            System.out.print(outStr);
            System.out.println("我的完整数据****************************************");
            System.out.print(tempStr);
        }

        return same;
    }

    public String[][] readFileName(String homeworkNumber, String questionNumber){
        File catalogue = new File("F:\\work\\projects\\formalProject\\myArithmetic\\src\\main\\resources\\seatwork\\case\\"+homeworkNumber+"/"+questionNumber);

        if(!catalogue.exists()){
            return null;
        }

        String[] fileNames = catalogue.list();




        String[][] testFileNames = new String[2][fileNames.length/2];
        String[] caseNames = testFileNames[0];
        String[] resultNames = testFileNames[1];

        int caseIndex = 0;
        int resultIndex = 0;
        for (int i = 0; i < fileNames.length; i++) {
            if(fileNames[i].contains("in")){
                caseNames[caseIndex++] = fileNames[i];
            }else {
                resultNames[resultIndex++] = fileNames[i];
            }
        }
        return testFileNames;
    }


    public void read(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}
