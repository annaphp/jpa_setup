package jpa_setup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.Config;
import model.Parcel;
import model.Stamp;
import repo.ParcelRepo;

@ContextConfiguration(classes=Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ParceRepoTest {
	
	@Autowired
	ParcelRepo repo;
	
	Parcel parcel;
	
	@Before
	public void setup(){
		 parcel = new Parcel("urgent", "small", "Edmonton");
	}
	
	@Test
	public void shouldSave(){
		parcel = repo.save(parcel);
		assertNotNull(repo.findById(parcel.getId()));
	}
	
	@Test
	public void shouldAddRemoveStamp(){
		parcel = repo.save(parcel);
		Stamp stamp = new Stamp("Stamp 1");
		
		//add stamp
		parcel.getStamps().add(stamp);
		repo.update(parcel);
		parcel = repo.findById(parcel.getId());
		assertTrue(parcel.getStamps().contains(stamp));
		
		//remove stamp
		parcel.getStamps().remove(stamp);
		repo.update(parcel);
		assertFalse(parcel.getStamps().contains(stamp));
	}
	
	@Test 
	public void shouldAddRemoveLavels(){
		parcel = repo.save(parcel);
		parcel.getLabels().put("Red", "bad");
		
		//add label
		repo.update(parcel);
		parcel = repo.findById(parcel.getId());
		assertTrue(parcel.getLabels().containsKey("Red"));
		
		//remove label
		parcel.getLabels().remove("Red");
		repo.update(parcel);
		parcel = repo.findById(parcel.getId());
		assertFalse(parcel.getLabels().containsKey("Red"));	
	}
}
