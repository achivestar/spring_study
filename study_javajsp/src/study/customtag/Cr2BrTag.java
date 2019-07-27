package study.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import study.common.util.GlobalUtil;

/**
 * @author Park
 *
 */
public class Cr2BrTag extends TagSupport {
	private String value;

	public int doStartTag() throws JspException {
		try {
			String val = GlobalUtil.Cr2Br(value);
			pageContext.getOut().print(val);
		} catch (Exception ex) {
			throw new JspTagException("Cr2BrTag " + ex.getMessage());
		}

		return SKIP_BODY;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
