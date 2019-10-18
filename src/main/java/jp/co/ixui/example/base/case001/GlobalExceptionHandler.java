package jp.co.ixui.example.base.case001;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.ixui.example.base.case001.exception.Http404NotFoundException;

/**
 * 例外の種類によってレスポンスの内容を変更するためのハンドラークラス
 * @author t-kawasaki
 * 
 * ここでハンドリングしていない例外は 500:Internal Server Error となる
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Http404NotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
	
}
