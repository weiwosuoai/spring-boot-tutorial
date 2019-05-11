package site.exception.springbootexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.exception.springbootexcel.model.WriteModel;
import site.exception.springbootexcel.model.WriteModel2;
import site.exception.springbootexcel.util.DataUtil;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordTests {

    private List<WriteModel> createModelList() {
        List<WriteModel> writeModels = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            WriteModel writeModel = WriteModel.builder().name("犬小哈" + i).password("123456").age(i+1).build();
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
     * @return
     */
    private List<List<Object>> createUserList() {
        List<List<Object>> datas = Lists.newArrayList();

        for (int i = 0; i < 10000; i++) {
            List<Object> objects = new ArrayList<Object>();
            objects.add("字符串"+i);
            objects.add(Long.valueOf(187837834l+i));
            objects.add(Integer.valueOf(2233+i));
            datas.add(objects);
        }

        return datas;
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
        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet2 = new Sheet(2, 0);
        sheet2.setSheetName("第二个sheet");
        Table table1 = new Table(1);
        // 自定义表格样式
        table1.setTableStyle(DataUtil.createTableStyle());
        // 无注解的模式，动态添加表头
        table1.setHead(DataUtil.createTestListStringHead());
        writer.write1(createUserList(), sheet2, table1);
        // ===================================== End =====================================


        // ==================================== Start ====================================
        // 合并单元格
		Sheet sheet3 = new Sheet(3, 0, WriteModel.class, "第三个sheet", null);
		//writer.write1(null, sheet2);
		writer.write(createModelList(), sheet3);
		//需要合并单元格
		writer.merge(5,20,1,1);
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

}
