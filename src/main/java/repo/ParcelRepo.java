package repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Parcel;

@Repository
@Transactional
public class ParcelRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public Parcel save(Parcel parcel){
		em.persist(parcel);
		System.out.println(parcel);
		return parcel;	
	}
	
	public Parcel update(Parcel parcel){
		em.merge(parcel);
		return parcel;
	}
	
	public Parcel findById(Long id){
		return em.find(Parcel.class, id);
	}

}
