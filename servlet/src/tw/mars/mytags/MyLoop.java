package tw.mars.mytags;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyLoop extends SimpleTagSupport{
	private String var;
	private Collection<String>items;
	
	public void setVar(String var){
		this.var=var;
	}
	public void setItems(Collection<String> items){
		this.items=items;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		JspContext jsp=getJspContext();
		JspFragment body=getJspBody();
		
		for(String obj:items){
			jsp.setAttribute(var,obj);
			body.invoke(null);
			jsp.removeAttribute(var);
		}
	}
}
