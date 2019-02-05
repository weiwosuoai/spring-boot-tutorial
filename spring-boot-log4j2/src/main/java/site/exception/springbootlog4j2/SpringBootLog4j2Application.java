package site.exception.springbootlog4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLog4j2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLog4j2Application.class, args);
	}

	private static final Logger LOG = LogManager.getLogger(SpringBootLog4j2Application.class);

	@GetMapping("/test")
	public String test() {
		LOG.debug("debug 级别日志 ...");
		LOG.info("info 级别日志 ...");
		LOG.warn("warn 级别日志 ...");
		LOG.error("error 级别日志 ...");
		LOG.fatal("fatal 级别日志 ...");
		return "Hello Log4j2 !";
	}
}

