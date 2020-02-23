package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblTags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private long id;
	
	@Column(name = "name", length = 50, nullable = false)
    private String name;
	
	@Column(name = "urlSlug", length = 50, nullable = false)
    private String urlSlug;
	
	@Column(name = "description", length = 200)
    private String description;
	
	
	@ManyToMany(mappedBy="tags")
    private Set<Post> posts = new HashSet<Post>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrlSlug() {
		return urlSlug;
	}


	public void setUrlSlug(String urlSlug) {
		this.urlSlug = urlSlug;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Post> getPosts() {
		return posts;
	}


	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}