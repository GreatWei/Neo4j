import org.neo4j.cineasts.entity.GoogleProfile;
import org.neo4j.cineasts.service.GoogleProfileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.conversion.Result;

import java.util.Iterator;

public class GoogleProfileTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("googleprofile.xml");
        GoogleProfileService service = (GoogleProfileService) context.getBean("googleProfileService");      // Please uncomment one of the operation section
        // and comment remaining section to test only one operation at a time
        // Here I've uncommented CREATE operation and
        // commented other operations: FIND ONE, FIND ALL, DELETE
        // CREATE Operation
        GoogleProfile profile = createPofile();
        createProfile(service, profile);
        System.out.println("GoogleProfile created successfully.");      // FIND ONE
      /*
      GoogleProfile profile = getOneProfileById(service,67515L);
      System.out.println(profile);
      */      // FIND ALL
      /*
      getAllProfiles(service);
      */      // DELETE
      /*
      GoogleProfile profile = createPofile();
      deleteProfile(service,profile);
      System.out.println("GoogleProfile deleted successfully.");
      */
    }

    private static GoogleProfile createProfile(GoogleProfileService service, GoogleProfile profile) {
        return service.create(profile);
    }

    private static void deleteProfile(GoogleProfileService service, GoogleProfile profile) {
        service.delete(profile);
    }

    private static GoogleProfile getOneProfileById(GoogleProfileService service, Long id) {
        return service.findById(id);
    }

    private static void getAllProfiles(GoogleProfileService service) {
        Result<GoogleProfile> result = service.findAll();
        Iterator<GoogleProfile> iterator = result.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static GoogleProfile createPofile() {
        GoogleProfile profile = new GoogleProfile();
        profile.setName("Profile-2");
        profile.setAddress("Hyderabad");
        profile.setSex("Male");
        profile.setDob("02/02/1980");
        return profile;
    }
}
