package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService service; // This will auto-inject the authentication service into the controller.

	@RequestMapping("/all")
	public String index(Model model) {
		System.out.println("Hello action");

//		SessionFactory sessionFactory = null;
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
		// from
		// hibernate.cfg.xml
		// .build();

		//
//			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//			System.out.println("-----Connection succes------");
//			Session session = sessionFactory.openSession();
		// service = new CategoryService(session);

		model.addAttribute("list", service.GetAll());

		// session.close();
		// } catch (Exception e) {
		// The registry would be destroyed by the SessionFactory, but we had trouble
		// building the SessionFactory
		// so destroy it manually.
		// StandardServiceRegistryBuilder.destroy(registry);
		// }

		return "admin/category/index";
	}

	@RequestMapping("/create")
	public String makeCategory(Model model) {
		System.out.println("----makeCategory----");

		//model.addAttribute("list", service.GetAll());

		return "admin/category/create";
	}

}