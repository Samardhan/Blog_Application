package in.samar.binding;

import javax.persistence.Lob;

import lombok.Data;

@Data
public class BlogBind {

	private String blogTitle;
	private String blogDesp;

	@Lob
	private String blogContent;

}
