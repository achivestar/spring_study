package study.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import study.common.util.GlobalUtil;

/**
 * @author Park
 *
 */
public class StringCutTag extends TagSupport {
	private String value;
	private int len;
	private boolean escape = true;

	public int doStartTag() throws JspException {
		try {
			String val = GlobalUtil.getLimitByte(escape?GlobalUtil.escapeTag(value):value, len);
			pageContext.getOut().print(val);
		} catch (Exception ex) {
			throw new JspTagException("StringCutTag " + ex.getMessage());
		}

		return SKIP_BODY;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public void setEscape(boolean escape) {
		this.escape = escape;
	}



}
