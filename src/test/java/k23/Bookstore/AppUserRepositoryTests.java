package k23.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k23.Bookstore.domain.AppUser;
import k23.Bookstore.domain.AppUserRepository;

@DataJpaTest
class AppUserRepositoryTests {
	@Autowired
	AppUserRepository appUserRepository;

	@Test
	public void findUsername() {
		AppUser appUser = appUserRepository.findByUsername("user");
		assertThat(appUser.getUsername().equals("user"));
	}

	@Test
	public void saveUser() {
		AppUser appUser = new AppUser("username","salasana","rooli");
		appUserRepository.save(appUser);
		assertNotEquals(appUser.getId(), null);
	}
	
	@Test
	public void deleteUser() {
		AppUser appUsers = appUserRepository.findByUsername("user");
		AppUser appUser = appUsers;
		
		appUserRepository.delete(appUser);

		AppUser newAppUsers = appUserRepository.findByUsername("user");
		assertThat(newAppUsers==null);
		
	}
	
}
