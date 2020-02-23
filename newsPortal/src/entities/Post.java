package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblPosts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private long id;
	
	@Column(name = "name", length = 255, nullable = false)
    private String name;
	
	@Column(name = "urlSlug", length = 50, nullable = false)
    private String urlSlug;
	
	@Column(name = "shortDescription", length = 5000)
    private String shortDescription;
	
	
	@Column(name = "description", length = 5000)
    private String description;
	
	@Column(name = "meta", length = 1000)
    private String meta;
	
	@Column(name = "published")
    private boolean published;
	
	@Column(name = "postedOn", nullable = false)
    private Date postedOn;
	
	@Column(name = "modified")
    private Date modified;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="tblPostTags", joinColumns= {@JoinColumn(name="post_id")},  inverseJoinColumns= {@JoinColumn(name="tag_id")})
    private Set<Tag> tags = new HashSet<Tag>();

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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
}
