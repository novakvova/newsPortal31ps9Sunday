package dto;

public class CreateCategoryDTO {
	private String name;

	private String urlSlug;

	private String description;

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
}
