package spring_boot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {
	Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(path = "/hello", method = RequestMethod.GET,
	produces = "application/json")
	public String hello(HttpServletResponse response, @CookieValue(value = "foo", defaultValue = "whatever") String foo) {
		log.info("foo is: " + foo);
		response.addCookie(new Cookie("foo", "bar"));
		return "{hello:world}";
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return "{greeting: hi there}";
	}
}
