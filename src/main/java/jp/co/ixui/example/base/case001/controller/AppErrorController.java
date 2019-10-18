package jp.co.ixui.example.base.case001.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 例外管理用コントローラ
 * @author t-kawasaki
 * 
 * コントローラから例外を投げられた時に反応する
 */
@Controller
@RequestMapping("/error")
public class AppErrorController extends AbstractErrorController {

	public AppErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	@RequestMapping
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, false);
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(body, status);
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
}
