package org.yodogi.learn.kata.spring.web;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("rest-controller")
@RequestMapping(value = "/rest/")
public class RestController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = { "/pendingTask.json" }, method = RequestMethod.GET)
	public String getPendingTask() {
		return loadJsonFile("/json/task_pending_manager.json");
	}

	private String loadJsonFile(String resource_json) {
		InputStream is = RestController.class.getResourceAsStream(resource_json);
		try {
			logger.info("Loading json file [" + resource_json + "]");
			return Inputstream2String(is);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "{}";
		}
	}

	private String Inputstream2String(InputStream is) throws IOException {
		final int PKG_SIZE = 1024;
		byte[] data = new byte[PKG_SIZE];
		StringBuilder buffer = new StringBuilder(PKG_SIZE * 50);
		int size;

		size = is.read(data, 0, data.length);
		while (size > 0) {
			String str = new String(data, 0, size);
			buffer.append(str);
			size = is.read(data, 0, data.length);
		}
		return buffer.toString();
	}
}
