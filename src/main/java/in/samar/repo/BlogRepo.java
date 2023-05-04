package in.samar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.samar.entity.BlogEntity;

public interface BlogRepo extends JpaRepository<BlogEntity, Integer> {

}
