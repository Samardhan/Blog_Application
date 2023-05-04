package in.samar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.samar.entity.BlogUserEntity;


public interface UserRepo extends JpaRepository<BlogUserEntity, Integer>{

	public BlogUserEntity findByuserEmail(String email);
}
