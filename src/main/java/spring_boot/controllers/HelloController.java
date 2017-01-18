package spring_boot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
	Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(path = "/hello", method = RequestMethod.GET,
	produces = "application/json")
	public String hello(HttpServletResponse response, @CookieValue(value = "foo", defaultValue = "whatever") String foo) {
		log.info("foo is: " + foo);
		response.addCookie(new Cookie("foo", "bar"));
		return "{hello:world} >>> ";
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(HttpSession httpSession) {
		httpSession.setAttribute("intro", "introduction");
		return "{greeting: hi there}";
	}

	@RequestMapping(path = "/session", method = RequestMethod.GET)
	public String session(HttpSession httpSession) {
		if (httpSession.getAttribute("intro") == null) {
			return "{msg: session is empty}";
		}

		return "{msg: session is applied, value : " + httpSession.getAttribute("intro") + "}";
	}


	@ModelAttribute("intro")
	public String createIntro() {
		return "this is intro to sessions in spring mvc";
	}
}
