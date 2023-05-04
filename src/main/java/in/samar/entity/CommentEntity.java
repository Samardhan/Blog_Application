package in.samar.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;

	private String commentName;
	private String commentEmail;

	@Lob
	private String commentContent;

	@CreationTimestamp
	private LocalDate commentCreated;

	@ManyToOne
	@JoinColumn(name = "blogId")
	private BlogEntity blog;
}
