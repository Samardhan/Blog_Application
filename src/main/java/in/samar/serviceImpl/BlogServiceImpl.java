package in.samar.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.samar.binding.BlogBind;
import in.samar.entity.BlogEntity;
import in.samar.entity.BlogUserEntity;
import in.samar.repo.BlogRepo;
import in.samar.repo.UserRepo;
import in.samar.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepo brepo;
	
	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private HttpSession session;

	@Override
	public String newPost(BlogBind blog) {

		BlogEntity blogSave = new BlogEntity();

		BeanUtils.copyProperties(blog, blogSave);
		
		Integer uid = (Integer)session.getAttribute("userId");
		
		BlogUserEntity bue= urepo.findById(uid).get();
		
		blogSave.setUser(bue);
		
		

		brepo.save(blogSave);

		return "Saved";
	}
}
