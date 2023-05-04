package in.samar.service;

import org.springframework.stereotype.Service;

import in.samar.binding.BlogBind;

@Service
public interface BlogService {
	
	public String newPost(BlogBind blog);

}
