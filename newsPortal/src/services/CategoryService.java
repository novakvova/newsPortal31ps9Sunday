package services;

import java.util.List;

import org.hibernate.Session;

import entities.Category;

public class CategoryService {
	
	private Session session;

	public CategoryService(Session session) {
		super();
		this.session = session;
	}
	
	public Long Add(String name, String urlSlug, String description) {
		session.beginTransaction();
		Category cat = new Category(name, urlSlug, description);
		//cat.setName(name);
		Long id = (Long)session.save(cat);
		session.getTransaction().commit();
		return id;
	}
	public Category GetById(long id) {
		session.beginTransaction();
		Category cat =  (Category)session.get(Category.class, id);
		session.getTransaction().commit();
		return cat;
	}
	public void Delete(long id) {
		Category cat =  this.GetById(id);
		session.beginTransaction();
		session.delete(cat);
		session.getTransaction().commit();
	}
	public void Update(long id, String name, String urlSlug, String description) {
		Category cat =  this.GetById(id);
		session.beginTransaction();
		cat.setName(name);
		cat.setUrlSlug(urlSlug);
		cat.setDescription(description);
		session.update(cat);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> GetAll() {
		session.beginTransaction();
		List<Category> categories = session.createQuery("FROM Category").list();
		session.getTransaction().commit();
		return categories;
	}
}
