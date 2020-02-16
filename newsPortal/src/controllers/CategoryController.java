package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@RequestMapping("/all")
	public String index(Model model) {
		System.out.println("Hello action");
		
		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("-----Connection succes------");
			Session session = sessionFactory.openSession();
			CategoryService service = new CategoryService(session);
			
			model.addAttribute("list", service.GetAll());  
			
			session.close();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
		return "admin/category/index";
	}
}