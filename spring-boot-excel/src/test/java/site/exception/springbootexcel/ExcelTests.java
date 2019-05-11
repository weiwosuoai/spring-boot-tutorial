package site.exception.springbootexcel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.excel.EasyExcelFactory;
import site.exception.springbootexcel.model.User;
import site.exception.springbootexcel.model.WriteModel;
import site.exception.springbootexcel.model.WriteModel2;
import site.exception.springbootexcel.util.DataUtil;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelTests {

    private List<WriteModel> createModelList() {
        List<WriteModel> writeModels = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            WriteModel writeModel = WriteModel.builder()
                    .name("小哈学Java"+i).password("123456").age(i+1).build();
            writeModels.add(writeModel);
        }

        return writeModels;
    }

    private List<WriteModel2> createModel2List() {
        List<WriteModel2> writeModels2 = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            WriteModel2 writeModel2 = WriteModel2.builder().orderNo(String.valueOf(i)).name("犬小哈").createTime(LocalDateTime.now()).build();
            writeModels2.add(writeModel2);
        }

        return writeModels2;
    }

    /**
     * 无注解的实体类
     *
     * @return
     */
    private List<List<Object>> createChongqingDataList() {
        List<List<Object>> datas = Lists.newArrayList();

        for (int i = 0; i < 90; i++) {
            List<Object> objects = new ArrayList<Object>();
            objects.add(i + 1);
            objects.add("3P5072 全日安 白色涤纶防静电手套 8\" A03C/AS 8\" 包装内件数：12副/打 销售单位：打『固安捷』");
            objects.add("79446");
            objects.add("3P5072" + i);
            objects.add("");
            objects.add("");
            objects.add("");
            objects.add("100050");
            objects.add(-1);
            objects.add(21);
            objects.add(i);
            objects.add(21);
            datas.add(objects);
        }

        return datas;
    }

    /**
     * 无注解的实体类
     *
     * @return
     */
    private List<List<Object>> createDynamicModelList() {
        // 所有行数据
        List<List<Object>> rows = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            // 一行数据
            List<Object> row = new ArrayList<>();
            row.add("字符串" + i);
            row.add(Long.valueOf(187837834l + i));
            row.add(Integer.valueOf(2233 + i));
            row.add("犬小哈");
            row.add("微信公众号：小哈学Java");
            rows.add(row);
        }

        return rows;
    }

    /**
     * 简单场景
     * @throws Exception
     */
    @Test
    public void writeExcel1() throws Exception {
        // 文件输出位置
        OutputStream out = new FileOutputStream("/Users/a123123/Work/tmp_files/test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
        Sheet sheet1 = new Sheet(1, 0, WriteModel.class);

        // 第一个 sheet 名称
        sheet1.setSheetName("第一个sheet");

        // 写数据到 Writer 上下文中
        // 入参1: 创建要写入的模型数据
        // 入参2: 要写入的目标 sheet
        writer.write(createModelList(), sheet1);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
    }

    /**
     * 动态生成
     * @throws Exception
     */
    @Test
    public void writeExcel2() throws Exception {
        // 文件输出位置
        OutputStream out = new FileOutputStream("/Users/a123123/Work/tmp_files/test2.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet1 = new Sheet(1, 0);

        sheet1.setSheetName("第一个sheet");

        // 创建一个表格，用于 Sheet 中使用
        Table table1 = new Table(1);

        // 自定义表格样式
//        table1.setTableStyle(DataUtil.createTableStyle());

        // 无注解的模式，动态添加表头
        table1.setHead(DataUtil.createTestListStringHead());
        // 写数据
        writer.write1(createDynamicModelList(), sheet1, table1);

        // 合并单元格
        writer.merge(5, 6, 0, 4);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
    }



    @Test
    public void writeExcelSimple() throws Exception {
        OutputStream out = new FileOutputStream("/Users/a123123/Work/tmp_files/test.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        // ==================================== Start ====================================
        // 写仅有一个 Sheet 的 Excel, 此场景较为通用
        Sheet sheet1 = new Sheet(1, 0, WriteModel2.class);
        sheet1.setSheetName("第一个sheet");
        writer.write(createModel2List(), sheet1);
        // ===================================== End =====================================





        // ==================================== Start ====================================
        // 合并单元格
        Sheet sheet3 = new Sheet(3, 0, WriteModel.class, "第三个sheet", null);
        //writer.write1(null, sheet2);
        writer.write(createModelList(), sheet3);
        // 需要合并单元格
        writer.merge(5, 6, 1, 5);
        // ===================================== End =====================================


        // ==================================== Start ====================================
        // 单个 Sheet 中包含多个 Table
        Sheet sheet4 = new Sheet(4, 0);
        sheet4.setSheetName("第四个sheet");

        Table sheet4table1 = new Table(1);
        sheet4table1.setClazz(WriteModel.class);
        writer.write(createModelList(), sheet4, sheet4table1);

        Table sheet4table2 = new Table(2);
        sheet4table2.setClazz(WriteModel2.class);
        writer.write(createModel2List(), sheet4, sheet4table2);
        // ===================================== End =====================================

        writer.finish();
        out.close();
    }

    /**
     * Invalid row number (1048576) outside allowable range (0..1048575)
     * 07 版 excel 单个 sheet 允许的最大行数是 1048576
     *
     * @throws Exception
     */
    @Test
    public void writeChongqingExcel() throws Exception {
        OutputStream out = new FileOutputStream("/Users/a123123/Work/tmp_files/chongqing.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("电子超市标准版商品导出");
        // 设置列的宽度
//        Map columnWidth = new HashMap();
//        columnWidth.put(0, 10);
//        sheet1.setColumnWidthMap(columnWidth);
//        sheet1.setAutoWidth(true);
        Table table1 = new Table(1);

        //
        // 自定义表格样式
        table1.setTableStyle(DataUtil.createChongqingTableStyle());
//        // 无注解的模式，动态添加表头
        table1.setHead(DataUtil.createTestListStringHead());

        // 内容
        for (int i = 0; i < 2; i++) {
            writer.write1(createChongqingDataList(), sheet1, table1);
        }

        // 最后一行，总价合计
        List<List<Object>> lastLine = new ArrayList<>();
        List<Object> objects = new ArrayList<Object>();
        objects.add("总价合计：21");
        lastLine.add(objects);
        writer.write1(lastLine, sheet1, table1);

        // 合并单元格 todo
        writer.merge(12, 12, 0, 11);


        writer.finish();
        out.close();
    }


}
