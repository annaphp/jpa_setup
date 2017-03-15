import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
import model.Parcel;
import repo.ParcelRepo;

public class Main {

	public static void main (String[] args){
		
	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	ParcelRepo repo = context.getBean("parcelRepo",ParcelRepo.class);
	
	Parcel p = new Parcel("First", "heavy", "Toronto");
	
	repo.save(p);
	Parcel p2 = repo.findById(1L);
	p2.setName("Third");
	System.out.println(repo.update(p2));
    }
}
