package site.exception.springbootfreemarkexcel;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Builder;
import lombok.Data;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import site.exception.springbootfreemarkexcel.entity.Commodity;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFreemarkExcelApplicationTests {

	@Test
	public void createExcelByFreemark() throws Exception {

		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

		// 设置模板文件的父目录
		configuration.setDirectoryForTemplateLoading(new File("/Users/a123123/Work/tmp_files"));

		// 加载模板文件
		Template template = configuration.getTemplate("/excel_template.xml", "UTF-8");

		// 数据准备，可以是从数据库中查询，这里为了方便演示，手动 new 了
		Map<String, Object> data = new HashMap<>();
		data.put("title", "测试标题1");

		List<Commodity> commodities = new ArrayList<>();
		Commodity commodity1 = Commodity.builder()
				.name("name1").num(11).num1(111)
				.price(new BigDecimal(11.1)).price2(new Double(11.11))
				.price3(new Float(11.1111))
				.createTime(new Date())
				.timestamp(System.currentTimeMillis())
				.build();

        Commodity commodity2 = Commodity.builder()
                .name("name2").num(22).num1(222)
                .price(new BigDecimal(22.2)).price2(new Double(22.22))
                .price3(new Float(22.2222))
                .createTime(new Date())
                .timestamp(System.currentTimeMillis())
                .build();

		commodities.add(commodity1);
		commodities.add(commodity2);
		data.put("commodities", commodities);

		// 生成 excel 文件
		template.process(data, new FileWriter("/Users/a123123/Work/tmp_files/excelByFreemark.xls"));
	}


}
