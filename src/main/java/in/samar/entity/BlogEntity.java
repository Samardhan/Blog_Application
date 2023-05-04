package in.samar.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class BlogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blogId;
	private String blogTitle;
	private String blogDesp;

	@Lob
	private String blogContent;

	@CreationTimestamp
	private LocalDate blogCreated;

	@UpdateTimestamp
	private LocalDate blogUpdated;

	@ManyToOne
	@JoinColumn(name = "userId")
	private BlogUserEntity user;

	@OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
	private List<CommentEntity> comments;

}
