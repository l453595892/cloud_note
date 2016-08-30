package org.tarena.note.aop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionHandler {
	
	//ex参数作用：接受目标组件抛出的异常对象
	@AfterThrowing(throwing="ex",pointcut="within(org.tarena.note.controller..*)")
	public void handler(Exception ex){
		//将异常信息写入文件
//		System.out.println("发生了异常"+ex);
		FileWriter fw;
		try {
			fw = new FileWriter("note_error.log",true);
			PrintWriter pw=new PrintWriter(fw);
			ex.printStackTrace(pw);
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("记录异常日志失败");
		}
		
	}

}
